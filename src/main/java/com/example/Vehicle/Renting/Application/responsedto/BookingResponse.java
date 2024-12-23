package com.example.Vehicle.Renting.Application.responsedto;

import java.time.Duration;

import com.example.Vehicle.Renting.Application.entity.DropLocation;
import com.example.Vehicle.Renting.Application.entity.PickUp;
import com.example.Vehicle.Renting.Application.entity.User;
import com.example.Vehicle.Renting.Application.entity.Vehicle;
import com.example.Vehicle.Renting.Application.entity.VehicleListing;
import com.example.Vehicle.Renting.Application.enums.BookingStatus;
import com.example.Vehicle.Renting.Application.enums.RentingType;

public class BookingResponse {
	private int bookingId;
	private double totalPayableAmount;
	
	private RentingType rentingType; 
	private BookingStatus bookingStatus;
	
	private VehicleListingResponse vehicleListing;
	private VehicleResponse model;
	
	private PickUprResponse pickUp;
	private DropLocationResponse drop;
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public double getTotalPayableAmount() {
		return totalPayableAmount;
	}
	public void setTotalPayableAmount(double totalPayableAmount) {
		this.totalPayableAmount = totalPayableAmount;
	}
	public RentingType getRentingType() {
		return rentingType;
	}
	public void setRentingType(RentingType rentingType) {
		this.rentingType = rentingType;
	}
	public BookingStatus getBookingStatus() {
		return bookingStatus;
	}
	public void setBookingStatus(BookingStatus bookingStatus) {
		this.bookingStatus = bookingStatus;
	}
	public VehicleListingResponse getVehicleListing() {
		return vehicleListing;
	}
	public void setVehicleListing(VehicleListingResponse vehicleListing) {
		this.vehicleListing = vehicleListing;
	}
	public VehicleResponse getModel() {
		return model;
	}
	public void setModel(VehicleResponse model) {
		this.model = model;
	}
	public PickUprResponse getPickUp() {
		return pickUp;
	}
	public void setPickUp(PickUprResponse pickUp) {
		this.pickUp = pickUp;
	}
	public DropLocationResponse getDrop() {
		return drop;
	}
	public void setDrop(DropLocationResponse drop) {
		this.drop = drop;
	}
	
   

}