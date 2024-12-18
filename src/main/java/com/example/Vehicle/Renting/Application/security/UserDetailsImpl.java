package com.example.Vehicle.Renting.Application.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.example.Vehicle.Renting.Application.entity.User;
import com.example.Vehicle.Renting.Application.enums.UserRole;

public class UserDetailsImpl implements UserDetails {
	private final User user;
	

	public UserDetailsImpl(User user) {
		super();
		this.user = user;
	}


	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getEmail();
	}


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
//		UserRole[] roles = UserRole.values();
//		List<GrantedAuthority> authorities= new ArrayList<GrantedAuthority>();
//		for(UserRole role:roles) {
//			authorities.add(new SimpleGrantedAuthority(role.name()));
//			
//		}
//		
//		return authorities;
		return List.of(new SimpleGrantedAuthority(user.getRole().name()));
	}

}
