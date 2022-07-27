package ru.devteam.resume.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.devteam.resume.dtos.JwtRequest;
import ru.devteam.resume.dtos.JwtResponse;
import ru.devteam.resume.exceptions.AppError;
import ru.devteam.resume.services.UserService;
import ru.devteam.resume.utils.JwtTokenUtil;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    private final UserService userService;
    private final JwtTokenUtil jwtTokenUtil;
    private final AuthenticationManager authenticationManager;

    @PostMapping
    public ResponseEntity<?> createAuthToken(@RequestBody JwtRequest authRequest){
try {
    authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword()));
}catch (BadCredentialsException e) {
    return new ResponseEntity<>(new AppError("CHECK_TOKEN_ERROR", "Некорректный емайл или пароль"), HttpStatus.UNAUTHORIZED);
}
UserDetails userDetails = userService.loadUserByUsername(authRequest.getEmail());
String token = jwtTokenUtil.generateToken(userDetails);
return ResponseEntity.ok(new JwtResponse(token));
    }
}