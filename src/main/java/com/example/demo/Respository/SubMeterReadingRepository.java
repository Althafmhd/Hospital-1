package com.example.demo.Respository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.Submeterreading;

public interface SubMeterReadingRepository extends JpaRepository<Submeterreading ,Long> {
	List<Submeterreading>  findByDate(LocalDate date);
	
	Submeterreading  findTopBySubmeternameOrderByIdDesc(String submetername); 
}
