
package com.example.Vehicle.Renting.Application.responsedto;

import java.time.LocalDate;
import java.time.LocalTime;

public class PickUprResponse {
	private int pickupId;
	 private LocalDate date;
	 private LocalTime time;
	 private LocationResponse location;
	 
	public int getPickupId() {
		return pickupId;
	}
	public void setPickupId(int pickupId) {
		this.pickupId = pickupId;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public LocalTime getTime() {
		return time;
	}
	public void setTime(LocalTime time) {
		this.time = time;
	}
	public LocationResponse getLocation() {
		return location;
	}
	public void setLocation(LocationResponse location) {
		this.location = location;
	} 
	 

}
