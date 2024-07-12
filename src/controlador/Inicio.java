package controlador;

import java.util.Scanner;

import modelo.*;

public class Inicio {

	public static void main(String[] args) {

		Humano persona = new Humano();
		Monstruo monstruo = new Monstruo();

		Pelea combate = new Pelea(persona, monstruo);

		Hechizo bolaDeFuego = new Hechizo("Bola de fuego", 1, TipoHechizo.Ofensivo, 20, 10, "Lanza una bola de fuego");
		Hechizo gotaVital = new Hechizo("Gota vital", 1, TipoHechizo.Curativo, 5, 5,
				"Cubrete de un liquido magico que cura tus heridas");

		Arma martillo = new Arma("Martillo", 1, 5, TipoArma.Contundente, 10);
		
		Habilidad intimidación = new Habilidad("Intimidación", 1, "Reduce el ataque del enemigo", 5);
		Habilidad saludable = new Habilidad("Saludable", 1, "Aumenta tu salud maxima", 5);
		Habilidad potencia = new Habilidad("Potencia", 1, "Aumenta tu ataque", 5);
		
		persona.meterHabilidad(intimidación);
		persona.meterHabilidad(saludable);
		persona.meterHabilidad(potencia);

		persona.meterHechizo(bolaDeFuego, persona);
		persona.meterHechizo(gotaVital, persona);

		persona.equiparArma(persona, martillo);

		persona.ponerNombre(persona);

		persona.elegirHabilidad(persona, monstruo);

		int numeroCombate = 1;

		while (persona.getVida() > 0) {
			monstruo.ponerNombre(monstruo);
			combate.enfrentamiento(persona, monstruo, numeroCombate);

			if (persona.getVida() > 0) {
				combate.elegirRecompensa(combate, persona, martillo, bolaDeFuego, monstruo);
				monstruo.ganarExperiencia(monstruo);
				monstruo.setVida(monstruo.getVidaMaxima());
				numeroCombate++;
			}

		}

	}

}
