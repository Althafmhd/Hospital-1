package com.example.demo.Respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Submeter;

import jakarta.transaction.Transactional;

public interface SubMeterRespository extends JpaRepository<Submeter ,Long>{
	
	@Modifying
	@Query("DELETE FROM Submeter m WHERE m.submetername = :submetername ")
	@Transactional
	void deleteByMetername(@Param("submetername") String submetername);
	
	@Modifying
	@Query("DELETE FROM Submeter m WHERE m.subblockmetername = :subblockmetername ")
	@Transactional
	void deleteBysubBlockMetername(@Param("subblockmetername") String subblockmetername);
}
