package com.example.Vehicle.Renting.Application.entity;

import java.util.List;

import com.example.Vehicle.Renting.Application.enums.Seating;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class VehicleListing {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int listingId;
	private String VehicleNo;
	private double pricePerDay;
	private Seating seating;
	@ManyToOne(fetch = FetchType.LAZY)
	private User rentingPartner;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Vehicle vehicle;
	
	@ManyToMany
	private List< Location> location;
	

	public List<Location> getLocation() {
		return location;
	}

	public void setLocation(List<Location> location) {
		this.location = location;
	}

	public int getListingId() {
		return listingId;
	}

	public void setListingId(int listingId) {
		this.listingId = listingId;
	}

	public String getVehicleNo() {
		return VehicleNo;
	}

	public void setVehicleNo(String vehicleNo) {
		VehicleNo = vehicleNo;
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

	public User getRentingPartner() {
		return rentingPartner;
	}

	public void setRentingPartner(User rentingPartner) {
		this.rentingPartner = rentingPartner;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle= vehicle;
	}
	
	


}
