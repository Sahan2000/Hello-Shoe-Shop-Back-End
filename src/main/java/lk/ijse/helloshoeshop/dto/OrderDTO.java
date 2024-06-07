package lk.ijse.helloshoeshop.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lk.ijse.helloshoeshop.entity.enumerate.PaymentMethod;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
    @NotBlank(message = "Order ID cannot be blank")
    private String orderNo;

    @NotNull(message = "Payment Method cannot be null")
    private PaymentMethod paymentMethod;

    @Positive(message = "Total amount must be positive")
    private Double totalAmount;

    @Positive(message = "Total amount must be positive")
    private Double paidAmount;

    private String bankName;

    private String bankNo;

    @NotNull(message = "Customer cannot be null")
    private String customerId;

    @NotNull(message = "User cannot be null")
    private String userId;

    @NotEmpty(message = "Order details cannot be empty")
    private List<OrderDetailsDTO> orderDetailsList;
}
