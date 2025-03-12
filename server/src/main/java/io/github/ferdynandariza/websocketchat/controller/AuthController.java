package io.github.ferdynandariza.websocketchat.controller;

import io.github.ferdynandariza.websocketchat.entity.UserData;
import io.github.ferdynandariza.websocketchat.model.UserRequest;
import io.github.ferdynandariza.websocketchat.model.UserResponse;
import io.github.ferdynandariza.websocketchat.services.UserService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(path = "/api")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public UserResponse register(@RequestBody UserRequest request) {
        return userService.register(request);
    }

    @PostMapping("/login")
    public UserResponse login(@RequestBody UserRequest request) {
        return userService.login(request);
    }

    @GetMapping("/ping")
    public String ping(UserData userData) {
        return "pong";
    }
}
