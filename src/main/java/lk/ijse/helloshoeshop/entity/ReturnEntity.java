package lk.ijse.helloshoeshop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.sql.Date;
import java.util.List;

@AllArgsConstructor
@Data
@RequiredArgsConstructor
@Entity
@Table(name = "return")
public class ReturnEntity implements SuperEntity{
    @Id
    private String returnNo;
    private Date returnDate;
    private double total;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "returnEntity")
    private List<ReturnDetailsEntity> returnDetailsEntities;
    @OneToOne
    private OrderEntity order;
}
