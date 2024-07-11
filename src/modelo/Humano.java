package modelo;

import java.util.ArrayList;
import java.util.Scanner;

public class Humano {
	private String nombre;
	private int vida;
	private int vidaMaxima;
	private int fuerza;
	private Arma arma;
	private int energia;
	private int energiaMaxima;
	private int defensa;
	public ArrayList<Hechizo> hechizos;
	public Habilidad habilidad;
	public ArrayList<Habilidad> habilidades;
	private int nivel;
	private int experiencia;
	private int gananciaExperiencia;
	private int experienciaLimite;

	public Humano() {
		this.vida = 60;
		this.vidaMaxima = 60;
		this.fuerza = 0;
		this.energia = 30;
		this.energiaMaxima = 30;
		this.defensa = 5;
		hechizos = new ArrayList<Hechizo>();
		habilidades = new ArrayList<Habilidad>();
		this.nivel = 1;
		this.experiencia = 0;
		this.gananciaExperiencia = 5;
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

	public Arma getArma() {
		return arma;
	}

	public void setArma(Arma arma) {
		this.arma = arma;
	}

	public int getEnergia() {
		return energia;
	}

	public void setEnergia(int energia) {
		this.energia = energia;
	}

	public int getEnergiaMaxima() {
		return energiaMaxima;
	}

	public void setEnergiaMaxima(int energiaMaxima) {
		this.energiaMaxima = energiaMaxima;
	}

	public int getDefensa() {
		return defensa;
	}

	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}

	public ArrayList<Hechizo> getHechizos() {
		return hechizos;
	}

	public void setHechizos(ArrayList<Hechizo> hechizos) {
		this.hechizos = hechizos;
	}

	public Habilidad getHabilidad() {
		return habilidad;
	}

	public void setHabilidad(Habilidad habilidad) {
		this.habilidad = habilidad;
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

	public int getGananciaExperiencia() {
		return gananciaExperiencia;
	}

	public void setGananciaExperiencia(int gananciaExperiencia) {
		this.gananciaExperiencia = gananciaExperiencia;
	}

	public int getExperienciaLimite() {
		return experienciaLimite;
	}

	public void setExperienciaLimite(int experienciaLimite) {
		this.experienciaLimite = experienciaLimite;
	}

	public void meterHechizo(Hechizo a, Humano humano) {

		if (humano.hechizos.size() > 4) {
			System.out.println("Solo puedes llevar 4 hechizos como maximo, has llegado al limite");
		} else {
			hechizos.add(a);
		}

	}

	public void meterHabilidad(Habilidad a) {
		habilidades.add(a);
	}

	// permite ver todos los hechizos

	public void verHechizos() {
		System.out.println("---------------------------------------------");
		for (int i = 0; i < hechizos.size(); i++) {
			System.out.println("Tecla " + i + ":" + hechizos.get(i));
		}
		System.out.println("---------------------------------------------");
	}

	public void verHabilidades() {
		System.out.println("---------------------------------------------");
		for (int i = 0; i < habilidades.size(); i++) {
			System.out.println("Tecla " + i + ":" + habilidades.get(i));
		}
		System.out.println("---------------------------------------------");
	}

	public void equiparArma(Humano humano, Arma arma) {
		humano.setFuerza(arma.getDaño() + humano.getFuerza());
		humano.setEnergia(humano.getEnergia() - arma.getPeso());
		humano.setArma(arma);
	}

	public void ponerNombre(Humano humano) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Escoge el nombre de tu personaje");
		String nombre = sc.nextLine();
		humano.setNombre(nombre);

	}

	public void elegirHabilidad(Humano humano, Monstruo bestia) {
		Scanner sc = new Scanner(System.in);

		Habilidad intimidación = new Habilidad("Intimidación", 1, "Reduce el ataque del enemigo", 5);
		Habilidad saludable = new Habilidad("Saludable", 1, "Aumenta tu salud maxima", 5);
		Habilidad potencia = new Habilidad("Potencia", 1, "Aumenta tu ataque", 5);

		humano.meterHabilidad(intimidación);
		humano.meterHabilidad(saludable);
		humano.meterHabilidad(potencia);

		System.out.println("Elige una habilidad");

		verHabilidades();

		int habilidad = sc.nextInt();

		while (habilidad < 0 || habilidad > humano.habilidades.size()) {
			System.out.println("Elige una habilidad valida");

			verHabilidades();

			habilidad = sc.nextInt();

			humano.setHabilidad(humano.habilidades.get(habilidad));

			equiparHabilidad(humano, bestia);
		}

		humano.setHabilidad(humano.habilidades.get(habilidad));

		equiparHabilidad(humano, bestia);

	}

	public void equiparHabilidad(Humano humano, Monstruo bestia) {

		if (humano.habilidad.getNombre().equals("Intimidación")) {
			bestia.setFuerza(bestia.getFuerza() - humano.habilidad.getIntensidad());
			System.out.println("Tu habilidad ha bajado el ataque del enemigo");
		}

		else if (humano.habilidad.getNombre().equals("Saludable")) {
			humano.setVidaMaxima(humano.getVidaMaxima() + humano.habilidad.getIntensidad());
			humano.setVida(humano.getVidaMaxima());
			System.out.println("Tu habilidad te ofrece mas vida");
		}

		else if (humano.habilidad.getNombre().equals("Potencia")) {
			humano.setFuerza(humano.getFuerza() + humano.habilidad.getIntensidad());
			System.out.println("Tu habilidad ha aumentado tu ataque");
		}

	}

	public void mejorarHabilidad(Habilidad habilidad) {

		habilidad.setNivel(habilidad.getNivel() + 1);

		habilidad.setIntensidad(habilidad.getIntensidad() + 5);

	}

	public void ganarExperiencia(Humano humano, Hechizo hechizo) {

		humano.setExperiencia(humano.getExperiencia() + humano.getGananciaExperiencia());

		if (humano.getExperiencia() >= humano.experienciaLimite) {
			subirNivel(humano, hechizo);

		}

	}

	public void subirNivel(Humano humano, Hechizo hechizo) {

		humano.setNivel(humano.getNivel() + 1);
		System.out.println("Has subido al nivel " + humano.getNivel());
		subirEstadisticas(humano, hechizo);

	}

	public void subirEstadisticas(Humano humano, Hechizo hechizo) {

		humano.setVida(humano.getVida() + 5);
		humano.setVidaMaxima(humano.getVidaMaxima() + 5);
		humano.setFuerza(humano.getFuerza() + 5);
		humano.setEnergia(humano.getEnergia() + 5);
		humano.setEnergiaMaxima(humano.getEnergiaMaxima() + 5);

		for (int i = 0; i < hechizos.size(); i++) {

			humano.hechizos.get(i).setFuerza(humano.hechizos.get(i).getFuerza() + 5);

		}

		humano.setExperienciaLimite(humano.getExperienciaLimite() + 10);

		System.out.println(humano);

	}

	public String toString() {
	    return "Humano [\n" +
	           "nombre=" + nombre + "\n" +
	           "vida=" + vida + "\n" +
	           "vidaMaxima=" + vidaMaxima + "\n" +
	           "fuerza=" + fuerza + "\n" +
	           "arma=" + arma + "\n" +
	           "energia=" + energia + "\n" +
	           "energiaMaxima=" + energiaMaxima + "\n" +
	           "defensa=" + defensa + "\n" +
	           "hechizos=" + hechizos + "\n" +
	           "habilidad=" + habilidad + "\n" +
	           "habilidades=" + habilidades + "\n" +
	           "nivel=" + nivel + "\n" +
	           "experiencia=" + experiencia + "\n" +
	           "gananciaExperiencia=" + gananciaExperiencia + "\n" +
	           "experienciaLimite=" + experienciaLimite + "\n" +
	           "]";
	}


}
