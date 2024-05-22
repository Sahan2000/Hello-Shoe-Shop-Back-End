package lk.ijse.helloshoeshop.controller;

import lk.ijse.helloshoeshop.dto.CustomerDTO;
import lk.ijse.helloshoeshop.exeption.NotFoundException;
import lk.ijse.helloshoeshop.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Timestamp;
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
@RequestMapping("api/v1/customer")
public class Customer {
    @Autowired
    private CustomerService customerService;
    @GetMapping("/health")
    public String healthTest(){
        return "CustomerHealth Test";
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> saveCustomer(@Validated @RequestBody CustomerDTO customerDTO, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(bindingResult.getFieldErrors().get(0).getDefaultMessage());
        }
        try {
            customerService.saveCustomer(customerDTO);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Customer Details saved Successfully.");
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
                    body("Internal server error | Customer saved Unsuccessfully.\nMore Details\n"+exception);
        }
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getCustomer(@Validated @PathVariable String id){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(customerService.getCustomer(id));
        }catch (NotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer not found.");
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
                    body("Internal server error | Customer saved Unsuccessfully.\nMore Details\n"+exception);
        }
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllCustomers(){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(customerService.getAllCustomer());
        }catch (Exception exception){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
                    body("Internal server error | Customer Details fetched Unsuccessfully.\nMore Reason\n"+exception);
        }
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateCustomer(@Validated @PathVariable String id, @RequestBody CustomerDTO customerDTO, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(bindingResult.getFieldErrors().get(0).getDefaultMessage());
        }
        try {
            customerService.updateCustomer(id, customerDTO);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Customer Details updated Successfully.");
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
                    body("Internal server error | Customer Details updated Unsuccessfully.\nMore Details\n"+exception);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteCustomer(@Validated @PathVariable String id){
        try {
            customerService.deleteCustomer(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Customer Details deleted Successfully.");
        }catch (NotFoundException exception) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer not found.");
        }catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
                    body("Internal server error | Customer Details deleted Unsuccessfully.\nMore Details\n"+exception);
        }
    }

}
