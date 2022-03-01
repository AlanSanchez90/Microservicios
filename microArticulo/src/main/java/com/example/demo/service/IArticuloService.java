package com.example.demo.service;

import java.util.List;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.model.ArticuloDTO;

public interface IArticuloService {

	
	
	public ArticuloDTO findById(String id);
	public List<ArticuloDTO> readAll();
	public ArticuloDTO create(@Validated @RequestBody ArticuloDTO dto);
	public ArticuloDTO update(@PathVariable String id, @RequestBody ArticuloDTO dto);
	public void delete(@PathVariable String id);
	
}
