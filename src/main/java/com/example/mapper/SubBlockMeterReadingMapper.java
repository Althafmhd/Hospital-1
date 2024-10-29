package com.example.mapper;

import com.example.demo.entity.Subblockmeterreading;
import com.example.dto.SubBlockMeterReadingTo;

public class SubBlockMeterReadingMapper {
	public static SubBlockMeterReadingTo mapToSubBlocMeterReadingTo(Subblockmeterreading subblockmeterreading) {
		return new SubBlockMeterReadingTo(
				subblockmeterreading.getId(),
				subblockmeterreading.getMainmetername(),
				subblockmeterreading.getSubblockmetername(),
				subblockmeterreading.getReadingunits(),
				subblockmeterreading.getTodayunits(),
				subblockmeterreading.getDate()

		);
	}
	public static Subblockmeterreading maptoSubBlockMeterReading(SubBlockMeterReadingTo subBlockMeterReadingTo) {
		return new Subblockmeterreading(
				subBlockMeterReadingTo.getId(),
				subBlockMeterReadingTo.getMainmetername(),
				subBlockMeterReadingTo.getSubblockmetername(),
				subBlockMeterReadingTo.getReadingunits(),
				subBlockMeterReadingTo.getTodayunits(),
				subBlockMeterReadingTo.getDate()
				
		);
				
	}
}
