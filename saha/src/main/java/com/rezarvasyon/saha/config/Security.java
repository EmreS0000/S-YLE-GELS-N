package com.rezarvasyon.saha.config;

import com.rezarvasyon.saha.service.CustomUserDetailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class Security {
    private final CustomUserDetailService customUserDetailService;
    public Security(CustomUserDetailService customUserDetailService){
        this.customUserDetailService=customUserDetailService;
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)throws Exception{
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // Lambda DSL ile güvenlik yapılandırması
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/users/register", "/api/users/login").permitAll() // Bu URL'lere public erişim izni ver
                        .anyRequest().authenticated() // Diğer tüm isteklerde kimlik doğrulaması gereklidir
                )
                .csrf(csrf -> csrf.disable()) // CSRF'yi devre dışı bırakıyoruz
                .formLogin(form ->form
                        .defaultSuccessUrl("/home",true)
                        .permitAll())

                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login")// Çıkış yapma URL'si
                        .permitAll() // Logout sayfasına herkese izin ver
                );

        return http.build();
    }
}
