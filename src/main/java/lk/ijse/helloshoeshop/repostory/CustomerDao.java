package lk.ijse.helloshoeshop.repostory;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDao extends JpaRepository<CustomerEntity, String> {
}
