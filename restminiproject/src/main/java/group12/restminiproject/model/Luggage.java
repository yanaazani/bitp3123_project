package group12.restminiproject.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "luggage")

public class Luggage {
	
	//Primary Key
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LuggageId")
	private int luggageId;

	@Column(name = "LuggageWeight")
	private double luggageWeight;
	
	@Column(name = "LuggageStatus")
	private String luggageStatus;

	public int getLuggageId() {
		return luggageId;
	}

	public void setLuggageId(int luggageId) {
		this.luggageId = luggageId;
	}

	public double getLuggageWeight() {
		return luggageWeight;
	}

	public void setLuggageWeight(double luggageWeight) {
		this.luggageWeight = luggageWeight;
	}

	public String getLuggageStatus() {
		return luggageStatus;
	}

	public void setLuggageStatus(String luggageStatus) {
		this.luggageStatus = luggageStatus;
	}
	


}
