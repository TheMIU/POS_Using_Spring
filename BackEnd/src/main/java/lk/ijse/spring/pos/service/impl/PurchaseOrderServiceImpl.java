package lk.ijse.spring.pos.service.impl;

import lk.ijse.spring.pos.dto.OrderDetailsDTO;
import lk.ijse.spring.pos.dto.OrdersDTO;
import lk.ijse.spring.pos.entity.Item;
import lk.ijse.spring.pos.entity.OrderDetails;
import lk.ijse.spring.pos.entity.Orders;
import lk.ijse.spring.pos.repo.ItemRepo;
import lk.ijse.spring.pos.repo.OrderDetailsRepo;
import lk.ijse.spring.pos.repo.OrdersRepo;
import lk.ijse.spring.pos.service.PurchaseOrderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

    @Autowired
    private OrdersRepo ordersRepo;

    @Autowired
    private OrderDetailsRepo orderDetailsRepo;

    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void purchaseOrder(OrdersDTO dto) {
        if (ordersRepo.existsById(dto.getOid())) throw new RuntimeException("exist order id");

        // Orders table & OrderDetails table
        ordersRepo.save(mapper.map(dto, Orders.class));

        // Update item qty
        List<OrderDetailsDTO> orderDetails = dto.getOrderDetails();
        for (OrderDetailsDTO detailsDTO : orderDetails) {
            String itemCode = detailsDTO.getItemCode();

            // get current item qty
            Item item = itemRepo.findById(itemCode).orElseThrow(() -> new RuntimeException("Item not found with code: " + itemCode));
            int qtyOnHand = item.getQtyOnHand();

            // update qty
            int updatedQty = qtyOnHand - detailsDTO.getQty();

            // check if not updatedQty is - value
            if (updatedQty >= 0) {
                item.setQtyOnHand(updatedQty);
                itemRepo.save(item);
            } else {
                throw new RuntimeException("Wrong item count in " + itemCode);
            }

        }
    }
}
