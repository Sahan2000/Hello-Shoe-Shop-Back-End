package lk.ijse.helloshoeshop.dto;

import lk.ijse.helloshoeshop.entity.enumerate.Role;
import lombok.*;

import java.util.List;
@AllArgsConstructor
@Data
@RequiredArgsConstructor
public class UserDTO {
    private String email;
    private String password;
    private Role role;
    @ToString.Exclude
    private EmployeeDTO employee;
    @ToString.Exclude
    private List<OrderDTO> orders;
}
