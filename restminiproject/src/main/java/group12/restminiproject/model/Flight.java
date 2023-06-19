package group12.restminiproject.model;

import java.sql.Date;
import java.sql.Time;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "flight")

public class Flight {
	
	//Primary Key
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "FlightId")
	private int flightId;

	@Column(name = "DepartureTime")
	private Time departureTime;
	
	@Column(name = "ArrivalTime")
	private Time arrivalTime;
	
	@Column(name = "DepartureDate")
	private Date departureDate;
	
	@Column(name = "ArrivalDate")
	private Date arrivalDate;
	
	public int getFlightId() {
		return flightId;
	}
	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}
	public Time getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(Time departureTime) {
		this.departureTime = departureTime;
	}
	public Time getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(Time arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public Date getDepartureDate() {
		return departureDate;
	}
	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}
	public Date getArrivalDate() {
		return arrivalDate;
	}
	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

}
