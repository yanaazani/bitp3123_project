package group12.restminiproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import group12.restminiproject.model.TrackingRecord;

public interface TrackingRecordRepository extends JpaRepository<TrackingRecord, Long> {

}
