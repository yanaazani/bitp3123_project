package group12.restminiproject.controller;

import java.util.List;
import java.util.Map;
import java.util.Arrays;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import group12.restminiproject.model.Flight;

/**
 * 
 * @author Nur Irdina Izzati 
 *
 */
@Controller 
public class FlightMenuController {

	private String defaultURI = "http://localhost:8080/projectapp/api/flights";
	
	/**
	 * This method is to display a list of flight 
	 * 
	 * @param model
	 * @return checkpoint 
	 */
	@GetMapping("/flight/list")
	public String getFlight(Model model) {
		
		// The URI for GET order types
		String uri = "http://localhost:8080/projectapp/api/flights";
		
		// Get a list order types from the web service
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Flight[]> response = restTemplate.getForEntity(uri,  Flight[].class);
		
		// Parse JSON data to array of subject
		Flight flight[] = response.getBody();
		
		// Parse an array to a list object
		List<Flight> flightTypeList = Arrays.asList(flight);
		
		// Attach list to model as attribute
		model.addAttribute("flights", flightTypeList);
		
		return "flight";
	}
	
	/**
	 * This method wil update or add a flight
	 * 
	 * @param checkpoint2
	 * @return
	 */
	@RequestMapping("/flight/save")
	public String updateFlight (@ModelAttribute Flight flight)
	{
		// Create a new RestTemplate
		RestTemplate restTemplate = new RestTemplate();
		
		// Create request body
		HttpEntity<Flight> request = new HttpEntity<Flight>(flight);
		
		String flightResponse = "";
		
		if (flight.getFlightId() > 0)
		{
			// This block update an new order type and send request as PUT
			restTemplate.put(defaultURI, request, Flight.class);
		}
		else 
		{
			// This block ass a new passenger and send request as POST
			flightResponse = restTemplate.postForObject(defaultURI, request, String.class);
			
		}
		
		System.out.println(flightResponse);
		
		// Redirect request to display a list of passenger
		return "redirect:/flight/list";
	}
	
	/**
	 *  This method is to get flight information based on flight Id
	 * @param flightId
	 * @param model
	 * @return
	 */
	@GetMapping("/flight/{flightId}")
	public String getFlight (@PathVariable Integer flightId, Model model)
	{
		String pageTitle = "New Flight";
		Flight flight = new Flight();
		
		// This block get an order type to be updated
		if (flightId > 0)
		{
			// Generate new URI and append orderTypeId to it
			String uri = defaultURI + "/" + flightId;
			
			//Get an order type from the web service
			RestTemplate restTemplate = new RestTemplate();
			flight = restTemplate.getForObject(uri,  Flight.class);
			
			//Give a new title to the page
			pageTitle = "Edit Flight";
		}
		
		//Attach value to pass to front end
		model.addAttribute("Flight", flight);
		model.addAttribute("pageTitle", pageTitle);
		
		return "flightinfo";
	}
	
	/**
	 * This method deletes an flight
	 * 
	 * @param passengerID
	 * @return
	 */
	@RequestMapping("/flight/delete/{flightId}")
	public String deleteFlight(@PathVariable String flightId)
	{
		// Generate new URI, similar to the mapping in PassengerRESTController
		String uri = defaultURI + "/{flightId}";
		
		// Send a DELETE request and attach the value of orderTypeId into URI
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(uri, Map.of("flightId",(flightId)));
		
		return "redirect:/flight/list";
	}
}