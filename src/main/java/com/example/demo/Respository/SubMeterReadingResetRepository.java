package com.example.demo.Respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Submeterreadingreset;

public interface SubMeterReadingResetRepository extends JpaRepository<Submeterreadingreset ,Long> {
	Submeterreadingreset findTopByOrderByIdDesc(); 
	 
	Submeterreadingreset findTopBySubmeternameOrderByIdDesc(String submetername); 
}
