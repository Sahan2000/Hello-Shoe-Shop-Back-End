package lk.ijse.helloshoeshop.dto;

import lombok.*;

@AllArgsConstructor

@Data
@RequiredArgsConstructor
public class SizeDetailsDTO {
    private String sizeDetailsId;
    @ToString.Exclude
    private SizesDTO size;
    @ToString.Exclude
    private ItemDTO inventory;
}
