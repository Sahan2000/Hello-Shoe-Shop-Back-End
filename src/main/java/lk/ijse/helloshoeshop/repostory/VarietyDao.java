package lk.ijse.helloshoeshop.repostory;

import lk.ijse.helloshoeshop.entity.VarietyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VarietyDao extends JpaRepository<VarietyEntity, String> {
}
