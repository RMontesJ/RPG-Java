package modelo;

public class Hechizo {
	private String nombre;
	private int nivel;
	private TipoHechizo tipo;
	private int fuerza;
	private int coste;
	private String descripción;

	public Hechizo(String nombre, int nivel, TipoHechizo tipo, int fuerza, int coste, String descripción) {
		this.nombre = nombre;
		this.nivel = nivel;
		this.tipo = tipo;
		this.fuerza = fuerza;
		this.coste = coste;
		this.descripción = descripción;
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

	public TipoHechizo getTipo() {
		return tipo;
	}

	public void setTipo(TipoHechizo tipo) {
		this.tipo = tipo;
	}

	public int getFuerza() {
		return fuerza;
	}

	public void setFuerza(int fuerza) {
		this.fuerza = fuerza;
	}

	public int getCoste() {
		return coste;
	}

	public void setCoste(int coste) {
		this.coste = coste;
	}

	public String getDescripción() {
		return descripción;
	}

	public void setDescripción(String descripción) {
		this.descripción = descripción;
	}

	@Override
	public String toString() {
		return "Hechizo [nombre=" + nombre + "nivel=" + nivel + ", tipo=" + tipo + ", fuerza=" + fuerza + ", coste=" + coste
				+ "\n" + ", descripción=" + descripción + "]" + "\n";
	}

}
