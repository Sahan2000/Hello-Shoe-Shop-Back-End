package lk.ijse.helloshoeshop.dto;
import lombok.*;

import java.sql.Date;
import java.util.List;

@AllArgsConstructor

@Data
@RequiredArgsConstructor
public class ReturnDTO {
    private String returnNo;
    private Date returnDate;
    private double total;
    @ToString.Exclude
    private List<ReturnDetailsDTO> returnDetails;
    @ToString.Exclude
    private SaleServiceDTO order;
}

