package com.roberto.modelo;

public class Representantes {
	
	private int numero_rep;
	private String nombre;
	private int edad;
	private int oficina_rep;
	private int director;
	private int num_ventas;
	private float imp_ventas;
	
	public Representantes(){super();}

	public Representantes(int numero_rep, String nombre, int edad, int oficina_rep, int director, int num_ventas,
			float imp_ventas) {
		super();
		this.numero_rep = numero_rep;
		this.nombre = nombre;
		this.edad = edad;
		this.oficina_rep = oficina_rep;
		this.director = director;
		this.num_ventas = num_ventas;
		this.imp_ventas = imp_ventas;
	}

	public int getNumero_rep() {
		return numero_rep;
	}

	public void setNumero_rep(int numero_rep) {
		this.numero_rep = numero_rep;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public int getOficina_rep() {
		return oficina_rep;
	}

	public void setOficina_rep(int oficina_rep) {
		this.oficina_rep = oficina_rep;
	}

	public int getDirector() {
		return director;
	}

	public void setDirector(int director) {
		this.director = director;
	}

	public int getNum_ventas() {
		return num_ventas;
	}

	public void setNum_ventas(int num_ventas) {
		this.num_ventas = num_ventas;
	}

	public float getImp_ventas() {
		return imp_ventas;
	}

	public void setImp_ventas(float imp_ventas) {
		this.imp_ventas = imp_ventas;
	}
	
	

}
