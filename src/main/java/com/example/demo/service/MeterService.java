package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Respository.MeterRespository;
import com.example.demo.entity.Meter;
import com.example.demo.service.serviceinterface.MeterServiceInterface;
import com.example.dto.MeterTo;
import com.example.mapper.MeterMapper;
import exception.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MeterService implements MeterServiceInterface {
	
	@Autowired
	private MeterRespository meterRespository;
	
	@Override
	public MeterTo createMeter(MeterTo meterTo) {
		// TODO Auto-generated method stub
		
		Meter meter =MeterMapper.mapToMeter(meterTo);
		Meter saveMeter=meterRespository.save(meter);
		return MeterMapper. mapToMeterTo(saveMeter);
	}
	
	@Override
	public MeterTo getMeterId(Long meterId) {
		// TODO Auto-generated method stub
		Meter meterid=meterRespository.findById(meterId).orElseThrow(()->new ResourceNotFoundException("meter is not exist"));
		return MeterMapper.mapToMeterTo(meterid);
	}
	
	
	@Override
	public List<MeterTo> geAllMeteres() {
		// TODO Auto-generated method stub
		List<Meter> getMeter=meterRespository.findAll();
		return  getMeter.stream().map((meter) -> MeterMapper.mapToMeterTo(meter)).collect(Collectors.toList());
	}

	@Override
	public MeterTo updateMeter(Long meterId, MeterTo updatedMeter) {
		// TODO Auto-generated method stub
		Meter meter=meterRespository.findById(meterId).orElseThrow(()-> new ResourceNotFoundException("meter is not exist"));
	
		meter.setMainmetername(updatedMeter.getMainmetername());
		
		Meter updatemeter=meterRespository.save(meter);
		
		return MeterMapper.mapToMeterTo(updatemeter);
	
	}

	@Override
	@Transactional
	public void deleteByMainmetername(String mainmetername) {
		// TODO Auto-generated method stub
	
		meterRespository.deleteByMainmetername(mainmetername);
	
	}





	  

	
	
	

	

	






	

	

}
