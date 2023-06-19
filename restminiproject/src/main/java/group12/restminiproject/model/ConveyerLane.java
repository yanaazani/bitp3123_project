package group12.restminiproject.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "conveyerLane")
public class ConveyerLane {
	
	//Primary Key
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ConveyerLaneId")
	private int conveyerLaneId;
	
	public int getConveyerLaneId() {
		return conveyerLaneId;
	}
	
	public void setConveyorLaneId(int conveyerLaneId) {
		this.conveyerLaneId = conveyerLaneId;
	}
}