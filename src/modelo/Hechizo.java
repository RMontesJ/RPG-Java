package modelo;

public class Hechizo {
	private String nombre;
	private int ataque;

	public Hechizo() {

	}

	public Hechizo(String nombre, int ataque) {
		this.nombre = nombre;
		this.ataque = ataque;
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

	@Override
	public String toString() {
		return "Hechizo [nombre=" + nombre + ", ataque=" + ataque + "]";
	}

}
