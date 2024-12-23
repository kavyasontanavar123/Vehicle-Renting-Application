package com.example.Vehicle.Renting.Application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Vehicle.Renting.Application.entity.Booking;
@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {

}
