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

import group12.restminiproject.model.Checkpoint1;
import group12.restminiproject.repository.Checkpoint1Repository;

/*
 * This REST Controller request REST web service in PROVIDER site
 * This is for Checkpoint 1 Rest Controller
 * 
 * @Author Nur Irdina Izzati Binti Khairuzaman
 * 
 */
@RestController
@RequestMapping("/api/checkpoints1")
public class Checkpoint1RESTController {
	
	@Autowired
	private Checkpoint1Repository checkpoint1Repository;
	
	/**
	 * This is to delete checkpoint 1 
	 * This method deletes checkpoint 1 based on id
	 *
	 */
	@DeleteMapping("{checkpoint1Id}")
	public ResponseEntity<HttpStatus> deleteCheckpoint1(@PathVariable long checkpoint1Id)
	{
		checkpoint1Repository.deleteById(checkpoint1Id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	

	/**
	 * This is to get checkpoint 1 details
	 * This method retrieves checkpoint 1 details
	 *
	 * @param Checkpoint1ID
	 * @return A list of checkpoint 1 details by id
	 */
	@GetMapping
	public List<Checkpoint1> getCheckpoint1()
	{
		return checkpoint1Repository.findAll();
	}
	
	/**
	 * This is to get checkpoint 1 based on id
	 * This method retrieves checkpoint 1 details by id
	 *
	 * @param Checkpoint1ID
	 * @return A list of checkpoint 1 details by id
	 */
	@GetMapping ("{checkpoint1Id}")
	public Checkpoint1 getCheckpoint1(@PathVariable long checkpoint1Id )
	{
		Checkpoint1 checkpoint1 = checkpoint1Repository.findById(checkpoint1Id).get();
		
		return checkpoint1;
	}
	
	/**
	 * This is to post checkpoint 1 
	 * This method add new checkpoint 1 b
	 *
	 */
	@PostMapping
	public Checkpoint1 insertCheckpoint1 (@RequestBody Checkpoint1 checkpoint1)
	{
		LocalDate checkpointDate = LocalDate.now();
	     LocalTime checkpointTime = LocalTime.now();
	     checkpoint1.setCheckpointDate(checkpointDate);
	     checkpoint1.setCheckpointTime(checkpointTime);
		return checkpoint1Repository.save(checkpoint1);
	}
	
	/**
	 * This is to put checkpoint 1 
	 * This method update checkpoint 1 details
	 *
	 */
	@PutMapping
	public Checkpoint1 updateCheckpoint1 (@RequestBody Checkpoint1 checkpoint1)
	{
		return checkpoint1Repository.save(checkpoint1);
	}

}
