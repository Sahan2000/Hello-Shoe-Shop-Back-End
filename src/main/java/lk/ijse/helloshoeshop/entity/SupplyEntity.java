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
@Table(name = "supply")
public class SupplyEntity implements SuperEntity{
    @Id
    private String supplyNo;
    private int qty;
    private double unitBuyingPrice;
    @ManyToOne(cascade = CascadeType.ALL)
    private InventoryEntity inventory;
    @ManyToOne(cascade = CascadeType.ALL)
    private SupplierEntity supplier;
}
