package group12.restminiproject.controller;

import java.util.List;

//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import group12.restminiproject.model.Checkpoint3;
import group12.restminiproject.repository.Checkpoint3Repository;



@RestController
@RequestMapping("/api/checkpoint3")
public class Checkpoint3RESTController 
	{
	
	
			@Autowired
			private Checkpoint3Repository checkpoint3Repository;
	
			// retrieve checkpoint 3 detail based on checkpoint 3 ID
			@GetMapping("{checkpoint3Id}")
			public Checkpoint3 getCheckpoint3(@PathVariable long checkpoint3Id)
			{
				Checkpoint3 Checkpoint3 = checkpoint3Repository.findById(checkpoint3Id).get();
				return Checkpoint3;
			}
	
			// retrieve all order types detail
			@GetMapping
			public List<Checkpoint3> getCheckpoint3()
			{
				return checkpoint3Repository.findAll();
				
			}

			/*// retrieve luggage detail based on luggage ID
			@GetMapping("{luggageId}")
			public Luggage getLuggage(@PathVariable long luggageId)
			{
				Luggage luggage = luggageRepository.findById(luggageId).get();
				return luggage;
			}*/
			
			// insert checkpoint 
			@PostMapping
			public Checkpoint3 insertCheckpoint(@RequestBody Checkpoint3 checkpoint3)
			{
				return checkpoint3Repository.save(checkpoint3);
			}
			
			// Update checkpoint 3 
			@PutMapping()
			public Checkpoint3 updateCheckpoint3(@RequestBody Checkpoint3 checkpoint3) {
				return checkpoint3Repository.save(checkpoint3);
			}
			
			// delete checkpoint 3 
			@DeleteMapping("{checkpoint3Id}")
			public ResponseEntity<HttpStatus> deleteCheckpoint3(@PathVariable long checkpoint3Id){
				checkpoint3Repository.deleteById(checkpoint3Id);
				return new ResponseEntity<>(HttpStatus.OK);
			}
			
			
	}