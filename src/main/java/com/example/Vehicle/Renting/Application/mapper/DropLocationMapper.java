package com.example.Vehicle.Renting.Application.mapper;

import org.springframework.stereotype.Component;

import com.example.Vehicle.Renting.Application.entity.DropLocation;
import com.example.Vehicle.Renting.Application.requestdto.DropLocationRequest;
import com.example.Vehicle.Renting.Application.responsedto.DropLocationResponse;

@Component
public class DropLocationMapper {
	public DropLocation mapToDrop(DropLocationRequest request) {
        DropLocation drop = new DropLocation();
        drop.setDate(request.getDate());    
        drop.setTime(request.getTime());    
        return drop;
    }
	public DropLocationResponse mapToDropResponse(DropLocation drop) {
        DropLocationResponse response = new DropLocationResponse();
        response.setDropId(drop.getDropId());  
        response.setDate(drop.getDate());      
        response.setTime(drop.getTime());      
        return response;

}
}
