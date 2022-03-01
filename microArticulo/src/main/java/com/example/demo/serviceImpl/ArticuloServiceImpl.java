package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IArticuloDAO;
import com.example.demo.model.ArticuloDTO;
import com.example.demo.service.IArticuloService;

import lombok.RequiredArgsConstructor;

@Service
//@RequiredArgsConstructor
public class ArticuloServiceImpl implements IArticuloService {

	
//	private final IArticuloDAO articuloDAO= null;
//	
//	public ArticuloServiceImpl(IArticuloDAO repository) {
//		// TODO Auto-generated constructor stub
//	}

	@Autowired
		private IArticuloDAO articuloDAO;
	
	@Override
	public List<ArticuloDTO> readAll() {
		return (List<ArticuloDTO>) articuloDAO.findAll();
	}

	@Override
	public ArticuloDTO create(ArticuloDTO dto) {
	    return  articuloDAO.insert(dto);
	}

	@Override
	public ArticuloDTO update(String id, ArticuloDTO dto) {
		return articuloDAO.save(dto);
	}

	@Override
	public void delete(String id) {
         articuloDAO.deleteById(id);
	}

	@Override
	public ArticuloDTO findById(String id) {
		return articuloDAO.findById(id).orElse(null);
	}

}
