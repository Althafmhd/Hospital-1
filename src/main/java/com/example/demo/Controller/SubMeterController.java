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
import com.example.demo.service.SubMeterService;
import com.example.dto.SubMeterTo;

import lombok.AllArgsConstructor;
@AllArgsConstructor
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/SubMeter")
public class SubMeterController {
	@Autowired
	SubMeterService subMeterService;
	
	@PostMapping
	public ResponseEntity<SubMeterTo> createSubMeter(@RequestBody SubMeterTo subMeter){
		SubMeterTo saveSubMeterTo=subMeterService.createSubMeter(subMeter);
		return new ResponseEntity<>(saveSubMeterTo,HttpStatus.CREATED);
	}
	@GetMapping()
	public ResponseEntity<List<SubMeterTo>> getAllMeter(){
		List<SubMeterTo> getMeter=subMeterService.geAllMeteres();
		return ResponseEntity.ok(getMeter);
	}
	@DeleteMapping("/deleteSubMeter/{submetername}")
	public ResponseEntity<String> deleteByMetername(@PathVariable String submetername){
		subMeterService.deleteBySubmetername(submetername);
		return ResponseEntity.ok("Sub meter deleted successfully");
	}
	@DeleteMapping("/deleteSubblockMeter/{subblockmetername}")
	public ResponseEntity<String> deleteBySubBlockMetername(@PathVariable String subblockmetername){
		subMeterService.deleterBySubBlockMetername(subblockmetername);
		return ResponseEntity.ok("Sub meter deleted successfully");
	}
	
}
