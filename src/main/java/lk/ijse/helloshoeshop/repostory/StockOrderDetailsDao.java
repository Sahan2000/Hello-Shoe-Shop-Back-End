package lk.ijse.helloshoeshop.repostory;

import lk.ijse.helloshoeshop.entity.StockSizeOrderDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockOrderDetailsDao extends JpaRepository<StockSizeOrderDetailsEntity, String> {

}
