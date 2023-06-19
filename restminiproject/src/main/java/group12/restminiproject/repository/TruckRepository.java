package group12.restminiproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import group12.restminiproject.model.Truck;

public interface TruckRepository extends JpaRepository<Truck, Long> {

}
