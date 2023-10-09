package lk.ijse.spring.pos.repo;

import lk.ijse.spring.pos.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer, String> {
}
