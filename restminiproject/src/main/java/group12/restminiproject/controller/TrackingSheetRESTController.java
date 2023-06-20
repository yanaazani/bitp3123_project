package group12.restminiproject.controller;

import java.util.List;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import group12.restminiproject.model.TrackingSheet;
import group12.restminiproject.repository.TrackingSheetRepository;

/**
 * 
 * @author Shaufy Yana Ezani
 *
 */

@RestController
@RequestMapping("/api/trackingsheet")
public class TrackingSheetRESTController {

	@Autowired
	private TrackingSheetRepository trackingSheetRepository;
	
	
	// retrieve all Tracking Sheet information detail
		@GetMapping
		public List<TrackingSheet> getTrackingSheet()
		{
			return trackingSheetRepository.findAll();
			
	}		
		// retrieve checkpoint detail based on Tracking Sheet ID
		@GetMapping("{trackingSheetId}")
		public TrackingSheet getTrackingSheet(@PathVariable long trackingSheetId)
		{
			TrackingSheet TrackingSheet = trackingSheetRepository.findById(trackingSheetId).get();
			return TrackingSheet;
		}
		
		// Update Tracking Sheet 
		@PutMapping()
		public TrackingSheet updateTrackingSheet(@RequestBody TrackingSheet trackingsheet) {
			return trackingSheetRepository.save(trackingsheet);
		}
}
