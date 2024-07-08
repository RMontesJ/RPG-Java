package controlador;

import modelo.*;

public class Inicio {

	public static void main(String[] args) {
		
		Humano persona = new Humano();
		Monstruo monstruo = new Monstruo("Gigante", 10, 40, 10);
		Monstruo criatura = new Monstruo("Manticora", 15, 55, 20);
		
		Pelea combate = new Pelea(persona, monstruo);
		
		Hechizo explosion = new Hechizo("Explosion", 10, 10);
		Hechizo hipnosis = new Hechizo("Hipnosis", 5, 5);
		Hechizo gotaVital = new Hechizo("Gota vital", 0, 5);
		
		Arma martillo = new Arma("Martillo", 5);
		
		persona.meterHechizo(explosion);
		persona.meterHechizo(hipnosis);
		persona.meterHechizo(gotaVital);
		
		persona.equiparArma(persona, martillo);
		
		persona.ponerNombre(persona);
		
		persona.elegirHabilidad(persona);
		
		combate.enfrentamiento(persona, monstruo, explosion);
		combate.enfrentamiento2(persona, criatura, explosion);

	}


}
