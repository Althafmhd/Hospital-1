package com.example.demo.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.service.MeterService;
import com.example.dto.MeterTo;

import lombok.AllArgsConstructor;



@AllArgsConstructor
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/Meter")
public class MeterController {
	
	@Autowired
	MeterService meterService;
	
	@PostMapping
	public ResponseEntity<MeterTo> createEmployee(@RequestBody	MeterTo  meterTo) {
		
		MeterTo saveMeter=meterService.createMeter(meterTo);
		return  new ResponseEntity<>(saveMeter,HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<MeterTo> getMeterId(@PathVariable Long id) {
		MeterTo  getMeter=meterService.getMeterId(id);
		return ResponseEntity.ok(getMeter);
	}
	
	@GetMapping()
	public ResponseEntity<List<MeterTo>> getAllMeter(){
		List<MeterTo> getMeter=meterService.geAllMeteres();
		return ResponseEntity.ok(getMeter);
	}
	@PutMapping("/{id}")
	public ResponseEntity<MeterTo> updateMeter(@PathVariable("id") Long meterId,@RequestBody MeterTo meterTo){
		MeterTo updat=meterService.updateMeter(meterId, meterTo);
		return ResponseEntity.ok(updat);
	}
	@DeleteMapping("/{mainmetername}")
	public ResponseEntity<String> deleteByMetername(@PathVariable String mainmetername){
		meterService.deleteByMainmetername(mainmetername);
		return ResponseEntity.ok("Meter deleted successfully");
	}
	
}
