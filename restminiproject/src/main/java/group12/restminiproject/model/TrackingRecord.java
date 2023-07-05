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
@Table(name = "trackingrecord")
public class TrackingRecord {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "TrackingRecordId")
	private int trackingRecordId;
	
	@ManyToOne
	@JoinColumn(name="LuggageId")
	private Luggage luggage;
	
	@Column(name="Checkpoint1Id")
	private String checkpoint1Id;
	
	@Column(name="Checkpoint2Id")
	private String checkpoint2Id;
	
	@Column(name="Checkpoint3Id")
	private String checkpoint3Id;
	
	@Column(name="Checkpoint4Id")
	private String checkpoint4Id;

	public TrackingRecord()
	{
		//DEfault constructor logic
	}

	public int getTrackingRecordId() {
		return trackingRecordId;
	}

	public void setTrackingRecordId(int trackingRecordId) {
		this.trackingRecordId = trackingRecordId;
	}

	public Luggage getLuggage() {
		return luggage;
	}

	public void setLuggage(Luggage luggage) {
		this.luggage = luggage;
	}

	public String getCheckpoint1Id() {
		return checkpoint1Id;
	}

	public void setCheckpoint1Id(String checkpoint1Id) {
		this.checkpoint1Id = checkpoint1Id;
	}

	public String getCheckpoint2Id() {
		return checkpoint2Id;
	}

	public void setCheckpoint2Id(String checkpoint2Id) {
		this.checkpoint2Id = checkpoint2Id;
	}

	public String getCheckpoint3Id() {
		return checkpoint3Id;
	}

	public void setCheckpoint3Id(String checkpoint3Id) {
		this.checkpoint3Id = checkpoint3Id;
	}

	public String getCheckpoint4Id() {
		return checkpoint4Id;
	}

	public void setCheckpoint4Id(String checkpoint4Id) {
		this.checkpoint4Id = checkpoint4Id;
	}
	
	
	
}
