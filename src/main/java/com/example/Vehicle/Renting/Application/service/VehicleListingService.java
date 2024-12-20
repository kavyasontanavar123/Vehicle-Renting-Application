package com.example.Vehicle.Renting.Application.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Vehicle.Renting.Application.entity.User;
import com.example.Vehicle.Renting.Application.entity.Vehicle;
import com.example.Vehicle.Renting.Application.entity.VehicleListing;
import com.example.Vehicle.Renting.Application.exception.VehicleNotFoundByIdExcepction;
import com.example.Vehicle.Renting.Application.mapper.VehicleListingMapper;
import com.example.Vehicle.Renting.Application.repository.UserRepository;
import com.example.Vehicle.Renting.Application.repository.VehicleListingRepository;
import com.example.Vehicle.Renting.Application.repository.VehicleRepository;
import com.example.Vehicle.Renting.Application.requestdto.VehicleListingRequset;
import com.example.Vehicle.Renting.Application.responsedto.VehicleListingResponse;
import com.example.Vehicle.Renting.Application.security.OauthUtil;

@Service
public class VehicleListingService {
	private final VehicleListingRepository vehicleListingRepository;
	private final UserRepository userRepository;
	private final VehicleListingMapper vehicleListingMapper;
	private final VehicleRepository vehicleRepository;
	private final OauthUtil oauthUtil;

	public VehicleListingService(VehicleListingRepository vehicleListingRepository, UserRepository userRepository,
			VehicleListingMapper vehicleListingMapper, VehicleRepository vehicleRepository, OauthUtil oauthUtil) {
		super();
		this.vehicleListingRepository = vehicleListingRepository;
		this.userRepository = userRepository;
		this.vehicleListingMapper = vehicleListingMapper;
		this.vehicleRepository = vehicleRepository;
		this.oauthUtil = oauthUtil;
	}

	public VehicleListingResponse createVehicleListing(VehicleListingRequset request, int vehicleId) {
		VehicleListing listing = vehicleListingMapper.mapToRequest(request);

		Vehicle vehicle = vehicleRepository.findById(vehicleId)
				.orElseThrow(() -> new VehicleNotFoundByIdExcepction("Vehicle not found By given Id"));

		User rentingPartner = oauthUtil.getCurrentUser();

		listing.setRentingPartner(rentingPartner);
		listing.setVehicle(vehicle);

		listing = vehicleListingRepository.save(listing);

		return vehicleListingMapper.mapToResponse(listing);

	}

	public List<VehicleListingResponse> findAllVehicleList(int vehicleId) {
		Vehicle vehicle = vehicleRepository.findById(vehicleId)
				.orElseThrow(() -> new VehicleNotFoundByIdExcepction("Vehicle not found by the given ID"));
		List<VehicleListing> vehicleListings = vehicleListingRepository.findAllByVehicle(vehicle);
		List<VehicleListingResponse> vehicleListingResponses = new ArrayList<>();
		for (VehicleListing vehicleListing : vehicleListings) {
			vehicleListingResponses.add(vehicleListingMapper.mapToResponse(vehicleListing));
		}

		return vehicleListingResponses;
	}

}
