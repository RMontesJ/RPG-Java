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
		this.vida = 100;
		this.vidaMaxima = 100;
		this.fuerza = 0;
		this.energia = 50;
		this.energiaMaxima = 50;
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

	public void meterHechizo(Hechizo hechizo, Humano humano) {
		 Scanner sc = new Scanner(System.in);

		    int eleccion = 0;
		    int olvido = 0;

		    if (humano.hechizos.size() >= 4) {
		        System.out.println("Solo puedes llevar 4 hechizos como máximo, has llegado al límite");
		        System.out.println("¿Quieres sustituir uno de tus hechizos para aprender " + hechizo.getNombre() + "?");
		        System.out.println("1. Sí");
		        System.out.println("2. No");

		        eleccion = sc.nextInt();

		        while (eleccion != 1 && eleccion != 2) {
		            System.out.println("Opción no válida. Elige 1 para Sí o 2 para No.");
		            System.out.println("¿Quieres sustituir uno de tus hechizos para aprender " + hechizo.getNombre() + "?");
		            System.out.println("1. Sí");
		            System.out.println("2. No");
		            eleccion = sc.nextInt();
		        }

		        if (eleccion == 1) {
		            System.out.println("¿Qué hechizo quieres olvidar?");
		            humano.verHechizos();
		            olvido = sc.nextInt();

		            while (olvido < 0 || olvido >= humano.hechizos.size()) {
		                System.out.println("Elige un hechizo válido.");
		                humano.verHechizos();
		                olvido = sc.nextInt();
		            }

		            System.out.println("Has olvidado " + humano.hechizos.get(olvido).getNombre());
		            humano.hechizos.remove(olvido);
		            humano.hechizos.add(hechizo);
		            System.out.println("Has aprendido " + hechizo.getNombre());

		        } else if (eleccion == 2) {
		            System.out.println("Decides no aprender " + hechizo.getNombre());
		        }

		    } else {
		        humano.hechizos.add(hechizo);
		        System.out.println("Has aprendido " + hechizo.getNombre());
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
			System.out.println("Tecla " + i + ":" + habilidades.get(i) + "\n");
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
		Habilidad energetico = new Habilidad("Energetico", 1, "Aumenta tu energia maxima", 5);
		Habilidad reforzado = new Habilidad("Reforzado", 1, "Aumenta tu defensa", 5);
		Habilidad eficiente = new Habilidad("Eficiente", 1, "Reduce el coste de todos tus hechizos", 5);
		Habilidad destrezaMagica = new Habilidad("Destreza magica", 1, "Aumenta el daño de todos tus hechizos", 5);
		Habilidad hojaAfilada = new Habilidad("Hoja afilada", 1, "Aumenta el daño de las armas cortantes", 5);
		Habilidad cabezaPesada = new Habilidad("Cabeza pesada", 1, "Aumenta el daño de las armas contundentes", 5);
		Habilidad puntaDeAcero = new Habilidad("Punta de acero", 1, "Aumenta el daño de las armas punzantes", 5);
		Habilidad vastagoEstable = new Habilidad("Vastago estable", 1, "Aumenta el daño de las armas de largo alcance", 5);
		
		humano.meterHabilidad(intimidación);
		humano.meterHabilidad(saludable);
		humano.meterHabilidad(potencia);
		humano.meterHabilidad(energetico);
		humano.meterHabilidad(reforzado);
		humano.meterHabilidad(eficiente);
		humano.meterHabilidad(destrezaMagica);
		humano.meterHabilidad(hojaAfilada);
		humano.meterHabilidad(cabezaPesada);
		humano.meterHabilidad(puntaDeAcero);
		humano.meterHabilidad(vastagoEstable);

		System.out.println("Elige una habilidad");

		verHabilidades();

		int habilidad = sc.nextInt();

		while (habilidad < 0 || habilidad > humano.habilidades.size()) {
			System.out.println("Elige una habilidad valida");

			verHabilidades();

			habilidad = sc.nextInt();

			humano.setHabilidad(humano.habilidades.get(habilidad));

			equiparHabilidad(humano, bestia, humano.getHabilidad());
		}

		humano.setHabilidad(humano.habilidades.get(habilidad));

		equiparHabilidad(humano, bestia, humano.getHabilidad());

	}

	public void equiparHabilidad(Humano humano, Monstruo bestia, Habilidad habilidad) {
		
		
		if (humano.getHabilidad().getNombre().equals("Intimidación")) {
			humano.setHabilidad(habilidad);
		}

		else if (humano.getHabilidad().getNombre().equals("Saludable")) {
			humano.setHabilidad(habilidad);
		}

		else if (humano.getHabilidad().getNombre().equals("Potencia")) {
			humano.setHabilidad(habilidad);
		}

		else if (humano.getHabilidad().getNombre().equals("Energetico")) {
			humano.setHabilidad(habilidad);
		}
		
		else if (humano.getHabilidad().getNombre().equals("Reforzado")) {
			humano.setHabilidad(habilidad);
		}

		else if (humano.getHabilidad().getNombre().equals("Eficiente")) {
			humano.setHabilidad(habilidad);
		}

		else if (humano.getHabilidad().getNombre().equals("Destreza magica")) {
			humano.setHabilidad(habilidad);
		}
		
		else if (humano.getHabilidad().getNombre().equals("Hoja afilada")) {
			humano.setHabilidad(habilidad);
		}
		
		else if (humano.getHabilidad().getNombre().equals("Cabeza pesada")) {
			humano.setHabilidad(habilidad);
		}
		
		else if (humano.getHabilidad().getNombre().equals("Punta de acero")) {
			humano.setHabilidad(habilidad);
		}
		
		else if (humano.getHabilidad().getNombre().equals("Vastago estable")) {
			humano.setHabilidad(habilidad);
		}
		
	}
	
	

	public void mejorarHabilidad(Humano humano, Monstruo bestia, Habilidad habilidad) {

		humano.habilidad.setNivel(habilidad.getNivel() + 1);

		System.out.println(
				"La habilidad " + humano.getHabilidad().getNombre() + " ha subido al nivel " + humano.getHabilidad().getNivel());

		humano.habilidad.setIntensidad(habilidad.getIntensidad() + 5);
		
		System.out.println("Intensidad de la habilidad " + humano.getHabilidad().getNombre() + ": " + humano.getHabilidad().getIntensidad());

		equiparHabilidad(humano, bestia, humano.getHabilidad());

	}

	public void ganarExperiencia(Humano humano) {

		humano.setExperiencia(humano.getExperiencia() + humano.getGananciaExperiencia());

		if (humano.getExperiencia() >= humano.experienciaLimite) {
			subirNivel(humano);

		}

	}

	public void subirNivel(Humano humano) {

		humano.setNivel(humano.getNivel() + 1);
		System.out.println("Has subido al nivel " + humano.getNivel());
		subirEstadisticas(humano);

	}

	public void subirEstadisticas(Humano humano) {

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
		return "Humano [\n" + "nombre=" + nombre + "\n" + "vida=" + vida + "\n" + "vidaMaxima=" + vidaMaxima + "\n"
				+ "fuerza=" + fuerza + "\n" + "arma=" + arma + "\n" + "energia=" + energia + "\n" + "energiaMaxima="
				+ energiaMaxima + "\n" + "defensa=" + defensa + "\n" + "hechizos=" + hechizos + "\n"
				+ "habilidad equipada= " + habilidad + "\n" + "nivel="
				+ nivel + "\n" + "experiencia=" + experiencia + "\n" + "gananciaExperiencia=" + gananciaExperiencia
				+ "\n" + "experienciaLimite=" + experienciaLimite + "\n" + "]";
	}

}
