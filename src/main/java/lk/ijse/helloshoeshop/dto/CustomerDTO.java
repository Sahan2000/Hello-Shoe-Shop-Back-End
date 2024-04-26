package lk.ijse.helloshoeshop.dto;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
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
    @Null(message = "Customer id generate by the programme")
    private String customerId;
    @NotBlank(message = "customer name cannot be blank")
    @Size(min = 2, max = 100, message = "Customer name must be between 2 and 100 characters")
    private String customerName;
    @NotNull(message = "Gender cannot be a null")
    private Gender gender;
    private Level level;
    @NotNull(message = "Joined date cannot be a null")
    @PastOrPresent(message = "Join date must be in the past or present")
    private Date joinDate;
    @PositiveOrZero(message = "Total points must be positive or zero")
    private Integer totalPoint;
    @Past(message = "Date of birth should be in the past")
    @NotNull(message = "Date of birth cannot be null")
    private Date dob;
    @NotBlank(message = "Address 1 cannot be blank")
    private String address1;
    @NotBlank(message = "Address 2 cannot be blank")
    private String address2;
    @NotBlank(message = "Address 3 cannot be blank")
    private String address3;
    @NotBlank(message = "Address 4 cannot be blank")
    private String address4;
    @NotBlank(message = "Postal code cannot be blank")
    @Pattern(regexp = "\\d{5}", message = "Postal code must be 5 digits")
    private String postalCode;
    @NotBlank(message = "Contact No cannot be blank")
    @Pattern(regexp = "^\\+?[0-9\\-\\s]+$", message = "Invalid contact number format")
    private String contactNo;
    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Invalid email format")
    private String email;
    @NotNull(message = "Recent purchased date cannot be null")
    private Timestamp recentPurchasedDate;
}
