package lk.ijse.helloshoeshop.dto;
import lk.ijse.helloshoeshop.entity.enumerate.Gender;
import lk.ijse.helloshoeshop.entity.enumerate.Level;
import lombok.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@AllArgsConstructor

@Data
@RequiredArgsConstructor
public class CustomerDTO {
    private String customerCode;
    private String customerName;
    private Gender gender;
    private Date joinedDate;
    private Level level;
    private int totalPoint;
    private Date dob;
    private String address1;
    private String address2;
    private String address3;
    private String address4;
    private String address5;
    private String contactNo;
    private String email;
    private Timestamp purchaseDate;
    @ToString.Exclude
    private List<OrderDTO> orders;
}
