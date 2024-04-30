package lk.ijse.helloshoeshop.repostory;

import lk.ijse.helloshoeshop.entity.CustomerEntity;
import lk.ijse.helloshoeshop.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeDao extends JpaRepository<EmployeeEntity, String> {
    EmployeeEntity findFirstByOrderByEmployeeCodeDesc();
}
