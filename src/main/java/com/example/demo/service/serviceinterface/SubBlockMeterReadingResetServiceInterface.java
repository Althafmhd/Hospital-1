package com.example.demo.service.serviceinterface;

import com.example.demo.entity.Subblockmeterreadingreset;
import com.example.dto.SubBlockMeterReadingResetTo;


public interface SubBlockMeterReadingResetServiceInterface {
	SubBlockMeterReadingResetTo resetValue(SubBlockMeterReadingResetTo sreadto);
	
	Long getLastMeterName();
	
	Subblockmeterreadingreset getLastEntryBySubblockmetername(String subblockmetername);
}
