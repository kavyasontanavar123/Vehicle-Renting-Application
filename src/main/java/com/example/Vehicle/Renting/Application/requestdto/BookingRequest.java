package com.example.Vehicle.Renting.Application.requestdto;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.stereotype.Component;

import com.example.Vehicle.Renting.Application.entity.PickUp;
import com.example.Vehicle.Renting.Application.enums.BookingStatus;
import com.example.Vehicle.Renting.Application.enums.RentingType;

@Component
public class BookingRequest {
	private double totalPayableAmount;
	private RentingType rentingType;

	private BookingStatus bookingStatus;
	private LocalDate pickUpDate;
	private LocalTime pickUpTime;

	private LocalDate dropDate;
	private LocalTime dropTime;

	public LocalDate getPickUpDate() {
		return pickUpDate;
	}

	public void setPickUpDate(LocalDate pickUpDate) {
		this.pickUpDate = pickUpDate;
	}

	public LocalTime getPickUpTime() {
		return pickUpTime;
	}

	public void setPickUpTime(LocalTime pickUpTime) {
		this.pickUpTime = pickUpTime;
	}

	public LocalDate getDropDate() {
		return dropDate;
	}

	public void setDropDate(LocalDate dropDate) {
		this.dropDate = dropDate;
	}

	public LocalTime getDropTime() {
		return dropTime;
	}

	public void setDropTime(LocalTime dropTime) {
		this.dropTime = dropTime;
	}

	public BookingStatus getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(BookingStatus bookingStatus) {
		this.bookingStatus = bookingStatus;
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

}
