package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entity.Submeterreadingreset;
import com.example.demo.service.SubMeterReadingResetService;
import com.example.dto.SubMeterReadingResetTo;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/Submeterreadingreset")
public class SubMeterReadingResetController {
	@Autowired
	SubMeterReadingResetService subMeterReadingResetService;
	
	@PostMapping
	public ResponseEntity<SubMeterReadingResetTo> resetReading(@RequestBody SubMeterReadingResetTo srreadto){
		  SubMeterReadingResetTo resetval=subMeterReadingResetService.resetValue(srreadto);
		  return new ResponseEntity<>( resetval,HttpStatus.CREATED);
	}
	@GetMapping("/lastentry/{submetername}")
	 public Submeterreadingreset getLastEntry(@PathVariable String submetername) {
		 return subMeterReadingResetService.getLastEntryBySubmetername(submetername);
	 }
}
