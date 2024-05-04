package lk.ijse.helloshoeshop.repostory;

import lk.ijse.helloshoeshop.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface InventoryDao extends JpaRepository<ItemEntity, String> {
    @Query("SELECT itemCode FROM ItemEntity  WHERE itemCode LIKE CONCAT(:prefix, '%') ORDER BY itemCode DESC")
    String findLastItemCodeStartingWithPrefix(@Param("prefix") String prefix);
}
