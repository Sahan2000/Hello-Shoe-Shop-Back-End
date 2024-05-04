package lk.ijse.helloshoeshop.controller;

import lk.ijse.helloshoeshop.dto.GenderDTO;
import lk.ijse.helloshoeshop.dto.OccasionDTO;
import lk.ijse.helloshoeshop.service.GenderService;
import lk.ijse.helloshoeshop.service.InventoryService;
import lk.ijse.helloshoeshop.service.OccasionService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/inventory")
@AllArgsConstructor
public class Inventory {
    @Autowired
    private GenderService genderService;

    @Autowired
    private OccasionService occasionService;

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
    public ResponseEntity<?> updateGender(@Validated @PathVariable ("id") String id, @RequestBody GenderDTO genderDTO, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(bindingResult.getFieldErrors().get(0).getDefaultMessage());
        }
        try {
            genderService.updateGender(id, genderDTO);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Gender Details updated Successfully.");
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
                    body("Internal server error | Gender Details fetched Unsuccessfully.\nMore Details\n"+exception);
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
    public ResponseEntity<?> updateOccation(@Validated @PathVariable ("id") String id, @RequestBody OccasionDTO occasionDTO, BindingResult bindingResult){
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
    public ResponseEntity<?> deleteGender(@Validated @PathVariable ("id") String id, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(bindingResult.getFieldErrors().get(0).getDefaultMessage());
        }
        try {
            occasionService.deleteOccasion(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Occasion Details deleted Successfully.");
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
                    body("Internal server error | Occasion Details deleted Unsuccessfully.\nMore Details\n"+exception);
        }
    }

}
