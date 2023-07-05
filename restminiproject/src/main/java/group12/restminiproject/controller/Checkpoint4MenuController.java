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

import group12.restminiproject.model.Checkpoint4;

/*
 * This REST Controller request REST web service in PROVIDER site
 * This is for Checkpoint 4 Menu Controller
 * 
 * @Author Shaufy Yana Ezani
 * 
 */
@Controller
public class Checkpoint4MenuController {
	
	private String defaultURI = "http://localhost:8080/projectapp/api/checkpoint4";
	
	/**
	 * This method is to display a list of checkpoint 4 where there are luggage id and flight id
	 * 
	 * @param model
	 * @return checkpoint 
	 */
	@GetMapping("/checkpoint4/list")
	public String getCheckpoint4(Model model)
	{
		//The URI for GET checkpoint3
		String uri="http://localhost:8080/projectapp/api/checkpoint4";
		
		//Get a list checkpoint3 from the web service
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Checkpoint4[]> response = restTemplate.getForEntity(uri,Checkpoint4[].class);
		
		//Parse JSON data to array of object
		Checkpoint4 checkpoint4s[] = response.getBody();
		
		//Parse an array to a list object
		List<Checkpoint4> checkpoint4List = Arrays.asList(checkpoint4s);
		
		//Attach list to model as attribute
		model.addAttribute("checkpoint4s", checkpoint4List);
				
		return "checkpoint4s";
	} 

	/**
	 * This method wil update or add an checkpoint
	 * 
	 * @param checkpoint4
	 * @return
	 */
	@RequestMapping ("/checkpoint4/save")
	public String updateCheckpoint4(@ModelAttribute Checkpoint4 checkpoint4) {		
	
		//Create a new RestTemplate
		RestTemplate restTemplate = new RestTemplate();
		
		//Create request body
		HttpEntity<Checkpoint4> request = new HttpEntity<Checkpoint4>(checkpoint4);
		
		String checkpoint4Response = "";
		
		if (checkpoint4.getCheckpoint4Id()>0)
		{	// This block update an new checkpoint and 
			
			// Send request as PUT
			restTemplate.put(defaultURI, request, Checkpoint4.class);
		}
			
		else 
		{	//This block add a new checkpoint 
			
			//send request as POST
			checkpoint4Response = restTemplate.postForObject(defaultURI, request, String.class);
			}
			
			System.out.println(checkpoint4Response);
			
			// Redirect request to display a list of checkpoint
			return "redirect:/checkpoint4/list";
		}
	
	/**
	 * This method is to get checkpoint 4 information
	 * 
	 * @param Checkpoint4Id
	 * @param model
	 * @return
	 */
	@GetMapping("/checkpoint4/{Checkpoint4Id}")
	public String getCheckpoint4(@PathVariable Integer Checkpoint4Id, Model model)
	{
		String pageTitle = " New Checkpoint 4 ";
		Checkpoint4 checkpoint4 = new Checkpoint4();
		
		//This block is to get the luggage to be updated
		if(Checkpoint4Id>0) {
			
			//Generate new URI and append luggageId to it
			String uri = defaultURI + "/" + Checkpoint4Id;
			
			// Get luggage from the web service
			RestTemplate restTemplate = new RestTemplate();
			checkpoint4 = restTemplate.getForObject(uri, Checkpoint4.class);
			
			//Give a new title to the page
			pageTitle = " Edit Checkpoint 4 ";
			
		}
		
		//Attach value to pass to front end
		model.addAttribute("checkpoint4", checkpoint4);
		model.addAttribute("pageTitle", pageTitle);
		
		return "checkpoint4info";
	}
	
	/**
	 * This is to request checkpoint 3
	 * This method function is to delete checkpoint
	 * 
	 * @param checkpoint4Id
	 * @return
	 */
	@RequestMapping("checkpoint4/delete/{checkpoint4Id}")
	public String deleteCheckpoint3(@PathVariable int checkpoint4Id) {
		
		//Generate new URI similar to the mapping in Checkpoint3RESTController
		String uri= defaultURI + "/{checkpoint4Id}";
		
		//Send a DELETE request and attach the value of checkpointId into URI
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(uri, Map.of("checkpoint4Id", Integer.toString(checkpoint4Id)));
		
		return "redirect:/checkpoint4/list";
		
		
	}

}
