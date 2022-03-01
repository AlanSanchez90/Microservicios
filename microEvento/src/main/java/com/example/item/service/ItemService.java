package com.example.item.service;

import java.util.List;

import com.example.item.model.Item;

public interface ItemService {
	
	public List<Item> findAll();
	public Item findById(String id, Integer cantidad);
}
