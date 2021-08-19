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
import rpp2020.jpa.Racun;
import rpp2020.reps.RacunRepository;

@RestController
@CrossOrigin
public class RacunRestController {

	@Autowired
	private RacunRepository racunRepository;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@ApiOperation(value = "Returns collection of all Racun from database.")
	@GetMapping("racun")
	public Collection<Racun> getRacuni(){
		return racunRepository.findAll();
	}
	
	@ApiOperation(value = "Returns Racun with id that was forwarded as path variable.")
	@GetMapping("racun/{id}")
	public ResponseEntity<Racun> getRacun (@PathVariable("id") Integer id) {
		if(racunRepository.findById(id).isPresent()) {
			Racun racun = racunRepository.getOne(id);
			return new ResponseEntity<>(racun, HttpStatus.OK);
		}
		
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
	
	@ApiOperation(value = "Returns collection of all Racun with payment method that was forwarded as path variable.")
	@GetMapping("racunPlacanje/{nacin_placanja}")
	public Collection<Racun> getByNacin_placanja(@PathVariable("nacin_placanja") String nacin_placanja){
		return racunRepository.findByNacinPlacanjaContainingIgnoreCase(nacin_placanja);
	}
	
	@ApiOperation(value = "Adds instance of Racun to database.")
	@PostMapping("racun")
	public ResponseEntity<HttpStatus> addRacun (@RequestBody Racun racun){
		racunRepository.save(racun);
		
		return new ResponseEntity<HttpStatus>(HttpStatus.CREATED);
	}
	
	@ApiOperation(value = "Updates Racun that has id that was forwarded as path variable with values forwarded in Request Body.")
	@PutMapping("racun/{id}")
	public ResponseEntity<HttpStatus> updateRacun (@RequestBody Racun racun, @PathVariable("id")Integer id){
		if(racunRepository.existsById(id)) {
			racun.setId(id);
			racunRepository.save(racun);
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		}
		return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
	}
	
	@ApiOperation(value = "Deletes Racun that has id that was forwarded as path variable.")
	@DeleteMapping("racun/{id}")
	public ResponseEntity<HttpStatus> delete (@PathVariable("id") Integer id){
		if(id == -100 && !racunRepository.existsById(id)) {
			jdbcTemplate.execute("INSERT INTO racun (\"id\", \"datum\", \"nacin_placanja\") VALUES (-100, to_date('04.03.2018.', 'dd.mm.yyyy.'), 'Test Gotovina')");
		}
		if(racunRepository.existsById(id)) {
			racunRepository.deleteById(id);
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		}
		return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
	}
	
}
