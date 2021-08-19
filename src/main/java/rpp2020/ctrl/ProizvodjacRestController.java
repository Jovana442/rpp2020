package rpp2020.ctrl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import rpp2020.jpa.Proizvodjac;
import rpp2020.reps.ProizvodjacRepository;

@RestController
@CrossOrigin
public class ProizvodjacRestController {
	@Autowired
	private ProizvodjacRepository proizvodjacRepository;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@ApiOperation(value = "Returns collection of all Proizvodjac from database.")
	@GetMapping("proizvodjac")
	public Collection<Proizvodjac> getProizvodjaci(){
		return proizvodjacRepository.findAll();
	}
	
	@ApiOperation(value = "Returns Proizvodjac with id that was forwarded as path variable.")
	@GetMapping("proizvodjac/{id}")
	public ResponseEntity<Proizvodjac> getProizvodjac(@PathVariable("id") Integer id) {
		if (proizvodjacRepository.findById(id).isPresent()) {
			Proizvodjac proizvodjac = proizvodjacRepository.getOne(id);
			return new ResponseEntity<>(proizvodjac, HttpStatus.OK);
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
	
	@ApiOperation(value = "Returns Proizvodjac with name that was forwarded as path variable.")
	@GetMapping("proizvodjac/naziv/{naziv}")
	public Collection<Proizvodjac> getByNaziv(@PathVariable("naziv") String naziv) {
		return proizvodjacRepository.findByNazivContainingIgnoreCase(naziv);
	}
	
	@ApiOperation(value = "Adds instance of Proizvodjac to database.")
	@PostMapping("proizvodjac")
	public ResponseEntity<HttpStatus> addProizvodjac (@RequestBody Proizvodjac proizvodjac){
		proizvodjacRepository.save(proizvodjac);
		
		return new ResponseEntity<HttpStatus>(HttpStatus.CREATED);
	}
	
	@ApiOperation(value = "Updates Proizvodjac that has id that was forwarded as path variable with values forwarded in Request Body.")
	@PutMapping("proizvodjac/{id}")
	public ResponseEntity<HttpStatus> updateProizvodjac(@RequestBody Proizvodjac proizvodjac, @PathVariable("id")Integer id){
		if(proizvodjacRepository.existsById(id)) {
			proizvodjac.setId(id);
			proizvodjacRepository.save(proizvodjac);
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		}
		return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
	}
	
	@ApiOperation(value = "Deletes Proizvodjac with id that was forwarded as path variable.")
	@DeleteMapping("proizvodjac/{id}")
	public ResponseEntity<HttpStatus> delete (@PathVariable("id") Integer id){
		if(id == -100 && !proizvodjacRepository.existsById(id)) {
			jdbcTemplate.execute("INSERT INTO proizvodjac (\"id\", \"naziv\", \"adresa\", \"kontakt\") VALUES (-100, 'Test Proizvodjac', 'Test Adresa', 'Test Kontakt')");
		
		}
		if(proizvodjacRepository.existsById(id)) {
			proizvodjacRepository.deleteById(id);
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		}
		return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
		}
		
		
	

}
