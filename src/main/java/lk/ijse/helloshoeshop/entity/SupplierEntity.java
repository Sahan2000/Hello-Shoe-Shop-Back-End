package lk.ijse.helloshoeshop.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@RequiredArgsConstructor
@Entity
@Table(name = "supplier")
public class SupplierEntity implements SuperEntity{
    @Id
    private String supplierCode;
    private String supplierName;
    private Category category;
    private String address1;
    private String address2;
    private String address3;
    private String address4;
    private String address5;
    private String address6;
    private String contact1;
    private String contact2;
    private String email;
}
