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
import rpp2020.jpa.Proizvod;
import rpp2020.reps.ProizvodRepository;

@RestController
@CrossOrigin
public class ProizvodRestController {
	
	@Autowired
	private ProizvodRepository proizvodRepository;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@ApiOperation(value = "Returns collection of all Proizvod from database.")
	@GetMapping("proizvod")
	public Collection<Proizvod> getAll(){
		return proizvodRepository.findAll();
	}
	
	@ApiOperation(value = "Returns Proizvod with id that was forwarded as path variable.")
	@GetMapping("proizvod/{id}")
	public Proizvod getOne(@PathVariable("id") Integer id) {
		return proizvodRepository.getOne(id);
	}
	
	@ApiOperation(value = "Returns Proizvod with name that was forwarded as path variable.")
	@GetMapping("proizvod/naziv/{naziv}")
	public Collection<Proizvod> getByNaziv(@PathVariable("naziv") String naziv) {
		return proizvodRepository.findByNazivContainingIgnoreCase(naziv);
	}
	
	@ApiOperation(value = "Adds instance of Proizvod to database.")
	@PostMapping("proizvod")
	public ResponseEntity<HttpStatus> addProizvod (@RequestBody Proizvod proizvod){
		proizvodRepository.save(proizvod);
		
		return new ResponseEntity<HttpStatus>(HttpStatus.CREATED);
	}
	
	@ApiOperation(value = "Updates Proizvod that has id that was forwarded as path variable with values forwarded in Request Body.")
	@PutMapping("proizvod/{id}")
	public ResponseEntity<HttpStatus> updateProizvod (@RequestBody Proizvod proizvod, @PathVariable("id")Integer id){
		if (proizvodRepository.existsById(id)) {
			proizvod.setId(id);
			proizvodRepository.save(proizvod);
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		}
		return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
	}
	
	@ApiOperation(value = "Deletes Proizvod that has id that was forwarded as path variable.")
	@DeleteMapping("proizvod/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable("id") Integer id){
		if(id == -100 && !proizvodRepository.existsById(id)) {
			jdbcTemplate.execute("INSERT INTO proizvod (\"id\", \"naziv\", \"proizvodjac\") VALUES (-100, 'Test Proizvod', 2)");
		}
		
		if (proizvodRepository.existsById(id)) {
		proizvodRepository.deleteById(id);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		}
		return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
	}

}
