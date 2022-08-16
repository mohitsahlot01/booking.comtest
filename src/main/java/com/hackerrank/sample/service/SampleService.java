package com.hackerrank.sample.service;

import java.util.List;
import java.util.Optional;

import com.hackerrank.sample.entity.DataEntity;

public interface SampleService {

	DataEntity createRecord(DataEntity de);
	List<DataEntity> fetchRecords();
	Optional<DataEntity> fetchRecordById(Integer id);
	boolean deleteRecord(Integer id);
}
