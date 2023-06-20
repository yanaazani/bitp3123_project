package group12.restminiproject.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

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

import group12.restminiproject.model.Checkpoint2;
import group12.restminiproject.repository.Checkpoint2Repository;

/**
 * 
 * @author Shaufy Yana Ezani
 *
 */
@RestController
@RequestMapping("/api/checkpoint2")
public class Checkpoint2RESTController {
	
	@Autowired
	private Checkpoint2Repository checkpoint2Repository;
	
	// retrieve checkpoint detail based on checkpoint 2 ID
	@GetMapping("{checkpoint2Id}")
	public Checkpoint2 getCheckpoint2(@PathVariable long checkpoint2Id)
	{
		Checkpoint2 Checkpoint2 = checkpoint2Repository.findById(checkpoint2Id).get();
		return Checkpoint2;
	}
	
	// retrieve all checkpoint 2 information detail
	@GetMapping
	public List<Checkpoint2> getCheckpoint2()
	{
		return checkpoint2Repository.findAll();
		
	}
	
	// insert checkpoint 
	@PostMapping
	public Checkpoint2 insertCheckpoint2(@RequestBody Checkpoint2 checkpoint2)
	{
		 LocalDate checkpoint2Date = LocalDate.now();
	     LocalTime checkpoint2Time = LocalTime.now();
	     checkpoint2.setCheckpoint2Date(checkpoint2Date);
	     checkpoint2.setCheckpoint2Time(checkpoint2Time);
		return checkpoint2Repository.save(checkpoint2);
	}
				
	// Update checkpoint 2
	@PutMapping()
	public Checkpoint2 updateCheckpoint2(@RequestBody Checkpoint2 checkpoint2) {
		return checkpoint2Repository.save(checkpoint2);
	}
				
	// delete checkpoint 2
	@DeleteMapping("{checkpoint2Id}")
	public ResponseEntity<HttpStatus> deleteCheckpoint2(@PathVariable long checkpoint2Id){
		checkpoint2Repository.deleteById(checkpoint2Id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
