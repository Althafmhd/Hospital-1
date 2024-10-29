package com.example.mapper;

import com.example.demo.entity.Submeterreadingreset;
import com.example.dto.SubMeterReadingResetTo;



public class SubMeterReadingResetMapper {
	public static  SubMeterReadingResetTo mapToSubMeterReadingResetTo(Submeterreadingreset srread) {
		return new  SubMeterReadingResetTo(
				srread.getId(),
				srread.getMainmetername(),
				srread.getSubblockmetername(),
				srread.getSubmetername(),
				srread.getReadingunits(),
				srread.getDate()
		);
		

	}
	public static Submeterreadingreset mapToSubMeterReadingReset(SubMeterReadingResetTo sreadto) {
		return new Submeterreadingreset(
			   sreadto.getId(),
			   sreadto.getMainmetername(),
			   sreadto.getSubblockmetername(),
			   sreadto.getSubmetername(),
			   sreadto.getReadingunits(),
			   sreadto.getDate()
				);
	}
}
