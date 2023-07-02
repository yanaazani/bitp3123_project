package group12.restminiproject.controller;

import java.util.List;
import java.util.Map;
import java.util.Arrays;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import group12.restminiproject.model.Luggage;
import group12.restminiproject.model.Passenger;

/**
 * 
 * @author Nur Irdina Izzati
 *
 */
@Controller 
public class LuggageMenuController {

  String defaultURI = "http://localhost:8080/projectapp/api/luggages";
  /**
   * 
   * This method is to display a list of luggage
   * 
   * @param model
   * @return
   */
  @GetMapping("/luggage/list")
  public String getLuggage (Model model)
  {
    // The URI for GET airport
    String uri = "http://localhost:8080/projectapp/api/luggages";
    
    // Get a list airport from the web service
    RestTemplate restTemplate = new RestTemplate();
    ResponseEntity<Luggage[]> response = restTemplate.getForEntity(uri, Luggage[].class);
    
    // Parse JSON data to array of object
    Luggage luggages[] = response.getBody();
    
    
    // Parse an array to a list object
    List<Luggage> luggageList = Arrays.asList(luggages);
    
    // Attach list to model as attribute 
    model.addAttribute("luggages", luggageList);
    
    
    // returning HTML file
    return "luggage";
    
  }
  
  /**
   * This method is to get luggage information based on luggage Id 
   * 
   * @param luggageId
   * @param model
   * @return
   */
  @GetMapping("/luggage/{luggageId}")
  public String getLuggage (@PathVariable int luggageId, Model model) {
    
    String title = "New Luggage";
    Luggage luggage = new Luggage();
    
    // This block get an passenger to be updated
    if (luggageId > 0) {

      // Generate new URI and append passengerID to it
      String uri = defaultURI + "/" + luggageId;
      
      // Get an order type from the web service
      RestTemplate restTemplate = new RestTemplate();
      luggage = restTemplate.getForObject(uri, Luggage.class);
      
      //Give a new title to the page
      title = "Edit Luggage";
    }
    
    RestTemplate restTemplateFlight = new RestTemplate();
    ResponseEntity<Passenger[]> responseFlight = 
    restTemplateFlight.getForEntity("http://localhost:8080/projectapp/api/passengers", Passenger[].class);
    
    Passenger passengerArray[] = responseFlight.getBody();  
    
    // Parse an array to a list object
    List<Passenger> passengerList = Arrays.asList(passengerArray);
    

    // Attach value to pass to front end
    model.addAttribute("luggage", luggage);
    model.addAttribute("pageTitle", title);
    model.addAttribute("passenger", passengerList);
    return "luggageinfo";
      
  }
  
  /**
   * This method deletes an luggage
   * 
   * @param passengerID
   * @return
   */
  @RequestMapping("/luggage/delete/{luggageId}")
  public String deleteLuggage(@PathVariable int luggageId)
  {
    // Generate new URI, similar to the mapping in PassengerRESTController
    String uri = defaultURI + "/{luggageId}";
    
    // Send a DELETE request and attach the value of orderTypeId into URI
    RestTemplate restTemplate = new RestTemplate();
    restTemplate.delete(uri, Map.of("luggageId",(luggageId)));
    
    return "redirect:/luggage/list";
  }
  
  /**
   * This method wil update or add an luggage
   * 
   * @param luggage
   * @return
   */
@RequestMapping("/luggage/save")
  public String updateLuggage (@ModelAttribute Luggage luggage)
  {
    // Create a new RestTemplate
    RestTemplate restTemplate = new RestTemplate();
    
    // Create request body
    HttpEntity<Luggage> request = new HttpEntity<Luggage>(luggage);
    
    String luggageResponse = "";
    
    if (luggage.getLuggageId() > 0)
    {
      // This block update an new order type and send request as PUT
      restTemplate.put(defaultURI, request, Luggage.class);
    }
    else 
    {
      // This block ass a new passenger and send request as POST
      luggageResponse = restTemplate.postForObject(defaultURI, request, String.class);
      
    }
    
    System.out.println(luggageResponse);
    
    // Redirect request to display a list of passenger
    return "redirect:/luggage/list";
  }


  
}