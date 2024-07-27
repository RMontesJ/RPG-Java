package modelo;

public class Hechizo {
	private String nombre;
	private int nivel;
	private TipoHechizo tipo;
	private int fuerza;
	private int fuerzaMaxima;
	private int coste;
	private String descripción;

	public Hechizo(String nombre, int nivel, TipoHechizo tipo, int fuerza, int fuerzaMaxima, int coste,
			String descripción) {
		this.nombre = nombre;
		this.nivel = nivel;
		this.tipo = tipo;
		this.fuerza = fuerza;
		this.fuerzaMaxima = fuerzaMaxima;
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

	public int getFuerzaMaxima() {
		return fuerzaMaxima;
	}

	public void setFuerzaMaxima(int fuerzaMaxima) {
		this.fuerzaMaxima = fuerzaMaxima;
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

	public void subirNivel(Hechizo hechizo) {

		hechizo.setNivel(hechizo.getNivel() + 1);
		System.out.println("El hechizo " + hechizo.getNombre() + " ha subido al nivel " + hechizo.getNivel());
		subirEstadisticas(hechizo);

	}

	public void subirEstadisticas(Hechizo hechizo) {

		hechizo.setFuerza(hechizo.getFuerza() + 5);
		hechizo.setFuerzaMaxima(hechizo.getFuerzaMaxima() + 10);

	}

	@Override
	public String toString() {
		return "Hechizo [nombre=" + nombre + ", nivel=" + nivel + ", tipo=" + tipo + ", fuerza=" + fuerza
				+ ", fuerza maxima= " + fuerzaMaxima + ", coste=" + coste + ", descripción=" + descripción + "]" + "\n";
	}

}
