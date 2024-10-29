package com.example.demo.Respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Meterreading;

public interface MeterReadingRepository extends JpaRepository<Meterreading, Long> {
	Meterreading findTopByMainmeternameOrderByIdDesc(String mainmetername); 
	

}
