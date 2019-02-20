package com.roberto.modelo;

public class Regiones {

	private int cod_region;
	private String nombre_re;
	private int num_oficinas;
	private int total_ventas;

	public Regiones(){super();}
	
	public Regiones(int cod_region, String nombre_re) {
		super();
		this.cod_region = cod_region;
		this.nombre_re = nombre_re;
	}
	
	public Regiones(int cod_region, String nombre_re, int num_oficinas, int total_ventas) {
		super();
		this.cod_region = cod_region;
		this.nombre_re = nombre_re;
		this.num_oficinas = num_oficinas;
		this.total_ventas = total_ventas;
	}

	public int getCod_region() {
		return cod_region;
	}

	public void setCod_region(int cod_region) {
		this.cod_region = cod_region;
	}

	public String getNombre_re() {
		return nombre_re;
	}

	public void setNombre_re(String nombre_re) {
		this.nombre_re = nombre_re;
	}

	public int getNum_oficinas() {
		return num_oficinas;
	}

	public void setNum_oficinas(int num_oficinas) {
		this.num_oficinas = num_oficinas;
	}

	public int getTotal_ventas() {
		return total_ventas;
	}

	public void setTotal_ventas(int total_ventas) {
		this.total_ventas = total_ventas;
	}
	
	
	
		
}
