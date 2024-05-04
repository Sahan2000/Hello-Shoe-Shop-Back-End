package lk.ijse.helloshoeshop.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lk.ijse.helloshoeshop.entity.enumerate.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class ItemDTO {
    @Null(message = "Item generate by program")
    private String itemCode;
    @NotBlank(message = "Item Description cannot be blank")
    private String itemDesc;
    @NotNull(message = "Propic cannot be null")
    private String pic;
    @NotNull(message = "Status cannot be null")
    private Status status;
    private String genderCode;
    private String occasionCode;
    private String varietyCode;
}
