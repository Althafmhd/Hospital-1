package com.example.mapper;

import com.example.demo.entity.Meter;
import com.example.dto.MeterTo;


public class MeterMapper {
	public static MeterTo mapToMeterTo(Meter meter) {
		return new MeterTo(
				meter.getId(),
				meter.getMainmetername(),
				meter.getDate()
		);
	}
	public static Meter mapToMeter(MeterTo meterTo) {
		return new Meter(
				meterTo.getId(),
				meterTo.getMainmetername(),
				meterTo.getDate()
			
				
		);
	}
}
