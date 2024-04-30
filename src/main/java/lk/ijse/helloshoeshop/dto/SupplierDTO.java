package lk.ijse.helloshoeshop.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lk.ijse.helloshoeshop.entity.enumerate.Category;
import lombok.*;

import java.util.List;

@AllArgsConstructor

@Data
@RequiredArgsConstructor
public class SupplierDTO {
    @Null(message = "Supplier id generate by the programme")
    private String supplierCode;

    @NotBlank(message = "Supplier name cannot be blank")
    private String supplierName;

    private Category category;

    @NotBlank(message = "Address Line 01 cannot be blank")
    private String address1;

    private String address2;

    @NotBlank(message = "Address Line 03 cannot be blank")
    private String address3;

    @NotBlank(message = "Address Line 04 cannot be blank")
    private String address4;

    @NotBlank(message = "Postal Code cannot be blank")
    @Pattern(regexp = "\\d{5}", message = "Postal code must be 5 digits")
    private String postalCode;

    @NotBlank(message = "Country cannot be blank")
    private String country;

    @Pattern(regexp = "^\\+?[0-9\\-\\s]+$", message = "Invalid contact number format")
    private String contactNo1;

    @Pattern(regexp = "^\\+?[0-9\\-\\s]+$", message = "Invalid contact number format")
    private String contactNo2;

    @Email(message = "Invalid email format")
    private String email;
}
