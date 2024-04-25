package lk.ijse.helloshoeshop.entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "Stock")
public class StockEntity implements SuperEntity{
    @Id
    private String stockId;
    @ManyToOne
    @JoinColumn(name = "supplierCode",nullable = false)
    private SupplierEntity supplierEntity;

    @ManyToOne
    @JoinColumn(name = "itemCode",nullable = false)
    private ItemEntity itemEntity;
    private Date supplierOrderDate;

    @OneToMany(mappedBy = "stockEntity",cascade = CascadeType.ALL)
    private List<StockSizeEntity> stockSizeEntities;
}
