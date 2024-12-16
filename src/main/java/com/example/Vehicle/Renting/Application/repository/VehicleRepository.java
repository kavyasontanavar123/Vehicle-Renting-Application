package com.example.Vehicle.Renting.Application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Vehicle.Renting.Application.entity.Vehicle;

@Repository
public interface VehicleRepository  extends  JpaRepository<Vehicle, Integer>{

}
