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

import group12.restminiproject.model.Passenger;
import group12.restminiproject.repository.PassengerRepository;

/*
 * This REST Controller request REST web service in PROVIDER site
 * This is for Passenger Rest Controller
 * 
 * @Author Nur Irdina Izzati Binti Khairuzaman
 * 
 */
@RestController
@RequestMapping("/api/passengers")
public class PassengerRESTController {
	
	@Autowired
	private PassengerRepository passengerRepository;
	
	/**
	 * This method retrieves all luggage details
	 *
	 *@return A list of passsenger details
	 */
	@GetMapping
	public List<Passenger> getPassenger()
	{
		return passengerRepository.findAll();
	}
	
	/**
	 * This method retrieves luggage details based on id
	 *
	 *@param passengerID
	 *@return A list of passenger details by id
	 */
	@GetMapping ("{passengerId}")
	public Passenger getPassenger(@PathVariable long passengerId )
	{
		Passenger passenger = passengerRepository.findById(passengerId).get();
		
		return passenger;
	}
	
	/**
	 * This is to post passenger details
	 * This method add new passenger 
	 *
	 */
	@PostMapping
	public Passenger insertPassenger (@RequestBody Passenger passenger)
	{
		return passengerRepository.save(passenger);
	}
	
	/**
	 * This is to put passenger details
	 * This method edit passenger details
	 *
	 */
	@PutMapping
	public Passenger updatePassenger (@RequestBody Passenger passenger)
	{
		return passengerRepository.save(passenger);
	}
	
	/**
	 * This is to delete passenger details
	 * This method deletes passenger based on id
	 *
	 */
	@DeleteMapping("{passengerId}")
	public ResponseEntity<HttpStatus> deleteFlight(@PathVariable long passengerId)
	{
		passengerRepository.deleteById(passengerId);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}