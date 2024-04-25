package lk.ijse.helloshoeshop.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "gender")
public class GenderEntity implements SuperEntity{
    @Id
    private String genderCode;
    private String genderDesc;
    @OneToMany(mappedBy = "genderEntity",cascade = CascadeType.ALL)
    private List<ItemEntity> itemEntities;
}
