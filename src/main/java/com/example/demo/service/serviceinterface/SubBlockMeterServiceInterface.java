package com.example.demo.service.serviceinterface;


import java.util.List;

import com.example.dto.SubBlockMeterTo;



public interface SubBlockMeterServiceInterface {
	SubBlockMeterTo createSubMeter(SubBlockMeterTo subBlockMeterTo);
	
	
	SubBlockMeterTo getMeterId(Long meterId);
	
	
	List<SubBlockMeterTo> geAllMeteres();
	
	void deleteByMetername(String subblockmetername);

	//List<SubMeterto> getMetername(String mmetername);
	void deleteByMainmetername(String mainmetername);

}
