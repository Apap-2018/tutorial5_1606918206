package com.apap.tutorial5.service;

import com.apap.tutorial5.model.FlightModel;
import com.apap.tutorial5.model.PilotModel;
import com.apap.tutorial5.repository.FlightDB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.sql.Date;

@Service
@Transactional
public class FlightServiceImpl implements FlightService{
	
	@Autowired
	private FlightDB flightDb;
	
	@Override
	public void addFlight(FlightModel flight) {
		flightDb.save(flight);
		
	}
	
	@Override 
	public void deleteFlight(FlightModel flight) {
		flightDb.delete(flight);
	}
	
	@Override
	public void updateFlight(FlightModel flight, String origin, String destination, Date time) {
		flight.setDestination(destination);
		flight.setOrigin(origin);
		flight.setTime(time);
		flightDb.save(flight);
	}
	
	
	@Override
	public FlightModel getFlightDetailByFlightNumber(String flightNumber) {
		return flightDb.findByFlightNumber(flightNumber);
	}
	@Override
	
	public void deleteFlightById(long id) {
		flightDb.deleteById(id);
	}
}
