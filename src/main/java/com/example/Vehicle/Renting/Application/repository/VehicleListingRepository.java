package com.example.Vehicle.Renting.Application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Vehicle.Renting.Application.entity.VehicleListing;

public interface VehicleListingRepository extends JpaRepository<VehicleListing, Integer> {
	

}
