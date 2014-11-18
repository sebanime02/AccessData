package com.example.db;

public class Planeta {

	public static final String TABLE_NAME="planeta";
	public static final String COLUMN_NAME="nombre";
	public static final String COLUMN_GRAVITY="gravedad";
	public static final String COLUMN_DISTANCE="distancia";
	
	String nombre;
	float gravedad;
	long distancia;
	int id;
	
	public Planeta(String nombre, float gravedad, long distancia) {
		this.nombre = nombre;
		this.gravedad = gravedad;
		this.distancia = distancia;
	}

	public Planeta() {}

	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getGravedad() {
		return gravedad;
	}

	public void setGravedad(float gravedad) {
		this.gravedad = gravedad;
	}

	public long getDistancia() {
		return distancia;
	}

	public void setDistancia(long distancia) {
		this.distancia = distancia;
	}
	
	
	
	
	
	
	
}
