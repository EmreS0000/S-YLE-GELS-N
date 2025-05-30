package com.rezarvasyon.saha.service;

import com.rezarvasyon.saha.dto.LoginUserDto;
import com.rezarvasyon.saha.dto.RegisterUserDto;
import com.rezarvasyon.saha.entity.Restaurant;
import com.rezarvasyon.saha.entity.User;
import com.rezarvasyon.saha.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
   private UserRepository userRepository;
    public void registerUser(RegisterUserDto registerUserDto){
        User user=new User();
        user.setUserName(registerUserDto.getUsername());
        user.setPassword(registerUserDto.getPassword());
        user.setEmail(user.getEmail());
        User savedUser=userRepository.save(user);
    }
    public void loginUser(LoginUserDto loginUserDto){
        Optional<User> user=userRepository.findByEmail(loginUserDto.getEmail());
    }
}
