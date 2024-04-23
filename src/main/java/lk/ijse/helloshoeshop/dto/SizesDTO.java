package lk.ijse.helloshoeshop.dto;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@RequiredArgsConstructor
public class SizesDTO {
    private String sizeCode;
    private String sizeCategory;
    private int qty;
    @ToString.Exclude
    private List<SizeDetailsDTO> sizeDetailsEntities;
}
