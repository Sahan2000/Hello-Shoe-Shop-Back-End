package lk.ijse.helloshoeshop.repostory;

import lk.ijse.helloshoeshop.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDao extends JpaRepository<CustomerEntity, String> {
}
