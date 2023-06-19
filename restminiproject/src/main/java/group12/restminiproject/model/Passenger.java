package group12.restminiproject.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "passenger")
public class Passenger {

	//Primary Key
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name="PassengerId")
	private String passengerID;
	
	@Column (name="PassengerName")
	private String passengerName;
	
	
	public String getPassengerID() {
		return passengerID;
	}
	public void setPassengerID(String passengerID) {
		this.passengerID = passengerID;
	}
	public String getPassengerName() {
		return passengerName;
	}
	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}
	
}
