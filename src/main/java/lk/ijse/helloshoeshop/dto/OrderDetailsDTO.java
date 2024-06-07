package lk.ijse.helloshoeshop.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailsDTO {
    @Null(message = "Stock order detail ID Should Null")
    private String stockOrderDetailsId;

    @Positive(message = "Quantity must be positive")
    private int qty;

    @NotBlank(message = "Stock ID cannot be blank")
    private String stockId;
}
