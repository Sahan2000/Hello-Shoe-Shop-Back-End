package lk.ijse.helloshoeshop.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@AllArgsConstructor

@Data
@RequiredArgsConstructor
public class SizesDTO {
    @NotNull(message = "Size id generate by the programme")
    private String sizeCode;
    @NotNull(message = "Size Description Should not null")
    private String sizeDesc;
}
