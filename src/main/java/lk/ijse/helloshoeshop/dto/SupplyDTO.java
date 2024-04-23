package lk.ijse.helloshoeshop.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@RequiredArgsConstructor
public class SupplyDTO {
    private String supplyNo;
    private int qty;
    private double unitBuyingPrice;
    @ToString.Exclude
    private InventoryDTO inventory;
    @ToString.Exclude
    private SupplierDTO supplier;
}
