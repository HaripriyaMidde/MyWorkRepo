package com.capg.flights.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.capg.flights.entities.Flights;


@Service
public interface IFlightService {
	
	List<Flights> findByOriginDestination(String origin,String destination,String filter);
	
	public Flights addFlights(Flights flights);
}
