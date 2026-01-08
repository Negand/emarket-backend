package com.rvs.emarket.auth.config.controller;

import com.rvs.emarket.auth.model.Role;
import com.rvs.emarket.auth.model.User;
import com.rvs.emarket.auth.repository.RoleRepository;
import com.rvs.emarket.auth.repository.UserRepository;
import com.rvs.emarket.auth.security.*;
import com.rvs.emarket.auth.dto.LoginRequest;
import com.rvs.emarket.auth.dto.LoginResponse;
import com.rvs.emarket.auth.dto.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;


@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    // ------------------ LOGIN ------------------
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        System.out.println("Login recibido para usuario: " + request.getUsername());
        try {
            // Autenticación
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getUsername(),
                            request.getPassword()
                    )
            );

            // Obtener usuario
            User user = userRepository.findByUsername(request.getUsername())
                    .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

            // Generar JWT
            String token = jwtService.generateToken(user.getUsername());

            return ResponseEntity.ok(new LoginResponse(token, user.getUsername()));

        } catch (AuthenticationException ex) {
            return ResponseEntity.status(401).body("Usuario o contraseña inválidos");
        }
    }

    // ------------------ REGISTRO ------------------
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request) {

        // Validar existencia de usuario o email
        if (userRepository.existsByUsername(request.getUsername())) {
            return ResponseEntity.badRequest().body("Username ya existe");
        }

        if (userRepository.existsByEmail(request.getEmail())) {
            return ResponseEntity.badRequest().body("Email ya registrado");
        }

        // Crear usuario
        User newUser = User.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .enabled(true)
                .build();

        // Asignar rol
        Optional<Role> role = roleRepository.findByName(request.getRole());
        role.ifPresent(r -> newUser.setRoles(Set.of(r)));

        userRepository.save(newUser);

        return ResponseEntity.ok("Usuario registrado correctamente");
    }
}
