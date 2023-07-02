package group12.restminiproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import group12.restminiproject.model.Checkpoint2;

@Repository
public interface Checkpoint2Repository extends JpaRepository<Checkpoint2, Long> {

}
