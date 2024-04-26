package lk.ijse.helloshoeshop.entity;

import jakarta.persistence.*;
import lk.ijse.helloshoeshop.entity.enumerate.PaymentMethod;
import lk.ijse.helloshoeshop.entity.enumerate.Role;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

@RequiredArgsConstructor
@Data
@Entity
@Table(name = "orders")
public class OrderEntity implements SuperEntity{
    @Id
    private String orderNo;
    private Timestamp purchasedDate;
    private int addedPoints;
    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    @ManyToOne
    @JoinColumn(name = "cutomerId",nullable = false)
    private CustomerEntity customerEntity;

    @ManyToOne
    @JoinColumn(name = "email",nullable = false)
    private UserEntity userEntity;

    @OneToMany(mappedBy = "orderEntity",cascade = CascadeType.ALL)
    private List<StockSizeOrderDetailsEntity> stockSizeOrderDetailsEntities;

}
