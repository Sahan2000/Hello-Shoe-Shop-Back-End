package lk.ijse.helloshoeshop.service.impl;

import lk.ijse.helloshoeshop.conversion.ConversionData;
import lk.ijse.helloshoeshop.dto.EmployeeDTO;
import lk.ijse.helloshoeshop.dto.UserDTO;
import lk.ijse.helloshoeshop.entity.UserEntity;
import lk.ijse.helloshoeshop.entity.enumerate.Role;
import lk.ijse.helloshoeshop.entity.enumerate.Status;
import lk.ijse.helloshoeshop.repostory.UserDao;
import lk.ijse.helloshoeshop.repostory.request.SignUpRequest;
import lk.ijse.helloshoeshop.repostory.request.SigninRequest;
import lk.ijse.helloshoeshop.repostory.response.JwtAuthenticationResponse;
import lk.ijse.helloshoeshop.service.AuthenticationService;
import lk.ijse.helloshoeshop.service.EmployeeService;
import lk.ijse.helloshoeshop.service.JwtService;
import lk.ijse.helloshoeshop.util.UtilMatter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserDao userDao;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final ConversionData conversionData;
    private final EmployeeService employeeService;

    @Override
    public JwtAuthenticationResponse signup(SignUpRequest signUp) {
        UserDTO userDTO = UserDTO.builder()
                .id(UtilMatter.generateId())
                .email(signUp.getEmail())
                .password(passwordEncoder.encode(signUp.getPassword()))
                .role(signUp.getRole())
                .build();
        UserEntity saveUser = userDao.save(conversionData.convertToUserEntity(userDTO));
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setEmail(signUp.getEmail());
        employeeDTO.setDesignation((signUp.getRole().equals(Role.ADMIN)) ?"Manager":null);
        employeeDTO.setBranchId(signUp.getBranchId());
        employeeDTO.setStatus(Status.LOW);
        employeeDTO.setDateOfJoin(Date.valueOf(LocalDate.now()));
        employeeService.saveEmployee(employeeDTO);
        String generateToken = jwtService.generateToken(saveUser);
        return JwtAuthenticationResponse.builder().token(generateToken).build();
    }

    @Override
    public JwtAuthenticationResponse signin(SigninRequest signIn) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signIn.getEmail(),signIn.getPassword())
        );
        UserEntity user = userDao.findByEmail(signIn.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        var generateToken = jwtService.generateToken(user);
        return JwtAuthenticationResponse.builder().token(generateToken).build();
    }

    @Override
    public JwtAuthenticationResponse refreshToken(String refreshToken) {
        var userEntity = userDao
                .findByEmail(jwtService.extractUserName(refreshToken))
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return JwtAuthenticationResponse.builder().
                token(jwtService.generateToken(userEntity)).build();
    }
}
