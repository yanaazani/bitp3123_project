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

import group12.restminiproject.model.TrackingRecord;

@Controller
public class TrackingRecordMenuController {

private String defaultURI = "http://localhost:8080/projectapp/api/trackingrecord";
	
	
	@GetMapping("/trackingrecord/list")
	public String getTrackingRecord(Model model)
	{
		// The URI for GET trackingrecord
		String uri = "http://localhost:8080/projectapp/api/trackingrecord";
		
		//Get a list of passengers from web service
		RestTemplate restTemplate= new RestTemplate();
		ResponseEntity<TrackingRecord[]> response = restTemplate.getForEntity(uri, TrackingRecord[].class);
		
		// Parse JSON data to array of object
		TrackingRecord trackingrecords[] = response.getBody();
		
		// Parse an array to a list object
		List<TrackingRecord> trackingrecordList = Arrays.asList(trackingrecords);
		
		//Attach list to model as attributes
		model.addAttribute("trackingrecords", trackingrecordList);
		
		return "trackingrecords";
		
	}


	/**
	 * This method will update or add a trackingrecord 
	 * 
	 * @param trackingrecord
	 * @return
	 */
	
	@RequestMapping("/trackingrecord/save")
	public String updateTrackingRecord(@ModelAttribute TrackingRecord trackingrecord)
	{
		// here create a new RestTemplate 
		RestTemplate restTemplate = new RestTemplate();
		
		//Create request body
		HttpEntity<TrackingRecord> request = new HttpEntity<TrackingRecord>(trackingrecord);
		
		String trackingrecordResponse = "";
		
		if (trackingrecord.getTrackingRecordId()>0)
		{
			// this block will update new trackingrecord and
			
			// send request as PUT
			
			restTemplate.put("http://localhost:8080/projectapp/api/trackingrecord", request, TrackingRecord.class);
			
			
		}
		
		else
		{
			// This block will add new passenger and
			
			// Send Request as POST	
			trackingrecordResponse = restTemplate.postForObject("http://localhost:8080/projectapp/api/trackingrecord", request, String.class);
			
		}
		
		System.out.println(trackingrecordResponse);
		
		//Redirect request to display a list of TrackingRecord
		return "redirect:/trackingrecord/list";
	}
	
	/**
	 * This method will get trackingrecord
	 * 
	 * @param trackingRecordId
	 * @param model
	 * @return
	 */
	
	@GetMapping("/trackingrecord/{trackingRecordId}")
	public String getTrackingRecord (@PathVariable Integer trackingRecordId, Model model)
	{
		String pageTitle = "New TrackingRecord Details";
		TrackingRecord trackingrecord = new TrackingRecord();
		
		//This block will get a TrackingRecord to be updated
		if(trackingRecordId > 0)
		{
			
			// Generate new URI and append PassengerId to it
			String uri = defaultURI + "/" + trackingRecordId;
			
			// Get a passenger detail from web service
			RestTemplate restTemplate = new RestTemplate();
			trackingrecord = restTemplate.getForObject(uri, TrackingRecord.class);
			
			//Give new title to the page:
			pageTitle = "Edit TrackingRecord Details";
			
			
		}
		
		
		// Attach value to pass to front end
		model.addAttribute("trackingrecord",trackingrecord);
		model.addAttribute("pageTitle", pageTitle);
		
		return "trackingrecordinfo";
	}
	
	/**
	 * This method deletes a trackingrecord
	 * 
	 * @param TrackingRecordId
	 * @return
	 */
	
	@RequestMapping("/trackingrecord/delete/{trackingRecordId}")
	public String deleteTrackingRecord(@PathVariable Integer trackingRecordId)
	{
		
		// Generate new URI, similar to the mapping in TrackingRecordIdRESTController
		String uri = defaultURI + "/{trackingRecordId}";
		
		// Send a DELETE request and attach the value of TrackingRecordId into URI
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(uri, Map.of("TrackingRecordId", Integer.toString(trackingRecordId)));
		
		return "redirect:/trackingrecord/list";
		
	}
	
	
}
