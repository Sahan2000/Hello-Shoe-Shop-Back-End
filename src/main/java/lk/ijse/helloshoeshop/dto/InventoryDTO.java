package lk.ijse.helloshoeshop.dto;

import lombok.*;

import java.util.List;

@AllArgsConstructor

@Data
@RequiredArgsConstructor
public class InventoryDTO {
    private String itemCode;
    private String itemDesc;
    private String itemPicture;
    private String category;
    private double unitPriceSale;
    private double unitPriceBuy;
    private double exceptedProfit;
    private double profitMargin;
    private String status;
    @ToString.Exclude
    private List<SizeDetailsDTO> sizeDetails;
    @ToString.Exclude
    private List<OrderDetailsDTO> orderDetails;
    @ToString.Exclude
    private List<ReturnDetailsDTO> returnDetails;
    @ToString.Exclude
    private List<SupplyDTO> supply;
}
