package com.example.demo.service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Respository.MeterReadingRepository;
import com.example.demo.entity.Meterreading;
import com.example.demo.service.serviceinterface.MeterReadingServiceInterface;
import com.example.dto.MeterReadingTo;
import com.example.mapper.MeterMapper;
import com.example.mapper.MeterReadingMapper;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MeterReadingService implements MeterReadingServiceInterface{
	@Autowired
	private MeterReadingRepository meterReadingRepository;
	@Override
	public MeterReadingTo createMeterReading(MeterReadingTo meterReadTo) {
		// TODO Auto-generated method stub
		Meterreading meterReading=MeterReadingMapper.maptoMeter(meterReadTo);
		Meterreading saveMeterRead=meterReadingRepository.save(meterReading);
		return MeterReadingMapper.mapToMeterReadingto(saveMeterRead);
	}
	@Override
	public List<Meterreading> getByMonth(String monthsr ) {
		// TODO Auto-generated method stub
		
		LocalDate date = LocalDate.parse(monthsr + "-01"); // Assuming monthStr is in "YYYY-MM" format
	    Month month = date.getMonth();
	    
	    // Filter the records by both month and year
	    return meterReadingRepository.findAll().stream()
	            .filter(read -> read.getDate() != null && 
	                            read.getDate().getMonth() == month)
	            .collect(Collectors.toList());
	}
	@Override
	public List<Meterreading> getByYear(int year) {
		// TODO Auto-generated method stub
	
		  return meterReadingRepository.findAll().stream()
		            .filter(read -> read.getDate().getYear() == year)
		            .collect(Collectors.toList());
	}
	@Override
	public List<Meterreading> getBydate(LocalDate date) {
		// TODO Auto-generated method stub
		 return  meterReadingRepository.findAll().stream()
		            .filter(read -> read.getDate().isEqual(date))
		            .collect(Collectors.toList());
	
	}
	@Override
	public List<Meterreading> getByDateRange(LocalDate startDate, LocalDate endDate) {
		// TODO Auto-generated method stub
		return  meterReadingRepository.findAll().stream()
	            .filter(event -> !event.getDate().isBefore(startDate) && !event.getDate().isAfter(endDate))
	            .collect(Collectors.toList());
	}
	@Override
	public Meterreading getLastEntryByMmetername(String mainmetername) {
		// TODO Auto-generated method stub
		 return  meterReadingRepository.findTopByMainmeternameOrderByIdDesc(mainmetername);
	}
	@Override
	public List<MeterReadingTo> geAllMeteres() {
		// TODO Auto-generated method stub
		List<Meterreading> getMeterReading=meterReadingRepository.findAll();
		return  getMeterReading.stream().map((meter) -> MeterReadingMapper.mapToMeterReadingto(meter)).collect(Collectors.toList());
	}
	
	
	
	
	
	

}
