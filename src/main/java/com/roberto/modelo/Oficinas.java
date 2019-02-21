package com.roberto.modelo;

public class Oficinas {

	private int oficina;
	private String ciudad;
	private String region;
	private int num_representantes;
	private String director;
	
	public Oficinas(){super();}

	public Oficinas(int oficina, String ciudad, String region, int num_representantes, String director) {
		super();
		this.oficina = oficina;
		this.ciudad = ciudad;
		this.region = region;
		this.num_representantes = num_representantes;
		this.director = director;
	}

	public int getOficina() {
		return oficina;
	}

	public void setOficina(int oficina) {
		this.oficina = oficina;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public int getNum_representantes() {
		return num_representantes;
	}

	public void setNum_representantes(int num_representantes) {
		this.num_representantes = num_representantes;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}
	
	
	
	
}
