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

import com.example.demo.entity.Subblockmeterreadingreset;

import com.example.demo.service.SubBlockMeterReadingResetService;

import com.example.dto.SubBlockMeterReadingResetTo;

import lombok.AllArgsConstructor;


@AllArgsConstructor
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/SubBlockMeterReadingReset")
public class SubBlockMeterReadingResetController {
   @Autowired
   SubBlockMeterReadingResetService sreadser;
   
   @PostMapping
   public ResponseEntity<SubBlockMeterReadingResetTo> resetReading(@RequestBody SubBlockMeterReadingResetTo srreadto){
	   SubBlockMeterReadingResetTo resetval=sreadser.resetValue(srreadto);
	   return new ResponseEntity<>( resetval,HttpStatus.CREATED);
   }
   @GetMapping("/{subblockmetername}")
	public Long getLastMeterName() {
       return sreadser.getLastMeterName();
   }
   @GetMapping("/lastentry/{subblockmetername}")
	 public Subblockmeterreadingreset getLastEntry(@PathVariable String subblockmetername) {
		 return sreadser.getLastEntryBySubblockmetername(subblockmetername);
	 }

}
