package lk.ijse.helloshoeshop.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
@Entity
@Table(name = "StockSizeOrderDetails")
public class StockSizeOrderDetailsEntity implements SuperEntity {
    @Id
    private String stockSizeOrderDetailsId;
    private int qty;

    @ManyToOne
    @JoinColumn(name = "stockId", nullable = false)
    private StockEntity stockEntity;

    @ManyToOne
    @JoinColumn(name = "orderId", nullable = false)
    private OrderEntity orderEntity;

}
