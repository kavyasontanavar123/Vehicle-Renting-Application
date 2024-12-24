package com.example.Vehicle.Renting.Application.responsedto;

import java.util.List;

import com.example.Vehicle.Renting.Application.entity.Image;
import com.example.Vehicle.Renting.Application.enums.FuelType;

public class VehicleResponse {
	
	private int vehicleId;
	private String brand;
	private String model;
	private String  vehicleType;
	private FuelType  fuelType;
	private List<Integer> vehicleImage;
	public int getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	public FuelType getFuelType() {
		return fuelType;
	}
	public void setFuelType(FuelType fuelType) {
		this.fuelType = fuelType;
	}
	public List<Integer> getVehicleImage() {
		return vehicleImage;
	}
	public void setVehicleImage(List<Integer> vehicleImage) {
		this.vehicleImage = vehicleImage;
	}
	
	
	
	

}
