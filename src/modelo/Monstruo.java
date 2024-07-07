package modelo;

public class Monstruo {
	private String nombre;
	private int vida;
	private int fuerza;
	private int aguante;

	public Monstruo() {
		this.nombre = nombre;
		this.fuerza = 10;
		this.vida = 80;
		this.aguante = 10;
	}
	
	public Monstruo(String nombre, int fuerza, int vida, int aguante) {
		this.nombre = nombre;
		this.fuerza = fuerza;
		this.vida = vida;
		this.aguante = aguante;
	}
	
	
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getFuerza() {
		return fuerza;
	}
	
	public void setFuerza(int fuerza) {
		this.fuerza = fuerza;
	}
	
	public int getVida() {
		return vida;
	}
	
	public void setVida(int vida) {
		this.vida = vida;
	}
	
	public int getAguante() {
		return aguante;
	}
	
	public void setAguante(int aguante) {
		this.aguante = aguante;
	}
	
	public int ataque() {
		int ataque = fuerza - vida;
		return ataque;
	}
	
	public int defensa(Humano a) {
		int defensa = vida - a.getFuerza();
		
		return defensa;
	}

	@Override
	public String toString() {
		return "Monstruo [vida=" + vida + ", fuerza=" + fuerza + ", aguante=" + aguante + "]";
	}

	
	
}
