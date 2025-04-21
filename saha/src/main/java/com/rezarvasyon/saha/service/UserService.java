package com.rezarvasyon.saha.service;

import com.rezarvasyon.saha.dto.Login;
import com.rezarvasyon.saha.dto.Register;
import com.rezarvasyon.saha.dto.UserResponse;
import com.rezarvasyon.saha.entity.User;
import com.rezarvasyon.saha.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    public UserResponse registerUser(Register register){
        if(userRepository.findByEmail(register.getEmail()).isPresent()){
            throw new RuntimeException("bu e posta zaten kullanımda");
        }
        User user=new User();
        user.setUserName(register.getUserName());
        user.setEmail(register.getEmail());
        user.setHashedPassword(passwordEncoder.encode(register.getPassword()));

        User savedUser=userRepository.save(user);
        return new UserResponse(savedUser.getId(),savedUser.getUserName(),savedUser.getEmail());
    }
    public UserResponse loginUser(Login login){
        Optional<User> optionalUser=userRepository.findByEmail(login.getEmail());
        if(optionalUser.isEmpty()){
            throw new RuntimeException("kullanıcı bulunamadı");
        }
        User user=optionalUser.get();
        if(!passwordEncoder.matches(login.getPassword(), user.getHashedPassword())){
            throw new RuntimeException("hatalı şifre");
        }
        Authentication authentication =authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(login.getEmail(),login.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return new UserResponse(user.getId(), user.getUserName(), user.getEmail());
    }
}
