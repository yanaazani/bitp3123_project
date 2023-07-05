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

import group12.restminiproject.model.Checkpoint2;

/*
 * This REST Controller request REST web service in PROVIDER site
 * This is for Checkpoint 2 Menu Controller
 * 
 * @Author Shaufy Yana Ezani
 * 
 */
@Controller
public class Checkpoint2MenuController {
	
private String defaultURI = "http://localhost:8080/projectapp/api/checkpoint2";
	
	/**
	 * This method is to display a list of checkpoint 2 where there are luggage id and flight id
	 * 
	 * @param model
	 * @return checkpoint 
	 */
	@GetMapping("/checkpoint2/list")
	public String getCheckpoint2(Model model)
	{
		//The URI for GET checkpoint3
		String uri="http://localhost:8080/projectapp/api/checkpoint2";
		
		//Get a list checkpoint3 from the web service
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Checkpoint2[]> response = restTemplate.getForEntity(uri,Checkpoint2[].class);
		
		//Parse JSON data to array of object
		Checkpoint2 checkpoint2s[] = response.getBody();
		
		//Parse an array to a list object
		List<Checkpoint2> checkpoint2List = Arrays.asList(checkpoint2s);
		
		//Attach list to model as attribute
		model.addAttribute("checkpoint2s", checkpoint2List);
				
		return "checkpoint2s";
	} 

	/**
	 * This method wil update or add an checkpoint
	 * 
	 * @param checkpoint2
	 * @return
	 */
	@RequestMapping ("/checkpoint2/save")
	public String updateCheckpoint2(@ModelAttribute Checkpoint2 checkpoint2) {		
	
		//Create a new RestTemplate
		RestTemplate restTemplate = new RestTemplate();
		
		//Create request body
		HttpEntity<Checkpoint2> request = new HttpEntity<Checkpoint2>(checkpoint2);
		
		String checkpoint2Response = "";
		
		if (checkpoint2.getCheckpoint2Id()>0)
		{	// This block update an new checkpoint and 
			
			// Send request as PUT
			restTemplate.put(defaultURI, request, Checkpoint2.class);
		}
			
		else 
		{	//This block add a new checkpoint 
			
			//send request as POST
			checkpoint2Response = restTemplate.postForObject(defaultURI, request, String.class);
			}
			
			System.out.println(checkpoint2Response);
			
			// Redirect request to display a list of checkpoint
			return "redirect:/checkpoint2/list";
		}
	
	/**
	 * This method is to get checkpoint 4 information based on checkpoint 4 Id
	 * 
	 * @param Checkpoint2Id
	 * @param model
	 * @return
	 */
	@GetMapping("/checkpoint2/{Checkpoint2Id}")
	public String getCheckpoint2(@PathVariable Integer Checkpoint2Id, Model model)
	{
		String pageTitle = " New Checkpoint 2 ";
		Checkpoint2 checkpoint2 = new Checkpoint2();
		
		//This block is to get the luggage to be updated
		if(Checkpoint2Id>0) {
			
			//Generate new URI and append luggageId to it
			String uri = defaultURI + "/" + Checkpoint2Id;
			
			// Get luggage from the web service
			RestTemplate restTemplate = new RestTemplate();
			checkpoint2 = restTemplate.getForObject(uri, Checkpoint2.class);
			
			//Give a new title to the page
			pageTitle = " Edit Checkpoint 2 ";
			
		}
		
		//Attach value to pass to front end
		model.addAttribute("checkpoint2", checkpoint2);
		model.addAttribute("pageTitle", pageTitle);
		
		return "checkpoint2info";
	}
	
	/**
	 * This is to request checkpoint 2
	 * This method function is to delete checkpoint 2
	 * 
	 * @param checkpoint2Id
	 * @return
	 */
	@RequestMapping("checkpoint2/delete/{checkpoint2Id}")
	public String deleteCheckpoint2(@PathVariable int checkpoint2Id) {
		
		//Generate new URI similar to the mapping in Checkpoint3RESTController
		String uri= defaultURI + "/{checkpoint2Id}";
		
		//Send a DELETE request and attach the value of checkpointId into URI
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(uri, Map.of("checkpoint2Id", Integer.toString(checkpoint2Id)));
		
		return "redirect:/checkpoint2/list";
		
		
	}

}
