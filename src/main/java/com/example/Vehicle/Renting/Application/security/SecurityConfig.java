package com.example.Vehicle.Renting.Application.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
	 PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
		
	}
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http
		.csrf(csrf->csrf.disable())// cross site request forgery
		.authorizeHttpRequests(authorize -> authorize 
				.requestMatchers("/customer/register","/find-all-vehicle","/save-vehicle")
				.permitAll()
				.anyRequest()
				.authenticated())
		.formLogin(Customizer.withDefaults())
		.build();
		
	}

}
