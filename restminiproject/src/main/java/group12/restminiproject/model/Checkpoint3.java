package group12.restminiproject.model;

import java.time.LocalDate;
import java.time.LocalTime;

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
	

	@Column(name = "Checkpoint3Time")
	private LocalTime checkpoint3Time;
	
	@Column(name = "Checkpoint3Date")
	private LocalDate checkpoint3Date;
	
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

	public LocalTime getCheckpoint3Time() {
		return checkpoint3Time;
	}

	public void setCheckpoint3Time(LocalTime checkpoint3Time) {
		this.checkpoint3Time = checkpoint3Time;
	}

	public LocalDate getCheckpoint3Date() {
		return checkpoint3Date;
	}

	public void setCheckpoint3Date(LocalDate checkpoint3Date) {
		this.checkpoint3Date = checkpoint3Date;
	}
}
