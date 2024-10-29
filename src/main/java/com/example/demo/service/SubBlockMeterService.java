package com.example.demo.service;


import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Respository.SubBlockMeteRepository;
import com.example.demo.entity.Subblockmeter;
import com.example.demo.service.serviceinterface.SubBlockMeterServiceInterface;
import com.example.dto.SubBlockMeterTo;
import com.example.mapper.SubBlockMeterMapper;



import exception.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SubBlockMeterService implements SubBlockMeterServiceInterface {
	@Autowired
	private SubBlockMeteRepository subBlockMeterRepository;
	@Override
	public SubBlockMeterTo createSubMeter(SubBlockMeterTo sumbmeter) {
		// TODO Auto-generated method stub
		Subblockmeter subBlockMeter=SubBlockMeterMapper.mapToSubMeter(sumbmeter);
		Subblockmeter saveSubBlockMeter=subBlockMeterRepository.save(subBlockMeter);
		return SubBlockMeterMapper.mapToSubMeterTo(saveSubBlockMeter);
				
	}
	@Override
	public List<SubBlockMeterTo> geAllMeteres() {
		// TODO Auto-generated method stub
		List<Subblockmeter> subBlockmeter=subBlockMeterRepository.findAll();
		return subBlockmeter.stream().map((employee) -> SubBlockMeterMapper.mapToSubMeterTo(employee)).collect(Collectors.toList());
	}
	@Override
	@Transactional
	public void deleteByMetername(String subblockmetername) {
		// TODO Auto-generated method stub
		subBlockMeterRepository.deleteByMetername(subblockmetername);
	}

	/*public List<SubMeterto> getMetername(String mmetername) {
		// TODO Auto-generated method stub
		List<Submeter> metername=submeterRepo.findByMeterName(mmetername);
		return metername.stream().map((employee) -> SubMetermapper.mapToSubMeterto(employee)).collect(Collectors.toList());
	}*/
	@Override
	public SubBlockMeterTo getMeterId(Long meterId) {
		// TODO Auto-generated method stub
		Subblockmeter employeeid=subBlockMeterRepository.findById(meterId).orElseThrow(()->new ResourceNotFoundException("Meter is not exist"));
		return SubBlockMeterMapper.mapToSubMeterTo(employeeid);
	}
	@Override
	public void deleteByMainmetername(String mainmetername) {
		// TODO Auto-generated method stub
		subBlockMeterRepository.deleteByMainmetername(mainmetername);
	}
	
	
	



	
	

	
	

}
