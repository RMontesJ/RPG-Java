package modelo;

import java.util.*;

public class Pelea {

	private Humano humano;
	private Monstruo monstruo;
	public ArrayList<Recompensa> recompensas;

	public Pelea() {
		recompensas = new ArrayList<Recompensa>();
	}

	public Pelea(Humano humano, Monstruo monstruo) {
		this.humano = humano;
		this.monstruo = monstruo;
		recompensas = new ArrayList<Recompensa>();
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

		Scanner sc = new Scanner(System.in);
		
		String opcion = "";
		
		while (humano.getVida() > 0 && bestia.getVida() > 0 || !opcion.equals("1") &&  !opcion.equals("2") && !opcion.equals("3")) {
			System.out.println("---------------------------------------------");
			System.out.println("1- Atacar");
			System.out.println("2- Usar hechizo");
			System.out.println("3- Informacion de la partida");
			System.out.println("---------------------------------------------");
			
			opcion = sc.nextLine();
			if (opcion.equals("1")) {
				ataque(humano, bestia);
			}

			else if (opcion.equals("2")) {
				usarHechizo(humano, hechizo, bestia);
			}

			else if (opcion.equals("3")) {
				infoCombate(humano, bestia);
			}

			if (bestia.getVida() <= 0) {
				bestia.setVida(0);
				humano.ganarExperiencia(humano, hechizo);
			}

			else if (humano.getVida() <= 0) {
				System.out.println("Has muerto. Fin de la partida");
			}

		}
		
		

	}

	public void infoCombate(Humano humano, Monstruo bestia) {
		System.out.println("---------------------------------------------");
		System.out.println(humano);
		System.out.println("---------------------------------------------");
		System.out.println(bestia);
		System.out.println("---------------------------------------------");
	}

	public void ataque(Humano humano, Monstruo monstruo) {
		monstruo.setVida(monstruo.getVida() - (humano.getFuerza() + humano.getArma().getDaño()));
		System.out.println(monstruo.getNombre() + " ha perdido " + (humano.getFuerza() + humano.getArma().getDaño())
				+ " puntos de vida");
		humano.setVida(humano.getVida() - monstruo.getFuerza());
		System.out.println("Has perdido " + monstruo.getFuerza() + " puntos de vida");
		System.out.println("Vida de " + humano.getNombre() + ": " + humano.getVida());
		System.out.println("Vida de " + monstruo.getNombre() + ": " + monstruo.getVida());

	}

	public void usarHechizo(Humano humano, Hechizo hechizo, Monstruo monstruo) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("¿Que hechizo quieres usar?");
		humano.verHechizos();
		int posicion = sc.nextInt();
		
		while(posicion < 0 || posicion > humano.hechizos.size()) {
			System.out.println("¿Que hechizo quieres usar?");
			humano.verHechizos();
			posicion = sc.nextInt();
		}

		System.out.println();

		if (humano.hechizos.get(posicion).getTipo() == TipoHechizo.Curativo) {
			System.out.println("Lanzas " + humano.hechizos.get(posicion).getNombre());
			humano.setVida(humano.getVida() + humano.hechizos.get(posicion).getFuerza());
			System.out.println("Te has curado " + humano.hechizos.get(posicion).getFuerza() + " puntos de vida");

		}

		else {
			System.out.println("Lanzas " + humano.hechizos.get(posicion).getNombre());
			System.out.println(monstruo.getNombre() + " ha perdido " + humano.hechizos.get(posicion).getFuerza()
					+ " puntos de vida");
			monstruo.setVida(monstruo.getVida() - humano.hechizos.get(posicion).getFuerza());
		}

		humano.setEnergia(humano.getEnergia() - humano.hechizos.get(posicion).getCoste());
		System.out.println("El enemigo te ataca.");
		humano.setVida(humano.getVida() - monstruo.getFuerza());
		System.out.println("Has perdido " + monstruo.getFuerza() + " puntos de vida");
		System.out.println("Vida de " + humano.getNombre() + ": " + humano.getVida());
		System.out.println("Vida de " + monstruo.getNombre() + ": " + monstruo.getVida());

		if (humano.getEnergia() < hechizo.getCoste()) {
			System.out.println("No tienes energia suficiente para lanzar " + hechizo.getNombre());
		}

	}

	public void elegirRecompensa(Pelea combate, Humano humano, Arma arma, Hechizo hechizo) {
		Scanner sc = new Scanner(System.in);

		Recompensa pocion = new Recompensa("Pocion", "Recupera salud", 20);
		Recompensa polvoMagico = new Recompensa("Polvo magico", "Recupera energia", 15);
		Recompensa martilloDeHerrero = new Recompensa("Martillo de herrero", "Aumenta el nivel de tu arma", 1);
		Recompensa maestriaMagica = new Recompensa("Maestria magica", "Aumenta el nivel de uno de tus hechizos", 1);

		combate.insertarRecompensa(pocion);
		combate.insertarRecompensa(polvoMagico);
		combate.insertarRecompensa(martilloDeHerrero);
		combate.insertarRecompensa(maestriaMagica);

		int aleatorio1 = (int) (Math.random() * recompensas.size());
		int aleatorio2 = (int) (Math.random() * recompensas.size());
		int aleatorio3 = (int) (Math.random() * recompensas.size());

		Recompensa recompensa1 = combate.recompensas.get(aleatorio1);
		Recompensa recompensa2 = combate.recompensas.get(aleatorio2);
		Recompensa recompensa3 = combate.recompensas.get(aleatorio3);

		String eleccion = "";

		Recompensa recompensaElegida = null;

		while (!eleccion.equals("1") && !eleccion.equals("2") && !eleccion.equals("3")) {

			System.out.println("Has ganado.Elige tu recompensa");

			System.out.println("1. " + recompensa1);
			System.out.println("2. " + recompensa2);
			System.out.println("3. " + recompensa3);

			eleccion = sc.nextLine();

			if (eleccion.equals("1")) {
				recompensaElegida = recompensa1;
			} else if (eleccion.equals("2")) {
				recompensaElegida = recompensa2;
			} else if (eleccion.equals("3")) {
				recompensaElegida = recompensa3;
			}

			if (recompensaElegida.getNombre().equals("Pocion")) {
				humano.setVida(humano.getVida() + pocion.getEfecto());
				if (humano.getVida() > humano.getVidaMaxima()) {
					humano.setVida(humano.getVidaMaxima());
				}
			}

			else if (recompensaElegida.getNombre().equals("Polvo magico")) {
				humano.setEnergia(humano.getEnergia() + polvoMagico.getEfecto());
				if (humano.getEnergia() > humano.getEnergiaMaxima()) {
					humano.setEnergia(humano.getEnergiaMaxima());
				}
			}

			else if (recompensaElegida.getNombre().equals("Martillo de herrero")) {
				arma.subirNivel(arma);

			}

			else if (recompensaElegida.getNombre().equals("Maestria magica")) {

				System.out.println("Elige el hechizo que quieres mejorar");

				int posicion = 0;

				humano.verHechizos();

				posicion = sc.nextInt();

				Hechizo hechizoElegido = humano.hechizos.get(posicion);

				hechizo.subirNivel(hechizoElegido);
			}

		}

	}

	public void insertarRecompensa(Recompensa premio) {
		recompensas.add(premio);
	}

	@Override
	public String toString() {
		return "Pelea [humano=" + humano + ", monstruo=" + monstruo + "]";
	}

}
