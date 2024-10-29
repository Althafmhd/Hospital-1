package com.example.demo.Controller;

import java.util.List;

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

import com.example.demo.entity. Meterreadingreset;

import com.example.demo.service.MeterReadingResetService;

import com.example.dto.MeterReadingResetTo;


import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/MeterReadingReset")
public class MeterReadingResetController {
	@Autowired
	MeterReadingResetService meterReadingResetService;
	
	@PostMapping
	public ResponseEntity<MeterReadingResetTo> resetReading(@RequestBody MeterReadingResetTo meterReadingResetTo){
		MeterReadingResetTo saveReading=meterReadingResetService.resetMeter(meterReadingResetTo);
		return new ResponseEntity<>(saveReading,HttpStatus.CREATED);
	}
	/*@GetMapping("/{mmetername}")
	public Long getLastMeterName() {
        return readSer.getLastMeterName();
    }*/
	@GetMapping("{mainmetername}")
	 public List< Meterreadingreset> getAllValuesByMeterName(@PathVariable String mainmetername) {
	        return meterReadingResetService.getAllValuesByMeterName(mainmetername); // Return readings for the specified meter name
	    }
	@GetMapping("lastentry/{mainmetername}")
	public  Meterreadingreset getLastEntry(@PathVariable String mainmetername) {
		return meterReadingResetService.getLastEntryByMainmetername(mainmetername);
	}
}
