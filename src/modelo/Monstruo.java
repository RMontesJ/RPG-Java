package modelo;

public class Monstruo {
	private String nombre;
	private int vida;
	private int vidaLimite;
	private int fuerza;
	private int fuerzaLimite;
	private int nivel;
	private int experiencia;
	private int experienciaLimite;
	

	public Monstruo() {
		this.nombre = "Gigante";
		this.vida = 20;
		this.vidaLimite = 20;
		this.fuerza = 10;
		this.fuerzaLimite = 10;
		this.nivel = 1;
		this.experiencia = 0;
		this.experienciaLimite = 10;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public int getVidaLimite() {
		return vidaLimite;
	}

	public void setVidaLimite(int vidaLimite) {
		this.vidaLimite = vidaLimite;
	}

	public int getFuerza() {
		return fuerza;
	}

	public void setFuerza(int fuerza) {
		this.fuerza = fuerza;
	}

	public int getFuerzaLimite() {
		return fuerzaLimite;
	}

	public void setFuerzaLimite(int fuerzaLimite) {
		this.fuerzaLimite = fuerzaLimite;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public int getExperiencia() {
		return experiencia;
	}

	public void setExperiencia(int experiencia) {
		this.experiencia = experiencia;
	}

	public int getExperienciaLimite() {
		return experienciaLimite;
	}

	public void setExperienciaLimite(int experienciaLimite) {
		this.experienciaLimite = experienciaLimite;
	}
	
	public void ganarExperiencia(Monstruo enemigo) {

		enemigo.setExperiencia(enemigo.getExperiencia() + 10);

		if (enemigo.getExperiencia() >= enemigo.experienciaLimite) {
			subirNivel(enemigo);

		}

	}

	public void subirNivel(Monstruo enemigo) {

		enemigo.setNivel(enemigo.getNivel() + 1);
		
		subirEstadisticas(enemigo);

	}

	public void subirEstadisticas(Monstruo enemigo) {

		enemigo.setVida(enemigo.getVida() + 5);
		enemigo.setVidaLimite(enemigo.getVidaLimite() + 5);
		enemigo.setFuerza(enemigo.getFuerza() + 5);
		enemigo.setFuerzaLimite(enemigo.getFuerzaLimite() + 5);
		enemigo.setExperienciaLimite(enemigo.getExperienciaLimite() + 10);

	}

	@Override
	public String toString() {
	    return "Monstruo {" + 
	           "\n  nombre=" + nombre + 
	           "\n  vida=" + vida + 
	           "\n  vidaLimite=" + vidaLimite + 
	           "\n  fuerza=" + fuerza + 
	           "\n  fuerzaLimite=" + fuerzaLimite + 
	           "\n  nivel=" + nivel + 
	           "\n  EXP= " + experiencia + 
	           "\n  EXP para siguiente nivel= " + experienciaLimite + 
	           "\n}";
	}


	

}
