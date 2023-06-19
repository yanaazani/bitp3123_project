package group12.restminiproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import group12.restminiproject.model.Luggage;

public interface LuggageRepository extends JpaRepository<Luggage, Long> {

}
