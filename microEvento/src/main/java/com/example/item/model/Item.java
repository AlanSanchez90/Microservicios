package com.example.item.model;

public class Item {

	public Item() {	}

	public  Evento evento;
	public Integer cantidad;
	
	public Item(Evento evento, Integer cantidad) {
		this.evento = evento;
		this.cantidad = cantidad;
	}
	
	public Double  getTotal(){
		return  evento.getPrecio() * cantidad.doubleValue();
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	
	
	
}
