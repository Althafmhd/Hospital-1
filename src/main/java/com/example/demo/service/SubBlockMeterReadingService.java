package com.example.demo.service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.Respository.SubBlockMeterReadingRepository;

import com.example.demo.entity.Subblockmeterreading;

import com.example.demo.service.serviceinterface.SubBlockMeterReadingServiceInterface;


import com.example.dto.SubBlockMeterReadingTo;
import com.example.mapper.MeterReadingMapper;
import com.example.mapper.SubBlockMeterReadingMapper;


import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class SubBlockMeterReadingService implements SubBlockMeterReadingServiceInterface {
	@Autowired
    private SubBlockMeterReadingRepository subBlockMeteReadingRepository;
	
	
	@Override
	public SubBlockMeterReadingTo createSubBlockMeterReading(SubBlockMeterReadingTo sread) {
		// TODO Auto-generated method stub
	 Subblockmeterreading reading = SubBlockMeterReadingMapper.maptoSubBlockMeterReading(sread);
     Subblockmeterreading savedReading =subBlockMeteReadingRepository.save(reading);
     return SubBlockMeterReadingMapper.mapToSubBlocMeterReadingTo(savedReading);
	}

	

	@Override
	public List<Subblockmeterreading> getReadingBydate(LocalDate date) {
		// TODO Auto-generated method stub
		return  subBlockMeteReadingRepository.findAll().stream()
	            .filter(read -> read.getDate() !=null && read.getDate().isEqual(date))
	            .collect(Collectors.toList());
	}

	@Override
	public List<Subblockmeterreading> getByMonth(String monthsr) {
		// TODO Auto-generated method stub
		LocalDate date = LocalDate.parse(monthsr + "-01"); // Assuming monthStr is in "YYYY-MM" format
	    Month month = date.getMonth();
	    
	    // Convert yearStr to an integer
	 
	   
	    // Filter the records by both month and year
	    return subBlockMeteReadingRepository.findAll().stream()
	            .filter(read -> read.getDate() != null && 
	                            read.getDate().getMonth() == month) //&& 
	                            //read.getDate().getYear() == year)
	            .collect(Collectors.toList());
	}

	@Override
	public List<Subblockmeterreading> getByYear(int yearsr) {
		// TODO Auto-generated method stub
		return subBlockMeteReadingRepository.findAll().stream()
	            .filter(read -> read.getDate() != null && read.getDate().getYear() == yearsr)
	            .collect(Collectors.toList());
	}

	@Override
	public List<Subblockmeterreading> getByDateRange(LocalDate startDate, LocalDate endDate) {
		// TODO Auto-generated method stub
		return  subBlockMeteReadingRepository.findAll().stream()
	            .filter(event ->event.getDate()!= null && !event.getDate().isBefore(startDate) && !event.getDate().isAfter(endDate))
	            .collect(Collectors.toList());

	}

	@Override
	public Subblockmeterreading getLastEntryBySubblockmetername(String subblockmetername) {
		// TODO Auto-generated method stub
		 return  subBlockMeteReadingRepository.findTopBySubblockmeternameOrderByIdDesc(subblockmetername);
	}



	@Override
	public List<SubBlockMeterReadingTo> geAllMeteres() {
		// TODO Auto-generated method stub
		List<Subblockmeterreading> getAllMeterReading=subBlockMeteReadingRepository.findAll();
		return getAllMeterReading.stream().map((meter) -> SubBlockMeterReadingMapper.mapToSubBlocMeterReadingTo(meter)).collect(Collectors.toList());
	}
	
	
	
}
