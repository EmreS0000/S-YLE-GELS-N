package com.rezarvasyon.saha.controller;

import com.rezarvasyon.saha.dto.Login;
import com.rezarvasyon.saha.dto.Register;
import com.rezarvasyon.saha.dto.UserResponse;
import com.rezarvasyon.saha.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @PostMapping("/register")
    public ResponseEntity <UserResponse> registerUser(@RequestBody Register register){
        return ResponseEntity.ok(userService.registerUser(register));
    }
    @PostMapping("/login")
    public  ResponseEntity<UserResponse> loginUser(@RequestBody Login login){
        return ResponseEntity.ok(userService.loginUser(login));
    }

}
