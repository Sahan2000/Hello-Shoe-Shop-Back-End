package lk.ijse.helloshoeshop.entity;

import jakarta.persistence.*;
import lk.ijse.helloshoeshop.entity.enumerate.Gender;
import lk.ijse.helloshoeshop.entity.enumerate.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@RequiredArgsConstructor
@Entity
@Table(name = "employee")
public class EmployeeEntity implements SuperEntity {
    @Id
    private String employeeId;
    private String employeeName;
    private String employeeProfilePic;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String status;
    private String designation;
    @Enumerated(EnumType.STRING)
    private Role accessRole;
    private Date dob;
    private Date joinedDate;
    private String attachedBranch;
    private String address1;
    private String address2;
    private String address3;
    private String address4;
    private String address5;
    private String contactNo;
    private String email;
    private String guardian;
    private String emergencyContact;

}
