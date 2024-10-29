package com.example.demo.Respository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.example.demo.entity. Meterreadingreset;

public interface MeterReadingResetRepository extends JpaRepository<Meterreadingreset, Long>{
	//Reading findTopByOrderByIdDesc();
	@Query("SELECT r FROM Meterreading r WHERE r.mainmetername = ?1 ORDER BY r.date DESC")
	List< Meterreadingreset> findByMainmetername(String mainmetername);
	
	 Meterreadingreset findTopByMainmeternameOrderByIdDesc(String mainmetername);
}
