package lk.ijse.helloshoeshop.repostory;

import lk.ijse.helloshoeshop.entity.OccasionEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OccasionDao extends JpaRepository<OccasionEntity, String> {
}
