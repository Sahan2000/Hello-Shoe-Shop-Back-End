package lk.ijse.helloshoeshop.dto;

import jakarta.validation.constraints.NotNull;

public class VarietyDTO {
    @NotNull(message = "Variety Code Should Be not null.")
    private String varietyCode;
    @NotNull(message = "Variety Description Should Be not null.")
    private String varietyDesc;
}
