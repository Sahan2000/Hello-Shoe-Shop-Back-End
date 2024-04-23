package lk.ijse.helloshoeshop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
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
    private OrderEntity order;
    @ManyToOne(cascade = CascadeType.ALL)
    private InventoryEntity inventory;
}
