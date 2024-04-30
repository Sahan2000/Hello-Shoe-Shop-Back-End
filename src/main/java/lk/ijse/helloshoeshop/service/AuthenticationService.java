package lk.ijse.helloshoeshop.service;

import lk.ijse.helloshoeshop.repostory.request.SignUpRequest;
import lk.ijse.helloshoeshop.repostory.request.SigninRequest;
import lk.ijse.helloshoeshop.repostory.response.JwtAuthenticationResponse;

public interface AuthenticationService {
    JwtAuthenticationResponse signup(SignUpRequest request);

    JwtAuthenticationResponse signin(SigninRequest request);

    JwtAuthenticationResponse refreshToken(String refreshToken);
}
