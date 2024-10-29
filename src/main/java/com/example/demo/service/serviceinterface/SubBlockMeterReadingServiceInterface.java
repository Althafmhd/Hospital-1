package com.example.demo.service.serviceinterface;

import java.time.LocalDate;
import java.util.List;
import com.example.demo.entity.Subblockmeterreading;
import com.example.dto.SubBlockMeterReadingTo;
import com.example.dto.SubBlockMeterTo;

public interface SubBlockMeterReadingServiceInterface {
	SubBlockMeterReadingTo createSubBlockMeterReading(SubBlockMeterReadingTo sread);
	
	
	
	List<Subblockmeterreading> getReadingBydate(LocalDate date);
	
	
	List<Subblockmeterreading> getByMonth(String monthsr);
	
	
	List<Subblockmeterreading> getByYear(int yearsr);
	
	List<Subblockmeterreading>  getByDateRange(LocalDate startDate,LocalDate endDate);
	
	Subblockmeterreading getLastEntryBySubblockmetername(String subblockmetername);
	
	List<SubBlockMeterReadingTo> geAllMeteres();
}
