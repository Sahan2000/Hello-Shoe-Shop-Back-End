package lk.ijse.helloshoeshop.controller;

import jakarta.validation.Valid;
import lk.ijse.helloshoeshop.dto.EmployeeDTO;
import lk.ijse.helloshoeshop.entity.enumerate.Gender;
import lk.ijse.helloshoeshop.entity.enumerate.Status;
import lk.ijse.helloshoeshop.exeption.NotFoundException;
import lk.ijse.helloshoeshop.service.EmployeeService;
import lk.ijse.helloshoeshop.util.UtilMatter;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Date;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
@RequestMapping("/api/v1/employee")
@AllArgsConstructor
public class Employee {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/health")
    public String healthCheck(){
        return "Employee Health Check";
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> saveEmployee(@Validated
                                              @RequestPart ("employeeName") String employeeName,
                                          @RequestPart ("profilePic") String profilePic,
                                          @RequestPart ("gender") String gender,
                                          @RequestPart ("status") String status,
                                          @RequestPart ("designation") String designation,
                                          @RequestPart ("dateOfBirth") String dateOfBirth,
                                          @RequestPart ("attachedBranch") String attachedBranch,
                                          @RequestPart ("address1") String address1,
                                          @RequestPart ("address2") String address2,
                                          @RequestPart ("address3") String address3,
                                          @RequestPart ("address4") String address4,
                                          @RequestPart ("postalCode") String postalCode,
                                          @RequestPart ("contactNo") String contactNo,
                                          @RequestPart ("email") String email,
                                          @RequestPart ("emergencyContactName") String emergencyContactName,
                                          @RequestPart ("emergencyContact") String emergencyContact,
                                          @RequestPart ("dateOfJoin") String dateOfJoin,
                                          Errors errors
                                          ){
        if(errors.hasErrors()){
            return new ResponseEntity<>(errors.getAllErrors(),HttpStatus.BAD_REQUEST);
        }
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setEmployeeName(employeeName);
        employeeDTO.setProfilePic(UtilMatter.convertBase64(profilePic));
        employeeDTO.setGender(Gender.valueOf(gender));
        employeeDTO.setStatus(status);
        employeeDTO.setDesignation(designation);
        employeeDTO.setDateOfBirth(Date.valueOf(dateOfBirth));
        employeeDTO.setAttachedBranch(attachedBranch);
        employeeDTO.setAddress1(address1);
        employeeDTO.setAddress2(address2);
        employeeDTO.setAddress3(address3);
        employeeDTO.setAddress4(address4);
        employeeDTO.setPostalCode(postalCode);
        employeeDTO.setContactNo(contactNo);
        employeeDTO.setEmail(email);
        employeeDTO.setEmergencyContactName(emergencyContactName);
        employeeDTO.setEmergencyContact(emergencyContact);
        employeeDTO.setDateOfJoin(Date.valueOf(dateOfJoin));
        employeeService.saveEmployee(employeeDTO);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Employee Details saved Successfully.");
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getEmployee(@Validated @PathVariable ("id") String id){
        try {
            return ResponseEntity.ok(employeeService.getEmployee(id));
        } catch (NotFoundException exception) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee not found.");
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
                    body("Internal server error | Employee Details fetched Unsuccessfully.\nMore Reason\n"+exception);
        }
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllEmployees(){
        try {
            return ResponseEntity.ok(employeeService.getAllEmployees());
        } catch (NotFoundException exception) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employees not found.");
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
                    body("Internal server error | Employees Details fetched Unsuccessfully.\nMore Reason\n"+exception);
        }
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping(value = "/{id}",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> updateEmployee(@PathVariable ("id") String id,
                                            @Valid
                                            @RequestPart ("employeeName") String employeeName,
                                            @RequestPart ("profilePic") String profilePic,
                                            @RequestPart ("gender") String gender,
                                            @RequestPart ("status") String status,
                                            @RequestPart ("designation") String designation,
                                            @RequestPart ("dateOfBirth") String dateOfBirth,
                                            @RequestPart ("attachedBranch") String attachedBranch,
                                            @RequestPart ("address1") String address1,
                                            @RequestPart ("address2") String address2,
                                            @RequestPart ("address3") String address3,
                                            @RequestPart ("address4") String address4,
                                            @RequestPart ("postalCode") String postalCode,
                                            @RequestPart ("contactNo") String contactNo,
                                            @RequestPart ("email") String email,
                                            @RequestPart ("emergencyContactName") String emergencyContactName,
                                            @RequestPart ("emergencyContact") String emergencyContact,
                                            @RequestPart ("dateOfJoin") String dateOfJoin,
                                            Errors errors) {
        if (errors.hasFieldErrors()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    errors.getFieldErrors().get(0).getDefaultMessage());
        }

        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setEmployeeName(employeeName);
        employeeDTO.setProfilePic(UtilMatter.convertBase64(profilePic));
        employeeDTO.setGender(Gender.valueOf(gender));
        employeeDTO.setStatus(status);
        employeeDTO.setDesignation(designation);
        employeeDTO.setDateOfBirth(Date.valueOf(dateOfBirth));
        employeeDTO.setAttachedBranch(attachedBranch);
        employeeDTO.setAddress1(address1);
        employeeDTO.setAddress2(address2);
        employeeDTO.setAddress3(address3);
        employeeDTO.setAddress4(address4);
        employeeDTO.setPostalCode(postalCode);
        employeeDTO.setContactNo(contactNo);
        employeeDTO.setEmail(email);
        employeeDTO.setEmergencyContact(emergencyContact);
        employeeDTO.setEmergencyContactName(emergencyContactName);
        employeeDTO.setDateOfJoin(Date.valueOf(dateOfJoin));

        try {
            employeeService.updateEmployee(id,employeeDTO);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Employee Details Updated Successfully.");
        } catch (NotFoundException exception) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee not found.");
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
                    body("Internal server error | Employee Details Updated Unsuccessfully.\nMore Reason\n"+exception);
        }
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable ("id") String id){
        try {
            employeeService.deleteEmployee(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Employee Details deleted Successfully.");
        } catch (NotFoundException exception) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee not found.");
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
                    body("Internal server error | Employee Details deleted Unsuccessfully.\nMore Reason\n"+exception);
        }
    }
}
