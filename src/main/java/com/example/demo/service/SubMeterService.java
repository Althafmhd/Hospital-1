package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.Respository.SubBlockMeteRepository;
import com.example.demo.Respository.SubMeterRespository;
import com.example.demo.entity.Subblockmeter;
import com.example.demo.entity.Submeter;
import com.example.demo.service.serviceinterface.SubMeterServiceInterface;
import com.example.dto.SubBlockMeterTo;
import com.example.dto.SubMeterTo;
import com.example.mapper.SubBlockMeterMapper;
import com.example.mapper.SubMeterMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SubMeterService implements SubMeterServiceInterface {
	
	SubMeterRespository subMeterRepository;
	
	@Override
	public SubMeterTo createSubMeter(SubMeterTo subMeterTo) {
		// TODO Auto-generated method stub
		Submeter subMeter=SubMeterMapper.mapToSubMeter(subMeterTo);
		Submeter saveSubBlockMeter=subMeterRepository.save(subMeter);
		return SubMeterMapper.mapToSubMeterTo(saveSubBlockMeter);
	}

	@Override
	public List<SubMeterTo> geAllMeteres() {
		// TODO Auto-generated method stub
		List<Submeter> subMeter=subMeterRepository.findAll();
		return subMeter.stream().map((meter) -> SubMeterMapper.mapToSubMeterTo(meter)).collect(Collectors.toList());
	}

	@Override
	public void deleteBySubmetername(String submetername) {
		// TODO Auto-generated method stub
		subMeterRepository.deleteByMetername(submetername);
	}

	@Override
	public void deleterBySubBlockMetername(String subblockmetername) {
		// TODO Auto-generated method stub
		subMeterRepository.deleteBysubBlockMetername(subblockmetername);
	}

}
