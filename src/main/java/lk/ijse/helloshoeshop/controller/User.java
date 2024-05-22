package lk.ijse.helloshoeshop.controller;

import lk.ijse.helloshoeshop.repostory.request.SignUpRequest;
import lk.ijse.helloshoeshop.repostory.request.SigninRequest;
import lk.ijse.helloshoeshop.repostory.response.JwtAuthenticationResponse;
import lk.ijse.helloshoeshop.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/auth")
public class User {
    private final AuthenticationService authenticationService;

    @PostMapping("/signUp")
    public ResponseEntity<JwtAuthenticationResponse> signup(@RequestBody SignUpRequest signup){
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
}
