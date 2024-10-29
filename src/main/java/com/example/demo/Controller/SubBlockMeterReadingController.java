package com.example.demo.Controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

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


import com.example.demo.entity.Subblockmeterreading;

import com.example.demo.service.SubBlockMeterReadingService;
import com.example.dto.MeterReadingTo;
import com.example.dto.SubBlockMeterReadingTo;

import lombok.AllArgsConstructor;


@AllArgsConstructor
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/Subblockmeterreading")
public class SubBlockMeterReadingController {
	@Autowired
	SubBlockMeterReadingService sreadser;
	
	@PostMapping
	public ResponseEntity<SubBlockMeterReadingTo> creadSReading(@RequestBody SubBlockMeterReadingTo sread){
		SubBlockMeterReadingTo saveSReading=sreadser.createSubBlockMeterReading(sread);
		return new ResponseEntity<>(saveSReading,HttpStatus.CREATED);
	}
	
	@GetMapping("/date/{date}")
	 public ResponseEntity<List<Subblockmeterreading>> getReadingByDate(@PathVariable String date){
		 LocalDate parsedDate = LocalDate.parse(date); // Expecting format: YYYY-MM-DD
        List<Subblockmeterreading> events = sreadser.getReadingBydate(parsedDate);
            return ResponseEntity.ok(events);
	 }
	@GetMapping("/lastentry/{smetername}")
	 public Subblockmeterreading getLastEntry(@PathVariable String smetername) {
		 return sreadser.getLastEntryBySubblockmetername(smetername);
	 }
	 @GetMapping("/month/{month}")
	    public ResponseEntity<List<Subblockmeterreading>> getEventsByMonth(@PathVariable String month ) {
		
		 
	        List<Subblockmeterreading> events = sreadser.getByMonth(month);
	        return ResponseEntity.ok(events);
	    }
	 @GetMapping("/year/{year}")
	 public ResponseEntity<List<Subblockmeterreading>> getEventsByYear(@PathVariable int year) {
	     List<Subblockmeterreading> events =sreadser.getByYear(year);
	     return ResponseEntity.ok(events);
	 }
	 
	 @GetMapping("/dateRange/{startDate}/{endDate}")
	 public ResponseEntity<List<Subblockmeterreading>> getEventsBYDateRange(@PathVariable String startDate,@PathVariable String endDate){
		 LocalDate start = LocalDate.parse(startDate); // Expecting format: YYYY-MM-DD
		 LocalDate end = LocalDate.parse(endDate);
		 List<Subblockmeterreading> events =  sreadser.getByDateRange(start, end);
         return ResponseEntity.ok(events);
	 }
	 @GetMapping()
	public ResponseEntity<List<SubBlockMeterReadingTo>> getAllMeter(){
		List<SubBlockMeterReadingTo> getMeterReading=sreadser.geAllMeteres();
		return ResponseEntity.ok(getMeterReading);
	}
}
