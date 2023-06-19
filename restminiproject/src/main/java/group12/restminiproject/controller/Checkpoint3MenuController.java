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

import group12.restminiproject.model.Checkpoint3;


/**
 * 
 * 
 * @author Shaufy Yana Ezani
 *
 */
@Controller
public class Checkpoint3MenuController {
	
	private String defaultURI = "http://localhost:8080/projectapp/api/checkpoint3";
	
	/**
	 * This method is to display a list of checkpoint 3 where there are luggage id and truck id
	 * 
	 * @param model
	 * @return checkpoint 
	 */
	@GetMapping("/checkpoint3/list")
	public String getCheckpoint3(Model model)
	{
		//The URI for GET checkpoint3
		String uri="http://localhost:8080/projectapp/api/checkpoint3";
		
		//Get a list checkpoint3 from the web service
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Checkpoint3[]> response = restTemplate.getForEntity(uri,Checkpoint3[].class);
		
		//Parse JSON data to array of object
		Checkpoint3 checkpoint3s[] = response.getBody();
		
		//Parse an array to a list object
		List<Checkpoint3> checkpoint3List = Arrays.asList(checkpoint3s);
		
		//Attach list to model as attribute
		model.addAttribute("checkpoint3s", checkpoint3List);
				
		return "checkpoint3s";
	} 

	/**
	 * This method wil update or add an checkpoint
	 * 
	 * @param checkpoint3
	 * @return
	 */
	@RequestMapping ("/checkpoint3/save")
	public String updateCheckpoint3(@ModelAttribute Checkpoint3 checkpoint3) {		
	
		//Create a new RestTemplate
		RestTemplate restTemplate = new RestTemplate();
		
		//Create request body
		HttpEntity<Checkpoint3> request = new HttpEntity<Checkpoint3>(checkpoint3);
		
		String checkpoint3Response = "";
		
		if (checkpoint3.getCheckpoint3Id()>0)
		{	// This block update an new checkpoint and 
			
			// Send request as PUT
			restTemplate.put(defaultURI, request, Checkpoint3.class);
		}
			
		else 
		{	//This block add a new checkpoint 
			
			//send request as POST
				checkpoint3Response = restTemplate.postForObject(defaultURI, request, String.class);
			}
			
			System.out.println(checkpoint3Response);
			
			// Redirect request to display a list of checkpoint
			return "redirect:/checkpoint3/list";
		}
	
	/**
	 * This method is to get checkpoint 3 information
	 * 
	 * @param Checkpoint3Id
	 * @param model
	 * @return
	 */
	@GetMapping("/checkpoint3/{Checkpoint3Id}")
	public String getCheckpoint3(@PathVariable Integer Checkpoint3Id, Model model)
	{
		String pageTitle = " New Checkpoint 3 ";
		Checkpoint3 checkpoint3 = new Checkpoint3();
		
		//This block is to get the luggage to be updated
		if(Checkpoint3Id>0) {
			
			//Generate new URI and append luggageId to it
			String uri = defaultURI + "/" + Checkpoint3Id;
			
			// Get luggage from the web service
			RestTemplate restTemplate = new RestTemplate();
			checkpoint3 = restTemplate.getForObject(uri, Checkpoint3.class);
			
			//Give a new title to the page
			pageTitle = " Edit Checkpoint 3 ";
			
		}
		
		//Attach value to pass to front end
		model.addAttribute("checkpoint3", checkpoint3);
		model.addAttribute("pageTitle", pageTitle);
		
		return "checkpoint3info";
	}
	
	/**
	 * This method function is to delete checkpoint
	 * 
	 * @param checkpoint3Id
	 * @return
	 */
	@RequestMapping("checkpoint3/delete/{checkpoint3Id}")
	public String deleteCheckpoint3(@PathVariable int checkpoint3Id) {
		
		//Generate new URI similar to the mapping in Checkpoint3RESTController
		String uri= defaultURI + "/{checkpoint3Id}";
		
		//Send a DELETE request and attach the value of checkpointId into URI
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(uri, Map.of("checkpoint3Id", Integer.toString(checkpoint3Id)));
		
		return "redirect:/checkpoint3/list";
		
		
	}
	
}
