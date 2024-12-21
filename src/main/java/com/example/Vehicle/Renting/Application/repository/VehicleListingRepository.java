package com.example.Vehicle.Renting.Application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.Vehicle.Renting.Application.entity.Location;
import com.example.Vehicle.Renting.Application.entity.Vehicle;
import com.example.Vehicle.Renting.Application.entity.VehicleListing;

@Repository
public interface VehicleListingRepository extends JpaRepository<VehicleListing, Integer> {
	
	
	List<VehicleListing> findAllByVehicle(Vehicle vehicle);
//	@Query("SELECT l FROM Location l JOIN l.vehicleListing v WHERE v.id = :vehicleListingId")
//	List<Location> findAllByVehicleListings(int vehicleListingId);

	
	

}
