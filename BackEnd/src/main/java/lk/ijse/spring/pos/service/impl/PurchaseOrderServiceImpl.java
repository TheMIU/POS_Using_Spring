package lk.ijse.spring.pos.service.impl;

import lk.ijse.spring.pos.dto.OrdersDTO;
import lk.ijse.spring.pos.entity.Orders;
import lk.ijse.spring.pos.repo.OrderDetailsRepo;
import lk.ijse.spring.pos.repo.OrdersRepo;
import lk.ijse.spring.pos.service.PurchaseOrderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

    @Autowired
    private OrdersRepo ordersRepo;

    @Autowired
    private OrderDetailsRepo orderDetailsRepo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void purchaseOrder(OrdersDTO dto) {
        if (ordersRepo.existsById(dto.getOid())) throw new RuntimeException("exist order id");
        System.out.println(dto);
        Orders map = mapper.map(dto, Orders.class);
        System.out.println(map);
        ordersRepo.save(map);
    }
}
