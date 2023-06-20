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

import group12.restminiproject.model.Checkpoint1;
import group12.restminiproject.model.Luggage;
import group12.restminiproject.model.Passenger;


@Controller
public class Checkpoint1MenuController {
	
	private String defaultURI = "http://localhost:8080/projectapp/api/checkpoints1";
	
	@GetMapping("/checkpoint1/list")
	public String getCheckpoints1 (Model model)
	{
		// The URI for GET checkpoint
		String uri = "http://localhost:8080/projectapp/api/checkpoints1";
		
		// Get a list checkpoint from the web service
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Checkpoint1[]> response = restTemplate.getForEntity(uri, Checkpoint1[].class);
		
		// Parse JSON data to array of object
		Checkpoint1 checkpoints1[] = response.getBody();
		
		
		// Parse an array to a list object
		List<Checkpoint1> checkpointList1 = Arrays.asList(checkpoints1);
		
		// Attach list to model as attribute 
		model.addAttribute("checkpoints1", checkpointList1);
		
		
		// returning HTML file
		return "checkpoint1";
		
	}
	
	@RequestMapping("/checkpoint1/save")
	public String updateCeckpoint1 (@ModelAttribute Checkpoint1 checkpoint1)
	{
		// Create a new RestTemplate
		RestTemplate restTemplate = new RestTemplate();
		
		// Create request body
		HttpEntity<Checkpoint1> request = new HttpEntity<Checkpoint1>(checkpoint1);
		
		String checkpointResponse1 = "";
		
		if (checkpoint1.getCheckpoint1Id() > 0)
		{
			// This block update an new luggage and send request as PUT
			restTemplate.put(defaultURI, request, Checkpoint1.class);
		}
		else 
		{
			// This block add a new luggage and send request as POST
			checkpointResponse1 = restTemplate.postForObject(defaultURI, request, String.class);
			
		}
		
		System.out.println(checkpointResponse1);
		
		// Redirect request to display a list of passenger
		return "redirect:/checkpoint1/list";
	}
	
	@GetMapping("/checkpoint1/{Checkpoint1Id}")
	public String getCheckpoint1(@PathVariable int Checkpoint1Id, Model model) {

	    String title = "New Checkpoint 1";
	    Checkpoint1 checkpoint1 = new Checkpoint1();

	    // This block gets a checkpoint1 to be updated
	    if (Checkpoint1Id > 0) {

	        // Generate a new URI and append Checkpoint1Id to it
	        String uri = defaultURI + "/" + Checkpoint1Id;

	        // Get a checkpoint1 from the web service
	        RestTemplate restTemplate = new RestTemplate();
	        checkpoint1 = restTemplate.getForObject(uri, Checkpoint1.class);

	        // Give a new title to the page
	        title = "Edit Checkpoint 1";
	    }

	    
	    RestTemplate restTemplateLuggage = new RestTemplate();
	    ResponseEntity<Luggage[]> responseLuggage =
	            restTemplateLuggage.getForEntity("http://localhost:8080/projectapp/api/luggages", Luggage[].class);

	    Luggage luggageArray[] = responseLuggage.getBody();

	    // Parse an array to a list object
	    List<Luggage> luggageList = Arrays.asList(luggageArray);


	    RestTemplate restTemplatePassenger = new RestTemplate();
	    ResponseEntity<Passenger[]> responsePassenger =
	            restTemplatePassenger.getForEntity("http://localhost:8080/projectapp/api/passengers", Passenger[].class);

	    Passenger passengerArray[] = responsePassenger.getBody();

	    // Parse an array to a list object
	    List<Passenger> passengerList = Arrays.asList(passengerArray);


	    // Attach values to pass to the front end
	    model.addAttribute("checkpoint1", checkpoint1);
	    model.addAttribute("passenger", passengerList);
	    model.addAttribute("luggage", luggageList);
	    model.addAttribute("pageTitle", title);

	    return "checkpoint1info";
	}

	/**
	 * This method deletes an passenger
	 * 
	 * @param CheckpointID
	 * @return
	 */
	@RequestMapping("checkpoint1/delete/{Checkpoint1Id}")
	public String deleteCheckpoint1(@PathVariable int Checkpoint1Id)
	{
		// Generate new URI, similar to the mapping in Checkpoint1RESTController
		String uri = defaultURI + "/{Checkpoint1Id}";
		
		// Send a DELETE request and attach the value of orderTypeId into URI
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(uri, Map.of("Checkpoint1Id",(Checkpoint1Id)));
		
		return "redirect:/checkpoint1/list";
	}

}