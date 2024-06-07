package lk.ijse.helloshoeshop.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lk.ijse.helloshoeshop.entity.enumerate.Category;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Data
@Entity
@Table(name = "Supplier")
public class SupplierEntity implements SuperEntity{
    @Id
    private String supplierCode;
    private String supplierName;
    @Enumerated(EnumType.STRING)
    private Category category;
    private String address1;
    private String address2;
    private String address3;
    private String address4;
    private String postalCode;
    private String country;
    private String contactNo1;
    private String contactNo2;
    private String email;
    @JsonIgnore
    @OneToMany(mappedBy = "supplierEntity",cascade = CascadeType.ALL)
    private List<StockEntity> stockEntities;
}
