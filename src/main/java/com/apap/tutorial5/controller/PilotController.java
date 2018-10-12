package com.apap.tutorial5.controller;

import com.apap.tutorial5.model.FlightModel;
import com.apap.tutorial5.model.PilotModel;
import com.apap.tutorial5.service.PilotService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class PilotController {
	
	@Autowired
	private PilotService pilotService;
	
	@RequestMapping("/")
	private String home() {
		return "home";
	}
	
	
	@RequestMapping(value = "/pilot/add", method = RequestMethod.GET)
	private String add(Model model) {
		model.addAttribute("pilot",new PilotModel());
		return "addPilot";
	}
	
	@RequestMapping(value = "/pilot/add", method = RequestMethod.POST)
	private String addPilotSubmit(@ModelAttribute PilotModel pilot) {
		pilotService.addPilot(pilot);
		return "add";
	}
	
	@RequestMapping(value="/pilot/update/{licenseNumber}", method = RequestMethod.POST)
	private String update(@PathVariable(value= "licenseNumber") String licenseNumber, @RequestParam(value="name") String name, @RequestParam(value="flyHour") Integer flyHour) {
		PilotModel pilot = pilotService.getPilotDetailByLicenseNumber(licenseNumber);
		pilotService.updatePilot(pilot, name, flyHour);
		
		return "updated";
	}
	
	@RequestMapping(value="/pilot/update/{licenseNumber}", method = RequestMethod.GET)
	private String updatePilotSubmit(@PathVariable(value= "licenseNumber") String licenseNumber, Model model) {
		PilotModel pilot = pilotService.getPilotDetailByLicenseNumber(licenseNumber);
		model.addAttribute("pilot", pilot);
		
		return "update-pilot";
	}
	
	/*@RequestMapping(value = "/pilot/view", method = RequestMethod.GET)
	private String view(@RequestParam("licenseNumber") String licenseNumber, Model model) {
		PilotModel archive = pilotService.getPilotDetailByLicenseNumber(licenseNumber);
		model.addAttribute("pilot", archive);
		
		List<FlightModel> archive2 = pilotService.getPilotDetailByLicenseNumber(licenseNumber).getPilotFlight();
		model.addAttribute("listFlight", archive2);
		
		return "view-pilot";
	}*/
	@RequestMapping(value = "/pilot/view", method = RequestMethod.GET)
	private String view(@RequestParam("licenseNumber") String licenseNumber, Model model) {
		PilotModel pilot = pilotService.getPilotDetailByLicenseNumber(licenseNumber);
		model.addAttribute("pilot", pilot);
		model.addAttribute("listFlight", pilot.getPilotFlight());
		
		return "view-pilot";
	}
	
	
	@RequestMapping(value = "/pilot/delete/{licenseNumber}", method = RequestMethod.GET)
	private String delete(@PathVariable(value= "licenseNumber") String licenseNumber, Model model) {
		PilotModel pilot = pilotService.getPilotDetailByLicenseNumber(licenseNumber);
		pilotService.deletePilot(pilot);
		
		return "delete-pilot";
	}
	
}
