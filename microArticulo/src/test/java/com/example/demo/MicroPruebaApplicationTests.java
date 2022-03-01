package com.example.demo;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestClassOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.dao.IArticuloDAO;
import com.example.demo.model.ArticuloDTO;
import com.example.demo.service.IArticuloService;
import com.example.demo.serviceImpl.ArticuloServiceImpl;
import com.google.common.base.Optional;


@SpringBootTest
class MicroPruebaApplicationTests {

	//@Autowired
	
	@Mock
	private IArticuloDAO repository;
	
	private IArticuloService articuloService;
	
	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(getClass());
	//	articuloService= new ArticuloServiceImpl(repository);
		ArticuloDTO a = ArticuloDTO();
		a.setId("2");
		a.setNombre("prueba1");
		a.setUnidad("pulgada");
		a.setClave("1234435");
		a.setPrecio(13.25);
		
		
		Mockito.when(repository.findAll()).thenReturn((List<com.example.demo.model.ArticuloDTO>) Optional.of(a));
				
	}
	@Test
	public void whenValidGetID_ThenReturnArticulo() {
		Class<? extends IArticuloService> found = articuloService.getClass();
		Assertions.assertTrue(found.getName().isEmpty());
		
	}
	
    
	private ArticuloDTO ArticuloDTO() {
		// TODO Auto-generated method stub
		return null;
	}

}
