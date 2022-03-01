package com.example.item.serviceImpl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.item.model.Evento;
import com.example.item.model.Item;
import com.example.item.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public List<Item> findAll() {
		List<Evento> eventos= Arrays.asList(restTemplate.getForObject("http://localhost:8001/api/articulo/listar", Evento[].class));
		return eventos.stream().map(e -> new Item(e,1)).collect(Collectors.toList());
	}

	@Override
	public Item findById(String id, Integer cantidad) {
		Map<String, String> pathVariables = new HashMap<String,String>();
		pathVariables.put("id",id.toString());
		Evento evento = restTemplate.getForObject("http://localhost:8001/api/articulo/ver/{id}", Evento.class, pathVariables);
		return new Item(evento, cantidad);
	}

}
