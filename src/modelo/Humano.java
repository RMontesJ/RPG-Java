package modelo;

import java.util.ArrayList;
import java.util.Scanner;

public class Humano {
	private String nombre;
	private int vida;
	private int fuerza;
	private Arma arma;
	private int energia;
	public ArrayList<Hechizo> hechizos;
	public boolean transformacion;
	public String habilidad;

	public Humano() {
		this.nombre = "Gregory";
		this.vida = 50;
		this.fuerza = 5;
		this.energia = 30;
		hechizos = new ArrayList<Hechizo>();
		this.transformacion = false;
		this.habilidad = "Intimidacion";
	}

	public Humano(int fuerza, int vida, int energia, boolean transformacion, String habiliidad) {
		this.fuerza = fuerza;
		this.vida = vida;
		this.energia = energia;
		hechizos = new ArrayList<Hechizo>();
		this.transformacion = transformacion;
		this.habilidad = habiliidad;
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

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
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

	public boolean isTransformacion() {
		return transformacion;
	}

	public void setTransformacion(boolean transformacion) {
		this.transformacion = transformacion;
	}

	public String getHabilidad() {
		return habilidad;
	}

	public void setHabilidad(String habilidad) {
		this.habilidad = habilidad;
	}

	// permite guardar hechizos

	public void meterHechizo(Hechizo a) {
		hechizos.add(a);
	}

	// permite ver todos los hechizos

	public void verHechizos() {
		for (int i = 0; i < hechizos.size(); i++) {
			System.out.println(i + ":" + hechizos.get(i));
		}
	}

	public void crearHechizos(Hechizo h) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nombre del hechizo");
		h.setNombre(sc.nextLine());
		System.out.println("Daño del hechizo");
		h.setAtaque(sc.nextInt());
		hechizos.add(h);
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

	public void elegirHabilidad(Humano humano) {
		Scanner sc = new Scanner(System.in);
		int habilidad = 0;
		while (habilidad != 1 && habilidad != 2 && habilidad != 3) {
			System.out.println("Eligue una habilidad");
			System.out.println("1- Intimidación");
			System.out.println("2- Saludable");
			System.out.println("3- Potencia");
			habilidad = sc.nextInt();
		}

		if (habilidad == 1) {
			humano.setHabilidad("Intimidación");
		}

		else if (habilidad == 2) {
			humano.setHabilidad("Saludable");
		}

		else if (habilidad == 3) {
			humano.setHabilidad("Potencia");
		}
	}

	@Override
	public String toString() {
		return "Humano:\n" + "Nombre: " + nombre + "\n" + "Vida: " + vida + "\n" + "Fuerza: " + fuerza + "\n" + "Arma: "
				+ arma + "\n" + "Energia: " + energia + "\n" + "Hechizos: " + hechizos + "\n" + "Transformacion: "
				+ transformacion + "\n" + "Habilidad: " + habilidad + "\n";
	}

}
