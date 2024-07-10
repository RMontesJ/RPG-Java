package controlador;

import modelo.*;

public class Inicio {

	public static void main(String[] args) {
		
		Humano persona = new Humano();
		Monstruo monstruo = new Monstruo();
		
		Pelea combate = new Pelea(persona, monstruo);
		
		Hechizo bolaDeFuego = new Hechizo("Bola de fuego", 1, TipoHechizo.Ofensivo, 10, 10, "Lanza una bola de fuego");
		Hechizo gotaVital = new Hechizo("Gota vital", 1, TipoHechizo.Curativo, 5, 5, "Cubrete de un liquido magico que cura tus heridas");
		
		Arma martillo = new Arma("Martillo", 1, 5);
		
		persona.meterHechizo(bolaDeFuego);
		persona.meterHechizo(gotaVital);
		
		persona.equiparArma(persona, martillo);
		
		persona.ponerNombre(persona);
		
		persona.elegirHabilidad(persona, monstruo);
		
		int numeroCombate = 1;
		
		while(persona.getVida() > 0) {
			monstruo.ponerNombre(monstruo);
			combate.enfrentamiento(persona, monstruo, bolaDeFuego, numeroCombate);
			
			if(persona.getVida() > 0) {
				combate.elegirRecompensa(combate, persona, martillo, bolaDeFuego);
				monstruo.ganarExperiencia(monstruo);
				monstruo.setVida(monstruo.getVidaMaxima());
				numeroCombate++;
			}
			
			
		}

	}


}
