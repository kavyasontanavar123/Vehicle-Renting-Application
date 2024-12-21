package com.example.Vehicle.Renting.Application.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Vehicle.Renting.Application.entity.VehicleListing;
import com.example.Vehicle.Renting.Application.requestdto.VehicleListingRequset;
import com.example.Vehicle.Renting.Application.responsedto.VehicleListingResponse;
import com.example.Vehicle.Renting.Application.service.VehicleListingService;
import com.example.Vehicle.Renting.Application.util.ResponseStructure;
import com.example.Vehicle.Renting.Application.util.SimpleResponseStructure;

@RestController
public class VehicleListingController {
	private final VehicleListingService vehicleListingService;

	public VehicleListingController(VehicleListingService vehicleListingService) {
		super();
		this.vehicleListingService = vehicleListingService;
	}

	@PostMapping("/create")
	public ResponseEntity<ResponseStructure<VehicleListingResponse>> createVehicleListing(
			@RequestBody VehicleListingRequset vehicleListingRequest, @RequestParam("vehicleId") int vehicleId) {

		VehicleListingResponse vehicleListingResponse = vehicleListingService
				.createVehicleListing(vehicleListingRequest, vehicleId);

		return ResponseEntity.status(HttpStatus.CREATED).body(ResponseStructure.create(HttpStatus.CREATED.value(),
				"Vehicle Listing created", vehicleListingResponse));
	}
	 @GetMapping("/find-all-vehicle-list")
	 public ResponseEntity<ResponseStructure<List<VehicleListingResponse>>> findAllVehicleList(
			 @RequestParam("vehicleId") int vehicleId){
	  List<VehicleListingResponse> vehicleListingResponses = vehicleListingService.findAllVehicleList(vehicleId);
	  return ResponseEntity
              .status(HttpStatus.OK)
              .body(ResponseStructure.create(HttpStatus.OK.value(), "Vehicle Listings fetched", vehicleListingResponses));
		 
	 }
	 @PutMapping("/update-location-into-vehiclelisting")
		public ResponseEntity<SimpleResponseStructure> updateLocationIntoVehicleListing(@RequestParam int locationId,
				@RequestParam int vehicleListingId) {

			vehicleListingService.updateLocationIntoVehicleListing(locationId,vehicleListingId);

			return ResponseEntity.status(HttpStatus.CREATED)
					.body(SimpleResponseStructure.create(HttpStatus.CREATED.value(), "Location inserted into Vehicle Listing Successfully"));
		}

}
