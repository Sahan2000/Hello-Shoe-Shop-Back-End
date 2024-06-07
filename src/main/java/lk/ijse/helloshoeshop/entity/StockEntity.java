package lk.ijse.helloshoeshop.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Stock")
public class StockEntity implements SuperEntity{
    @Id
    private String stockId;

    private Date supplierOrderDate;
    private int qty;
    private Double unitBuyingPrice;
    private Double unitSellingPrice;

    @ManyToOne
    @JoinColumn(name = "supplierCode",nullable = false)
    @JsonIgnoreProperties("stockEntities")
    private SupplierEntity supplierEntity;

    @ManyToOne
    @JoinColumn(name = "itemCode",nullable = false)
    @JsonIgnoreProperties("stockEntities")
    private ItemEntity itemEntity;

    @ManyToOne
    @JoinColumn(name = "branchId",nullable = false)
    @JsonIgnoreProperties("stockEntities")
    private BranchEntity branchEntity;

    @ManyToOne
    @JoinColumn(name = "sizeCode",nullable = false)
    @JsonIgnoreProperties("stockEntities")
    private SizeEntity sizeEntity;
}
