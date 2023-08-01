package com.capg.flights.service;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.flights.entities.Flights;
import com.capg.flights.repository.IFlightsRepository;


@Service
public class FlightServiceImpl implements IFlightService{

	@Autowired
	private IFlightsRepository flightRepo;
	
	List<Flights> flights;
	
	
	@Override
	public List<Flights> findByOriginDestination(String origin,String destination,String filter) {
		flights = new ArrayList<Flights>(); 
		flights = flightRepo.findByOriginDestination(origin,destination);
		if(filter.equals("price")) {
            flights.sort(Comparator.comparingDouble(Flights::getPrice));
        }else if(filter.equalsIgnoreCase("duration")){
            Collections.sort(flights, new Comparator<Flights>() {
                @Override
                public int compare(Flights flight1, Flights flight2) {
                    long duration1 = Duration.between(flight1.getDepartureTime().toLocalTime(),flight1.getArrivalTime().toLocalTime()).toSeconds();
                    long duration2 = Duration.between(flight2.getDepartureTime().toLocalTime(),flight2.getArrivalTime().toLocalTime()).toSeconds();
                    return (int) (duration1 - duration2);
                }
            });
        }else if(filter.equalsIgnoreCase("flightNumber")) {
            Collections.sort(flights, new Comparator<Flights>() {
                @Override
                public int compare(Flights flight1, Flights flight2) {                    
                    return flight1.getFlightNumber().compareTo(flight2.getFlightNumber());                    
                }
            });
        }
		return flights;
	}
	@Override
	public Flights addFlights(Flights flights) {
		Flights f= flightRepo.save(flights);
		return f;
	}
	@Override
	public List<Flights> getAllFlights() {
		flights =  new ArrayList<Flights>();
		flights =flightRepo.findAll();
		return flights;
	}
	
}
