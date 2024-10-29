package com.example.demo.Controller;

import java.time.LocalDate;
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
import com.example.demo.entity.Meterreading;
import com.example.demo.service.MeterReadingService;
import com.example.dto.MeterReadingTo;


import lombok.AllArgsConstructor;


@AllArgsConstructor
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/MeterReading")
public class MeterReadingController {
	@Autowired
	MeterReadingService meterReadService;
	@PostMapping
	public ResponseEntity<MeterReadingTo> createMReading(@RequestBody MeterReadingTo meterReadTo){
		MeterReadingTo meterReadingTo=meterReadService.createMeterReading(meterReadTo);
		return new ResponseEntity<>(meterReadingTo,HttpStatus.CREATED);
	}
	 @GetMapping("/month/{month}")
	    public ResponseEntity<List<Meterreading>> getEventsByMonth(@PathVariable String month) {
		 	
	        List<Meterreading> months = meterReadService.getByMonth(month);
	        return ResponseEntity.ok(months);
	    }
	 @GetMapping("/year/{year}")
	 public ResponseEntity<List<Meterreading>> getEventsByYear(@PathVariable int year) {
	     List<Meterreading> years =meterReadService.getByYear(year);
	     return ResponseEntity.ok(years);
	 }
	 @GetMapping("/date/{date}")
	 public ResponseEntity<List<Meterreading>> getByDate(@PathVariable String date){
		 LocalDate dates= LocalDate.parse(date); // Expecting format: YYYY-MM-DD
         List<Meterreading> years = meterReadService.getBydate(dates);
         return ResponseEntity.ok(years);
	 }
	 @GetMapping("/dateRange/{startDate}/{endDate}")
	 public ResponseEntity<List<Meterreading>> getEventsBYDateRange(@PathVariable String startDate,@PathVariable String endDate){
		 LocalDate startDates = LocalDate.parse(startDate); // Expecting format: YYYY-MM-DD
         LocalDate endDates = LocalDate.parse(endDate);
         List<Meterreading> events =  meterReadService.getByDateRange(startDates, endDates);
         return ResponseEntity.ok(events);
	 }
	 @GetMapping("/lastentry/{mainmetername}")
	 public Meterreading getLastEntry(@PathVariable String mainmetername) {
		 return meterReadService.getLastEntryByMmetername(mainmetername);
	 }
	 
	 @GetMapping()
	public ResponseEntity<List<MeterReadingTo>> getAllMeter(){
		List<MeterReadingTo> getMeterReading=meterReadService.geAllMeteres();
		return ResponseEntity.ok(getMeterReading);
	}
	 
	 
	 
}
