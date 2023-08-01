package com.capg.flights.entities;

import java.sql.Time;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Component
@Table(name="Flights")
public class Flights {
//Flight Number | Origin |Destination |Departure Time |Arrival Time |Price
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String flightNumber;
	private String origin;
	private String destination;
	private Time departureTime;
	private Time arrivalTime;
	private double price;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public Time getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(Time departureTime) {
		this.departureTime = departureTime;
	}
	public Time getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(Time arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Flights [id=" + id + ", flightNumber=" + flightNumber + ", origin=" + origin + ", destination="
				+ destination + ", departureTime=" + departureTime + ", arrivalTime=" + arrivalTime + ", price=" + price
				+ "]";
	}
	
	
}
	
