package lk.ijse.spring.pos.controller;

import lk.ijse.spring.pos.dto.OrdersDTO;
import lk.ijse.spring.pos.service.PurchaseOrderService;
import lk.ijse.spring.pos.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/purchase")
@CrossOrigin
public class PurchaseOrderController {
    @Autowired
    private PurchaseOrderService service;

    @PostMapping
    public ResponseUtil purchaseOrder(@RequestBody OrdersDTO dto) {
        service.purchaseOrder(dto);
        return new ResponseUtil("Ok", "Success", dto);
    }
}
