package com.web.project.modules.user.controller;

import com.web.project.modules.user.payload.UserRequest;
import com.web.project.modules.user.payload.UserResponse;
import com.web.project.modules.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@Slf4j
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<UserResponse> getUsers() {
        log.info("Get All Users");
        return userService.getAll();
    }

    @PostMapping
    public void addUser(@RequestBody UserRequest request) {
        userService.addUser(request);
    }
}
