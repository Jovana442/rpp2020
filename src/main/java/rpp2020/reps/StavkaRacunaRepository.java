package rpp2020.reps;

import java.math.BigDecimal;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import rpp2020.jpa.Racun;
import rpp2020.jpa.StavkaRacuna;

public interface StavkaRacunaRepository extends JpaRepository<StavkaRacuna, Integer> {
	Collection<StavkaRacuna> findByRacun(Racun r);
	Collection<StavkaRacuna> findByCenaLessThanOrderById(BigDecimal cena);
	
	@Query(value = "select coalesce(max(redni_broj)+1, 1) from stavka_racuna where racun = ?1", nativeQuery = true)
	Integer nextRBr(Integer racunId);

}
