package com.example.Vehicle.Renting.Application.mapper;

import org.springframework.stereotype.Component;

import com.example.Vehicle.Renting.Application.entity.User;
import com.example.Vehicle.Renting.Application.entity.VehicleListing;
import com.example.Vehicle.Renting.Application.requestdto.UserRequest;
import com.example.Vehicle.Renting.Application.requestdto.VehicleListingRequset;
import com.example.Vehicle.Renting.Application.responsedto.VehicleListingResponse;

@Component
public class VehicleListingMapper {
	public VehicleListingResponse mapToResponse(VehicleListing list) {
	VehicleListingResponse response = new VehicleListingResponse();
	response.setListingId(list.getListingId());
	response.setVehicleNo(list.getVehicleNo());
	response.setPricePerDay(list.getPricePerDay());
	response.setSeating(list.getSeating());
	
	return response;
	

	}
	public VehicleListing mapToRequest(VehicleListingRequset request) {
	VehicleListing listing = new VehicleListing();
	
	listing.setVehicleNo(request.getVehicleNo());
	listing.setPricePerDay(request.getPricePerDay());
	listing.setSeating(request.getSeating());
	

	return listing;
	}

}
