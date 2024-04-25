package lk.ijse.helloshoeshop.entity;

import jakarta.persistence.*;
import lk.ijse.helloshoeshop.entity.enumerate.Role;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Data
@Entity
@Table(name = "User")
public class UserEntity implements SuperEntity{
    @Id
    private String email;
    private String password;
    private Role role;
    @OneToMany(mappedBy = "userEntity",cascade = CascadeType.ALL)
    private List<OrderEntity> orderEntities;
}
