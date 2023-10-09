package lk.ijse.spring.pos.repo;

import lk.ijse.spring.pos.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepo extends JpaRepository<Item, String> {
}
