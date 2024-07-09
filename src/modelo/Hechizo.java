package modelo;

public class Hechizo {
	private String nombre;
	private TipoHechizo tipo;
	private int ataque;
	private int coste;

	public Hechizo(String nombre, TipoHechizo tipo, int ataque, int coste) {
		this.nombre = nombre;
		this.tipo = tipo;
		this.ataque = ataque;
		this.coste = coste;
	}
	
	public Hechizo(String nombre, TipoHechizo tipo, int coste) {
		this.nombre = nombre;
		this.tipo = tipo;
		this.coste = coste;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public TipoHechizo getTipo() {
		return tipo;
	}

	public void setTipo(TipoHechizo tipo) {
		this.tipo = tipo;
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
		return "Hechizo [nombre=" + nombre + ", tipo=" + tipo + ", ataque=" + ataque + ", coste=" + coste + "\n" + "]";
	}

	

}
