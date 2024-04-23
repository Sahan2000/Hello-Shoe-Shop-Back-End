package lk.ijse.helloshoeshop.dto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.ManyToOne;
import lk.ijse.helloshoeshop.entity.InventoryEntity;
import lk.ijse.helloshoeshop.entity.SizesEntity;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@RequiredArgsConstructor
public class SizeDetailsDTO {
    private String sizeDetailsId;
    @ToString.Exclude
    private SizesDTO size;
    @ToString.Exclude
    private InventoryDTO inventory;
}
