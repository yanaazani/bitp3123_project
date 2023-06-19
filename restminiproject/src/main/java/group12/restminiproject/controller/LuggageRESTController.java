package group12.restminiproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import group12.restminiproject.model.Luggage;
import group12.restminiproject.repository.LuggageRepository;

@RestController
@RequestMapping("/api/luggages")
public class LuggageRESTController {

	@Autowired
	private LuggageRepository luggageRepository;
	
	// delete order type record based on Id
	@DeleteMapping("{luggageId}")
	public ResponseEntity<HttpStatus> deleteAirport(@PathVariable long luggageId)
	{
		luggageRepository.deleteById(luggageId);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	// retrieve all luggage detail
	@GetMapping
	public List<Luggage> getLuggage()
	{
		return luggageRepository.findAll();
		
	}
	
	// retrieve product detail based on product ID
		@GetMapping("{luggageId}")
		public Luggage getLuggage(@PathVariable long luggageId)
		{
			Luggage luggage = luggageRepository.findById(luggageId).get();
			return luggage;
		}

}
