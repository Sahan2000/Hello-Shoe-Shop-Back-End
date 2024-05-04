package lk.ijse.helloshoeshop.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenderDTO {
    @NotNull(message = "Gender code should not null")
    private String genderCode;
    @NotNull(message = "Gender Description Should not null")
    private String genderDesc;
}
