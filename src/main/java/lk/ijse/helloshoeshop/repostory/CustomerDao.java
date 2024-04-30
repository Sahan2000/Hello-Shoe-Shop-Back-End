package lk.ijse.helloshoeshop.repostory;

import lk.ijse.helloshoeshop.controller.Customer;
import lk.ijse.helloshoeshop.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDao extends JpaRepository<CustomerEntity, String> {
    CustomerEntity findFirstByOrderByCustomerIdDesc();
}
