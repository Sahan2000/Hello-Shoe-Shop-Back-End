package lk.ijse.helloshoeshop.repostory;

import lk.ijse.helloshoeshop.entity.SizeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SizesDao extends JpaRepository<SizeEntity, String> {
    SizeEntity findFirstByOrderBySizeCodeDesc();
}
