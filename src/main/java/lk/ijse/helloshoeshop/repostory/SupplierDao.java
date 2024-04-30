package lk.ijse.helloshoeshop.repostory;

import lk.ijse.helloshoeshop.entity.CustomerEntity;
import lk.ijse.helloshoeshop.entity.SupplierEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierDao extends JpaRepository<SupplierEntity, String> {
    SupplierEntity findFirstByOrderBySupplierCodeDesc();
}
