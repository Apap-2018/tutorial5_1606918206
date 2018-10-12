package com.apap.tutorial5.repository;

import com.apap.tutorial5.model.FlightModel;
import com.apap.tutorial5.model.PilotModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightDB extends JpaRepository<FlightModel, Long> {
	FlightModel findByFlightNumber(String flightNumber);
}
