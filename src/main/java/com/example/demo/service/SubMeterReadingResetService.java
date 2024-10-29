package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Respository.SubMeterReadingResetRepository;
import com.example.demo.entity.Submeterreadingreset;
import com.example.demo.service.serviceinterface.SubMeterReadingResetServiceInterface;
import com.example.dto.SubMeterReadingResetTo;
import com.example.mapper.SubMeterReadingResetMapper;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class SubMeterReadingResetService implements SubMeterReadingResetServiceInterface {
	@Autowired
	private SubMeterReadingResetRepository subMeterReadingResetRespository;
	@Override
	public SubMeterReadingResetTo resetValue(SubMeterReadingResetTo subMeterReadingResetTo) {
		// TODO Auto-generated method stub
		Submeterreadingreset sread=SubMeterReadingResetMapper. mapToSubMeterReadingReset(subMeterReadingResetTo);
		Submeterreadingreset savesr=subMeterReadingResetRespository.save(sread);
		return SubMeterReadingResetMapper.mapToSubMeterReadingResetTo(savesr);
	}
	@Override
	public Submeterreadingreset getLastEntryBySubmetername(String submetername) {
		// TODO Auto-generated method stub
		return subMeterReadingResetRespository.findTopBySubmeternameOrderByIdDesc(submetername);
	}

}
