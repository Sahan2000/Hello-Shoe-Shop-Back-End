package lk.ijse.helloshoeshop.controller;

import lk.ijse.helloshoeshop.dto.BranchDTO;
import lk.ijse.helloshoeshop.exeption.InvalidException;
import lk.ijse.helloshoeshop.exeption.NotFoundException;
import lk.ijse.helloshoeshop.repostory.request.SignUpRequest;
import lk.ijse.helloshoeshop.repostory.request.SigninRequest;
import lk.ijse.helloshoeshop.repostory.response.JwtAuthenticationResponse;
import lk.ijse.helloshoeshop.service.AuthenticationService;
import lk.ijse.helloshoeshop.service.BranchService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/auth")
public class User {
    private final AuthenticationService authenticationService;
    @Autowired
    private BranchService branchService;

    @PostMapping("/signUp")
    public ResponseEntity<JwtAuthenticationResponse> signup(@RequestBody SignUpRequest signup){
        System.out.println(signup.getEmail());
        return ResponseEntity.ok(authenticationService.signup(signup));
    }

    @PostMapping("/signIn")
    public ResponseEntity<JwtAuthenticationResponse> signIn(@RequestBody SigninRequest signIn){
        return ResponseEntity.ok(authenticationService.signin(signIn));
    }

    @GetMapping("/refresh")
    public ResponseEntity<JwtAuthenticationResponse> refresh(
            @RequestParam("refreshToken") String refreshToken
    ){
        System.out.println(refreshToken);
        return ResponseEntity.ok(authenticationService.refreshToken(refreshToken));
    }

    @PostMapping("/saveBranch")
    public ResponseEntity<?> saveBranch(@Validated @RequestBody BranchDTO branchDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).
                    body(bindingResult.getFieldErrors().get(0).getDefaultMessage());
        }

        try {
            branchService.saveBranch(branchDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body("New Branch Added Successfully.");
        } catch (InvalidException exception) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Product Code Invalid");
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
                    body("Internal server error | New Branch Added Unsuccessfully.\nMore Details\n" + exception);
        }
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<?> getBranches(){
        try {
            return ResponseEntity.ok(branchService.getAllBranches());
        } catch (NotFoundException exception) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Branches not found.");
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
                    body("Internal server error | Branches Details fetched Unsuccessfully.\nMore Reason\n"+exception);
        }
    }
}
