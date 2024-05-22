package lk.ijse.helloshoeshop.controller;

import lk.ijse.helloshoeshop.dto.CustomerDTO;
import lk.ijse.helloshoeshop.dto.SupplierDTO;
import lk.ijse.helloshoeshop.exeption.NotFoundException;
import lk.ijse.helloshoeshop.service.SuppliersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
@RequestMapping("api/v1/supplier")
public class Supplier {
    @Autowired
    private SuppliersService supplierService;
    @GetMapping("/health")
    public String healthTest(){
        return "SupplierHealth Test";
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> saveSupplier(@Validated @RequestBody SupplierDTO supplierDTO, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(bindingResult.getFieldErrors().get(0).getDefaultMessage());
        }
        try {
            supplierService.saveSupplier(supplierDTO);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Supplier Details saved Successfully.");
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
                    body("Internal server error | Supplier saved Unsuccessfully.\nMore Details\n"+exception);
        }
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getSupplier(@Validated @PathVariable String id){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(supplierService.getSupplier(id));
        }catch (NotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Supplier not found.");
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
                    body("Internal server error | Supplier saved Unsuccessfully.\nMore Details\n"+exception);
        }
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllSuppliers(){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(supplierService.getAllSuppliers());
        }catch (Exception exception){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
                    body("Internal server error | Supplier Details fetched Unsuccessfully.\nMore Reason\n"+exception);
        }
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateCustomer(@Validated @PathVariable String id, @RequestBody SupplierDTO supplierDTO, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(bindingResult.getFieldErrors().get(0).getDefaultMessage());
        }
        try {
            supplierService.updateSupplier(id, supplierDTO);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Supplier Details updated Successfully.");
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
                    body("Internal server error | Supplier Details updated Unsuccessfully.\nMore Details\n"+exception);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteSupplier(@Validated @PathVariable String id){
        try {
            supplierService.deleteSupplier(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Supplier Details deleted Successfully.");
        }catch (NotFoundException exception) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Supplier not found.");
        }catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
                    body("Internal server error | Supplier Details deleted Unsuccessfully.\nMore Details\n"+exception);
        }
    }

}
