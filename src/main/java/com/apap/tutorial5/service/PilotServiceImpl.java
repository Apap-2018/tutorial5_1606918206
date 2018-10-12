package com.apap.tutorial5.service;

import com.apap.tutorial5.model.PilotModel;
import com.apap.tutorial5.repository.PilotDB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class PilotServiceImpl implements PilotService{
	
	@Autowired
	private PilotDB pilotDb;
	
	@Override
	public PilotModel getPilotDetailByLicenseNumber(String licenseNumber) {
		return pilotDb.findByLicenseNumber(licenseNumber);
	}
	
	@Override
	public void addPilot(PilotModel pilot) {
		pilotDb.save(pilot);	
	}
	
	public void deletePilot(PilotModel pilot) {
		pilotDb.delete(pilot);
	}
	
	@Override
	public void updatePilot(PilotModel pilot,String name, Integer flyHour) {
		pilot.setName(name);
		pilot.setFlyHour(flyHour);
		pilotDb.save(pilot);
	}
	
	
}
