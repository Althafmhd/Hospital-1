package com.example.demo.Respository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.Subblockmeterreadingreset;

public interface SubBlockMeterReadingResetRepository extends JpaRepository<Subblockmeterreadingreset, Long> {
	Subblockmeterreadingreset findTopByOrderByIdDesc(); 
	 
	Subblockmeterreadingreset findTopBySubblockmeternameOrderByIdDesc(String subblockmetername); 
}
