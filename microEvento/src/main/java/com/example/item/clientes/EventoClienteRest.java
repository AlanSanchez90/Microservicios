package com.example.item.clientes;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.item.model.Evento;

@FeignClient(name="microArticulo",url="http://localhost:8001")
public interface EventoClienteRest {

	@GetMapping("/api/articulo/listar")
	public List<Evento> listar();

	@GetMapping("/api/articulo/ver/{id}")
	public Evento detalle(@PathVariable String id);
}
