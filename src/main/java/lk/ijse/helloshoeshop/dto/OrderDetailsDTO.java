package lk.ijse.helloshoeshop.dto;

import lombok.*;

@AllArgsConstructor

@Data
@RequiredArgsConstructor
public class OrderDetailsDTO {
    private String orderDetailsId;
    private double unitPrice;
    private int sizeType;
    private int quantity;
    @ToString.Exclude
    private OrderDTO order;
    @ToString.Exclude
    private InventoryDTO inventory;
}
