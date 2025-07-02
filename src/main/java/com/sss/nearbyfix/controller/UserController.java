package com.sss.nearbyfix.controller;

import com.sss.nearbyfix.model.User;
import com.sss.nearbyfix.security.JwtUtil;
import com.sss.nearbyfix.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) {
        return new ResponseEntity<>(userService.registerUser(user), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody User user) {
        Optional<User> found = userService.login(user.getEmail(), user.getPassword());
        if (found.isPresent()) {
            String token = jwtUtil.generateToken(found.get().getEmail());
            return ResponseEntity.ok(Map.of(
                "user", found.get(),
                "token", token
            ));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }

}
