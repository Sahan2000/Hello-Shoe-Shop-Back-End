package lk.ijse.helloshoeshop.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Data
@Entity
@Table(name = "Size")
public class SizeEntity implements SuperEntity{
    @Id
    private String sizeCode;
    private String sizeDesc;

    @OneToMany(mappedBy = "sizeEntity",cascade = CascadeType.ALL)
    private List<StockSizeEntity> stockSizeEntities;
}
