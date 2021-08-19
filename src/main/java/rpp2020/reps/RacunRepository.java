package rpp2020.reps;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import rpp2020.jpa.Racun;

public interface RacunRepository extends JpaRepository<Racun, Integer>{
	Collection<Racun> findByNacinPlacanjaContainingIgnoreCase(String nacin_placanja);
}
