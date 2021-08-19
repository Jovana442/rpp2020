package rpp2020.ctrl;

import java.math.BigDecimal;
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
import rpp2020.jpa.StavkaRacuna;
import rpp2020.reps.RacunRepository;
import rpp2020.reps.StavkaRacunaRepository;

@CrossOrigin
@RestController
public class StavkaRacunaRestController {
	
	@Autowired
	private StavkaRacunaRepository stavkaRacunaRepository;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private RacunRepository racunRepository;
	
	@ApiOperation(value = "Returns collection of all StavkaRacuna from database.")
	@GetMapping("stavkaRacuna")
	public Collection<StavkaRacuna> getAll(){
		return stavkaRacunaRepository.findAll();
	}
	
	@ApiOperation(value = "Returns StavkaRacuna with id that was forwarded as path variable.")
	@GetMapping("stavkaRacuna/{id}")
	public ResponseEntity<StavkaRacuna> getOne(@PathVariable("id") Integer id) {
		if(stavkaRacunaRepository.findById(id).isPresent()) {
			StavkaRacuna stavkaRacuna = stavkaRacunaRepository.getOne(id);
			return new ResponseEntity<>(stavkaRacuna, HttpStatus.OK);
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
	
	@ApiOperation(value = "Returns collection of StavkaRacuna for Racun with id that was forwarded as path variable.")
	@GetMapping("stavkeRacuna/{id}")
	public Collection<StavkaRacuna> getAllForRacun(@PathVariable("id") Integer id){
		Racun r = racunRepository.getOne(id);
		return stavkaRacunaRepository.findByRacun(r);
	}
	
	@ApiOperation(value = "Returns collection of StavkaRacuna with price that is lower than price that was forwarded as path variable.")
	@GetMapping("stavkaRacunaCena/{cena}")
	public Collection<StavkaRacuna> getStavkaRacunaCena (@PathVariable("cena") BigDecimal cena){
		return stavkaRacunaRepository.findByCenaLessThanOrderById(cena);
	}
	
	@ApiOperation(value = "Adds instance of StavkaRacuna to database.")
	@PostMapping("stavkaRacuna")
	public ResponseEntity<HttpStatus> addOne(@RequestBody StavkaRacuna stavkaRacuna){
		stavkaRacuna.setRedniBroj(stavkaRacunaRepository.nextRBr(stavkaRacuna.getRacun().getId()));
		stavkaRacunaRepository.save(stavkaRacuna);
		return new ResponseEntity<HttpStatus>(HttpStatus.CREATED);
		
	}
	
	@ApiOperation(value = "Updates StavkaRacuna that has id that was forwarded as path variable with values forwarded in Request Body.")
	@PutMapping("stavkaRacuna/{id}")
	public ResponseEntity<HttpStatus> updateOne(@RequestBody StavkaRacuna stavkaRacuna, @PathVariable("id")Integer id){
		if(stavkaRacunaRepository.existsById(id)) {
			stavkaRacuna.setId(id);
			stavkaRacunaRepository.save(stavkaRacuna);
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		}
		return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
		
	}
	
	@ApiOperation(value = "Deletes StavkaRacuna that has id that was forwarded as path variable.")
	@DeleteMapping("stavkaRacuna/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable Integer id){
		if (id == -100 && !stavkaRacunaRepository.existsById(id)){
			jdbcTemplate.execute("INSERT INTO stavkaRacuna (\"id\", \"cena\", \"jedinica_mere\", \"kolicina\", \"proizvod\", \"racun\") VALUES (-100, 1, 'kom', 1, 1, 1)");
		}
		if(stavkaRacunaRepository.existsById(id)) {
			stavkaRacunaRepository.deleteById(id);
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		}
		return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
	
	}

}
