package com.example.demo.service.serviceinterface;

import java.time.LocalDate;
import java.util.List;
import com.example.demo.entity.Submeterreading;
import com.example.dto.SubMeterReadingTo;

public interface SubMeterReadingServiceInterface {
	
    SubMeterReadingTo createSubMeterReading(SubMeterReadingTo sread);
	
	//List<Submeterreading> getReadingForYesteday();
	
	List<Submeterreading> getReadingBydate(LocalDate date);
	
	
	List<Submeterreading> getByMonth(String month);
	
	
	List<Submeterreading> getByYear(int year);
	
	List<Submeterreading>  getByDateRange(LocalDate startDate,LocalDate endDate);
	
	//Submeterreading getLastEntryBySubmetername(String submetername);
	
	List<SubMeterReadingTo> getAllMeter();
}
