package lk.ijse.helloshoeshop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;

@AllArgsConstructor

@Data
@RequiredArgsConstructor
@Entity
@Table(name = "inventory")
public class InventoryEntity implements SuperEntity{
    @Id
    private String itemCode;
    private String itemDesc;
    private String itemPicture;
    private String category;
    private double unitPriceSale;
    private double unitPriceBuy;
    private double exceptedProfit;
    private double profitMargin;
    private String status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "inventory")
    private List<SizeDetailsEntity> sizeDetailsEntities;
    @OneToMany(mappedBy = "inventory", cascade = CascadeType.ALL)
    private List<OrderDetailsEntity> orderDetailsEntities;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "inventory")
    private List<ReturnDetailsEntity> returnDetailsEntities;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "inventory")
    private List<SupplyEntity> supplyEntities;
}
