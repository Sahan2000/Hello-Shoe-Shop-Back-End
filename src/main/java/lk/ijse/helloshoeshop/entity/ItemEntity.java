package lk.ijse.helloshoeshop.entity;

import jakarta.persistence.*;
import lk.ijse.helloshoeshop.entity.enumerate.Status;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Data
@Entity
@Table(name = "Item")
public class ItemEntity implements SuperEntity{
    @Id
    private String itemCode;
    private String itemDesc;
    @Column(columnDefinition = "LONGTEXT")
    private String pic;
    @ManyToOne
    @JoinColumn(name = "genderCode",nullable = true)
    private GenderEntity genderEntity;

    @ManyToOne
    @JoinColumn(name = "occasionCode",nullable = true)
    private OccasionEntity occasionEntity;

    @ManyToOne
    @JoinColumn(name = "varietyCode",nullable = true)
    private VarietyEntity varietyEntity;

    @OneToMany(mappedBy = "itemEntity",cascade = CascadeType.ALL)
    private List<StockEntity> stockEntities;
}
