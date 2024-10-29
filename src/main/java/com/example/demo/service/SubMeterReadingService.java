package com.example.demo.service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Respository.SubMeterReadingRepository;
import com.example.demo.entity.Subblockmeterreading;
import com.example.demo.entity.Submeterreading;
import com.example.demo.service.serviceinterface.SubMeterReadingServiceInterface;
import com.example.dto.SubMeterReadingTo;
import com.example.mapper.SubBlockMeterReadingMapper;
import com.example.mapper.SubMeterReadingMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SubMeterReadingService implements SubMeterReadingServiceInterface {
	
	@Autowired
	SubMeterReadingRepository subMeterReadingRepository;
	@Override
	public SubMeterReadingTo createSubMeterReading(SubMeterReadingTo sread) {
		// TODO Auto-generated method stub
		 Submeterreading reading = SubMeterReadingMapper.maptoSubMeterReading(sread);
	     Submeterreading savedReading =subMeterReadingRepository.save(reading);
	     return SubMeterReadingMapper.mapToSubMeterReadingTo(savedReading);
	}
	@Override
	public List<Submeterreading> getReadingBydate(LocalDate date) {
		// TODO Auto-generated method stub
		return  subMeterReadingRepository.findAll().stream()
	            .filter(read -> read.getDate() !=null && read.getDate().isEqual(date))
	            .collect(Collectors.toList());
	}
	@Override
	public List<Submeterreading> getByMonth(String monthsr) {
		// TODO Auto-generated method stub
		
		LocalDate date = LocalDate.parse(monthsr + "-01"); // Assuming monthStr is in "YYYY-MM" format
	    Month month = date.getMonth();
	    
	    // Convert yearStr to an integer
	 
	    

	    // Filter the records by both month and year
	    return subMeterReadingRepository.findAll().stream()
	            .filter(read -> read.getDate() != null && 
	                            read.getDate().getMonth() == month)
	            .collect(Collectors.toList());
	}
	@Override
	public List<Submeterreading> getByYear(int year) {
		// TODO Auto-generated method stub
		return subMeterReadingRepository.findAll().stream()
	            .filter(read ->read.getDate() !=null && read.getDate().getYear() == year)
	            .collect(Collectors.toList());
	}
	@Override
	public List<Submeterreading> getByDateRange(LocalDate startDate, LocalDate endDate) {
		// TODO Auto-generated method stub
		return  subMeterReadingRepository.findAll().stream()
	            .filter(event ->event.getDate()!= null && !event.getDate().isBefore(startDate) && !event.getDate().isAfter(endDate))
	            .collect(Collectors.toList());
	}
	@Override
	public List<SubMeterReadingTo> getAllMeter() {
		// TODO Auto-generated method stub
		List<Submeterreading> getAllMeterReading=subMeterReadingRepository.findAll();
		return getAllMeterReading.stream().map((meter) -> SubMeterReadingMapper.mapToSubMeterReadingTo(meter)).collect(Collectors.toList());
	}

}
