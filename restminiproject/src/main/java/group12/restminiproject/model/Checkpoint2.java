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
@Table(name = "checkpoint2")
public class Checkpoint2 {
	
		//Primary Key
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "Checkpoint2Id")
		private int checkpoint2Id;
		
		@Column(name = "Checkpoint2Time")
		private LocalTime checkpoint2Time;
		
		@Column(name = "Checkpoint2Date")
		private LocalDate checkpoint2Date;
		
		@ManyToOne
		@JoinColumn(name = "LuggageId")
		private Luggage luggage;
		
		@ManyToOne
		@JoinColumn(name = "ConveyorLaneId")
		private ConveyorLane conveyorLane;

		public int getCheckpoint2Id() {
			return checkpoint2Id;
		}

		public void setCheckpoint2Id(int checkpoint2Id) {
			this.checkpoint2Id = checkpoint2Id;
		}

		public LocalTime getCheckpoint2Time() {
			return checkpoint2Time;
		}

		public void setCheckpoint2Time(LocalTime checkpoint2Time) {
			this.checkpoint2Time = checkpoint2Time;
		}

		public LocalDate getCheckpoint2Date() {
			return checkpoint2Date;
		}

		public void setCheckpoint2Date(LocalDate checkpoint2Date) {
			this.checkpoint2Date = checkpoint2Date;
		}

		public Luggage getLuggage() {
			return luggage;
		}

		public void setLuggage(Luggage luggage) {
			this.luggage = luggage;
		}

		public ConveyorLane getConveyorLane() {
			return conveyorLane;
		}

		public void setConveyorLane(ConveyorLane conveyorLane) {
			this.conveyorLane = conveyorLane;
		}
	

}
