package lk.ijse.helloshoeshop.dto;

import jakarta.validation.constraints.*;
import lk.ijse.helloshoeshop.entity.enumerate.Gender;
import lk.ijse.helloshoeshop.entity.enumerate.Role;
import lk.ijse.helloshoeshop.entity.enumerate.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.sql.Date;

@AllArgsConstructor

@Data
@RequiredArgsConstructor
public class EmployeeDTO {
    @Null(message = "Employee code generate by the program")
    private String employeeCode;
    @NotBlank(message = "Employee name cannot be blank")
    @Size(min = 2, max = 50, message = "Employee name must be between 2 and 50 characters")
    private String employeeName;
    @NotBlank(message = "Pro picture  cannot be blank")
    private String pic;
    @NotNull(message = "Gender cannot be null")
    private Gender gender;
    @NotNull(message = "Status cannot be null")
    private Status status;
    @NotNull(message = "Designation cannot be null")
    private String designation;
    @Past(message = "Date of birth should be in the past")
    @NotNull(message = "Date of birth cannot be null")
    private Date dateOfBirth;
    @NotNull(message = "Join date cannot be null")
    @PastOrPresent(message = "Join date must be in the past or present")
    private Date dateOfJoin;
    @Null
    private String branchId;
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
    @Email(message = "Invalid email format")
    @NotBlank(message = "Email cannot be blank")
    private String email;
    @NotBlank(message = "Emergency Contact Name cannot be blank")
    private String emergencyContactName;
    @NotBlank(message = "Emergency Contact No cannot be blank")
    @Pattern(regexp = "^\\+?[0-9\\-\\s]+$", message = "Invalid Emergency contact number format")
    private String emergencyContact;
}
