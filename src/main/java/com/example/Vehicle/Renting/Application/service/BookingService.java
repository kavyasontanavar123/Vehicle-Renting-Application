package com.example.Vehicle.Renting.Application.service;

import org.springframework.stereotype.Service;

import com.example.Vehicle.Renting.Application.entity.Booking;
import com.example.Vehicle.Renting.Application.entity.DropLocation;
import com.example.Vehicle.Renting.Application.entity.Location;
import com.example.Vehicle.Renting.Application.entity.PickUp;
import com.example.Vehicle.Renting.Application.entity.User;
import com.example.Vehicle.Renting.Application.entity.Vehicle;
import com.example.Vehicle.Renting.Application.entity.VehicleListing;
import com.example.Vehicle.Renting.Application.exception.LocationNotFoundException;
import com.example.Vehicle.Renting.Application.exception.UserNotFoundByIdException;
import com.example.Vehicle.Renting.Application.exception.VehicleNotFoundException;
import com.example.Vehicle.Renting.Application.mapper.BookingMapper;
import com.example.Vehicle.Renting.Application.mapper.DropLocationMapper;
import com.example.Vehicle.Renting.Application.mapper.LocationMapper;
import com.example.Vehicle.Renting.Application.mapper.PickUpMapper;
import com.example.Vehicle.Renting.Application.mapper.VehicleListingMapper;
import com.example.Vehicle.Renting.Application.mapper.VehicleMapper;
import com.example.Vehicle.Renting.Application.repository.BookingRepository;
import com.example.Vehicle.Renting.Application.repository.DropRepository;
import com.example.Vehicle.Renting.Application.repository.LocationRepository;
import com.example.Vehicle.Renting.Application.repository.PickUpRepository;
import com.example.Vehicle.Renting.Application.repository.UserRepository;
import com.example.Vehicle.Renting.Application.repository.VehicleListingRepository;
import com.example.Vehicle.Renting.Application.repository.VehicleRepository;
import com.example.Vehicle.Renting.Application.requestdto.BookingRequest;
import com.example.Vehicle.Renting.Application.responsedto.BookingResponse;
import com.example.Vehicle.Renting.Application.responsedto.DropLocationResponse;
import com.example.Vehicle.Renting.Application.responsedto.PickUprResponse;
import com.example.Vehicle.Renting.Application.security.OauthUtil;

@Service
public class BookingService {
	private final VehicleRepository vehicleRepository;
	private final UserRepository userRepository;
	private final BookingMapper bookingMapper;
	private final BookingRepository bookingRepository;
	private final OauthUtil oauthUtil;
	private final VehicleListingService vehicleListingService;
	private final PickUpMapper pickUpMapper;
	private final DropLocationMapper dropLocationMapper;
	private final PickUpRepository pickUpRepository;  
    private final DropRepository dropLocationRepository;
    private final LocationRepository locationRepository;
    private final VehicleListingRepository vehicleListingRepository;
    private final BookingRequest bookingRequest;
    private final LocationMapper locationMapper;
    private final VehicleMapper vehicleMapper;
    private final VehicleListingMapper listingMapper;
   

	public BookingService(VehicleRepository vehicleRepository, UserRepository userRepository,
			BookingMapper bookingMapper, BookingRepository bookingRepository, OauthUtil oauthUtil,
			VehicleListingService vehicleListingService, PickUpMapper pickUpMapper, PickUpRepository pickUpRepository,
			DropLocationMapper dropLocationMapper,DropRepository dropLocationRepository,LocationRepository locationRepository,
			VehicleListingRepository vehicleListingRepository,BookingRequest bookingRequest,LocationMapper locationMapper
			,VehicleMapper vehicleMapper, VehicleListingMapper listingMapper) {
		super();
		this.vehicleRepository = vehicleRepository;
		this.userRepository = userRepository;
		this.bookingMapper = bookingMapper;
		this.bookingRepository = bookingRepository;
		this.oauthUtil = oauthUtil;
		this.vehicleListingService = vehicleListingService;
		this.pickUpMapper = pickUpMapper;
		this.dropLocationMapper = dropLocationMapper;
		this.pickUpRepository = pickUpRepository;
        this.dropLocationRepository = dropLocationRepository;
        this.locationRepository=locationRepository;
        this.vehicleListingRepository=vehicleListingRepository;
        this.bookingRequest= bookingRequest;
        this.locationMapper=locationMapper;
        this.vehicleMapper= vehicleMapper;
        this.listingMapper=listingMapper;
       
		
	}
public BookingResponse createBooking(BookingRequest request,int vehicleListingId, int pickUpLocationId, int dropLocationId) {
    	
    	User currentuser = oauthUtil.getCurrentUser();
       
    	VehicleListing vehicleListing = vehicleListingRepository.findById(vehicleListingId)
                .orElseThrow(() -> new VehicleNotFoundException("Vehicle listing not found"));
        User user = userRepository.findById(currentuser.getUserId())
                .orElseThrow(() -> new UserNotFoundByIdException("User not found"));
        Location pickUpLocation = locationRepository.findById(pickUpLocationId)
                .orElseThrow(() -> new LocationNotFoundException("PickUp location not found"));
        Location dropLocation = locationRepository.findById(dropLocationId)
                .orElseThrow(() -> new LocationNotFoundException("Drop location not found"));
        /*
         * Fetching the Vehicle data explicitly as the Vehicle is loaded through LAZY behaviour*/
        Vehicle vehicle = vehicleRepository.findById(vehicleListing.getVehicle().getVehicleId())
        		.orElseThrow(() -> new VehicleNotFoundException("Failed to find the vehicle model"));
        
        PickUp pickUp = bookingMapper.mapToPickUp(request, new PickUp());
        pickUp.setLocation(pickUpLocation);
        DropLocation drop = bookingMapper.mapTodrop(request, new DropLocation()); 
        drop.setLocation(dropLocation);

        Booking booking = bookingMapper.mapToBooking(request,  new Booking());
        booking.setDrop(drop);
        booking.setPickUp(pickUp);
        booking.setUser(user);
        booking.setVehicleListing(vehicleListing);
        
        pickUp = pickUpRepository.save(pickUp);
        drop = dropLocationRepository.save(drop);
        
        bookingRepository.save(booking);
        
       return this.buildBookingResponse(booking, drop, pickUp, vehicle, vehicleListing);
        
    }



	private BookingResponse buildBookingResponse(Booking booking, DropLocation drop, PickUp pickUp, Vehicle vehicle, VehicleListing vehicleListing) {
		 BookingResponse response = bookingMapper.mapToResponse(booking);
		 DropLocationResponse dropResponse = bookingMapper.mapToDropResponse(drop);
		 	dropResponse.setLocation(locationMapper.mapToLocationResponse(drop.getLocation()));
	        response.setDrop(dropResponse);
	        
	        PickUprResponse pickUpResponse = bookingMapper.mapToPickupResponse(pickUp);
	        pickUpResponse.setLocation(locationMapper.mapToLocationResponse(pickUp.getLocation()));
	        response.setPickUp(pickUpResponse);
	        
	        response.setModel(vehicleMapper.mapToResponse(vehicle));
	        response.setVehicleListing(listingMapper.mapToResponse(vehicleListing));
	        
	        return response;
	}





}
