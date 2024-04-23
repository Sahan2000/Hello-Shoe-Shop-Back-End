package lk.ijse.helloshoeshop.dto;

import lombok.*;

import java.sql.Timestamp;
import java.util.List;

@AllArgsConstructor

@Data
@RequiredArgsConstructor
public class OrderDTO {
    private String orderNo;
    private String customerName;
    private double addedPoint;
    private double totalPrice;
    private String paymentMethod;
    private Timestamp purchaseDate;
    private String cashierName;
    @ToString.Exclude
    private UserDTO user;
    @ToString.Exclude
    private CustomerDTO customer;
    @ToString.Exclude
    private List<OrderDetailsDTO> orderDetails;
}
