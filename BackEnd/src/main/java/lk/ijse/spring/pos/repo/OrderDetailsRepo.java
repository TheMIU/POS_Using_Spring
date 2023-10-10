package lk.ijse.spring.pos.repo;

import lk.ijse.spring.pos.entity.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailsRepo extends JpaRepository<OrderDetails,String> {
}
