package group12.restminiproject.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "conveyorLane")
public class ConveyorLane {
	
	//Primary Key
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ConveyorLaneId")
	private int conveyorLaneId;
	
	@Column(name = "SourceLocation")
	private String sourceLocation;
	
	@Column(name = "Destination")
	private String destination;

	public int getConveyorLaneId() {
		return conveyorLaneId;
	}

	public void setConveyorLaneId(int conveyorLaneId) {
		this.conveyorLaneId = conveyorLaneId;
	}

	public String getSourceLocation() {
		return sourceLocation;
	}

	public void setSourceLocation(String sourceLocation) {
		this.sourceLocation = sourceLocation;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}
	
	
	
	
}