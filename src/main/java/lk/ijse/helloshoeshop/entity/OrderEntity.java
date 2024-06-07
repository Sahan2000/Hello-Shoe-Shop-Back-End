package lk.ijse.helloshoeshop.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;
    private double totalAmount;
    private double paidAmount;
    private String bankName;
    private String bankNo;

    @ManyToOne
    @JoinColumn(name = "cutomerId",nullable = false)
    @JsonIgnoreProperties("orderEntities")
    private CustomerEntity customerEntity;

    @ManyToOne
    @JoinColumn(name = "email",nullable = false)
    @JsonIgnoreProperties("orderEntities")
    private UserEntity userEntity;


}
