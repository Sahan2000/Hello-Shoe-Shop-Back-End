package lk.ijse.helloshoeshop.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lk.ijse.helloshoeshop.entity.enumerate.Gender;
import lk.ijse.helloshoeshop.entity.enumerate.Status;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.sql.Date;

@RequiredArgsConstructor
@Data
@Entity
@Table(name = "employee")
public class EmployeeEntity implements SuperEntity{
    @Id
    private String employeeCode;
    private String employeeName;
    @Column(columnDefinition = "LONGTEXT")
    private String pic;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Enumerated(EnumType.STRING)
    private Status status;
    private String designation;
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    @Temporal(TemporalType.DATE)
    private Date dateOfJoin;
    private String address1;
    private String address2;
    private String address3;
    private String address4;
    private String postalCode;
    private String contactNo;
    private String email;
    private String emergencyContactName;
    private String emergencyContact;

    @JsonManagedReference
    @OneToOne(cascade = CascadeType.ALL)
    private UserEntity userEntity;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "branchId", nullable = true)
    private BranchEntity branch;

}
