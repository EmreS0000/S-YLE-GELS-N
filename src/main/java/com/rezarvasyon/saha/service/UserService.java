package com.rezarvasyon.saha.service;

import com.rezarvasyon.saha.dto.LoginUserDto;
import com.rezarvasyon.saha.dto.RegisterUserDto;
import com.rezarvasyon.saha.entity.User;
import com.rezarvasyon.saha.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    public UserService(
            UserRepository userRepository,
            AuthenticationManager authenticationManager,
            PasswordEncoder passwordEncoder

    ) {
        this.userRepository = userRepository;
        this.authenticationManager=authenticationManager;
        this.passwordEncoder=passwordEncoder;
    }

    public User registerUser(RegisterUserDto registerUserDto) {

        User user = new User();
        user.setUserName(registerUserDto.getUsername());
        user.setPassword(passwordEncoder.encode(registerUserDto.getPassword()));
        user.setEmail(registerUserDto.getEmail());
        userRepository.save(user);
        return user;
    }

    public User loginUser(LoginUserDto loginUserDto) {

      authenticationManager.authenticate(
              new UsernamePasswordAuthenticationToken(
                      loginUserDto.getEmail(),
                      loginUserDto.getPassword()
              )
      );
      return userRepository.findByEmail(loginUserDto.getEmail())
              .orElseThrow();
    }
}
