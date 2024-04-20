package lk.ijse.helloshoeshop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.sql.Timestamp;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@RequiredArgsConstructor
@Entity
@Table(name = "customer")
public class CustomerEntity implements SuperEntity{
    @Id
    private String customerCode;
    private String customerName;
    private Gender gender;
    private Date joinedDate;
    @Enumerated(EnumType.STRING)
    private Level level;
    private int totalPoints;
    private Date dob;
    private String address1;
    private String address2;
    private String address3;
    private String address4;
    private String address5;
    private String contactNo;
    private String email;
    private Timestamp purchaseData;
}
