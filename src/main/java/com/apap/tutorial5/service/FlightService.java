package com.apap.tutorial5.service;

import java.sql.Date;

import com.apap.tutorial5.model.FlightModel;

public interface FlightService {
	void addFlight(FlightModel flight);
	public FlightModel getFlightDetailByFlightNumber(String flightNumber);
	public void updateFlight(FlightModel flight, String Origin, String Destination, Date date);
	void deleteFlight(FlightModel flight);
	void deleteFlightById(long id);
}
