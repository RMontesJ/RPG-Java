package modelo;

public class Hechizo {
	private String nombre;
	private int ataque;
	private int coste;

	public Hechizo(String nombre, int ataque, int coste) {
		this.nombre = nombre;
		this.ataque = ataque;
		this.coste = coste;
	}
	
	// para hechizos que no tienen daño
	public Hechizo(String nombre, int coste) {
		this.nombre = nombre;
		this.coste = coste;
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

	public int getCoste() {
		return coste;
	}

	public void setCoste(int coste) {
		this.coste = coste;
	}

	@Override
	public String toString() {
		return "[nombre=" + nombre + " ataque=" + ataque + " coste=" + coste + "]" + "\n";
	}


}
