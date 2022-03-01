package com.example.item.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.item.clientes.EventoClienteRest;
import com.example.item.model.Item;
import com.example.item.service.ItemService;

@Service("serviceFeing")
@Primary
public class ItemServiceFeing implements ItemService {

	@Autowired
	private EventoClienteRest clienteFeing;
	
	@Override
	public List<Item> findAll() {
		return clienteFeing.listar().stream().map(e -> new Item(e,1)).collect(Collectors.toList());
	}

	@Override
	public Item findById(String id, Integer cantidad) {
		return new Item(clienteFeing.detalle(id),cantidad);	
	}

}
