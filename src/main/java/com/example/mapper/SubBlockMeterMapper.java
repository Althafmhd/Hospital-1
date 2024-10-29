package com.example.mapper;


import com.example.demo.entity.Subblockmeter;
import com.example.dto.SubBlockMeterTo;



public class SubBlockMeterMapper {
	public static SubBlockMeterTo mapToSubMeterTo (Subblockmeter subBlockMeter) {
		return new SubBlockMeterTo (
				subBlockMeter.getId(),
				subBlockMeter.getMainmetername(),
				subBlockMeter.getSubblockmetername(),
				subBlockMeter.getDate()
			
		);
	}
	public static  Subblockmeter mapToSubMeter(SubBlockMeterTo subBlockMeterTo) {
		return new Subblockmeter(
				subBlockMeterTo.getId(),
				subBlockMeterTo.getMainmetername(),
				subBlockMeterTo.getSubblockmetername(),
				subBlockMeterTo.getDate()
			
				);
				
	}
}
