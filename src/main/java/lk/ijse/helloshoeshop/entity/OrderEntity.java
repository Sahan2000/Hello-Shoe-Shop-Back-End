package lk.ijse.helloshoeshop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

@AllArgsConstructor

@Data
@RequiredArgsConstructor
@Entity
@Table(name = "orders")
public class OrderEntity implements SuperEntity{
    @Id
    private String orderNo;
    private String customerName;
    private double addedPoint;
    private double totalPrice;
    private String paymentMethod;
    private Timestamp purchaseDate;
    private String cashierName;
    @ManyToOne(cascade = CascadeType.ALL)
    private UserEntity user;
    @ManyToOne(cascade = CascadeType.ALL)
    private CustomerEntity customer;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
    private List<OrderDetailsEntity> orderDetailsEntities;
}
