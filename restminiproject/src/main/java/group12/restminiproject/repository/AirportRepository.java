package group12.restminiproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import group12.restminiproject.model.Airport;

public interface AirportRepository extends JpaRepository<Airport, Long> {

}
