package com.example.demo.service.serviceinterface;

import java.time.LocalDate;
import java.util.List;
import com.example.demo.entity.Meterreading;
import com.example.dto.MeterReadingTo;
import com.example.dto.MeterTo;



public interface MeterReadingServiceInterface {
	MeterReadingTo createMeterReading(MeterReadingTo meterReadTo);
	
	List<Meterreading> getByMonth(String month);
	
	
	List<Meterreading> getByYear(int year);
	
	List<Meterreading> getBydate(LocalDate date);
	
	List<Meterreading>  getByDateRange(LocalDate startDate,LocalDate endDate);
	
	Meterreading getLastEntryByMmetername(String mainmetername);
	
	List<MeterReadingTo> geAllMeteres();
	
	
}
