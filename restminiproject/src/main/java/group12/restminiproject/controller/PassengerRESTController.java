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

@RestController
@RequestMapping("/api/passengers")
public class PassengerRESTController {

		@Autowired
		private PassengerRepository passengerRepository;
		
		
		@DeleteMapping("{passengerId}")
		public ResponseEntity<HttpStatus> deletePassenger(@PathVariable long passengerID)
		{
			passengerRepository.deleteById(passengerID);
			
			return new ResponseEntity<>(HttpStatus.OK);
		}
		
		
		// Retrieve all passengers detail from table passenger
		@GetMapping
		public List<Passenger> getPassengers()
		{
			return passengerRepository.findAll();
			
		}
		
		//retrieve passenger detail based on passenger ID
//		@GetMapping("{passengerId}")
//		public Passenger getPassenger(@PathVariable long passengerID)
//		{
//			Passenger passenger = passengerRepository.findById(passengerID);
//	        return passenger;	
//		}
		
	
		//insert records for passenger information
		@PostMapping
		public Passenger insertPassenger(@RequestBody Passenger passenger)
		{
			return passengerRepository.save(passenger);
		}
		
		//update records for passenger information
		@PutMapping
		public Passenger updatePassenger(@RequestBody Passenger passenger)
		{
			return passengerRepository.save(passenger);
		}
		
		
	
}
