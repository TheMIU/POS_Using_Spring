package lk.ijse.spring.pos.repo;


import lk.ijse.spring.pos.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepo extends JpaRepository<Orders,String> {
}
