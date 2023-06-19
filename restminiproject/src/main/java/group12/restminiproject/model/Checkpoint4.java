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
@Table(name = "checkpoint4")
public class Checkpoint4 {
	

	//Primary Key
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Checkpoint4Id")
	private int checkpoint4Id;
	
	@Column(name = "Checkpoint4Time")
	private LocalTime checkpoint4Time;
	
	@Column(name = "Checkpoint4Date")
	private LocalDate checkpoint4Date;
	
	@ManyToOne
	@JoinColumn(name = "LuggageId")
	private Luggage luggage;
	
	@ManyToOne
	@JoinColumn(name="FlightId")
	private Flight flight;

	public int getCheckpoint4Id() {
		return checkpoint4Id;
	}

	public void setCheckpoint4Id(int checkpoint4Id) {
		this.checkpoint4Id = checkpoint4Id;
	}

	public Luggage getLuggage() {
		return luggage;
	}

	public void setLuggage(Luggage luggage) {
		this.luggage = luggage;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public LocalTime getCheckpoint4Time() {
		return checkpoint4Time;
	}

	public void setCheckpoint4Time(LocalTime checkpoint4Time) {
		this.checkpoint4Time = checkpoint4Time;
	}

	public LocalDate getCheckpoint4Date() {
		return checkpoint4Date;
	}

	public void setCheckpoint4Date(LocalDate checkpoint4Date) {
		this.checkpoint4Date = checkpoint4Date;
	}



}
