package lk.ijse.helloshoeshop.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.sql.Timestamp;

@RequiredArgsConstructor
@Data
@Entity
@Table(name = "Returns")
public class ReturnEntity implements SuperEntity{
    @Id
    private String returnId;
    private Timestamp returnDate;
    @OneToOne(cascade = CascadeType.ALL)
    private StockSizeOrderDetailsEntity stockSizeOrderDetailsEntity;
    private int qty;
}
