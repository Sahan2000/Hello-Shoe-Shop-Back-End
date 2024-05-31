package lk.ijse.helloshoeshop.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Branch")
@Data
public class BranchEntity {
    @Id
    private String branchId;
    @Column(unique = true)
    private String branchName;
}
