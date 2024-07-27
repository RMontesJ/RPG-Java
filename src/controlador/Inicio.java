package controlador;

import java.util.Scanner;

import modelo.*;

public class Inicio {

	public static void main(String[] args) {

		Humano persona = new Humano();
		Monstruo monstruo = new Monstruo();

		Pelea combate = new Pelea(persona, monstruo);

		Hechizo llamarada = new Hechizo("Llamarada", 1, TipoHechizo.Ofensivo, 20, 10, "Lanza una rafaga de fuego");
		Hechizo gotaVital = new Hechizo("Gota vital", 1, TipoHechizo.Curativo, 5, 5,"Cubrete de un liquido magico que cura tus heridas");

		Arma martillo = new Arma("Martillo", 1, 5, TipoArma.Contundente, 10);
		
		Habilidad intimidación = new Habilidad("Intimidación", 1, "Reduce el ataque del enemigo", 10);
		Habilidad saludable = new Habilidad("Saludable", 1, "Aumenta tu salud maxima", 10);
		Habilidad potencia = new Habilidad("Potencia", 1, "Aumenta tu ataque", 10);
		Habilidad energetico = new Habilidad("Energetico", 1, "Aumenta tu energia maxima", 10);
		Habilidad reforzado = new Habilidad("Reforzado", 1, "Aumenta tu defensa", 5);
		Habilidad eficiente = new Habilidad("Eficiente", 1, "Reduce el coste de tus hechizos", 5);
		Habilidad destrezaMagica = new Habilidad("Destreza magica", 1, "Aumenta el poder de tus hechizos", 10);
		Habilidad expertoEnArmas = new Habilidad("Experto en armas", 1, "Aumenta el daño de tu arma", 10);
		Habilidad cuerpoFuerte = new Habilidad("Cuerpo fuerte", 1, "Reduce el peso de tu arma", 5);
		
		
		persona.meterHabilidad(intimidación);
		persona.meterHabilidad(saludable);
		persona.meterHabilidad(potencia);
		persona.meterHabilidad(energetico);
		persona.meterHabilidad(reforzado);
		persona.meterHabilidad(eficiente);
		persona.meterHabilidad(destrezaMagica);
		persona.meterHabilidad(expertoEnArmas);
		persona.meterHabilidad(cuerpoFuerte);

		persona.meterHechizo(llamarada, persona);
		persona.meterHechizo(gotaVital, persona);

		persona.equiparArma(persona, martillo);

		persona.ponerNombre(persona);

		persona.elegirHabilidad(persona, monstruo);

		int numeroCombate = 1;

		while (persona.getVida() > 0) {
			monstruo.ponerNombre(monstruo);
			combate.enfrentamiento(persona, monstruo, numeroCombate);

			if (persona.getVida() > 0) {
				combate.elegirRecompensa(combate, persona, martillo, llamarada, monstruo, numeroCombate);
				monstruo.ganarExperiencia(monstruo);
				monstruo.setVida(monstruo.getVidaMaxima());
				numeroCombate++;
			}

		}

	}

}
