package com.example.Vehicle.Renting.Application.mapper;

import org.springframework.stereotype.Component;

import com.example.Vehicle.Renting.Application.entity.PickUp;
import com.example.Vehicle.Renting.Application.requestdto.PickUpRequest;
import com.example.Vehicle.Renting.Application.responsedto.PickUprResponse;

@Component
public class PickUpMapper {
	 public PickUp mapToPickUp(PickUpRequest request) {
	        PickUp pickUp = new PickUp();
	        pickUp.setDate(request.getDate());   
	        pickUp.setTime(request.getTime());    
	       
	        return pickUp;
	    }
	 public PickUprResponse mapToPickUpResponse(PickUp pickUp) {
		 PickUprResponse response = new PickUprResponse();
	        response.setPickupId(pickUp.getPickupId());  
	        response.setDate(pickUp.getDate());         
	        response.setTime(pickUp.getTime());          
	        return response;
	    }

}
