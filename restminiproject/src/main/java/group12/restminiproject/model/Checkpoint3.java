package group12.restminiproject.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "checkpoint3")
public class Checkpoint3 {

	//Primary Key
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Checkpoint3Id")
	private int checkpoint3Id;
	
	@ManyToOne
	@JoinColumn(name = "LuggageId")
	private Luggage luggage;
	
	@ManyToOne
	@JoinColumn(name = "TruckId")
	private Truck truck;
	
		

	public int getCheckpoint3Id() {
		return checkpoint3Id;
	}

	public void setCheckpoint3Id(int checkpoint3Id) {
		this.checkpoint3Id = checkpoint3Id;
	}

	public Luggage getLuggage() {
		return luggage;
	}

	public void setLuggage(Luggage luggage) {
		this.luggage = luggage;
	}

	public Truck getTruck() {
		return truck;
	}

	public void setTruck(Truck truck) {
		this.truck = truck;
	}



	

	
}
