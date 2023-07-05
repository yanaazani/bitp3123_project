package group12.restminiproject.controller;
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

import group12.restminiproject.model.Luggage;
import group12.restminiproject.repository.LuggageRepository;


/*
 * This REST Controller request REST web service in PROVIDER site
 * This is for Luggage Rest Controller
 * 
 * @Author Nur Irdina Izzati Binti Khairuzaman
 * 
 */
@RestController
@RequestMapping("/api/luggages")
public class LuggageRESTController {
  
  @Autowired
  private LuggageRepository luggageRepository;
  
  /**
	 * This is to delete luggage by id
	 * This method deletes luggage based on id
	 *
	 */
  @DeleteMapping("{luggageId}")
  public ResponseEntity<HttpStatus> deleteLuggage(@PathVariable long luggageId) {
      luggageRepository.deleteById(luggageId);
      return new ResponseEntity<>(HttpStatus.OK);
  }


  /**
	 * This is to get luggage details
	 * This method retrieves all luggage details
	 *
	 *@return A list of luggage details
	 */
  @GetMapping
  public List<Luggage> getLuggage()
  {
    return luggageRepository.findAll();
    
  }
  
  /**
	 * This is to get the luggage details by id
	 * This method retrieves luggage details based on id
	 * 
	 * @param luggageID
	 * @return A list of luggage details by id
	 */
  @GetMapping("{luggageId}")
  public Luggage getLuggage(@PathVariable long luggageId)
  {
    Luggage luggage = luggageRepository.findById(luggageId).get();
    return luggage;
  }

  /**
   * This is to post luggage details
   * This method insert new luggage details
   * 
   */
  @PostMapping
  public Luggage insertLuggage(@RequestBody Luggage luggage)
  {
    return luggageRepository.save(luggage);
  }

  /**
   * This is to put luggage details
   * This method update luggage details
   * 
   */
  @PutMapping
  public Luggage updateLuggage (@RequestBody Luggage luggage)
  {
    return luggageRepository.save(luggage);
  }
  
}