package com.uca.capas.domain;

public class Product {
	
	private Integer id;
	private String nombre;
	private Integer cantidad;
	
	public Product(Integer id, String nombre, Integer cantidad) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.cantidad = cantidad;
	}
	
	public Product() {
		
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
	

}
