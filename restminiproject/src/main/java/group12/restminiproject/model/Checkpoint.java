package group12.restminiproject.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "checkpoint")

public class Checkpoint {
	
	//Primary Key
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CheckpointId")
	private int checkpointId;
	
	@Column(name = "Name")
	private String checkpointName;
	
	public int getCheckpointId() {
		return checkpointId;
	}
	
	public void setAirportId(int checkpointId) {
		this.checkpointId = checkpointId;
	}
	
	public String getName() {
		return checkpointName;
	}
	
	public void setName(String checkpointName) {
		this.checkpointName = checkpointName;
	}
}