package group12.restminiproject.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import group12.restminiproject.model.Airport;
import group12.restminiproject.repository.AirportRepository;



/*
 * This REST Controller request REST web service in PROVIDER site
 * 
 * @Author Nur Irdina Izzati Binti Khairuzaman
 * 
 */

@RestController
@RequestMapping("/api/airports")

public class AirportRESTController {
	
	@Autowired
	private AirportRepository airportRepository;
	
	// retrieve all order types detail
	@GetMapping
	public List<Airport> getAirport()
	{
		return airportRepository.findAll();
		
	}
	
	// retrieve product detail based on product ID
	@GetMapping("{airportId}")
	public Airport getAirport(@PathVariable long airportId)
	{
		Airport airport = airportRepository.findById(airportId).get();
		return airport;
	}

	
}