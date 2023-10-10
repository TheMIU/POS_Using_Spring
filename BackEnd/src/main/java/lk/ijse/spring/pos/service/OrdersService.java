package lk.ijse.spring.pos.service;

import lk.ijse.spring.pos.dto.OrdersDTO;

import java.util.List;

public interface OrdersService {
    List<OrdersDTO> getAllOrders();
}
