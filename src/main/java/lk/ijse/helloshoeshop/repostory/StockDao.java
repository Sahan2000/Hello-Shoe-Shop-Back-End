package lk.ijse.helloshoeshop.repostory;

import lk.ijse.helloshoeshop.entity.StockEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockDao extends JpaRepository<StockEntity, String> {
    StockEntity findFirstByOrderByStockIdDesc();
}
