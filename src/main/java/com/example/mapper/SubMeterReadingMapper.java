package com.example.mapper;

import com.example.demo.entity.Submeterreading;
import com.example.dto.SubMeterReadingTo;

public class SubMeterReadingMapper {
	public static SubMeterReadingTo mapToSubMeterReadingTo(Submeterreading subMeterReading) {
		return new SubMeterReadingTo(
				subMeterReading.getId(),
				subMeterReading.getMainmetername(),
				subMeterReading.getSubblockmetername(),
				subMeterReading.getSubmetername(),
				subMeterReading.getReadingunits(),

				subMeterReading.getTodayunits(),
		
				subMeterReading.getDate()
	
		);
	}
	public static Submeterreading maptoSubMeterReading(SubMeterReadingTo subMeterReadingTo) {
		return new Submeterreading(
				subMeterReadingTo.getId(),
				subMeterReadingTo.getMainmetername(),
				subMeterReadingTo.getSubblockmetername(),
				subMeterReadingTo.getSubmetername(),
				subMeterReadingTo.getReadingunits(),

				subMeterReadingTo.getTodayunits(),
				
				subMeterReadingTo.getDate()

				);
				
	}
}
