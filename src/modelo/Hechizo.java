package modelo;

public class Hechizo {
	private String nombre;
	private int ataque;
	private int energia;

	public Hechizo() {

	}

	public Hechizo(String nombre, int ataque, int energia) {
		this.nombre = nombre;
		this.ataque = ataque;
		this.energia = energia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getAtaque() {
		return ataque;
	}

	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}

	public int getEnergia() {
		return energia;
	}

	public void setEnergia(int energia) {
		this.energia = energia;
	}

	@Override
	public String toString() {
		return "Hechizo [nombre=" + nombre + ", ataque=" + ataque + "]";
	}

}
