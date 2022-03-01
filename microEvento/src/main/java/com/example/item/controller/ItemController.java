package com.example.item.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.item.model.Item;
import com.example.item.service.ItemService;


@RestController
public class ItemController {

	@Autowired
	@Qualifier("serviceFeing")
	private ItemService itemService;

	@GetMapping("/listar")
public List<Item> listar(){
	return itemService.findAll();
}
	@GetMapping("/ver/{id}/cantidad/{cantidad}")
	public Item detalle(@PathVariable String id,@PathVariable Integer cantidad) {
		return itemService.findById(id, cantidad);
		
	}

}