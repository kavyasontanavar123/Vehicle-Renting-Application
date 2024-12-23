package com.example.Vehicle.Renting.Application.mapper;

import org.springframework.stereotype.Component;

import com.example.Vehicle.Renting.Application.entity.Booking;
import com.example.Vehicle.Renting.Application.entity.DropLocation;
import com.example.Vehicle.Renting.Application.entity.Location;
import com.example.Vehicle.Renting.Application.entity.PickUp;
import com.example.Vehicle.Renting.Application.entity.User;
import com.example.Vehicle.Renting.Application.entity.Vehicle;
import com.example.Vehicle.Renting.Application.entity.VehicleListing;
import com.example.Vehicle.Renting.Application.enums.BookingStatus;
import com.example.Vehicle.Renting.Application.enums.RentingType;
import com.example.Vehicle.Renting.Application.requestdto.BookingRequest;
import com.example.Vehicle.Renting.Application.responsedto.BookingResponse;
import com.example.Vehicle.Renting.Application.responsedto.DropLocationResponse;
import com.example.Vehicle.Renting.Application.responsedto.PickUprResponse;

@Component
public class BookingMapper {

	public Booking mapToBooking(BookingRequest request, Booking booking) {
		booking.setBookingStatus(request.getBookingStatus());
		booking.setTotalPayableAmount(request.getTotalPayableAmount());
		booking.setRentingType(request.getRentingType());

		return booking;
	}
	public PickUp mapToPickUp(BookingRequest request, PickUp pickUp) {
		pickUp.setDate(request.getPickUpDate());
		pickUp.setTime(request.getPickUpTime());
		return pickUp;
	}

	public DropLocation mapTodrop(BookingRequest request, DropLocation drop) {
		drop.setDate(request.getDropDate());
		drop.setTime(request.getDropTime());
		return drop;
	}
	public BookingResponse mapToResponse(Booking booking) {
		BookingResponse response = new BookingResponse();
		response.setBookingId(booking.getBookingId());
		response.setBookingStatus(booking.getBookingStatus());
		response.setRentingType(booking.getRentingType());
		response.setTotalPayableAmount(booking.getTotalPayableAmount());

		return response;
	}

	public DropLocationResponse mapToDropResponse(DropLocation drop) {
		DropLocationResponse response = new DropLocationResponse();
		response.setDate(drop.getDate());
		response.setTime(drop.getTime());
		response.setDropId(drop.getDropId());
		return response;
	}
	public PickUprResponse mapToPickupResponse(PickUp pickUp) {
		PickUprResponse response = new PickUprResponse();
		response.setDate(pickUp.getDate());
		response.setTime(pickUp.getTime());
		response.setPickupId(pickUp.getPickupId());
		return response;
		
	}







	

}