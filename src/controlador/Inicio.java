package controlador;

import modelo.*;

public class Inicio {

	public static void main(String[] args) {
		
		Humano persona = new Humano();
		Monstruo monstruo = new Monstruo();
		
		Pelea combate = new Pelea(persona, monstruo);
		
		Hechizo explosion = new Hechizo("Explosion", 10, 10);
		Hechizo hipnosis = new Hechizo("Hipnosis", 5, 5);
		Hechizo gotaVital = new Hechizo("Gota vital", 5);
		
		Arma martillo = new Arma("Martillo", 5);
		
		persona.meterHechizo(explosion);
		persona.meterHechizo(hipnosis);
		persona.meterHechizo(gotaVital);
		
		persona.equiparArma(persona, martillo);
		
		persona.ponerNombre(persona);
		
		persona.elegirHabilidad(persona, monstruo);
		
		int numeroCombate = 1;
		
		while(persona.getVida() >= 0) {
			combate.enfrentamiento(persona, monstruo, explosion, numeroCombate);
			monstruo.setVida(monstruo.getVidaLimite());
			numeroCombate++;
			monstruo.ganarExperiencia(monstruo);
		}

	}


}
