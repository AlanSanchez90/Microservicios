package com.example.demo.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.ArticuloDTO;


@Repository
public interface IArticuloDAO extends MongoRepository<ArticuloDTO, String>{

}
