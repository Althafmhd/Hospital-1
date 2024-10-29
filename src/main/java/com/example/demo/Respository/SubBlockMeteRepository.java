package com.example.demo.Respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.demo.entity.Subblockmeter;
import jakarta.transaction.Transactional;




public interface SubBlockMeteRepository extends JpaRepository<Subblockmeter ,Long>{
	
	/*@Query("SELECT DISTINCT m FROM Submeter m WHERE m.mmetername = :mmetername")
	List<Submeter> findByMeterName(@Param("mmetername")String mmetername);*/
	
	@Modifying
	@Query("DELETE FROM Subblockmeter m WHERE m.subblockmetername = :subblockmetername ")
	@Transactional
	void deleteByMetername(@Param("subblockmetername") String subblockmetername);

	@Modifying
	@Query("DELETE FROM Subblockmeter m WHERE m.mainmetername = :mainmetername")
	@Transactional
	void deleteByMainmetername(@Param("mainmetername") String mainmetername);


}
	
	