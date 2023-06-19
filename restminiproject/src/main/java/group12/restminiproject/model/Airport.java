package group12.restminiproject.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "airport")
public class Airport {
	
	//Primary Key
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "AirportId")
	private int airportId;
	
	@Column(name = "AirportName")
	private String airportName;
	
	@Column(name = "DepartureTime")
	private String departureTime;
	
	@Column(name = "ArrivalTime")
	private String arrivalTime;
	
	@Column(name = "DepartureDate")
	private String departureDate;
	
	@Column(name = "ArrivalDate")
	private String arrivalDate;
	
	public int getAirportId() {
		return airportId;
	}
	public void setAirportId(int airportId) {
		this.airportId = airportId;
	}
	public String getAirportName() {
		return airportName;
	}
	public void setAirportName(String airportName) {
		this.airportName = airportName;
	}
	public String getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}
	public String getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public String getDepartureDate() {
		return departureDate;
	}
	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}
	public String getArrivalDate() {
		return arrivalDate;
	}
	public void setArrivalDate(String arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

}