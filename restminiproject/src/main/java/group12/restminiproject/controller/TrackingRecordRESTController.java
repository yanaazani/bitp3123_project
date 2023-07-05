package group12.restminiproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import group12.restminiproject.model.TrackingRecord;
import group12.restminiproject.repository.TrackingRecordRepository;

@RestController
@RequestMapping("/api/trackingrecord")
public class TrackingRecordRESTController {
	
	@Autowired
	private TrackingRecordRepository trackingRecordRepository;
	
	
	// retrieve all Tracking Sheet information detail
		@GetMapping
		public List<TrackingRecord> getTrackingRecord()
		{
			return trackingRecordRepository.findAll();
			
		}		
		
		// Update Tracking Record
		@PutMapping()
		public TrackingRecord updateTrackingRecord(@RequestBody TrackingRecord trackingrecord)
		{
			return trackingRecordRepository.save(trackingrecord);
		}
		
		// delete Tracking Record
		@DeleteMapping("{trackingRecordId}")
		public ResponseEntity<HttpStatus> deleteTrackingRecord(@PathVariable Long trackingRecordId){
			trackingRecordRepository.deleteById(trackingRecordId);
			return new ResponseEntity<>(HttpStatus.OK);
		}

}
