package lk.ijse.helloshoeshop.entity;

import jakarta.persistence.*;
import lk.ijse.helloshoeshop.entity.enumerate.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@RequiredArgsConstructor
@Entity
@Table(name = "supplier")
public class SupplierEntity implements SuperEntity{
    @Id
    private String supplierId;
    private String supplierName;
    private Category category;
    private String address1;
    private String address2;
    private String address3;
    private String address4;
    private String address5;
    private String address6;
    private String contactNo1;
    private String contactNo2;
    private String email;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "supplier")
    private List<SupplyEntity> supplyList;
}

