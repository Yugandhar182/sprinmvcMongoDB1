package com.springmvc.SpringMvcCRUD2.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.springmvc.SpringMvcCRUD2.entity.Studentdata;

public interface   StudentdataRepository extends MongoRepository<Studentdata, Integer> {

}
