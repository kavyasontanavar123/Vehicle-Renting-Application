package com.example.Vehicle.Renting.Application.responsedto;

import com.example.Vehicle.Renting.Application.enums.Seating;

public class VehicleListingResponse {
	private int listingId;
    private String vehicleNo;
    private double pricePerDay;
    private Seating seating;
    
	public int getListingId() {
		return listingId;
	}
	public void setListingId(int listingId) {
		this.listingId = listingId;
	}
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
	public void setSeating(Seating seating2) {
		this.seating = seating2;
	}
	
    

}
