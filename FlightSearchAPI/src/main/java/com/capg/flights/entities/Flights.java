package com.capg.flights.entities;

import java.sql.Time;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Component
@AllArgsConstructor @NoArgsConstructor
@Table(name="Flights")
public class Flights {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Getter(AccessLevel.PUBLIC) @Setter(AccessLevel.PUBLIC)
	private int id;
	@Getter(AccessLevel.PUBLIC) @Setter(AccessLevel.PUBLIC)
	@Pattern(regexp = "[^[A-Z]{1}[0-9]{3}$]")
	private @NotNull String flightNumber;
	@Getter(AccessLevel.PUBLIC) @Setter(AccessLevel.PUBLIC)
	@Pattern(regexp = "[\\w]")
	private @NotNull String origin;
	@Getter(AccessLevel.PUBLIC) @Setter(AccessLevel.PUBLIC)
	@Pattern(regexp = "[\\w]")
	private @NotNull String destination;
	@Getter(AccessLevel.PUBLIC) @Setter(AccessLevel.PUBLIC)
	@Pattern(regexp = "^[0-2][0-9]:[0-5][0-9]$")
	private @NotNull Time departureTime;
	@Getter(AccessLevel.PUBLIC) @Setter(AccessLevel.PUBLIC)
	@Pattern(regexp = "^[0-1][0-9]:[0-5][0-9]$")
	private @NotNull Time arrivalTime;
	@Getter(AccessLevel.PUBLIC) @Setter(AccessLevel.PUBLIC)
	@Pattern(regexp = "[\\d]")
	private @NotNull double price;
		
}
	
