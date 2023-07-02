package group12.restminiproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import group12.restminiproject.model.Checkpoint1;

@Repository
public interface Checkpoint1Repository extends JpaRepository<Checkpoint1, Long> {

}
