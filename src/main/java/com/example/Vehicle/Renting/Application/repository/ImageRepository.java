package com.example.Vehicle.Renting.Application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Vehicle.Renting.Application.entity.Image;

public interface ImageRepository extends JpaRepository<Image, Integer> {

}
