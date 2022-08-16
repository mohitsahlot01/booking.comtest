/**
 * 
 */
package com.hackerrank.sample.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackerrank.sample.entity.DataEntity;
import com.hackerrank.sample.repository.SampleRepository;

/**
 * @author Mohit
 *
 */
@Service
public class SampleServiceImpl implements SampleService {

	@Autowired
	private SampleRepository sampleRepository;
	
	@Override
	public DataEntity createRecord(DataEntity de) {
		if(de == null)
			return null;
		return sampleRepository.save(de);
	}

	@Override
	public List<DataEntity> fetchRecords() {
		return (List<DataEntity>) sampleRepository.findAll();
	}

	@Override
	public Optional<DataEntity> fetchRecordById(Integer id) {
		return sampleRepository.findById(id);
	}

	@Override
	public boolean deleteRecord(Integer id) {
		Optional<DataEntity> de = sampleRepository.findById(id);
		if(de.isPresent()) {
			sampleRepository.deleteById(id);
			return true;
		}
		return false;
	}

}
