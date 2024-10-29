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

import com.example.demo.entity.Subblockmeterreading;
import com.example.demo.entity.Submeterreading;
import com.example.demo.service.SubMeterReadingService;
import com.example.dto.SubBlockMeterReadingTo;
import com.example.dto.SubMeterReadingTo;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/Submeterreading")
public class SubMeterReadingController {
	
	@Autowired
	SubMeterReadingService subMeterReadingService;
	
	@PostMapping
	public ResponseEntity<SubMeterReadingTo> creadSReading(@RequestBody SubMeterReadingTo subMeterReadTo){
		SubMeterReadingTo saveSReading=subMeterReadingService.createSubMeterReading(subMeterReadTo);
		return new ResponseEntity<>(saveSReading,HttpStatus.CREATED);
	}
	@GetMapping("/date/{date}")
	 public ResponseEntity<List<Submeterreading>> getReadingByDate(@PathVariable String date){
		 LocalDate parsedDate = LocalDate.parse(date); // Expecting format: YYYY-MM-DD
		 List<Submeterreading> events = subMeterReadingService.getReadingBydate(parsedDate);
         return ResponseEntity.ok(events);
	 }
	@GetMapping("/month/{month}")
    public ResponseEntity<List<Submeterreading>> getEventsByMonth(@PathVariable String month) {
		
		
        List<Submeterreading> events = subMeterReadingService.getByMonth(month);
        return ResponseEntity.ok(events);
    }
	 @GetMapping("/year/{year}")
	 public ResponseEntity<List<Submeterreading>> getEventsByYear(@PathVariable int year) {
	     List<Submeterreading> events =subMeterReadingService.getByYear(year);
	     return ResponseEntity.ok(events);
	 }
 
	 @GetMapping("/dateRange/{startDate}/{endDate}")
	 public ResponseEntity<List<Submeterreading>> getEventsBYDateRange(@PathVariable String startDate,@PathVariable String endDate){
		 LocalDate start = LocalDate.parse(startDate); // Expecting format: YYYY-MM-DD
		 LocalDate end = LocalDate.parse(endDate);
		 List<Submeterreading> events =  subMeterReadingService.getByDateRange(start, end);
	      return ResponseEntity.ok(events);
	 }
	 @GetMapping()
		public ResponseEntity<List<SubMeterReadingTo>> getAllMeter(){
			List<SubMeterReadingTo> getMeterReading=subMeterReadingService.getAllMeter();
			return ResponseEntity.ok(getMeterReading);
		}
}
