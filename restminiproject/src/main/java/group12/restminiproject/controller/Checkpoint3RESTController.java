package group12.restminiproject.controller;

import java.time.LocalDate;
import java.time.LocalTime;
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


/*
 * This REST Controller request REST web service in PROVIDER site
 * This is for Checkpoint 3 Rest Controller
 * 
 * @Author Shaufy Yana Ezani
 * 
 */
@RestController
@RequestMapping("/api/checkpoint3")
public class Checkpoint3RESTController 
	{
	
	
			@Autowired
			private Checkpoint3Repository checkpoint3Repository;
	
			/**
			 * This is to get checkpoint 3
			 * This method retrieve checkpoint detail based on checkpoint 3 ID
			 *
			 * @param Checkpoint3Id
			 * @return A list of checkpoint 3 details by id
			 */
			@GetMapping("{checkpoint3Id}")
			public Checkpoint3 getCheckpoint3(@PathVariable long checkpoint3Id)
			{
				Checkpoint3 Checkpoint3 = checkpoint3Repository.findById(checkpoint3Id).get();
				return Checkpoint3;
			}
	
			/**
			 * This is to get checkpoint 3 details
			 * This method retrieves checkpoint 3 details
			 *
			 * @param Checkpoint3ID
			 * @return A list of checkpoint  details by id
			 */
			@GetMapping
			public List<Checkpoint3> getCheckpoint3()
			{
				return checkpoint3Repository.findAll();
				
			}
			
			/**
			 * This is to post checkpoint 3 
			 * This method add new checkpoint 3
			 *
			 */
			@PostMapping
			public Checkpoint3 insertCheckpoint(@RequestBody Checkpoint3 checkpoint3)
			{
				LocalDate checkpoint3Date = LocalDate.now();
			     LocalTime checkpoint3Time = LocalTime.now();
			     checkpoint3.setCheckpoint3Date(checkpoint3Date);
			     checkpoint3.setCheckpoint3Time(checkpoint3Time);
				return checkpoint3Repository.save(checkpoint3);
			}
			
			/**
			 * This is to put checkpoint 3
			 * This method update checkpoint 3 details
			 *
			 */
			@PutMapping()
			public Checkpoint3 updateCheckpoint3(@RequestBody Checkpoint3 checkpoint3) {
				return checkpoint3Repository.save(checkpoint3);
			}
			
			/**
			 * This is to delete checkpoint 3 
			 * This method deletes checkpoint 3 based on id
			 *
			 */
			@DeleteMapping("{checkpoint3Id}")
			public ResponseEntity<HttpStatus> deleteCheckpoint3(@PathVariable long checkpoint3Id){
				checkpoint3Repository.deleteById(checkpoint3Id);
				return new ResponseEntity<>(HttpStatus.OK);
			}
			
			
	}
