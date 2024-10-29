package com.example.demo.service.serviceinterface;

import java.util.List;
import com.example.demo.entity. Meterreadingreset;
import com.example.dto.MeterReadingResetTo;

public interface MeterReadingResetServiceInterface {
	MeterReadingResetTo resetMeter(MeterReadingResetTo meterReadingResetTo);
	
	//Long getLastMeterName();
	List< Meterreadingreset> getAllValuesByMeterName(String mainmetername);
	
	 Meterreadingreset getLastEntryByMainmetername(String mainmetername);
}
