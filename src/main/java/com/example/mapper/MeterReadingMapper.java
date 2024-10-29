package com.example.mapper;


import com.example.demo.entity.Meterreading;
import com.example.dto.MeterReadingTo;



public class MeterReadingMapper {
	public static MeterReadingTo mapToMeterReadingto(Meterreading meterRead) {
		return new MeterReadingTo(
				meterRead.getId(),
				meterRead.getMainmetername(),
				meterRead.getReadingunits(),
			
				meterRead.getTodayunits(),
			
				meterRead.getDate()
			
			
		);
	}
	public static Meterreading maptoMeter(MeterReadingTo meterReadTo) {
		return new Meterreading(
				meterReadTo.getId(),
				meterReadTo.getMainmetername(),
				meterReadTo.getReadingunits(),
			
				meterReadTo.getTodayunits(),
			
				meterReadTo.getDate()
		
				
				);
	}
}
