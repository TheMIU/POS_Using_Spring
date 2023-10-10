package lk.ijse.spring.pos.service.impl;
import lk.ijse.spring.pos.dto.OrdersDTO;
import lk.ijse.spring.pos.entity.Orders;
import lk.ijse.spring.pos.repo.OrdersRepo;
import lk.ijse.spring.pos.service.OrdersService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class OrdersServiceImpl implements OrdersService {
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private OrdersRepo repo;

    @Override
    public List<OrdersDTO> getAllOrders() {
        List<Orders> all = repo.findAll();
        return mapper.map(all, new TypeToken<List<OrdersDTO>>() {
        }.getType());
    }
}
