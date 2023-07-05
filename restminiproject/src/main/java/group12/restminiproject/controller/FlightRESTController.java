package group12.restminiproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import group12.restminiproject.model.Flight;
import group12.restminiproject.repository.FlightRepository;



/*
 * This REST Controller request REST web service in PROVIDER site
 * This is for Flight Rest Controller
 * 
 * @Author Nur Irdina Izzati Binti Khairuzaman
 * 
 */
@RestController
@RequestMapping("/api/flights")

public class FlightRESTController {
	
	@Autowired
	private FlightRepository flightRepository;
	
	/**
	 * This is to delete flight by id
	 * This method deletes flight based on id
	 *
	 */
	@DeleteMapping("{flightId}")
	public ResponseEntity<HttpStatus> deleteFlight(@PathVariable long flightId)
	{
		flightRepository.deleteById(flightId);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	/**
	 * This is to get flight details
	 * This method retrieves all flight details
	 *
	 */
	@GetMapping
	public List<Flight> getFlight()
	{
		return flightRepository.findAll();
		
	}
	
	/**
	 * This is to get flight details by id
	 * This method retrieves all flight details based on id
	 *
	 */
	@GetMapping("{flightId}")
	public Flight getFlight(@PathVariable long flightId)
	{
		Flight flight = flightRepository.findById(flightId).get();
		return flight;
	}

	/**
	 * This is to post flight details
	 * This method insert new flight details
	 *
	 */
	@PostMapping
	public Flight insertFlight(@RequestBody Flight flight)
	{
		return flightRepository.save(flight);
	}

	/**
	 * This is to put flight details
	 * This method update details for  flight
	 *
	 */
	@PutMapping
	public Flight updateFlight(@RequestBody Flight flight)
	{
		return flightRepository.save(flight);
	}
	
}

