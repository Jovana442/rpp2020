package rpp2020.reps;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import rpp2020.jpa.Proizvod;

public interface ProizvodRepository extends JpaRepository<Proizvod, Integer>{
	
	Collection <Proizvod> findByNazivContainingIgnoreCase(String naziv);

}
