package lk.ijse.helloshoeshop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@RequiredArgsConstructor
@Entity
@Table(name = "user")
public class UserEntity implements SuperEntity{
    @Id
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;
    private String emp_code;
}
