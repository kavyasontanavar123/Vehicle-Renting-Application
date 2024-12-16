package com.example.Vehicle.Renting.Application.security;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.Vehicle.Renting.Application.entity.User;
import com.example.Vehicle.Renting.Application.exception.UserNotFoundByIdException;
import com.example.Vehicle.Renting.Application.repository.UserRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
	private final UserRepository userRepository;
	
	
	public UserDetailServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	     User user =  userRepository.findByEmail(username)
	    		 .orElseThrow(()->new UsernameNotFoundException("Failed to authenticate user"));
	     
		return  new UserDetailsImpl(user);
	}

}
