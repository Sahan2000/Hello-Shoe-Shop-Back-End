package lk.ijse.helloshoeshop.dto;

import lombok.*;

@AllArgsConstructor

@Data
@RequiredArgsConstructor
public class ReturnDetailsDTO {
    private String returnDetailsNo;
    private int sizeType;
    private int quantity;
    private double unitPrice;
    @ToString.Exclude
    private ReturnDTO returnEntity;
    @ToString.Exclude
    private ItemDTO inventory;
}
