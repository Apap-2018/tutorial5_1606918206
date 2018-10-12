package com.apap.tutorial5.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *  PilotModel
 *  @author Priscilla Tiffany
 */
@Entity
@Table(name = "pilot")
public class PilotModel implements Serializable {
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLicenseNumber() {
		return licenseNumber;
	}

	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getFlyHour() {
		return flyHour;
	}

	public void setFlyHour(int flyHour) {
		this.flyHour = flyHour;
	}

	public List<FlightModel> getPilotFlight() {
		return pilotFlight;
	}

	public void addPilotFlight(FlightModel flight) {
		this.pilotFlight.add(flight);
	}
	
	public void setPilotFlight(List<FlightModel> newPilotFlight) {
		this.pilotFlight = newPilotFlight;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@Size(max = 50)
	@Column(name = "license_number", nullable = false, unique = true)
	private String licenseNumber;
	
	@NotNull
	@Size(max = 50)
	@Column(name = "name", nullable = false)
	private String name;
	
	@NotNull
	@Column(name = "fly_hour", nullable = false)
	private int flyHour;
	
	@OneToMany(mappedBy = "pilot", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
	private List<FlightModel> pilotFlight = new ArrayList<FlightModel>();
	
	
	
}