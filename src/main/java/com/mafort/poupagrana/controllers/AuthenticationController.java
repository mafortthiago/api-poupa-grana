package com.mafort.poupagrana.controllers;

import com.mafort.poupagrana.domain.user.AuthenticationDTO;
import com.mafort.poupagrana.domain.user.LoginResponseDTO;
import com.mafort.poupagrana.domain.user.RegisterDTO;
import com.mafort.poupagrana.domain.user.User;
import com.mafort.poupagrana.services.TokenService;
import com.mafort.poupagrana.repositories.UserRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
public class AuthenticationController {
    private final AuthenticationManager authenticationManager;
    private final UserRepository repository;
    private final TokenService tokenService;
    private final PasswordEncoder passwordEncoder;

    public AuthenticationController(AuthenticationManager authenticationManager, UserRepository repository, TokenService tokenService, PasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.repository = repository;
        this.tokenService = tokenService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data){
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var user = (User) auth.getPrincipal();
        var token = tokenService.generateToken(user);

        return ResponseEntity.ok(new LoginResponseDTO(token, user.getId()));
    }
    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO data) throws Exception {
        if(this.repository.findByLogin(data.login()) != null) {
            throw new Exception("User with login " + data.login() + " already exists.");
        }

        String encryptedPassword = passwordEncoder.encode(data.password());
        User newUser = new User(data.login(), encryptedPassword, data.role());

        this.repository.save(newUser);

        return ResponseEntity.ok().build();
    }
}
