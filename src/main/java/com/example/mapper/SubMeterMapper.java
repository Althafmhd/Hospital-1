package com.example.mapper;

import com.example.demo.entity.Submeter;
import com.example.dto.SubMeterTo;

public class SubMeterMapper {
	 
	public static SubMeterTo mapToSubMeterTo (Submeter subMeter) {
		return new SubMeterTo (
				subMeter.getId(),
				subMeter.getMainmetername(),
				subMeter.getSubblockmetername(),
				subMeter.getSubmetername(),
				subMeter.getDate()

		);
	}
	public static  Submeter mapToSubMeter(SubMeterTo subMeterTo) {
		return new Submeter(
				subMeterTo.getId(),
				subMeterTo.getMainmetername(),
				subMeterTo.getSubblockmetername(),
				subMeterTo.getSubmetername(),
				subMeterTo.getDate()
	
				);
				
	}
}
