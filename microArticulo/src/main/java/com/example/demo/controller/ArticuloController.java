package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;


import java.util.List;
import java.util.Optional;

import com.example.demo.dao.IArticuloDAO;
import com.example.demo.model.ArticuloDTO;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;


@RestController
@CrossOrigin
//(origins="*", methods= {RequestMethod.POST,RequestMethod.GET,
	//	RequestMethod.PUT,RequestMethod.DELETE})
@RequestMapping("/api/articulo")
public class ArticuloController {
	
	@Autowired
	private IArticuloDAO repository;
	
	

	@GetMapping("/listar")
	//@ManagedOperation(description="Presenta todo el listado de aticulos")
	public List<ArticuloDTO> readAll() {
		return repository.findAll();
	}
	
	@GetMapping("/ver/{id}")
	//@ManagedOperation(description="Presenta todo el listado de aticulos")
	public Optional<ArticuloDTO> findById(@PathVariable String id) {
		return repository.findById(id);
	}

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/crear") // request-response
	//@ManagedOperation(description="Crea algun producto")
	public ArticuloDTO create(@Validated @RequestBody ArticuloDTO dto) { // requestbody sirve para mapear del json al objeto // en java
		return repository.insert(dto);
	}

	@PutMapping("{id}") 
	//@ManagedOperation(description="Actualiza algun producto especifico")
	@CrossOrigin
	public ArticuloDTO update(@PathVariable String id, @RequestBody ArticuloDTO dto) { // requestbody sirve para mapear del json al objeto // en java
		ArticuloDTO aUpdate = repository.findById(id).orElseThrow(RuntimeException::new);
		aUpdate.setNombre(dto.nombre);
		aUpdate.setUnidad(dto.unidad);
		aUpdate.setClave(dto.clave);
		aUpdate.setPrecio(dto.precio);
		aUpdate.setFecha(dto.fecha);
		return repository.save(aUpdate);
	}	
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("{id}") 
	//@ManagedOperation(description="Elimina algun producto especifico")
	public void delete(@PathVariable String id) {
		ArticuloDTO dDelete = repository.findById(id).orElseThrow(RuntimeException::new);
		repository.delete(dDelete);
		
	}
}
