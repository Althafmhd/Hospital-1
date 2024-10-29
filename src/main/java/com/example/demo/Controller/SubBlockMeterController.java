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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.service.SubBlockMeterService;
import com.example.dto.SubBlockMeterTo;



import lombok.AllArgsConstructor;


@AllArgsConstructor
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/Subblockmeter")
public class SubBlockMeterController {
	@Autowired
	SubBlockMeterService subMeterser;
	@PostMapping
	public ResponseEntity<SubBlockMeterTo> createSubMeter(@RequestBody SubBlockMeterTo submeter){
		SubBlockMeterTo savesubmeterto=subMeterser.createSubMeter(submeter);
		return new ResponseEntity<>(savesubmeterto,HttpStatus.CREATED);
	}
	
	
	/*@GetMapping("/{mmetername}")
	public ResponseEntity<List<SubMeterto>> getEmployeId(@PathVariable String mmetername) {
		  List<SubMeterto> mmeternames=subMeterser.getMetername(mmetername);
		  return ResponseEntity.ok(mmeternames);
	}*/
	@GetMapping()
	public ResponseEntity<List<SubBlockMeterTo>> getAllMeter(){
		List<SubBlockMeterTo> getemployees=subMeterser.geAllMeteres();
		return ResponseEntity.ok(getemployees);
	}
	
	@DeleteMapping("/deleteSubBlockMeter/{subblockmetername}")
	public ResponseEntity<String> deleteByMetername(@PathVariable String subblockmetername){
		subMeterser.deleteByMetername(subblockmetername);
		return ResponseEntity.ok("Sub block meter deleted successfully");
	}
	@DeleteMapping("/deleteMainMeter/{mainmetername}")
	public ResponseEntity<String> deleteByMainMetername(@PathVariable String mainmetername){
		subMeterser.deleteByMainmetername(mainmetername);
		return ResponseEntity.ok("Main Meter deleted successfully");
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<SubBlockMeterTo> getEmployeId(@PathVariable Long id) {
		SubBlockMeterTo getemp=subMeterser.getMeterId(id);
		return ResponseEntity.ok(getemp);
	}
}
