package lk.ijse.helloshoeshop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor

@Data
@RequiredArgsConstructor
@Entity
@Table(name = "sizeDetails")
public class SizeDetailsEntity implements SuperEntity{
    @Id
    private String sizeDetailsId;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sizeCode", insertable = false, updatable = false)
    private SizesEntity size;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "itemCode", insertable = false, updatable = false)
    private InventoryEntity inventory;
}
