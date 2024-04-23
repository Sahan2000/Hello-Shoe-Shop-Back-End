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
@Table(name = "orderDetails")
public class OrderDetailsEntity implements SuperEntity{
    @Id
    private String orderDetailsId;
    private double unitPrice;
    private int sizeType;
    private int quantity;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "orderNo", insertable = false, updatable = false)
    private OrderEntity order;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "itemCode", insertable = false, updatable = false)
    private InventoryEntity inventory;
}
