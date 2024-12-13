package com.JavaMiniProject.SchoolManagementSystem.service;
import com.JavaMiniProject.SchoolManagementSystem.authController.AuthRequest;
import com.JavaMiniProject.SchoolManagementSystem.authController.AuthenticationResponse;
import com.JavaMiniProject.SchoolManagementSystem.authController.RegisterRequest;
import com.JavaMiniProject.SchoolManagementSystem.filter.JwtService;
import com.JavaMiniProject.SchoolManagementSystem.model.Parent;
import com.JavaMiniProject.SchoolManagementSystem.repository.ParentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final ParentRepository parentRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    @Transactional
    public AuthenticationResponse register(RegisterRequest request) {
        if (parentRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already in use");
        }
        if (!request.getPassword().equals(request.getConfirmPassword())) {
            throw new RuntimeException("Passwords do not match");
        }

        var parent = Parent.builder()
                .firstName(request.getFirstName())
                .middleName(request.getMiddleName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .build();
        parentRepository.save(parent);
        var token = jwtService.generateToken(parent);
        return AuthenticationResponse.builder()
                .jwt(token)
                .build();

    }
        public AuthenticationResponse authenticate (AuthRequest request){
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
            );
            var parent = parentRepository.findByEmail(request.getEmail())
                    .orElseThrow(() -> new RuntimeException("User not found"));

            var token = jwtService.generateToken(parent);
            return AuthenticationResponse.builder()
                    .jwt(token)
                    .build();
        }

    }