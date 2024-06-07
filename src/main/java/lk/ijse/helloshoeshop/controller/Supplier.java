package lk.ijse.helloshoeshop.controller;

import lk.ijse.helloshoeshop.dto.StockDTO;
import lk.ijse.helloshoeshop.dto.SupplierDTO;
import lk.ijse.helloshoeshop.exeption.NotFoundException;
import lk.ijse.helloshoeshop.service.StockService;
import lk.ijse.helloshoeshop.service.SuppliersService;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class Supplier {
    @Autowired
    private SuppliersService supplierService;
    @Autowired
    private StockService stockService;
    @GetMapping("/health")
    public String healthTest(){
        return "SupplierHealth Test";
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> saveSupplier(@Validated @RequestBody SupplierDTO supplierDTO, BindingResult bindingResult){
        System.out.println(supplierDTO.getSupplierCode());
        System.out.println(supplierDTO.getSupplierName());
        System.out.println(supplierDTO.getCategory());
        System.out.println(supplierDTO.getAddress1());
        System.out.println(supplierDTO.getAddress2());
        System.out.println(supplierDTO.getAddress3());
        System.out.println(supplierDTO.getAddress4());
        System.out.println(supplierDTO.getPostalCode());
        System.out.println(supplierDTO.getCountry());
        System.out.println(supplierDTO.getContactNo1());
        System.out.println(supplierDTO.getContactNo2());
        System.out.println(supplierDTO.getEmail());
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

    @GetMapping("/nextSupplierId")
    public ResponseEntity<?> generateNextSupplierId(){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(supplierService.generateNextSupplierId());
        }catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
                    body("Internal server error | Supplier Details fetched Unsuccessfully.\nMore Details\n"+exception);
        }
    }

    @GetMapping("/nextStockId")
    public ResponseEntity<?> getStockId(){
        try {
            return ResponseEntity.ok(stockService.getStockId());
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
                    body("Internal server error | Stock Id fetched Unsuccessfully.\nMore Reason\n" + exception);
        }
    }

    @PostMapping(value = "/saveStock/{email}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> saveStock(@Validated @RequestBody StockDTO stockDTO,
                                       BindingResult bindingResult,
                                       @PathVariable("email") String email) {

        if (bindingResult.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(bindingResult.getFieldErrors().get(0).getDefaultMessage());
        }

        try {
            stockService.saveStock(stockDTO, email);
            log.info("StockDto : "+stockDTO+" email : "+email);
            return ResponseEntity.status(HttpStatus.CREATED).body("Stock Details saved Successfully.");
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Internal server error | Stock saved Unsuccessfully.\nMore Details\n" + exception.getMessage());
        }
    }

    @GetMapping(value = "/getAllStock")
    public ResponseEntity<?> getAllStock(){
        try {
            return ResponseEntity.ok(stockService.getAllStock());
        } catch (NotFoundException exception) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employees not found.");
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
                    body("Internal server error | Employees Details fetched Unsuccessfully.\nMore Reason\n"+exception);
        }
    }

    @PutMapping(value = "/updateStock/{stockId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<?> updateStock(@Validated @RequestBody StockDTO stockDTO,
                                         BindingResult bindingResult,
                                         @PathVariable("stockId") String stockId) {

        log.info("StockDto : " +stockDTO+" "+stockId);
        if (bindingResult.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(bindingResult.getFieldErrors().get(0).getDefaultMessage());
        }

        try {
            stockService.updateStock(stockDTO,stockId);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Stock Details Updated Successfully.");
        } catch (NotFoundException exception) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Stock not found.");
        } catch (Exception exception) {
            log.info("Exception : "+exception);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
                    body("Internal server error | Stock Details Updated Unsuccessfully.\nMore Reason\n"+exception);
        }
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "/deleteStock/{stockId}")
    public ResponseEntity<String> deleteStock(@PathVariable ("stockId") String id){
        try {
            stockService.deleteStock(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Stock Details deleted Successfully.");
        } catch (NotFoundException exception) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Stock not found.");
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
                    body("Internal server error | Stock Details deleted Unsuccessfully.\nMore Reason\n"+exception);
        }
    }

}
