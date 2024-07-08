package modelo;

public class Monstruo {
	private String nombre;
	private int vida;
	private int fuerza;


	public Monstruo() {
		this.vida = 80;
		this.fuerza = 10;
	}
	
	public Monstruo(String nombre, int vida, int fuerza) {
		this.nombre = nombre;
		this.vida = vida;
		this.fuerza = fuerza;
		
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getVida() {
		return vida;
	}
	
	public void setVida(int vida) {
		this.vida = vida;
	}

	public int getFuerza() {
		return fuerza;
	}
	
	public void setFuerza(int fuerza) {
		this.fuerza = fuerza;
	}

	@Override
	public String toString() {
		return "Monstruo [nombre=" + nombre + ", vida=" + vida + ", fuerza=" + fuerza + "]";
	}

	
	
}
