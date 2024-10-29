package com.example.demo.service.serviceinterface;

import java.util.List;

import com.example.dto.SubBlockMeterTo;
import com.example.dto.SubMeterTo;

public interface SubMeterServiceInterface {
	SubMeterTo createSubMeter(SubMeterTo subMeterTo);
	
	
	//SubMeterTo getMeterId(Long meterId);
	
	
	List<SubMeterTo> geAllMeteres();
	
	void deleteBySubmetername(String submetername);
	
	void deleterBySubBlockMetername(String subblockmetername);

	//List<SubMeterto> getMetername(String mmetername);
}
