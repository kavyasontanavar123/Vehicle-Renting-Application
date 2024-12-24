package com.example.Vehicle.Renting.Application.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.Vehicle.Renting.Application.entity.Image;
import com.example.Vehicle.Renting.Application.entity.Vehicle;
import com.example.Vehicle.Renting.Application.responsedto.VehicleResponse;

@Component
public class VehicleMapper {
	public VehicleResponse mapToResponse(Vehicle vehicle) {
		VehicleResponse response = new VehicleResponse();
		response.setVehicleId(vehicle.getVehicleId());
		response.setBrand(vehicle.getBrand());
		response.setModel(vehicle.getModel());
		response.setFuelType(vehicle.getFuelType());
		
		if(vehicle.getVehicleImage()!= null) {
			List<Integer> vehicleImage= vehicle.getVehicleImage().stream()
					.map(Image:: getImageId)
					.collect(Collectors.toList());
			response.setVehicleImage(vehicleImage);
					
			
			
		}
		return response;
	}

}
