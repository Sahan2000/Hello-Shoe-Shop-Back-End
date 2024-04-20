package lk.ijse.helloshoeshop.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@RequiredArgsConstructor
@Entity
public class InventoryEntity implements SuperEntity{
    @Id
    private String itemCode;
    private String itemDesc;
    private String itemPic;
    private String category;
    private String status;
    private double unitPriceSale;
}
