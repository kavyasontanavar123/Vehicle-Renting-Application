package com.example.Vehicle.Renting.Application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.Vehicle.Renting.Application.entity.Location;
import com.example.Vehicle.Renting.Application.entity.VehicleListing;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer> {
	//List<Location> findAllByVehicleListings(VehicleListing vehicleListing);
	
	List<Location> findAllByVehicleListingsListingId(int vehicleListingId);
	

	
	
}
