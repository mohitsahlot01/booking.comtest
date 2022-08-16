package com.hackerrank.sample.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hackerrank.sample.entity.DataEntity;

@Repository
public interface SampleRepository extends CrudRepository<DataEntity, Integer>{

}
