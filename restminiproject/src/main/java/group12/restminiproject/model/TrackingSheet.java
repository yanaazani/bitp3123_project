package group12.restminiproject.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "trackingsheet")

public class TrackingSheet {
	
	//Primary Key
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TrackingSheetId")
	private int trackingSheet;
	
	@Column(name = "CheckInDateTime")
	private String checkInDateTime;
	
	public int getTrackingSheetId() {
		return trackingSheet;
	}
	
	public void setPassengerId(int trackingSheet) {
		this.trackingSheet = trackingSheet;
	}
	
	public String getCheckInDateTime() {
		return checkInDateTime;
	}
	
	public void setCheckInDateTime(String checkInDateTime) {
		this.checkInDateTime = checkInDateTime;
	}
}