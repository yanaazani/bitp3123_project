package group12.restminiproject.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import group12.restminiproject.model.Passenger;

public class PassengerMenuController {

	//without installation for defaultURI, nanti akan ada whitelabel error untuk tambah new order type
		//so kena initialise varieble Default URI link ceniiii!!
		private String defaultURI = "http://localhost:8080/projectapp/api/passengers";
		
		
		@GetMapping("/passenger/list")
		public String getPassengers(Model model)
		{
			//The URI for GET order types
			String uri="http://localhost:8080/projectapp/api/passengers";
		
			//Get a list order types from the web service
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<Passenger[]> response = restTemplate.getForEntity(uri,Passenger[].class);
			
			//Parse JSON data to array of object
			Passenger passengers[] = response.getBody();
			
			//Parse an array to a list object
			List<Passenger> passengerList = Arrays.asList(passengers);
			
			//Attach list to model as attribute
			model.addAttribute("passengers", passengerList);
			
			return "passengers";
		}
		

		/**
		 * This method gets an passenger 
		 * 
		 * @param passengerId
		 * @param passengerId and model
		 * @return passengerinfo
		 */
		@GetMapping("/passenger/{passengerId}")
		public String getOrderType(@PathVariable String passengerId, Model model)
		{
			String pageTitle = "New Passenger ";
			Passenger passenger = new Passenger();
			
			//This block get an order type to be updated
			//if(passengerId != NULL)
			//{
				//Generate new URI and append orderTypeId to it 
				String uri = defaultURI + "/"+ passengerId;
				
				//Get an order type from the web service 
				RestTemplate restTemplate = new RestTemplate();
				passenger = restTemplate.getForObject(uri, Passenger.class);
				
				//Give a new title to the page 
				pageTitle = "Edit Passenger";
			//}
			
			//Attach value to pass to front end
			model.addAttribute("passenger", passenger);
			model.addAttribute("pageTitle", pageTitle);
			
			return "passengerinfo";
			
		}
		
		
		/**
		 * This method will update or add passenger
		 * 
		 * @param passenger
		 * @return
		 */
		@RequestMapping("/passenger/save")
		public String updatePassenger(@ModelAttribute Passenger passenger){
			
			//Create a new RestTemplate
			RestTemplate restTemplate = new RestTemplate();
			
			//Create request body
			HttpEntity<Passenger> request = new HttpEntity<Passenger>(passenger);
			
			String passengerRsponse="";
			
			if (passenger.getPassengerID() != null)
			{
				//This block update an new order type and
				
				//orderType.Send request as PUT
				restTemplate.put(defaultURI, request, Passenger.class);
			}else {
				//This block add a new order type
				
				//Send request as POST
				passengerRsponse = restTemplate.postForObject(defaultURI, request, String.class);
				
			}
			
			System.out.println(passengerRsponse);
			
			//Redirect request to display a list of passenger type
			return "redirect:/passenger/list";	
		}
}
