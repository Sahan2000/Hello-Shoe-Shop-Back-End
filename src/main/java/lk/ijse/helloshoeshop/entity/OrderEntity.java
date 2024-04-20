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
@Table(name = "orders")
public class OrderEntity implements SuperEntity{
    @Id
    private String orderNo;
    private String customerName;
    private String cashierName;
    private double addedPoint;
    private double totalPrice;
    private String paymentMethod;
}
