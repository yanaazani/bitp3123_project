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

/*
 * This REST Controller request REST web service in PROVIDER site
 * This is for Checkpoint 2 Rest Controller
 * 
 * @Author Shaufy Yana Ezani
 * 
 */
@RestController
@RequestMapping("/api/checkpoint2")
public class Checkpoint2RESTController {
	
	@Autowired
	private Checkpoint2Repository checkpoint2Repository;
	
	/**
	 * This is to get checkpoint 2
	 * This method retrieve checkpoint detail based on checkpoint 2 ID
	 *
	 * @param Checkpoint2Id
	 * @return A list of checkpoint 2 details by id
	 */
	@GetMapping("{checkpoint2Id}")
	public Checkpoint2 getCheckpoint2(@PathVariable long checkpoint2Id)
	{
		Checkpoint2 Checkpoint2 = checkpoint2Repository.findById(checkpoint2Id).get();
		return Checkpoint2;
	}
	
	/**
	 * This is to get checkpoint 2 details
	 * This method retrieves checkpoint 2 details
	 */
	@GetMapping
	public List<Checkpoint2> getCheckpoint2()
	{
		return checkpoint2Repository.findAll();
		
	}
	
	/**
	 * This is to post checkpoint 2
	 * This method add new checkpoint 2
	 *
	 */
	@PostMapping
	public Checkpoint2 insertCheckpoint2(@RequestBody Checkpoint2 checkpoint2)
	{
		 LocalDate checkpoint2Date = LocalDate.now();
	     LocalTime checkpoint2Time = LocalTime.now();
	     checkpoint2.setCheckpoint2Date(checkpoint2Date);
	     checkpoint2.setCheckpoint2Time(checkpoint2Time);
		return checkpoint2Repository.save(checkpoint2);
	}
				
	/**
	 * This is to put checkpoint 2 
	 * This method update checkpoint 2 details
	 *
	 */
	@PutMapping()
	public Checkpoint2 updateCheckpoint2(@RequestBody Checkpoint2 checkpoint2) {
		return checkpoint2Repository.save(checkpoint2);
	}
				
	/**
	 * This is to delete checkpoint 2 
	 * This method deletes checkpoint 2 based on id
	 *
	 */
	@DeleteMapping("{checkpoint2Id}")
	public ResponseEntity<HttpStatus> deleteCheckpoint2(@PathVariable long checkpoint2Id){
		checkpoint2Repository.deleteById(checkpoint2Id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
