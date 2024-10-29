package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Respository.SubBlockMeterReadingResetRepository;
import com.example.demo.entity.Subblockmeterreadingreset;
import com.example.demo.service.serviceinterface.SubBlockMeterReadingResetServiceInterface;
import com.example.dto.SubBlockMeterReadingResetTo;
import com.example.mapper.SubBlockMeterReadingResetMapper;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SubBlockMeterReadingResetService implements SubBlockMeterReadingResetServiceInterface{
	@Autowired
	private SubBlockMeterReadingResetRepository sreadrepo;
	@Override
	public SubBlockMeterReadingResetTo resetValue(SubBlockMeterReadingResetTo sreadto) {
		// TODO Auto-generated method stub
		Subblockmeterreadingreset sread=SubBlockMeterReadingResetMapper.maptoSubBlockMeterReadingReset(sreadto);
		Subblockmeterreadingreset savesr=sreadrepo.save(sread);
		return SubBlockMeterReadingResetMapper.mapToSubBlockMeterReadingResetTo(savesr);
		
	}
	@Override
	public Long getLastMeterName() {
		// TODO Auto-generated method stub
		Subblockmeterreadingreset lastReading = sreadrepo.findTopByOrderByIdDesc();
	        return lastReading != null ? lastReading.getReadingunits() : null;
	}
	@Override
	public Subblockmeterreadingreset getLastEntryBySubblockmetername(String subblockmetername) {
		// TODO Auto-generated method stub
		return sreadrepo.findTopBySubblockmeternameOrderByIdDesc(subblockmetername);
	}
	

}
