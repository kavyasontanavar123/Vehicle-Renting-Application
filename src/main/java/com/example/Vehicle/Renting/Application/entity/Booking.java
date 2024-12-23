package com.example.Vehicle.Renting.Application.entity;

import java.time.Duration;

import com.example.Vehicle.Renting.Application.enums.BookingStatus;
import com.example.Vehicle.Renting.Application.enums.RentingType;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookingId;
	private double totalPayableAmount;

	private RentingType rentingType;
	private Duration duration;
	private BookingStatus bookingStatus;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private VehicleListing vehicleListing;

	@ManyToOne(fetch = FetchType.LAZY)
	private User user;
	@OneToOne
	private PickUp pickUp;
	@OneToOne
	private DropLocation drop;

	public BookingStatus getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(BookingStatus bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

	public DropLocation getDrop() {
		return drop;
	}

	public void setDrop(DropLocation drop) {
		this.drop = drop;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public VehicleListing getVehicleListing() {
		return vehicleListing;
	}

	public void setVehicleListing(VehicleListing vehicleListing) {
		this.vehicleListing = vehicleListing;
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

	public Duration getDuration() {
		return duration;
	}

	public void setDuration(Duration duration) {
		this.duration = duration;
	}


	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public PickUp getPickUp() {
		return pickUp;
	}

	public void setPickUp(PickUp pickUp) {
		this.pickUp = pickUp;
	}
	
	
}
