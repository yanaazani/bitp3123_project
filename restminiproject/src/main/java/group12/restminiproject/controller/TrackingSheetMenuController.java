package group12.restminiproject.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import group12.restminiproject.model.TrackingSheet;

/**
 * 
 * @author Shaufy Yana Ezani
 *
 */
@Controller
public class TrackingSheetMenuController {
	
	private String defaultURI = "http://localhost:8080/projectapp/api/trackingsheet";
	
		/**
		 * This method is to display a list from checkpoint 1 to checkpoint 4
		 * and luggage id
		 * 
		 * @param model
		 * @return checkpoint 
		 */
		@GetMapping("/trackingsheet/list")
		public String getTrackingSheet(Model model)
		{
			//The URI for GET checkpoint3
			String uri="http://localhost:8080/projectapp/api/trackingsheet";
			
			//Get a list checkpoint3 from the web service
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<TrackingSheet[]> response = restTemplate.getForEntity(uri,TrackingSheet[].class);
			//response.
			//Parse JSON data to array of object
			TrackingSheet trackingsheets[] = response.getBody();
			
			//Parse an array to a list object
			List<TrackingSheet> trackingsheetList = Arrays.asList(trackingsheets);
			
			//Attach list to model as attribute
			model.addAttribute("trackingsheets", trackingsheetList);
					
			return "trackingsheets";
		} 
		
		/**
		 * This method is to get checkpoint 4 information
		 * 
		 * @param Checkpoint4Id
		 * @param model
		 * @return
		 */
		@GetMapping("/trackingsheet/{TrackingSheetId}")
		public String getTrackingSheet(@PathVariable Integer TrackingSheetId, Model model)
		{
			String pageTitle = " New Checkpoint 4 ";
			TrackingSheet trackingSheet = new TrackingSheet();
			
			//This block is to get the luggage to be updated
			if(TrackingSheetId>0) {
				
				//Generate new URI and append luggageId to it
				String uri = defaultURI + "/" + TrackingSheetId;
				
				// Get luggage from the web service
				RestTemplate restTemplate = new RestTemplate();
				trackingSheet = restTemplate.getForObject(uri, TrackingSheet.class);
				
				//Give a new title to the page
				pageTitle = " Edit Tracking Sheet ";
				
			}
			
			//Attach value to pass to front end
			model.addAttribute("trackingSheet", trackingSheet);
			model.addAttribute("pageTitle", pageTitle);
			
			return "trackingsheetinfo";
		}
		
		/**
		 * This method wil update or add an checkpoint
		 * 
		 * @param checkpoint4
		 * @return
		 */
		@RequestMapping ("/trackingsheet/save")
		public String updateTrackingSheet(@ModelAttribute TrackingSheet trackingsheet) {		
		
			//Create a new RestTemplate
			RestTemplate restTemplate = new RestTemplate();
			
			//Create request body
			HttpEntity<TrackingSheet> request = new HttpEntity<TrackingSheet>(trackingsheet);
			
			String trackingsheetResponse = "";
			
			if (trackingsheet.getTrackingSheetId()>0)
			{	// This block update an new checkpoint and 
				
				// Send request as PUT
				restTemplate.put(defaultURI, request, TrackingSheet.class);
			}
				
			else 
			{	//This block add a new checkpoint 
				
				//send request as POST
				trackingsheetResponse = restTemplate.postForObject(defaultURI, request, String.class);
				}
				
				System.out.println(trackingsheetResponse);
				
				// Redirect request to display a list of checkpoint
				return "redirect:/trackingsheet/list";
			}
		

}
