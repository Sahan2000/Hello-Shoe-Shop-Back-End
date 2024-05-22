package lk.ijse.helloshoeshop.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@AllArgsConstructor

@Data
@RequiredArgsConstructor
public class SaleServiceDTO {
    @NotBlank(message = "Item code is required")
    private String itemCode;

    @NotBlank(message = "Order number is required")
    private String orderNumber;

    private String customerId;

    @NotBlank(message = "Item description is required")
    private String itemDescription;

    @Positive(message = "Size must be a positive integer")
    private int size;

    @PositiveOrZero(message = "Unit price must be a positive number")
    private double unitPrice;

    @Positive(message = "Item quantity must be a positive integer")
    private int itemQuantity;

    @PositiveOrZero(message = "Total price must be a positive number")
    private double totalPrice;

    @NotNull(message = "Purchase date is required")
    private Date purchaseDate;

    @NotBlank(message = "Payment method is required")
    private String paymentMethod;

    @PositiveOrZero(message = "Added points must be a positive number")
    private double addedPoints;

    @NotBlank(message = "Cashier name is required")
    private String cashierName;
}
