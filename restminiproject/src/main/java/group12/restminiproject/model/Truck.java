package group12.restminiproject.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "truck")

public class Truck {
	
	//Primary Key
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TruckId")
	private int truckId;

	@Column(name = "TruckLocation")
	private String truckLocation;
	
	@Column(name = "TruckStatus")
	private String truckStatus;
	
	public int getTruckId() {
		return truckId;
	}
	
	public void setTruckId(int truckId) {
		this.truckId = truckId;
	}
	
	public String getTruckLocation() {
		return truckLocation;
	}
	
	public void setTruckLocation(String truckLocation) {
		this.truckLocation = truckLocation;
	}
	
	public String getTruckStatus() {
		return truckStatus;
	}
	
	public void setTruckStatus(String truckStatus) {
		this.truckStatus = truckStatus;
	}

}
