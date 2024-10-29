package com.example.demo.service.serviceinterface;

import java.util.List;

import com.example.dto.MeterTo;



public interface MeterServiceInterface {
	MeterTo createMeter(MeterTo meterTo);
	
	MeterTo getMeterId(Long meterId);
	
	List<MeterTo> geAllMeteres();
	
	MeterTo updateMeter(Long meterId , MeterTo updatedMeter);
	
	void deleteByMainmetername(String mainmetername);
	

}
