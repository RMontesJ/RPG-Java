package modelo;

public class Recompensa {

	private String nombre;
	private String descripción;
	private int efecto;
	
	public Recompensa(String nombre, String descripción, int efecto) {
		
		this.nombre = nombre;
		this.descripción = descripción;
		this.efecto = efecto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripción() {
		return descripción;
	}

	public void setDescripción(String descripción) {
		this.descripción = descripción;
	}

	public int getEfecto() {
		return efecto;
	}

	public void setEfecto(int efecto) {
		this.efecto = efecto;
	}

	@Override
	public String toString() {
		return "Recompensa [nombre=" + nombre + ", descripción=" + descripción + ", efecto=" + efecto + "]";
	}
	
}
