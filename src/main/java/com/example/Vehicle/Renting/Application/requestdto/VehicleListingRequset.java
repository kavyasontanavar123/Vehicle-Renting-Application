package com.example.Vehicle.Renting.Application.requestdto;

import com.example.Vehicle.Renting.Application.entity.User;
import com.example.Vehicle.Renting.Application.enums.Seating;

public class VehicleListingRequset {
	private String vehicleNo;
    private double pricePerDay;
    private Seating seating;  
   
    
	
	
	public String getVehicleNo() {
		return vehicleNo;
	}
	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}
	public double getPricePerDay() {
		return pricePerDay;
	}
	public void setPricePerDay(double pricePerDay) {
		this.pricePerDay = pricePerDay;
	}
	public Seating getSeating() {
		return seating;
	}
	public void setSeating(Seating seating) {
		this.seating = seating;
	}
	
    

}
