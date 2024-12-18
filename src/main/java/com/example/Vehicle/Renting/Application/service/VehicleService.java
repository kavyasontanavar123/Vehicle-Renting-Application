package com.example.Vehicle.Renting.Application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.Vehicle.Renting.Application.entity.Vehicle;
import com.example.Vehicle.Renting.Application.exception.VehicleNotFoundByIdExcepction;
import com.example.Vehicle.Renting.Application.repository.VehicleRepository;

@Service
public class VehicleService {

	private final VehicleRepository vehicleRepository;

	public VehicleService(VehicleRepository vehicleRepository) {
		super();
		this.vehicleRepository = vehicleRepository;
	}

	public Vehicle addVehicle(Vehicle vehicle) {

		return vehicleRepository.save(vehicle);
	}

	public Vehicle updateVehicle(Vehicle vehicle) {

		Optional<Vehicle> optional = vehicleRepository.findById(vehicle.getVehicleId());

		if (optional.isPresent()) {
			return vehicleRepository.save(vehicle);
		} else {
			throw new VehicleNotFoundByIdExcepction("Failed to find the Vehicle");
		}
	}

	public List<Vehicle> findAllVehicle() {

		List<Vehicle> vehicles = vehicleRepository.findAll();

		if (vehicles.size() != 0) {
			return vehicles;
		} else {
			throw new VehicleNotFoundByIdExcepction("Failed to find the Vehicle");
		}

	}

	
		   

	
}