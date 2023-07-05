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
 * This is for Airport Rest Controller
 * 
 * @Author Nur Irdina Izzati Binti Khairuzaman
 * 
 */
@RestController
@RequestMapping("/api/airports")

public class AirportRESTController {
	
	@Autowired
	private AirportRepository airportRepository;
	
	/**
	 * This method retrieves all airport information
	 * This is to display all airport details such as name and id
	 *
	 * @param AirportID
	 * @return
	 */
	@GetMapping
	public List<Airport> getAirport()
	{
		return airportRepository.findAll();
		
	}
	
	/**
	 * This method retrieves airport detail based on id
	 * This is to find airport details such as name by id
	 *
	 * @param AirportID
	 * @return
	 */
	@GetMapping("{airportId}")
	public Airport getAirport(@PathVariable long airportId)
	{
		Airport airport = airportRepository.findById(airportId).get();
		return airport;
	}

	
}