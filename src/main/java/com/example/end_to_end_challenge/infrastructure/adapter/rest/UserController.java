package com.example.end_to_end_challenge.infrastructure.adapter.rest;

import com.example.end_to_end_challenge.domain.model.User;
import com.example.end_to_end_challenge.domain.port.api.UserServicePort;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserServicePort userServicePort;

    public UserController(UserServicePort userServicePort) {
        this.userServicePort = userServicePort;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userServicePort.getAllUsers();
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userServicePort.createUser(user);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userServicePort.getUserById(id);
    }
}
