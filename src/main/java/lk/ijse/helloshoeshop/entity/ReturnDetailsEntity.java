package lk.ijse.helloshoeshop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "returnDetails")
public class ReturnDetailsEntity implements SuperEntity{
    @Id
    private String returnDetailsNo;
    private int sizeType;
    private int quantity;
    private double unitPrice;
    @ManyToOne(cascade = CascadeType.ALL)
    private ReturnEntity returnEntity;
    @ManyToOne(cascade = CascadeType.ALL)
    private InventoryEntity inventory;
}
