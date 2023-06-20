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
@Table(name = "trackingsheet")
public class TrackingSheet {
	
		//Primary Key
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "TrackingSheetId")
		private int trackingSheetId;
		
		@ManyToOne
		@JoinColumn(name = "LuggageId")
		private Luggage luggage;
		
		@ManyToOne
		@JoinColumn(name = "Checkpoint1Id")
		private Checkpoint1 checkpoint1;
		
		@ManyToOne
		@JoinColumn(name = "Checkpoint2Id")
		private Checkpoint2 checkpoint2;
		
		@ManyToOne
		@JoinColumn(name = "Checkpoint3Id")
		private Checkpoint3 checkpoint3;
		
		@ManyToOne
		@JoinColumn(name = "Checkpoint4Id")
		private Checkpoint4 checkpoint4;

		public int getTrackingSheetId() {
			return trackingSheetId;
		}

		public void setTrackingSheetId(int trackingSheetId) {
			this.trackingSheetId = trackingSheetId;
		}

		public Luggage getLuggage() {
			return luggage;
		}

		public void setLuggage(Luggage luggage) {
			this.luggage = luggage;
		}

		public Checkpoint1 getCheckpoint1() {
			return checkpoint1;
		}

		public void setCheckpoint1(Checkpoint1 checkpoint1) {
			this.checkpoint1 = checkpoint1;
		}

		public Checkpoint2 getCheckpoint2() {
			return checkpoint2;
		}

		public void setCheckpoint2(Checkpoint2 checkpoint2) {
			this.checkpoint2 = checkpoint2;
		}

		public Checkpoint3 getCheckpoint3() {
			return checkpoint3;
		}

		public void setCheckpoint3(Checkpoint3 checkpoint3) {
			this.checkpoint3 = checkpoint3;
		}

		public Checkpoint4 getCheckpoint4() {
			return checkpoint4;
		}

		public void setCheckpoint4(Checkpoint4 checkpoint4) {
			this.checkpoint4 = checkpoint4;
		}


		
}