package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Respository.MeterReadingResetRepository;
import com.example.demo.entity.Meterreadingreset;
import com.example.demo.service.serviceinterface.MeterReadingResetServiceInterface;
import com.example.dto.MeterReadingResetTo;
import com.example.mapper.MeterReadingResetMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MeterReadingResetService implements MeterReadingResetServiceInterface {
	
	private MeterReadingResetRepository meterReadingResetRepository;
	
	@Override
	public MeterReadingResetTo resetMeter(MeterReadingResetTo meterReadingResetTo) {
		// TODO Auto-generated method stub
		 Meterreadingreset meterReadingReset=MeterReadingResetMapper.maptoMeteReadingReset(meterReadingResetTo);
		 Meterreadingreset saveReadReset=meterReadingResetRepository.save(meterReadingReset);
		return MeterReadingResetMapper.maptoMeterReadingResetTo(saveReadReset);
	}
	@Override
	public List<Meterreadingreset> getAllValuesByMeterName(String mainmetername) {
		// TODO Auto-generated method stub
		return meterReadingResetRepository.findByMainmetername(mainmetername);
	}
	@Override
	public  Meterreadingreset getLastEntryByMainmetername(String mainmetername) {
		// TODO Auto-generated method stub
		return meterReadingResetRepository.findTopByMainmeternameOrderByIdDesc(mainmetername);
	}
	/*@Override
	public Long getLastMeterName() {
		// TODO Auto-generated method stub
		 Reading lastReading = readingRepo.findTopByOrderByIdDesc();
	        return lastReading != null ? lastReading.getRvalue() : null;
	}*/

}
