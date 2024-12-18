package com.example.Vehicle.Renting.Application.security;

import java.util.Optional;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.example.Vehicle.Renting.Application.entity.User;
import com.example.Vehicle.Renting.Application.repository.UserRepository;

@Component
public class OauthUtil {
	private final UserRepository userRepository;

	public OauthUtil(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	public Authentication getAuthentication() {
		return SecurityContextHolder.getContext().getAuthentication();

	}
	public String getCurrentUsername() {
		return this.getAuthentication().getName();
	}
	public User getCurrentUser() {
		return userRepository.findByEmail(getCurrentUsername()).orElseThrow(() -> new UsernameNotFoundException("user not found"));


	}

}