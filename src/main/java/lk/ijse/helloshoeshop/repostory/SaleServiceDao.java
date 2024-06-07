package lk.ijse.helloshoeshop.repostory;

import lk.ijse.helloshoeshop.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleServiceDao extends JpaRepository<OrderEntity, String> {
    OrderEntity findFirstByOrderByOrderNoDesc();
}
