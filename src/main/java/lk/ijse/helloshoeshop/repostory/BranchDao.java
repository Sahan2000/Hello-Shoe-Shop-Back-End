package lk.ijse.helloshoeshop.repostory;

import lk.ijse.helloshoeshop.entity.BranchEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BranchDao extends JpaRepository<BranchEntity, String> {
}
