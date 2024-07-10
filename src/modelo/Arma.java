package modelo;

public class Arma {
	private String nombre;
	private int nivel;
	private int daño;

	public Arma() {

	}

	public Arma(String nombre, int nivel, int daño) {
		this.nombre = nombre;
		this.nivel = nivel;
		this.daño = daño;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public int getDaño() {
		return daño;
	}

	public void setDaño(int daño) {
		this.daño = daño;
	}
	
	public void subirNivel(Arma arma) {

		arma.setNivel(arma.getNivel() + 1);
		System.out.println("Tu arma ha subido al nivel " + arma.getNivel());
		subirEstadisticas(arma);

	}

	public void subirEstadisticas(Arma arma) {

		arma.setDaño(arma.getDaño() + 5);

	}

	@Override
	public String toString() {
		return "Arma [nombre=" + nombre + ", nivel=" + nivel + ", daño=" + daño + "]";
	}

	
}
