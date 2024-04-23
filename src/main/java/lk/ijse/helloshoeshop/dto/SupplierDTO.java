package lk.ijse.helloshoeshop.dto;

import lk.ijse.helloshoeshop.entity.enumerate.Category;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@RequiredArgsConstructor
public class SupplierDTO {
    private String supplierId;
    private String supplierName;
    private Category category;
    private String address1;
    private String address2;
    private String address3;
    private String address4;
    private String address5;
    private String address6;
    private String contactNo1;
    private String contactNo2;
    private String email;
    @ToString.Exclude
    private List<SupplyDTO> supplyList;
}
