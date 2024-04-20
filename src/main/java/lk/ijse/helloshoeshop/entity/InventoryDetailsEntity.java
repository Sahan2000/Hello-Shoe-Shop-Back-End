package lk.ijse.helloshoeshop.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@RequiredArgsConstructor
@Entity
@Table(name = "inventory")
public class InventoryDetailsEntity implements SuperEntity{
    @Id
    private String itemCode;
    @Id
    private String orderNo;
    private double unitPrice;
    private int size;
    private int quantity;
}
