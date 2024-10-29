package com.example.demo.service.serviceinterface;

import com.example.demo.entity.Submeterreadingreset;
import com.example.dto.SubMeterReadingResetTo;

public interface SubMeterReadingResetServiceInterface {
	SubMeterReadingResetTo resetValue(SubMeterReadingResetTo subMeterReadingResetTo);
	
	//Long getLastMeterName();
	
	Submeterreadingreset getLastEntryBySubmetername(String submetername);
}
