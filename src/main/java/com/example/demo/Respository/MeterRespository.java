package com.example.demo.Respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.demo.entity.Meter;
import jakarta.transaction.Transactional;

public interface MeterRespository extends JpaRepository<Meter, Long> {
	
	@Modifying
	@Query("DELETE FROM Meter m WHERE m.mainmetername = :mainmetername")
	@Transactional
	void deleteByMainmetername(@Param("mainmetername") String mainmetername);








}
