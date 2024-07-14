package modelo;

public class Monstruo {
	private String nombre;
	private int vida;
	private int vidaMaxima;
	private int fuerza;
	private int fuerzaMaxima;
	private int nivel;
	private int experiencia;
	private int experienciaLimite;
	

	public Monstruo() {
		this.vida = 20;
		this.vidaMaxima = 20;
		this.fuerza = 10;
		this.fuerzaMaxima = 10;
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

	public int getVidaMaxima() {
		return vidaMaxima;
	}

	public void setVidaMaxima(int vidaMaxima) {
		this.vidaMaxima = vidaMaxima;
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
	
	public void ponerNombre(Monstruo enemigo) {
		
		String nombre [] = {"Dragon", "Minotauro", "Gigante", "Leviatan", "Quimera", "Escorpion"};
		
		int aleatorio = (int) (Math.random() * nombre.length);
		
		enemigo.setNombre(nombre[aleatorio]);
		
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
		enemigo.setVidaMaxima(enemigo.getVidaMaxima() + 5);
		enemigo.setFuerza(enemigo.getFuerza() + 5);
		enemigo.setFuerzaMaxima(enemigo.getFuerzaMaxima() + 5);
		enemigo.setExperienciaLimite(enemigo.getExperienciaLimite() + 10);

	}

	@Override
	public String toString() {
	    return "Monstruo {" + 
	           "\n  nombre=" + nombre + 
	           "\n  vida=" + vida + 
	           "\n  vida Maxima=" + vidaMaxima + 
	           "\n  fuerza=" + fuerza + 
	           "\n  fuerza maxima=" + fuerzaMaxima + 
	           "\n  nivel=" + nivel + 
	           "\n  EXP= " + experiencia + 
	           "\n  EXP para siguiente nivel= " + experienciaLimite + 
	           "\n}";
	}


	

}
