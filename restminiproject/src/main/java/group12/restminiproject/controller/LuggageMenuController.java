package group12.restminiproject.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import group12.restminiproject.model.Luggage;

@Controller
public class LuggageMenuController {

	private String defaultURI = "http://localhost:8080/projectapp/api/luggage";
	
	@GetMapping("/luggage/list")
	public String getLuggage(Model model) {
		
		// The URI for GET order types
		String uri = "http://localhost:8080/projectapp/api/luggages";
		
		// Get a list order types from the web service
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Luggage[]> response = restTemplate.getForEntity(uri,  Luggage[].class);
		
		// Parse JSON data to array of subject
		Luggage luggage[] = response.getBody();
		
		// Parse an array to a list object
		List<Luggage> luggageTypeList = Arrays.asList(luggage);
		
		// Attach list to model as attribute
		model.addAttribute("luggages", luggageTypeList);
		
		return "luggages";
	}
	
	@GetMapping("/luggage/{luggageId}")
	public String getFlight (@PathVariable Integer luggageId, Model model)
	{
		String pageTitle = "New Luggage";
		Luggage luggage = new Luggage();
		
		// This block get an order type to be updated
		if (luggageId > 0)
		{
			// Generate new URI and append orderTypeId to it
			String uri = defaultURI + "/" + luggageId;
			
			//Get an order type from the web service
			RestTemplate restTemplate = new RestTemplate();
			luggage = restTemplate.getForObject(uri,  Luggage.class);
			
			//Give a new title to the page
			pageTitle = "Edit Luggage";
		}
		
		//Attach value to pass to front end
		model.addAttribute("luggage", luggage);
		model.addAttribute("pageTitle", pageTitle);
		
		return "luggagetypeinfo";
	}
}
