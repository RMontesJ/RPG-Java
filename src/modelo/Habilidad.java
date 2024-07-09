package modelo;

public class Habilidad {

	private String nombre;
	private int nivel;
	private String descripcion;
	private int intensidad;
	
	public Habilidad() {
		
	}
	
	public Habilidad(String nombre, int nivel, String descripcion, int intensidad) {
		
		this.nombre = nombre;
		this.nivel = nivel;
		this.descripcion = descripcion;
		this.intensidad = intensidad;
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getIntensidad() {
		return intensidad;
	}

	public void setIntensidad(int intensidad) {
		this.intensidad = intensidad;
	}

	@Override
	public String toString() {
		return "Habilidad [nombre=" + nombre + ", nivel=" + nivel + ", descripcion=" + descripcion + ", intensidad="
				+ intensidad + "]";
	}
	
	
}
