package lk.ijse.helloshoeshop.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BranchDTO {
    @Null(message = "Branch Id generate by the program")
    private String branchId;

    @NotBlank(message = "Branch name cannot be blank")
    @Size(min = 2, max = 50, message = "Branch name must be between 2 and 50 characters")
    private String branchName;

    @NotBlank(message = "Product Activate Code cannot be blank")
    private String productCode;
}
