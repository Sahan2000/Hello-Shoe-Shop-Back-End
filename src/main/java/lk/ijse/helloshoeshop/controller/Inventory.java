package lk.ijse.helloshoeshop.controller;

import lk.ijse.helloshoeshop.dto.*;
import lk.ijse.helloshoeshop.exeption.NotFoundException;
import lk.ijse.helloshoeshop.service.*;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
@RequestMapping("/api/v1/inventory")
@AllArgsConstructor
public class Inventory {
    @Autowired
    private GenderService genderService;

    @Autowired
    private OccasionService occasionService;

    @Autowired
    private VarietyService varietyService;

    @Autowired
    private InventoryService inventoryDao;

    @Autowired
    private SizesService sizeService;

    @GetMapping("/health")
    public String health() {
        return "Inventory health check";
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/genderSave")
    public ResponseEntity<?> saveGender(@Validated @RequestBody GenderDTO genderDTO, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(bindingResult.getFieldErrors().get(0).getDefaultMessage());
        }
        try {
            genderService.saveGender(genderDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body("Gender Details saved Successfully.");
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
                    body("Internal server error | Gender saved Unsuccessfully.\nMore Details\n"+exception);
        }
    }

    @GetMapping("/genderGetAll")
    public ResponseEntity<?> getAllGender(){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(genderService.genderGetAll());
        }catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
                    body("Internal server error | Gender Details fetched Unsuccessfully.\nMore Details\n"+exception);
        }
    }

    @PutMapping("/genderUpdate")
    public ResponseEntity<?> updateGender(@Validated @RequestParam ("id") String id, @RequestBody GenderDTO genderDTO, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(bindingResult.getFieldErrors().get(0).getDefaultMessage());
        }
        try {
            System.out.println(" gender id : "+id);
            genderService.updateGender(id, genderDTO);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Gender Details updated Successfully.");
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
                    body("Internal server error | Gender Details fetched Unsuccessfully.\nMore Details\n"+exception);
        }
    }

    @DeleteMapping("/genderDelete")
    public ResponseEntity<String> deleteGender(@RequestParam String id){
        try {
            genderService.deleteGender(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Gender Details deleted Successfully.");
        } catch (NotFoundException exception) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Gender not found.");
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
                    body("Internal server error | Gender Details deleted Unsuccessfully.\nMore Reason\n"+exception);
        }
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/occationSave")
    public ResponseEntity<?> saveOccation(@Validated @RequestBody OccasionDTO occasionDTO, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(bindingResult.getFieldErrors().get(0).getDefaultMessage());
        }
        try {
            occasionService.saveOccasion(occasionDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body("Occasion Details saved Successfully.");
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
                    body("Internal server error | Occasion saved Unsuccessfully.\nMore Details\n"+exception);
        }
    }

    @GetMapping("/occationGetAll")
    public ResponseEntity<?> getAllOccasion(){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(occasionService.getAllOccasion());
        }catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
                    body("Internal server error | Occasion Details fetched Unsuccessfully.\nMore Details\n"+exception);
        }
    }

    @PutMapping("/occationUpdate")
    public ResponseEntity<?> updateOccation(@Validated @RequestParam ("id") String id, @RequestBody OccasionDTO occasionDTO, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(bindingResult.getFieldErrors().get(0).getDefaultMessage());
        }
        try {
            occasionService.updateOccasion(id, occasionDTO);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Occasion Details updated Successfully.");
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
                    body("Internal server error | Occasion Details fetched Unsuccessfully.\nMore Details\n"+exception);
        }
    }

    @DeleteMapping("/occasionDelete")
    public ResponseEntity<String> deleteOccasion(@RequestParam String id){
        try {
            occasionService.deleteOccasion(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Occasion Details deleted Successfully.");
        } catch (NotFoundException exception) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Occasion not found.");
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
                    body("Internal server error | Occasion Details deleted Unsuccessfully.\nMore Reason\n"+exception);
        }
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/varietySave")
    public ResponseEntity<?> saveVariety(@Validated @RequestBody VarietyDTO varietyDTO,
                                         BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).
                    body(bindingResult.getFieldErrors().get(0).getDefaultMessage());
        }

        try {
            varietyService.saveVariety(varietyDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body("Variety Details saved Successfully.");
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
                    body("Internal server error | Variety saved Unsuccessfully.\nMore Details\n"+exception);
        }
    }

    @GetMapping("/getAllVariety")
    public ResponseEntity<?> getAllVariety(){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(varietyService.getAllVariety());
        }catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
                    body("Internal server error | Variety Details fetched Unsuccessfully.\nMore Details\n"+exception);
        }
    }

    @PutMapping("/updateVariety")
    public ResponseEntity<?> updateVariety(@Validated @RequestParam ("id") String id, @RequestBody VarietyDTO varietyDTO, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(bindingResult.getFieldErrors().get(0).getDefaultMessage());
        }
        try {
            varietyService.updateVariety(id, varietyDTO);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Variety Details updated Successfully.");
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
                    body("Internal server error | Variety Details fetched Unsuccessfully.\nMore Details\n"+exception);
        }
    }

    @DeleteMapping("/deleteVariety")
    public ResponseEntity<?> deleteVariety(@Validated @RequestParam ("id") String id){
         try {
             varietyService.deleteVariety(id);
             return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Variety Details deleted Successfully.");
         } catch (Exception exception) {
             return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
                     body("Internal server error | Variety Details deleted Unsuccessfully.\nMore Details\n"+exception);
         }
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/sizeSave")
    public ResponseEntity<?> saveSize(@Validated @RequestBody SizesDTO sizeDTO,
                                      BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).
                    body(bindingResult.getFieldErrors().get(0).getDefaultMessage());
        }

        try {
            sizeService.saveSize(sizeDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body("Gender Details saved Successfully.");
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
                    body("Internal server error | Gender saved Unsuccessfully.\nMore Details\n"+exception);
        }
    }

    @GetMapping("/sizeGetAll")
    public ResponseEntity<?> getAllSizes(){
        try {
            return ResponseEntity.ok(sizeService.getAllSizes());
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
                    body("Internal server error | Size Details fetched Unsuccessfully.\nMore Reason\n"+exception);
        }
    }

    @GetMapping("/nextSizeId")
    public ResponseEntity<?> nextSizeId(){
        try {
            return ResponseEntity.ok(sizeService.getSizeId());
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
                    body("Internal server error | Size Details fetched Unsuccessfully.\nMore Reason\n"+exception);
        }
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/sizeDelete")
    public ResponseEntity<String> deleteSize(@RequestParam String id){
        try {
            sizeService.deleteSize(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Size Details deleted Successfully.");
        } catch (NotFoundException exception) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Size not found.");
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
                    body("Internal server error | Size Details deleted Unsuccessfully.\nMore Reason\n"+exception);
        }
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/sizeUpdate")
    public ResponseEntity<String> updateSize(@Validated @RequestBody SizesDTO sizeDTO,
                                             BindingResult bindingResult,
                                             @RequestParam ("id") String id) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).
                    body(bindingResult.getFieldErrors().get(0).getDefaultMessage());
        }

        try {
            sizeService.updateSize(id,sizeDTO);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Size Details Updated Successfully.");
        } catch (NotFoundException exception) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Size not found.");
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
                    body("Internal server error | Size Details Gender Unsuccessfully.\nMore Reason\n"+exception);
        }

    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/saveInventory")
    public ResponseEntity<?> saveInventory(@Validated @RequestBody ItemDTO inventoryDTO, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(bindingResult.getFieldErrors().get(0).getDefaultMessage());
        }
        try {
            inventoryDao.saveInventory(inventoryDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body("Inventory Details saved Successfully.");
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
                    body("Internal server error | Inventory saved Unsuccessfully.\nMore Details\n"+exception);
        }
    }
    @GetMapping("/getAllInventory")
    public ResponseEntity<?> getAllInventory(){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(inventoryDao.getAllInventory());
        }catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
                    body("Internal server error | Inventory Details fetched Unsuccessfully.\nMore Details\n"+exception);
        }
    }

    @GetMapping("/getItem")
    public ResponseEntity<?> getInventory(@Validated @PathVariable ("id") String id, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(bindingResult.getFieldErrors().get(0).getDefaultMessage());
        }
        try {
            return ResponseEntity.status(HttpStatus.OK).body(inventoryDao.getInventory(id));
        }catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
                    body("Internal server error | Inventory Details fetched Unsuccessfully.\nMore Details\n"+exception);
        }
    }

    @PutMapping("/updateInventory")
    public ResponseEntity<?> updateInventory(@Validated @PathVariable ("id") String id, @RequestBody ItemDTO inventoryDTO, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(bindingResult.getFieldErrors().get(0).getDefaultMessage());
        }
        try {
            inventoryDao.updateInventory(id, inventoryDTO);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Inventory Details updated Successfully.");
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
                    body("Internal server error | Inventory Details fetched Unsuccessfully.\nMore Details\n"+exception);
        }
    }

    @DeleteMapping("/deleteInventory")
    public ResponseEntity<?> deleteInventory(@Validated @PathVariable ("id") String id, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(bindingResult.getFieldErrors().get(0).getDefaultMessage());
        }
        try {
            inventoryDao.deleteInventory(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Inventory Details deleted Successfully.");
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
                    body("Internal server error | Inventory Details deleted Unsuccessfully.\nMore Details\n"+exception);
        }
    }

}
