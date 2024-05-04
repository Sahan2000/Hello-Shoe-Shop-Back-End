package lk.ijse.helloshoeshop.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "gender")
@Data
public class GenderEntity implements SuperEntity{
    @Id
    private String genderCode;
    private String genderDesc;
    @OneToMany(mappedBy = "genderEntity",cascade = CascadeType.ALL)
    private List<ItemEntity> itemEntities;
}
