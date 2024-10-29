package com.example.mapper;


import com.example.demo.entity. Meterreadingreset;
import com.example.dto.MeterReadingResetTo;



public class MeterReadingResetMapper {
	public static MeterReadingResetTo maptoMeterReadingResetTo(Meterreadingreset meterReadingReset) {
		return new MeterReadingResetTo(
				meterReadingReset.getId(),
				meterReadingReset.getMainmetername(),
				meterReadingReset.getReadingunits(),
				meterReadingReset.getDate()
		);
				
	}
	public static  Meterreadingreset maptoMeteReadingReset(MeterReadingResetTo meterReadingResetTo) {
		return new  Meterreadingreset(
				meterReadingResetTo.getId(),
				meterReadingResetTo.getMainmetername(),
				meterReadingResetTo.getReadingunits(),
				meterReadingResetTo.getDate()
		);
	}
}
