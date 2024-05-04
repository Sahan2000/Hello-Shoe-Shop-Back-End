package lk.ijse.helloshoeshop.repostory;

import lk.ijse.helloshoeshop.entity.GenderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenderDao extends JpaRepository<GenderEntity, String> {
}
