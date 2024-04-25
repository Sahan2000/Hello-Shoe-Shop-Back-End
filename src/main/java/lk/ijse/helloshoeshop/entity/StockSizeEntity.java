package lk.ijse.helloshoeshop.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Data
@Entity
@Table(name = "StockSize")
public class StockSizeEntity implements SuperEntity{
    @Id
    private String stockSizeId;
    private int qty;
    private Double unitBuyingPrice;
    private Double unitSellingPrice;
    private Double profit;
    private Double profitMargin;

    @ManyToOne
    @JoinColumn(name = "stockId",nullable = false)
    private StockEntity stockEntity;

    @ManyToOne
    @JoinColumn(name = "sizeCode",nullable = false)
    private SizeEntity sizeEntity;

    @OneToMany(mappedBy = "stockSizeEntity",cascade = CascadeType.ALL)
    private List<StockSizeOrderDetailsEntity> stockSizeOrderDetailsEntities;
}
