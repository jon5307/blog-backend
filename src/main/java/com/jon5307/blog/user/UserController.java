package com.jon5307.blog.user;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    @PostMapping("/login")
    public String login(
            @RequestParam String username,
            @RequestParam String password) {
        return userService.login(username, password);
    }

    @PostMapping("/signup")
    public String signup(
            @RequestParam String username,
            @RequestParam String email,
            @RequestParam String password) {
        userService.register(username, email, password);
        return "Signup successful";
    }

}
