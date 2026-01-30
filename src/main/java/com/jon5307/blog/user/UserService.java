package com.jon5307.blog.user;

import com.jon5307.blog.JwtTokenProvider;
import com.jon5307.blog.user.dto.LoginRequest;
import com.jon5307.blog.user.dto.LoginResponse;
import com.jon5307.blog.user.dto.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;

    public LoginResponse login(LoginRequest loginRequest) {
        String username = loginRequest.username();
        String password = loginRequest.password();
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);
        Authentication authentication = authenticationManager.authenticate(token);
        String jwt = jwtTokenProvider.createToken(authentication);
        LocalDateTime now = LocalDateTime.now();
        return new LoginResponse(jwt, now);
    }

    public Long register(RegisterRequest registerRequest) {
        String username = registerRequest.username();
        String email = registerRequest.email();
        String password = registerRequest.password();
        SiteUser user = new SiteUser();
        user.setUsername(username);
        user.setEmail(email);
        String encodedPassword = passwordEncoder.encode(password);
        user.setPassword(encodedPassword); // In a real application, ensure to hash the password
        userRepository.save(user);
        user.setRole("ROLE_USER");
        return user.getId();
    }
}
