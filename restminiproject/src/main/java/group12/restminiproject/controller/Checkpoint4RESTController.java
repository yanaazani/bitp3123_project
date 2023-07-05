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

import group12.restminiproject.model.Checkpoint4;
import group12.restminiproject.repository.Checkpoint4Repository;

/*
 * This REST Controller request REST web service in PROVIDER site
 * This is for Checkpoint 4 Rest Controller
 * 
 * @Author Shaufy Yana Ezani
 * 
 */
@RestController
@RequestMapping("/api/checkpoint4")
public class Checkpoint4RESTController {
	
	@Autowired
	private Checkpoint4Repository checkpoint4Repository;
	
	/**
	 * This is to get checkpoint 4
	 * This method retrieve checkpoint detail based on checkpoint 4 ID
	 *
	 * @param Checkpoint4Id
	 * @return A list of checkpoint 4 details by id
	 */
	@GetMapping("{checkpoint4Id}")
	public Checkpoint4 getCheckpoint4(@PathVariable long checkpoint4Id)
	{
		Checkpoint4 Checkpoint4 = checkpoint4Repository.findById(checkpoint4Id).get();
		return Checkpoint4;
	}
	
	/**
	 * This is to get checkpoint 4 details
	 * This method retrieves checkpoint 4 details
	 */
	@GetMapping
	public List<Checkpoint4> getCheckpoint4()
	{
		return checkpoint4Repository.findAll();
		
	}
	
	/**
	 * This is to post checkpoint 4 
	 * This method add new checkpoint 4
	 *
	 */
	@PostMapping
	public Checkpoint4 insertCheckpoint4(@RequestBody Checkpoint4 checkpoint4)
	{
		 LocalDate checkpoint4Date = LocalDate.now();
	     LocalTime checkpoint4Time = LocalTime.now();
	     checkpoint4.setCheckpoint4Date(checkpoint4Date);
	     checkpoint4.setCheckpoint4Time(checkpoint4Time);
		return checkpoint4Repository.save(checkpoint4);
	}
				
	/**
	 * This is to put checkpoint 4
	 * This method update checkpoint 4 details
	 *
	 */
	@PutMapping()
	public Checkpoint4 updateCheckpoint4(@RequestBody Checkpoint4 checkpoint4) {
		return checkpoint4Repository.save(checkpoint4);
	}
				
	/**
	 * This is to delete checkpoint 4 
	 * This method deletes checkpoint 4 based on id
	 *
	 */
	@DeleteMapping("{checkpoint4Id}")
	public ResponseEntity<HttpStatus> deleteCheckpoint4(@PathVariable long checkpoint4Id){
		checkpoint4Repository.deleteById(checkpoint4Id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
