package com.example.Vehicle.Renting.Application.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Vehicle.Renting.Application.entity.Location;
import com.example.Vehicle.Renting.Application.entity.User;
import com.example.Vehicle.Renting.Application.entity.VehicleListing;
import com.example.Vehicle.Renting.Application.mapper.LocationMapper;
import com.example.Vehicle.Renting.Application.repository.LocationRepository;
import com.example.Vehicle.Renting.Application.repository.VehicleListingRepository;
import com.example.Vehicle.Renting.Application.requestdto.LocationRequest;
import com.example.Vehicle.Renting.Application.responsedto.LocationResponse;
import com.example.Vehicle.Renting.Application.security.OauthUtil;

@Service
public class LocationService {
	private final LocationRepository locationRepository;
	private final OauthUtil oauthUtil;
	private final LocationMapper locationMapper;
	private final VehicleListingRepository vehicleListingRepository;

	public LocationService(LocationRepository locationRepository, OauthUtil oauthUtil, LocationMapper locationMapper,
			VehicleListingRepository vehicleListingRepository) {
		super();
		this.locationRepository = locationRepository;
		this.oauthUtil = oauthUtil;
		this.locationMapper = locationMapper;
		this.vehicleListingRepository = vehicleListingRepository;
	}

	public LocationResponse addLocation(LocationRequest request) {

		Location location = locationMapper.mapToLocation(request);
		location.setUser(oauthUtil.getCurrentUser());
		location = locationRepository.save(location);

		return locationMapper.mapToLocationResponse(location);
	}

	public List<LocationResponse> findAllLocationsByVehicleListing(int vehicleListingId) {
//		VehicleListing vehicle = vehicleListingRepository.findById(vehicleListingId).orElseThrow();

		List<Location> locations = locationRepository.findAllByVehicleListingsListingId(vehicleListingId);
		
		List<LocationResponse> locationResponses = new ArrayList<LocationResponse>();

		for (Location location : locations) {

			locationResponses.add(locationMapper.mapToLocationResponse(location));
		}
		return locationResponses;

	}

}
