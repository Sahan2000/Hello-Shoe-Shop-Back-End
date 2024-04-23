package lk.ijse.helloshoeshop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor

@Data
@Entity
@Table(name = "returnDetails")
public class ReturnDetailsEntity implements SuperEntity{
    @Id
    private String returnDetailsNo;
    private int sizeType;
    private int quantity;
    private double unitPrice;
    @ToString.Exclude
    private ReturnEntity returnEntity;
    @ToString.Exclude
    private InventoryEntity inventory;
}
