package modelo;

import java.util.Scanner;

public class Pelea {

	private Humano humano;
	private Monstruo monstruo;

	public Pelea() {

	}

	public Pelea(Humano humano, Monstruo monstruo) {
		this.humano = humano;
		this.monstruo = monstruo;
	}

	public Humano getHumano() {
		return humano;
	}

	public void setHumano(Humano humano) {
		this.humano = humano;
	}

	public Monstruo getMonstruo() {
		return monstruo;
	}

	public void setMonstruo(Monstruo monstruo) {
		this.monstruo = monstruo;
	}

	public void enfrentamiento(Humano humano, Monstruo bestia, Hechizo hechizo, int numeroCombate) {
		
		System.out.println("Inicio del combate " + numeroCombate);
		System.out.println("---------------------------------------------");

		Scanner sc = new Scanner(System.in);
		while(humano.getVida() >= 0 && bestia.getVida() >= 0) {
			System.out.println("1- Atacar");
			System.out.println("2- Usar hechizo");
			System.out.println("3- Informacion de " + humano.getNombre());
			String opcion = "";
			opcion = sc.nextLine();
			if (opcion.equals("1")) {
				ataque(humano, bestia);
			}

			else if (opcion.equals("2")) {
				usarHechizo(humano, bestia);
			}

			else if (opcion.equals("3")) {
				System.out.println(humano);
			}

			if (bestia.getVida() <= 0) {
				
				humano.setVida(humano.getVidaLimite());
				humano.setEnergia(humano.getEnergiaLimite());
				humano.ganarExperiencia(humano, hechizo);
			}

			else if (humano.getVida() <= 0) {
				System.out.println("Has muerto. Fin de la partida");
			}
		}

	}

	public void ataque(Humano humano, Monstruo monstruo) {
		monstruo.setVida(monstruo.getVida() - humano.getFuerza());
		System.out.println(monstruo.getNombre() + " ha perdido " + humano.getFuerza() + " puntos de vida");
		humano.setVida(humano.getVida() - monstruo.getFuerza());
		System.out.println("Has perdido " + monstruo.getFuerza() + " puntos de vida");
		System.out.println(humano);
		System.out.println(monstruo);
	}

	public void usarHechizo(Humano humano, Monstruo monstruo) {
		Scanner sc = new Scanner(System.in);
		System.out.println("¿Que hechizo quieres usar?");
		humano.verHechizos();
		int posicion = sc.nextInt();

		System.out.println();
		System.out.println("Lanzas " + humano.hechizos.get(posicion).getNombre());
		System.out.println(
				monstruo.getNombre() + " ha perdido " + humano.hechizos.get(posicion).getAtaque() + " puntos de vida");
		monstruo.setVida(monstruo.getVida() - humano.hechizos.get(posicion).getAtaque());
		if (humano.hechizos.get(posicion).getNombre().equals("Hipnosis")) {
			monstruo.setFuerza(monstruo.getFuerza() - 1);
		}
		if (humano.hechizos.get(posicion).getNombre().equals("Gota vital")) {
			humano.setVida(humano.getVida() + 10);
		}
		humano.setEnergia(humano.getEnergia() - humano.hechizos.get(posicion).getCoste());
		System.out.println("El enemigo te ataca.");
		humano.setVida(humano.getVida() - monstruo.getFuerza());
		System.out.println("Has perdido " + monstruo.getFuerza() + " puntos de vida");
		System.out.println(humano);
		System.out.println(monstruo);
	}

	@Override
	public String toString() {
		return "Pelea [humano=" + humano + ", monstruo=" + monstruo + "]";
	}

}
