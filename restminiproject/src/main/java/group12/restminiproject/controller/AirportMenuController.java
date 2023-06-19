package group12.restminiproject.controller;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import group12.restminiproject.model.Airport;



@Controller 
public class AirportMenuController {

	//private String defaultURI = "http://localhost:8080/lugaggeapp/api/airports";
	
	@GetMapping("/airport/list")
	public String getAirports(Model model)
	{
		//The URI for GET airport
		String uri="http://localhost:8080/projectapp/api/airports";
		
		//Get a list order types from the web service
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Airport[]> response = restTemplate.getForEntity(uri,Airport[].class);
		
		//Parse JSON data to array of object
		Airport airports[] = response.getBody();
		
		//Parse an array to a list object
		List<Airport> airportList = Arrays.asList(airports);
		
		//Attach list to model as attribute
		model.addAttribute("airports", airportList);
				
		return "airports";
	}
	
	
//	@RequestMapping ("/airport/save")
//	public String updateAirport (@ModelAttribute Airport airport) {
//		
//	
//		RestTemplate restTemplate = new RestTemplate();
//		HttpEntity<Airport> request = new HttpEntity<Airport>(airport);
//		
//		String airportResponse = "";
//		
//		if (airport.getAirportId()>0)
//		{
//			// This block update an new order type and 
//			
//			// Send request as PUT
//			restTemplate.put(defaultURI, request, Airport.class);
//		} else {
//			// This block add a new order type
//			
//			//send request as POST
//			airportResponse = restTemplate.postForObject(defaultURI, request, String.class);
//		}
//		
//		System.out.println(airportResponse);
//		
//		// Redirect request to display a list of order type
//		return "redirect:/airport/list";
//	}
//	
//	@GetMapping("/airport/{airportId}")
//	public String getAirportType (@PathVariable Integer airportId, Model model)
//	{
//		String pageTitle = "New Airport";
//		Airport airport = new Airport();
//		
//		// This block get an order type to be updated
//		if (airportId > 0)
//		{
//			// Generate new URI and append orderTypeId to it
//			String uri = defaultURI + "/" + airportId;
//			
//			//Get an order type from the web service
//			RestTemplate restTemplate = new RestTemplate();
//			airport = restTemplate.getForObject(uri,  Airport.class);
//			
//			//Give a new title to the page
//			pageTitle = "Edit Airport";
//		}
//		
//		//Attach value to pass to front end
//		model.addAttribute("airport", airport);
//		model.addAttribute("pageTitle", pageTitle);
//		
//		return "airporttypeinfo";
//	}
//	
//	@RequestMapping ("/airport/delete/{airportId}")
//	public String deleteAirportType(@PathVariable Integer airportId) {
//		
//		// Generate new URI, similar to the mapping in OrderTypeRESTController
//		String uri = defaultURI + "/{airportId}";
//		
//		//Send a DELETE request and attach the value of orderTypeId into URI
//		RestTemplate restTemplate = new RestTemplate();
//		restTemplate.delete(uri, Map.of("airportId", Integer.toString(airportId)));
//		
//		return "redirect:/airport/list";
//	}
}