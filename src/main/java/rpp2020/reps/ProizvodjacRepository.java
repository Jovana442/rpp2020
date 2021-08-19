package rpp2020.reps;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import rpp2020.jpa.Proizvodjac;

public interface ProizvodjacRepository extends JpaRepository<Proizvodjac, Integer>{
	Collection<Proizvodjac> findByNazivContainingIgnoreCase(String naziv);

}
