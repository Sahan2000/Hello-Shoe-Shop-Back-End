package lk.ijse.helloshoeshop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;

@AllArgsConstructor

@Data
@RequiredArgsConstructor
@Entity
@Table(name = "sizes")
public class SizesEntity implements SuperEntity{
    @Id
    private String sizeCode;
    private String sizeCategory;
    private int qty;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "size")
    private List<SizeDetailsEntity> sizeDetailsEntities;
}
