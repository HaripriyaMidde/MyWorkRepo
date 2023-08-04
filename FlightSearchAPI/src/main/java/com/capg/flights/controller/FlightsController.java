package com.capg.flights.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capg.flights.entities.Flights;
import com.capg.flights.service.FlightServiceImpl;


@RestController
public class FlightsController {
	@Autowired
	private FlightServiceImpl flightServiceImpl;
	
	List<Flights> flights;
	
	@GetMapping("/getFlights")
	public List<Flights> showFlightsByOriginDestination(@RequestParam(required=true) String origin,
														@RequestParam(required=true) String destination,
														@RequestParam(value="filter" ,defaultValue="false") String filter){
		flights = new ArrayList<Flights>();
		flights=flightServiceImpl.findByOriginDestination(origin,destination,filter);
		return flights;
	}
	@PostMapping("/addFlights")
	public Flights addFlights(@RequestBody Flights flight) {
		Flights f= flightServiceImpl.addFlights(flight);
		return f;
	}
}
