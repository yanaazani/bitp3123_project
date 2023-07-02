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

/**
 * This REST Controller request REST web service in PROVIDER site
 * 
 * @author Nur Irdina Izzati
 *
 */
@RestController
@RequestMapping("/api/passengers")
public class PassengerRESTController {
	
	@Autowired
	private PassengerRepository passengerRepository;
	
	// retrieve all passenger information detail
	@GetMapping
	public List<Passenger> getPassenger()
	{
		return passengerRepository.findAll();
	}
	
	// retrieve checkpoint detail based on passenger Id
	@GetMapping ("{passengerId}")
	public Passenger getPassenger(@PathVariable long passengerId )
	{
		Passenger passenger = passengerRepository.findById(passengerId).get();
		
		return passenger;
	}
	
	// insert passenger information
	@PostMapping
	public Passenger insertPassenger (@RequestBody Passenger passenger)
	{
		return passengerRepository.save(passenger);
	}
	
	// Update passenger information
	@PutMapping
	public Passenger updatePassenger (@RequestBody Passenger passenger)
	{
		return passengerRepository.save(passenger);
	}
	
	// delete passenger information based on passenger Id
	@DeleteMapping("{passengerId}")
	public ResponseEntity<HttpStatus> deleteFlight(@PathVariable long passengerId)
	{
		passengerRepository.deleteById(passengerId);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}