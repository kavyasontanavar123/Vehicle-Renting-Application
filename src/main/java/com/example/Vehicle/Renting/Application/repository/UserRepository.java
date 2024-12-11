package com.example.Vehicle.Renting.Application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Vehicle.Renting.Application.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
