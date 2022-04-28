package me.matej.hikingtrailmapper.controller;

import me.matej.hikingtrailmapper.contracts.LogInRequest;
import me.matej.hikingtrailmapper.contracts.SignUpRequest;
import me.matej.hikingtrailmapper.model.User;
import me.matej.hikingtrailmapper.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/sign-up")
    public User signUp(@RequestBody SignUpRequest request) {
        return userService.signUp(request);
    }

    @PostMapping("/log-in")
    public User logIn(@RequestBody LogInRequest request) {
        return userService.userLogin(request.getUserName(), request.getPassword());
    }
}
