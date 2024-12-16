package com.example.Vehicle.Renting.Application.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.Vehicle.Renting.Application.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("SELECT u.profilePicture.imageId FROM User u WHERE u.userId = :userId")
    Integer getProfilePictureIdByUserId(int userId);
    
    Optional<User> findByEmail(String userEmail);

	}

