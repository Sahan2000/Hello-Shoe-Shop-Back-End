package lk.ijse.helloshoeshop.dto;

import lombok.*;

@AllArgsConstructor

@Data
@RequiredArgsConstructor
public class SupplyDTO {
    private String supplyNo;
    private int qty;
    private double unitBuyingPrice;
    @ToString.Exclude
    private ItemDTO inventory;
    @ToString.Exclude
    private SupplierDTO supplier;
}
