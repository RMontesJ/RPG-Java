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
	public ArrayList<Hechizo> hechizos;
	public Habilidad habilidad;
	private int nivel;
	private int experiencia;
	private int gananciaExperiencia;
	private int experienciaLimite;

	public Humano() {
		this.nombre = "Gregory";
		this.vida = 50;
		this.vidaMaxima = 50;
		this.fuerza = 0;
		this.energia = 30;
		this.energiaMaxima = 30;
		hechizos = new ArrayList<Hechizo>();
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

	public int getFuerza() {
		return fuerza;
	}

	public void setFuerza(int fuerza) {
		this.fuerza = fuerza;
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

	public Arma getArma() {
		return arma;
	}

	public void setArma(Arma arma) {
		this.arma = arma;
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

	// permite guardar hechizos

	public void meterHechizo(Hechizo a) {
		hechizos.add(a);
	}

	// permite ver todos los hechizos

	public void verHechizos() {
		System.out.println("---------------------------------------------");
		for (int i = 0; i < hechizos.size(); i++) {
			System.out.println("Tecla " +i + ":" + hechizos.get(i));
		}
		System.out.println("---------------------------------------------");
	}

	public void equiparArma(Humano humano, Arma arma) {
		humano.setFuerza(arma.getDaño() + humano.getFuerza());
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
		String habilidad = "";
		Habilidad intimidación = new Habilidad("Intimidación", 1, "Reduce el ataque del enemigo", 5);
		Habilidad saludable = new Habilidad("Saludable", 1, "Aumenta tu salud maxima", 5);
		Habilidad potencia = new Habilidad("Potencia", 1, "Aumenta tu ataque", 5);
		while (!habilidad.equals("1") && !habilidad.equals("2") && !habilidad.equals("3")) {
			System.out.println("Eligue una habilidad");
			System.out.println("1- Intimidación");
			System.out.println("2- Saludable");
			System.out.println("3- Potencia");
			habilidad = sc.nextLine();
		}

		if (habilidad.equals("1")) {
			humano.setHabilidad(intimidación);
			equiparHabilidad(humano, bestia);
		}

		else if (habilidad.equals("2")) {
			humano.setHabilidad(saludable);
			equiparHabilidad(humano, bestia);
		}

		else if (habilidad.equals("3")) {
			humano.setHabilidad(potencia);
			equiparHabilidad(humano, bestia);
		}
	}
	
	public void equiparHabilidad(Humano humano, Monstruo bestia) {
		
		if(humano.habilidad.getNombre().equals("Intimidación")) {
			bestia.setFuerza(bestia.getFuerza() - humano.habilidad.getIntensidad());
			System.out.println("Tu habilidad ha bajado el ataque del enemigo");
		}
		
		else if(humano.habilidad.getNombre().equals("Saludable")) {
			humano.setVidaMaxima(humano.getVidaMaxima() + humano.habilidad.getIntensidad());
			humano.setVida(humano.getVidaMaxima());
			System.out.println("Tu habilidad te ofrece mas vida");
		}
		
		else if(humano.habilidad.getNombre().equals("Potencia")) {
			humano.setFuerza(humano.getFuerza() + humano.habilidad.getIntensidad());
			System.out.println("Tu habilidad ha aumentado tu ataque");
		}
		
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
		
		for(int i = 0; i < hechizos.size(); i++) {
			
			if(hechizos.get(i).getTipo().equals("Curativo")) {
				hechizos.get(i).setFuerza(hechizo.getFuerza());
			}
			else {
				hechizos.get(i).setFuerza(hechizo.getFuerza() + 5);
			}
	
		}
		
		humano.setExperienciaLimite(humano.getExperienciaLimite() + 10);

		System.out.println(humano);

	}

	@Override
	public String toString() {
	    return "Humano {" + 
	           "\n  Nombre= " + nombre + 
	           "\n  Vida= " + vida + 
	           "\n  Vida total= " + vidaMaxima + 
	           "\n  Fuerza= " + fuerza + 
	           "\n  Arma= " + arma + 
	           "\n  Energia= " + energia + 
	           "\n  Energia total= " + energiaMaxima + 
	           "\n  Hechizos= " + hechizos + 
	           "\n  Habilidad= " + habilidad + 
	           "\n  Nivel= " + nivel + 
	           "\n  EXP= " + experiencia + 
	           "\n  Ganacia de EXP= " + gananciaExperiencia + 
	           "\n  EXP para siguiente nivel= " + experienciaLimite + 
	           "\n}";
	}


}
