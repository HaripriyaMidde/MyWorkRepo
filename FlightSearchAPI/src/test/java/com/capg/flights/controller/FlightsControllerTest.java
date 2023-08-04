package com.capg.flights.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.when;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.capg.flights.entities.Flights;
import com.capg.flights.service.FlightServiceImpl;

@ExtendWith(MockitoExtension.class)
class FlightsControllerTest {
	
	@InjectMocks
	FlightsController flightController;
	@Mock
	FlightServiceImpl flightServiceImpl;
	
	static List<Flights> flights=new ArrayList<Flights>();
	static List<Flights> flightsByPrice=new ArrayList<Flights>();
	static List<Flights> flightsByDuration=new ArrayList<Flights>();
	static List<Flights> flightsByFlightNumber=new ArrayList<Flights>();
	
	@BeforeAll
	static void createMockObjects() {
		Flights f1= new Flights(6,"F101","BOM","DEL",new Time(20,30,00),new Time(21,30,00),80.0);
		Flights f2= new Flights(7,"G101","BOM","DEL",new Time(18,00,00),new Time(19,30,00),100.0);
		Flights f3= new Flights(13,"F201","BOM","DEL",new Time(21,15,00),new Time(22,30,00),80.0);
		Flights f4= new Flights(14,"G201","BOM","DEL",new Time(20,20,00),new Time(21,30,00),100.0);
		
		flights.add(f1);
		flights.add(f2);
		flights.add(f3);
		flights.add(f4);
		
		flightsByPrice.add(f1);
		flightsByPrice.add(f3);
		flightsByPrice.add(f2);
		flightsByPrice.add(f4);
		
		flightsByDuration.add(f1);
		flightsByDuration.add(f4);
		flightsByDuration.add(f3);
		flightsByDuration.add(f2);
		
		flightsByFlightNumber.add(f1);
		flightsByFlightNumber.add(f3);
		flightsByFlightNumber.add(f2);
		flightsByFlightNumber.add(f4);
		
			
	}
	
	@Test
	public void showFlightsByOriginDestinationTest() {
		when(flightServiceImpl.findByOriginDestination("BOM", "DEL", "false")).thenReturn(flights);
		List<Flights> expected=flights;
		List<Flights> actual= flightController.showFlightsByOriginDestination("BOM", "DEL", "false");
		assertEquals(expected,actual);
	}
	
	@Test
	public void showFlightsByOriginDestinationTestByPrice() {
		when(flightServiceImpl.findByOriginDestination("BOM", "DEL", "price")).thenReturn(flightsByPrice);
		List<Flights> expected=flightsByPrice;
		List<Flights> actual= flightController.showFlightsByOriginDestination("BOM", "DEL", "price");
		assertEquals(expected,actual);
	}
	@Test
	public void showFlightsByOriginDestinationTestByDuration() {
		when(flightServiceImpl.findByOriginDestination("BOM", "DEL", "duration")).thenReturn(flightsByDuration);
		List<Flights> expected=flightsByDuration;
		List<Flights> actual= flightController.showFlightsByOriginDestination("BOM", "DEL", "duration");
		assertEquals(expected,actual);
	}
	@Test
	public void showFlightsByOriginDestinationTestByFlightNumber() {
		when(flightServiceImpl.findByOriginDestination("BOM", "DEL", "flightNumber")).thenReturn(flightsByFlightNumber);
		List<Flights> expected=flightsByFlightNumber;
		List<Flights> actual= flightController.showFlightsByOriginDestination("BOM", "DEL", "flightNumber");
		assertEquals(expected,actual);
	}

}
