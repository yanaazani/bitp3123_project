package group12.restminiproject.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

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
import group12.restminiproject.model.Passenger;

/*
 * This REST Controller request REST web service in PROVIDER site
 * This is for Passenger Menu Controller
 * 
 * @Author Nur Irdina Izzati Binti Khairuzaman
 * 
 */
@Controller
public class PassengerMenuController {
	
	private String defaultURI = "http://localhost:8080/projectapp/api/passengers";
	
	/**
	 * This is to get the passenger 
	 * This method display passenger details
	 * 
	 * @return A list of passenger details
	 */
	@GetMapping("/passenger/list")
	public String getPassengers (Model model)
	{
		// The URI for GET passenger
		String uri = "http://localhost:8080/projectapp/api/passengers";
		
		// Get a list airport from the web service
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Passenger[]> response = restTemplate.getForEntity(uri, Passenger[].class);
		
		// Parse JSON data to array of object
		Passenger passengers[] = response.getBody();
		
		
		// Parse an array to a list object
		List<Passenger> passengerList = Arrays.asList(passengers);
		
		// Attach list to model as attribute 
		model.addAttribute("passengers", passengerList);
		
		return "passenger";
		
	}
	
	/**
	 * This is to request the passenger details
	 * This method update passenger details
	 * 
	 */
	@RequestMapping ("/passenger/save")
	public String updatePassenger (@ModelAttribute Passenger passenger) {		
	
		//Create a new RestTemplate
		RestTemplate restTemplate = new RestTemplate();
		
		//Create request body
		HttpEntity<Passenger> request = new HttpEntity<Passenger>(passenger);
		
		String passengerResponse = "";
		
		if (passenger.getPassengerId()>0)
		{	// This block update an new checkpoint and 
			
			// Send request as PUT
			restTemplate.put(defaultURI, request, Passenger.class);
		}
			
		else 
		{	//This block add a new checkpoint 
			
			//send request as POST
				passengerResponse = restTemplate.postForObject(defaultURI, request, String.class);
			}
			
			System.out.println(passengerResponse);
			
			// Redirect request to display a list of checkpoint
			return "redirect:/passenger/list";
		}
	
	/**
	 * This is to get the passenger by id
	 * This method add new passenger details
	 * 
	 * @return A list of new passenger details 
	 */
	@GetMapping("/passenger/{passengerId}")
	public String getPassenger (@PathVariable int passengerId, Model model) {
		
		String title = "New Passenger";
		Passenger passenger = new Passenger();
		
		// This block get an passenger to be updated
		if (passengerId > 0) {

			// Generate new URI and append passengerID to it
			String uri = defaultURI + "/" + passengerId;
			
			// Get an order type from the web service
			RestTemplate restTemplate = new RestTemplate();
			passenger = restTemplate.getForObject(uri, Passenger.class);
			
			//Give a new title to the page
			title = "Edit Passenger";
		}
		
		RestTemplate restTemplateFlight = new RestTemplate();
		ResponseEntity<Flight[]> responseFlight = 
				restTemplateFlight.getForEntity("http://localhost:8080/projectapp/api/flights", Flight[].class);
		
		Flight flightArray[] = responseFlight.getBody();	
		
		// Parse an array to a list object
		List<Flight> flightList = Arrays.asList(flightArray);
		
		// Attach value to pass to front end
		model.addAttribute("Passenger", passenger);
		model.addAttribute("pageTitle", title);
		model.addAttribute("flight", flightList);
		return "passengerinfo";
			
	}
	
	/**
	 * This is to request passenger details by id
	 * This method deletes an passenger details based on id
	 * 
	 * @param passengerID
	 */
	@RequestMapping("/passenger/delete/{passengerId}")
	public String deletePassenger(@PathVariable String passengerId)
	{
		// Generate new URI, similar to the mapping in PassengerRESTController
		String uri = defaultURI + "/{passengerId}";
		
		// Send a DELETE request and attach the value of passengerId into URI
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(uri, Map.of("passengerId",(passengerId)));
		
		return "redirect:/passenger/list";
	}
	

}