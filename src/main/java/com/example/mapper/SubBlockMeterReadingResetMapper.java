package com.example.mapper;


import com.example.demo.entity.Subblockmeterreadingreset;
import com.example.dto.SubBlockMeterReadingResetTo;



public class SubBlockMeterReadingResetMapper {
	public static  SubBlockMeterReadingResetTo mapToSubBlockMeterReadingResetTo(Subblockmeterreadingreset srread) {
		return new  SubBlockMeterReadingResetTo(
				srread.getId(),
				srread.getMainmetername(),
				srread.getSubblockmetername(),
				srread.getReadingunits(),
				srread.getDate()
		);
		

	}
	public static Subblockmeterreadingreset maptoSubBlockMeterReadingReset(SubBlockMeterReadingResetTo sreadto) {
		return new Subblockmeterreadingreset(
			   sreadto.getId(),
			   sreadto.getMainmetername(),
			   sreadto.getSubblockmetername(),
			   sreadto.getReadingunits(),
			   sreadto.getDate()
				);
	}
}
