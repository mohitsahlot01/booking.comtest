package com.hackerrank.sample.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hackerrank.sample.entity.DataEntity;
import com.hackerrank.sample.service.SampleService;

@RestController
public class SampleController {

	@Autowired
	SampleService sampleService;
	
	@PostMapping("/insert")
	public ResponseEntity<?> saveRecord(@RequestBody @Valid DataEntity dataEntity) {
		return new ResponseEntity<>(sampleService.createRecord(dataEntity), HttpStatus.CREATED);
	}
	
	@GetMapping("/select")
	public ResponseEntity<?> getRecords(){
		return new ResponseEntity<>(sampleService.fetchRecords(), HttpStatus.OK);
	}
	
	@GetMapping("/select/{id}")
	public ResponseEntity<?> getRecordById(@PathVariable("id") Integer id) {
		Optional<DataEntity> ode = sampleService.fetchRecordById(id);
		ResponseEntity<?> re;
		if(ode.isPresent()) {
			re = new ResponseEntity<>(ode.get(), HttpStatus.OK);
		}
		else {
			re = new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
		return re;
	}
	
	@DeleteMapping("/delete/{id}")
	ResponseEntity<?> deleteRecord(@PathVariable("id") Integer id) {
		boolean deleted = sampleService.deleteRecord(id);
		if(deleted)
			return new ResponseEntity<>(null, HttpStatus.OK);
		else
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
}
