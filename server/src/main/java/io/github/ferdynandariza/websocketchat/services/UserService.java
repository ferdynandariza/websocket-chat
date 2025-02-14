package io.github.ferdynandariza.websocketchat.services;

import io.github.ferdynandariza.websocketchat.entity.UserData;
import io.github.ferdynandariza.websocketchat.model.UserRequest;
import io.github.ferdynandariza.websocketchat.model.UserResponse;
import io.github.ferdynandariza.websocketchat.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final AuthenticationManager authManager;
    private final JwtService jwtService;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public UserService(AuthenticationManager authenticationManager, JwtService jwtService, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.authManager = authenticationManager;
        this.jwtService = jwtService;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserResponse register(UserRequest request) {
        UserData userData = userRepository.save(new UserData(request.username(), passwordEncoder.encode(request.password())));
        return new UserResponse(userData.getId(), userData.getUsername());
    }

    public UserResponse login(UserRequest request) {
        Authentication authentication;
        authentication = authManager.authenticate(new UsernamePasswordAuthenticationToken(request.username(), request.password()));

        if (authentication.isAuthenticated()) {
            UserResponse userResponse = new UserResponse(null, request.username(), jwtService.generateToken(request.username()));
            return userResponse;
        } else {
            throw new UsernameNotFoundException("Bad credentials");
        }
    }
}
