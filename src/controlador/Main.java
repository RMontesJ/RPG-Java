package controlador;

import modelo.*;

public class Main {

	public static void main(String[] args) {
		
		Hechizo hechizo = new Hechizo("Explosion", 20);
		Hechizo hechizo1 = new Hechizo("Hipnosis", 5);
		
		Monstruo criatura = new Monstruo("Gigante",10, 80, 10);
		Monstruo bestia = new Monstruo("Manticora", 20, 100,20);
		
		Arma martillo  = new Arma("Martillo", 5);
		
		Humano persona = new Humano();
		
		// mete los hechizos al arraylist

		persona.meterHechizo(hechizo);
		persona.meterHechizo(hechizo1);
		persona.equiparArma(persona, martillo);
		
		
		Pelea combate = new Pelea();
		persona.ponerNombre(persona);
		persona.elegirHabilidad(persona);
		combate.enfrentamiento(persona, criatura, hechizo);
		combate.enfrentamiento2(persona, bestia, hechizo);
		
	}

}