package group12.restminiproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import group12.restminiproject.model.ConveyerLane;

@Repository
public interface ConveyerLaneRepository extends JpaRepository<ConveyerLane, Long> {

}
