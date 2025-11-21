package com.fiap.futureskills.service;

import com.fiap.futureskills.config.JwtTokenProvider;
import com.fiap.futureskills.domain.user.User;
import com.fiap.futureskills.dto.AuthDTOs;
import com.fiap.futureskills.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final AuthenticationManager authenticationManager;

    // Registra um novo usuário e já retorna o token pra ele não precisar logar em
    // seguida
    public AuthDTOs.TokenResponse register(AuthDTOs.RegisterRequest request) {
        var user = User.builder()
                .name(request.name())
                .email(request.email())
                .password(passwordEncoder.encode(request.password())) // Importante: nunca salvar senha em texto plano
                .role(request.role())
                .build();

        userRepository.save(user);
        var jwtToken = jwtTokenProvider.generateToken(user);
        return new AuthDTOs.TokenResponse(jwtToken);
    }

    public AuthDTOs.TokenResponse authenticate(AuthDTOs.LoginRequest request) {
        // O AuthenticationManager cuida de validar as credenciais
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.email(),
                        request.password()));
        var user = userRepository.findByEmail(request.email())
                .orElseThrow();
        var jwtToken = jwtTokenProvider.generateToken(user);
        return new AuthDTOs.TokenResponse(jwtToken);
    }
}
