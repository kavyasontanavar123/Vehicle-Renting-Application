package com.example.Vehicle.Renting.Application.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Vehicle.Renting.Application.entity.VehicleListing;
import com.example.Vehicle.Renting.Application.requestdto.VehicleListingRequset;
import com.example.Vehicle.Renting.Application.responsedto.VehicleListingResponse;
import com.example.Vehicle.Renting.Application.service.VehicleListingService;
import com.example.Vehicle.Renting.Application.util.ResponseStructure;

@RestController
public class VehicleListingController {
	private final VehicleListingService vehicleListingService;
	
	
	
	public VehicleListingController(VehicleListingService vehicleListingService) {
		super();
		this.vehicleListingService = vehicleListingService;
	}



	@PostMapping("/create")
    public ResponseEntity<ResponseStructure<VehicleListingResponse>> createVehicleListing(
            @RequestBody VehicleListingRequset vehicleListingRequest,@RequestParam("vehicleId") int vehicleId) {

        VehicleListingResponse vehicleListingResponse = vehicleListingService.createVehicleListing(vehicleListingRequest, vehicleId);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ResponseStructure.create(HttpStatus.CREATED.value(), "Vehicle Listing created", vehicleListingResponse));
    }

}
