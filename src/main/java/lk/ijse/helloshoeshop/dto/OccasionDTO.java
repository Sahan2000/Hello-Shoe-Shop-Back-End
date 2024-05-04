package lk.ijse.helloshoeshop.dto;

import jakarta.validation.constraints.NotNull;

public class OccasionDTO {
    @NotNull(message = "Occasion code should not null")
    private String occasionCode;
    @NotNull(message = "Occasion Description Should not null")
    private String occasionDesc;
}
