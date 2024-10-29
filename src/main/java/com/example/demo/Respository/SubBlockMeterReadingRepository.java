package com.example.demo.Respository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Subblockmeterreading;

public interface SubBlockMeterReadingRepository extends JpaRepository<Subblockmeterreading ,Long> {
	
	  
	Subblockmeterreading findTopBySubblockmeternameOrderByIdDesc(String subblockmetername); 
}
