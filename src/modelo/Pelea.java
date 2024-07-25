package modelo;

import java.util.*;

public class Pelea {

	private Humano humano;
	private Monstruo monstruo;
	public ArrayList<Potenciador> potenciadores;
	public ArrayList<Arma> armaRecompensa;
	public ArrayList<Hechizo> hechizoRecompensa;

	public Pelea() {
		potenciadores = new ArrayList<Potenciador>();
		armaRecompensa = new ArrayList<Arma>();
		hechizoRecompensa = new ArrayList<Hechizo>();
	}

	public Pelea(Humano humano, Monstruo monstruo) {
		this.humano = humano;
		this.monstruo = monstruo;
		potenciadores = new ArrayList<Potenciador>();
		armaRecompensa = new ArrayList<Arma>();
		hechizoRecompensa = new ArrayList<Hechizo>();
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

	public ArrayList<Potenciador> getPotenciadores() {
		return potenciadores;
	}

	public void setPotenciadores(ArrayList<Potenciador> potenciadores) {
		this.potenciadores = potenciadores;
	}

	public ArrayList<Arma> getArmaRecompensa() {
		return armaRecompensa;
	}

	public void setArmaRecompensa(ArrayList<Arma> armaRecompensa) {
		this.armaRecompensa = armaRecompensa;
	}

	public ArrayList<Hechizo> getHechizoRecompensa() {
		return hechizoRecompensa;
	}

	public void setHechizoRecompensa(ArrayList<Hechizo> hechizoRecompensa) {
		this.hechizoRecompensa = hechizoRecompensa;
	}

	public void enfrentamiento(Humano humano, Monstruo bestia, int numeroCombate) {

		System.out.println("Inicio del combate " + numeroCombate);

		Scanner sc = new Scanner(System.in);

		String opcion = "";

		while (humano.getVida() > 0 && bestia.getVida() > 0
				|| !opcion.equals("1") && !opcion.equals("2") && !opcion.equals("3")) {
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
				usarHechizo(humano, bestia);
			}

			else if (opcion.equals("3")) {
				infoCombate(humano, bestia);
			}

			if (bestia.getVida() <= 0) {
				bestia.setVida(0);
				humano.ganarExperiencia(humano);
			}

			// limitar el efecto de Intimidacion
			if (bestia.getFuerza() <= humano.getDefensa()) {
				bestia.setFuerza(humano.getDefensa() + 5);
				System.out.println("No se puede bajar mas el ataque del enemigo");
			}

			// limitar el efecto de Saludable
			if (humano.getVida() > humano.getVidaMaxima()) {
				humano.setVida(humano.getVidaMaxima());
			}
			// limitar el efecto de Energetico
			if (humano.getEnergia() > humano.getEnergiaMaxima()) {
				humano.setEnergia(humano.getEnergiaMaxima());
			}
			// limitar el efecto de Reforzado
			if (humano.getDefensa() >= bestia.getFuerza()) {
				humano.setDefensa(bestia.getFuerza() - 5);
				System.out.println("No se puede aumentar mas tu defensa");
			}
			// limitar el efecto de Cuerpo fuerte
			if (humano.getArma().getPeso() < 0) {
				humano.getArma().setPeso(0);
				System.out.println("No se puede reducir mas el peso de esta arma");
			}

			if (humano.getVida() <= 0) {
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

		if (monstruo.getVida() <= 0) {
			monstruo.setVida(0);
		} else {
			ataqueMonstruo(humano, monstruo);
		}

		System.out.println("Vida de " + humano.getNombre() + ": " + humano.getVida());
		System.out.println("Energia de " + humano.getNombre() + ": " + humano.getEnergia());
		System.out.println("Vida de " + monstruo.getNombre() + ": " + monstruo.getVida());

	}

	public void usarHechizo(Humano humano, Monstruo monstruo) {
		Scanner sc = new Scanner(System.in);

		System.out.println("¿Que hechizo quieres usar?");
		humano.verHechizos();
		int posicion = sc.nextInt();

		while (posicion < 0 || posicion > humano.hechizos.size()) {
			System.out.println("¿Que hechizo quieres usar?");
			humano.verHechizos();
			posicion = sc.nextInt();
		}

		System.out.println();

		if (humano.getEnergia() < humano.hechizos.get(posicion).getCoste()) {
			System.out.println("No tienes energia suficiente para lanzar " + humano.hechizos.get(posicion).getNombre());
		}

		else {
			if (humano.hechizos.get(posicion).getTipo() == TipoHechizo.Curativo) {
				System.out.println("Lanzas " + humano.hechizos.get(posicion).getNombre());
				humano.setVida(humano.getVida() + humano.hechizos.get(posicion).getFuerza());
				System.out.println("Te has curado " + humano.hechizos.get(posicion).getFuerza() + " puntos de vida");

			} else if (humano.hechizos.get(posicion).getTipo() == TipoHechizo.Refuerzo) {
				System.out.println("Lanzas " + humano.hechizos.get(posicion).getNombre());

				if (humano.hechizos.get(posicion).getNombre().equals("Meditación")) {
					humano.setVida(humano.getVida() + humano.hechizos.get(posicion).getFuerza());
					humano.setFuerza(humano.getFuerza() + humano.hechizos.get(posicion).getFuerza());
				} else if (humano.hechizos.get(posicion).getNombre().equals("Fortaleza")) {
					humano.setDefensa(humano.getDefensa() + humano.hechizos.get(posicion).getFuerza());
					if (humano.getDefensa() >= monstruo.getFuerza()) {
						humano.setDefensa(humano.getDefensa() - 5);
						System.out.println("No se puede aumentar mas tu defensa");
					}
				}
			}

			else if (humano.hechizos.get(posicion).getTipo() == TipoHechizo.Ofensivo) {
				System.out.println("Lanzas " + humano.hechizos.get(posicion).getNombre());
				monstruo.setVida(monstruo.getVida() - humano.hechizos.get(posicion).getFuerza());
				System.out.println(monstruo.getNombre() + " ha perdido " + humano.hechizos.get(posicion).getFuerza()
						+ " puntos de vida");

			}

			humano.setEnergia(humano.getEnergia() - humano.hechizos.get(posicion).getCoste());

		}

		if (monstruo.getVida() <= 0) {
			monstruo.setVida(0);
		} else {
			ataqueMonstruo(humano, monstruo);
		}

		if (humano.getEnergia() <= 0) {
			humano.setEnergia(0);
		}

		System.out.println("Vida de " + humano.getNombre() + ": " + humano.getVida());
		System.out.println("Vida de " + monstruo.getNombre() + ": " + monstruo.getVida());

	}

	public void ataqueMonstruo(Humano humano, Monstruo bestia) {

		System.out.println("El enemigo te ataca.");
		humano.setVida(humano.getVida() - (bestia.getFuerza() - humano.getDefensa()));
		System.out.println("Has perdido " + (bestia.getFuerza() - humano.getDefensa()) + " puntos de vida");

	}

	public void elegirRecompensa(Pelea combate, Humano humano, Arma arma, Hechizo hechizo, Monstruo bestia) {
		Scanner sc = new Scanner(System.in);

		Potenciador pocion = new Potenciador("Pocion", "Recupera salud", 20);
		Potenciador polvoMagico = new Potenciador("Polvo magico", "Recupera energia", 15);
		Potenciador martilloDeHerrero = new Potenciador("Martillo de herrero", "Aumenta el nivel de tu arma", 1);
		Potenciador maestriaMagica = new Potenciador("Maestria magica", "Aumenta el nivel de uno de tus hechizos", 1);
		Potenciador mutaPiedra = new Potenciador("MutaPiedra", "Cambia tu habilidad actual", 1);
		Potenciador realzaPoder = new Potenciador("RealzaPoder", "Mejora el nivel de tu habilidad", 1);

		Arma cuchillo = new Arma("Cuchillo", 1, 5, TipoArma.Cortante, 2);
		Arma espada = new Arma("Espada", 1, 10, TipoArma.Cortante, 6);
		Arma filoCelestial = new Arma("Filo celestial", 1, 15, TipoArma.Cortante, 10);

		Arma sai = new Arma("Sai", 1, 5, TipoArma.Punzante, 3);
		Arma lanza = new Arma("Lanza", 1, 10, TipoArma.Punzante, 8);
		Arma puntaDelDestino = new Arma("Punta del destino", 1, 15, TipoArma.Punzante, 11);

		Arma arco = new Arma("Arco", 1, 5, TipoArma.LargaDistancia, 3);
		Arma ballesta = new Arma("Ballesta", 1, 10, TipoArma.LargaDistancia, 7);
		Arma javalinaDivina = new Arma("Javalina divina", 1, 15, TipoArma.LargaDistancia, 9);

		Arma porra = new Arma("Porra", 1, 5, TipoArma.Contundente, 5);
		Arma martillo = new Arma("Martillo", 1, 10, TipoArma.Contundente, 10);
		Arma mazaDemoniaca = new Arma("Maza demoniaca", 1, 20, TipoArma.Contundente, 15);

		Hechizo relampago = new Hechizo("Relampago", 1, TipoHechizo.Ofensivo, 30, 15, "Lanza una descarga electrica");
		Hechizo pedrada = new Hechizo("Pedrada", 1, TipoHechizo.Ofensivo, 30, 15, "Usa rocas para atacar");
		Hechizo golpeOscuro = new Hechizo("Golpe oscuro", 1, TipoHechizo.Ofensivo, 20, 10,"Concentra energia oscura para lanzar un golpe");
		Hechizo ondaPsiquica = new Hechizo("Onda psiquica", 1, TipoHechizo.Ofensivo, 40, 25,"Ataca con unas ondas de energia psiquica");
		Hechizo meditación = new Hechizo("Meditación", 1, TipoHechizo.Refuerzo, 10, 10,"Relaja tu mente para recuperar vida y aumentar tu ataque");
		Hechizo fortaleza = new Hechizo("Fortaleza", 1, TipoHechizo.Refuerzo, 10, 10,"Endurece tu cuerpo para aumentar tu defensa");
		
		Hechizo llamarada = new Hechizo("Llamarada", 1, TipoHechizo.Ofensivo, 20, 10, "Lanza una rafaga de fuego");
		Hechizo gotaVital = new Hechizo("Gota vital", 1, TipoHechizo.Curativo, 5, 5,"Cubrete de un liquido magico que cura tus heridas");

		combate.insertarPotenciador(pocion);
		combate.insertarPotenciador(polvoMagico);
		combate.insertarPotenciador(martilloDeHerrero);
		combate.insertarPotenciador(maestriaMagica);
		combate.insertarPotenciador(mutaPiedra);
		combate.insertarPotenciador(realzaPoder);

		combate.insertarArmaRecompensa(cuchillo);
		combate.insertarArmaRecompensa(espada);
		combate.insertarArmaRecompensa(filoCelestial);

		combate.insertarArmaRecompensa(sai);
		combate.insertarArmaRecompensa(lanza);
		combate.insertarArmaRecompensa(puntaDelDestino);

		combate.insertarArmaRecompensa(arco);
		combate.insertarArmaRecompensa(ballesta);
		combate.insertarArmaRecompensa(javalinaDivina);

		combate.insertarArmaRecompensa(porra);
		combate.insertarArmaRecompensa(martillo);
		combate.insertarArmaRecompensa(mazaDemoniaca);

		combate.insertarHechizoRecompensa(relampago);
		combate.insertarHechizoRecompensa(pedrada);
		combate.insertarHechizoRecompensa(golpeOscuro);
		combate.insertarHechizoRecompensa(ondaPsiquica);
		combate.insertarHechizoRecompensa(meditación);
		combate.insertarHechizoRecompensa(fortaleza);
		combate.insertarHechizoRecompensa(llamarada);
		combate.insertarHechizoRecompensa(gotaVital);

		int aleatorio1 = (int) (Math.random() * potenciadores.size());
		int aleatorio2 = (int) (Math.random() * potenciadores.size());
		int aleatorio3 = (int) (Math.random() * potenciadores.size());
		int aleatorio4 = (int) (Math.random() * armaRecompensa.size());
		int aleatorio5 = (int) (Math.random() * hechizoRecompensa.size());

		Potenciador recompensa1 = combate.potenciadores.get(aleatorio1);
		Potenciador recompensa2 = combate.potenciadores.get(aleatorio2);
		Potenciador recompensa3 = combate.potenciadores.get(aleatorio3);
		Arma recompensa4 = combate.armaRecompensa.get(aleatorio4);
		Hechizo recompensa5 = combate.hechizoRecompensa.get(aleatorio5);

		String eleccion = "";

		while (!eleccion.equals("1") && !eleccion.equals("2") && !eleccion.equals("3") && !eleccion.equals("4")
				&& !eleccion.equals("5")) {

			System.out.println("Has ganado.Elige tu recompensa");

			System.out.println("1. " + recompensa1);
			System.out.println();
			System.out.println("2. " + recompensa2);
			System.out.println();
			System.out.println("3. " + recompensa3);
			System.out.println();
			System.out.println("4. " + recompensa4);
			System.out.println();
			System.out.println("5. " + recompensa5);

			eleccion = sc.nextLine();

			// potenciadores

			if (eleccion.equals("1") || eleccion.equals("2") || eleccion.equals("3")) {

				if (eleccion.equals("1")) {

					if (recompensa1.getNombre().equals("Pocion")) {
						humano.setVida(humano.getVida() + pocion.getEfecto());
						if (humano.getVida() > humano.getVidaMaxima()) {
							humano.setVida(humano.getVidaMaxima());
						}
					}

					else if (recompensa1.getNombre().equals("Polvo magico")) {
						humano.setEnergia(humano.getEnergia() + polvoMagico.getEfecto());
						if (humano.getEnergia() > humano.getEnergiaMaxima()) {
							humano.setEnergia(humano.getEnergiaMaxima());
						}
					}

					else if (recompensa1.getNombre().equals("Martillo de herrero")) {
						arma.subirNivel(arma);

					}

					else if (recompensa1.getNombre().equals("Maestria magica")) {

						int posicion = -1; // Inicializamos con un valor fuera del rango válido

						do {
							System.out.println("Elige el hechizo que quieres mejorar");

							humano.verHechizos();

							if (sc.hasNextInt()) { // Verificar si la entrada es un entero
								posicion = sc.nextInt();
								if (posicion >= 0 && posicion < humano.hechizos.size()) {
									Hechizo hechizoElegido = humano.hechizos.get(posicion);
									hechizo.subirNivel(hechizoElegido);
								} else {
									System.out.println("Posición inválida. Por favor, elige un número entre 0 y "
											+ (humano.hechizos.size() - 1));
									humano.verHechizos();
								}
							} else {
								System.out.println("Entrada inválida. Por favor, ingresa un número.");
								sc.next(); // Limpiar la entrada inválida
							}
						} while (posicion < 0 || posicion >= humano.hechizos.size());

					}

					else if (recompensa1.getNombre().equals("MutaPiedra")) {
						humano.desequiparHabilidad(humano, bestia);
					}

					else if (recompensa1.getNombre().equals("RealzaPoder")) {
						humano.mejorarHabilidad(humano, bestia, humano.getHabilidad());
						humano.equiparHabilidad(humano, bestia, humano.getHabilidad());
					}

				}

				if (eleccion.equals("2")) {

					if (recompensa2.getNombre().equals("Pocion")) {
						humano.setVida(humano.getVida() + pocion.getEfecto());
						if (humano.getVida() > humano.getVidaMaxima()) {
							humano.setVida(humano.getVidaMaxima());
						}
					}

					else if (recompensa2.getNombre().equals("Polvo magico")) {
						humano.setEnergia(humano.getEnergia() + polvoMagico.getEfecto());
						if (humano.getEnergia() > humano.getEnergiaMaxima()) {
							humano.setEnergia(humano.getEnergiaMaxima());
						}
					}

					else if (recompensa2.getNombre().equals("Martillo de herrero")) {
						arma.subirNivel(arma);

					}

					else if (recompensa2.getNombre().equals("Maestria magica")) {

						int posicion = -1; // Inicializamos con un valor fuera del rango válido

						do {
							System.out.println("Elige el hechizo que quieres mejorar");

							humano.verHechizos();

							if (sc.hasNextInt()) { // Verificar si la entrada es un entero
								posicion = sc.nextInt();
								if (posicion >= 0 && posicion < humano.hechizos.size()) {
									Hechizo hechizoElegido = humano.hechizos.get(posicion);
									hechizo.subirNivel(hechizoElegido);
								} else {
									System.out.println("Posición inválida. Por favor, elige un número entre 0 y "
											+ (humano.hechizos.size() - 1));
									humano.verHechizos();
								}
							} else {
								System.out.println("Entrada inválida. Por favor, ingresa un número.");
								sc.next(); // Limpiar la entrada inválida
							}
						} while (posicion < 0 || posicion >= humano.hechizos.size());

					}

					else if (recompensa2.getNombre().equals("MutaPiedra")) {
						humano.desequiparHabilidad(humano, bestia);
					}

					else if (recompensa2.getNombre().equals("RealzaPoder")) {
						humano.mejorarHabilidad(humano, bestia, humano.getHabilidad());
						humano.equiparHabilidad(humano, bestia, humano.getHabilidad());
					}

				} else if (eleccion.equals("3")) {

					if (recompensa3.getNombre().equals("Pocion")) {
						humano.setVida(humano.getVida() + pocion.getEfecto());
						if (humano.getVida() > humano.getVidaMaxima()) {
							humano.setVida(humano.getVidaMaxima());
						}
					}

					else if (recompensa3.getNombre().equals("Polvo magico")) {
						humano.setEnergia(humano.getEnergia() + polvoMagico.getEfecto());
						if (humano.getEnergia() > humano.getEnergiaMaxima()) {
							humano.setEnergia(humano.getEnergiaMaxima());
						}
					}

					else if (recompensa3.getNombre().equals("Martillo de herrero")) {
						arma.subirNivel(arma);

					}

					else if (recompensa3.getNombre().equals("Maestria magica")) {

						int posicion = -1; // Inicializamos con un valor fuera del rango válido

						do {
							System.out.println("Elige el hechizo que quieres mejorar");

							humano.verHechizos();

							if (sc.hasNextInt()) { // Verificar si la entrada es un entero
								posicion = sc.nextInt();
								if (posicion >= 0 && posicion < humano.hechizos.size()) {
									Hechizo hechizoElegido = humano.hechizos.get(posicion);
									hechizo.subirNivel(hechizoElegido);
								} else {
									System.out.println("Posición inválida. Por favor, elige un número entre 0 y "
											+ (humano.hechizos.size() - 1));
									humano.verHechizos();
								}
							} else {
								System.out.println("Entrada inválida. Por favor, ingresa un número.");
								sc.next(); // Limpiar la entrada inválida
							}
						} while (posicion < 0 || posicion >= humano.hechizos.size());

					}

					else if (recompensa3.getNombre().equals("MutaPiedra")) {
						humano.desequiparHabilidad(humano, bestia);
					}

					else if (recompensa3.getNombre().equals("RealzaPoder")) {
						humano.mejorarHabilidad(humano, bestia, humano.getHabilidad());
						humano.equiparHabilidad(humano, bestia, humano.getHabilidad());
					}

				}
				// armas

			} else if (eleccion.equals("4")) {

				if (recompensa4.getNombre().equals("Cuchillo")) {
					humano.equiparArma(humano, recompensa4);
					humano.actualizarArma(humano, recompensa4);
				}

				else if (recompensa4.getNombre().equals("Espada")) {
					humano.equiparArma(humano, recompensa4);
					humano.actualizarArma(humano, recompensa4);
				}

				else if (recompensa4.getNombre().equals("Filo celestial")) {
					humano.equiparArma(humano, recompensa4);
					humano.actualizarArma(humano, recompensa4);
				}

				else if (recompensa4.getNombre().equals("Sai")) {
					humano.equiparArma(humano, recompensa4);
					humano.actualizarArma(humano, recompensa4);
				}

				else if (recompensa4.getNombre().equals("Lanza")) {
					humano.equiparArma(humano, recompensa4);
					humano.actualizarArma(humano, recompensa4);
				}

				else if (recompensa4.getNombre().equals("Punta del destino")) {
					humano.equiparArma(humano, recompensa4);
					humano.actualizarArma(humano, recompensa4);
				}

				else if (recompensa4.getNombre().equals("Porra")) {
					humano.equiparArma(humano, recompensa4);
					humano.actualizarArma(humano, recompensa4);
				}

				else if (recompensa4.getNombre().equals("Martillo")) {
					humano.equiparArma(humano, recompensa4);
					humano.actualizarArma(humano, recompensa4);
				}

				else if (recompensa4.getNombre().equals("Maza demoniaca")) {
					humano.equiparArma(humano, recompensa4);
					humano.actualizarArma(humano, recompensa4);
				}

				else if (recompensa4.getNombre().equals("Arco")) {
					humano.equiparArma(humano, recompensa4);
					humano.actualizarArma(humano, recompensa4);
				}

				else if (recompensa4.getNombre().equals("Ballesta")) {
					humano.equiparArma(humano, recompensa4);
					humano.actualizarArma(humano, recompensa4);
				}

				else if (recompensa4.getNombre().equals("Javalina divina")) {
					humano.equiparArma(humano, recompensa4);
					humano.actualizarArma(humano, recompensa4);
				}

				// hechizos

			} else if (eleccion.equals("5")) {
				if (recompensa5.getNombre().equals("Relampago")) {
					humano.meterHechizo(recompensa5, humano);
					humano.actualizarHechizo(humano, recompensa5);
				}

				else if (recompensa5.getNombre().equals("Pedrada")) {
					humano.meterHechizo(recompensa5, humano);
					humano.actualizarHechizo(humano, recompensa5);
				}

				else if (recompensa5.getNombre().equals("Golpe oscuro")) {
					humano.meterHechizo(recompensa5, humano);
					humano.actualizarHechizo(humano, recompensa5);
				}

				else if (recompensa5.getNombre().equals("Onda psiquica")) {
					humano.meterHechizo(recompensa5, humano);
					humano.actualizarHechizo(humano, recompensa5);
				}

				else if (recompensa5.getNombre().equals("Meditación")) {
					humano.meterHechizo(recompensa5, humano);
					humano.actualizarHechizo(humano, recompensa5);
				}

				else if (recompensa5.getNombre().equals("Fortaleza")) {
					humano.meterHechizo(recompensa5, humano);
					humano.actualizarHechizo(humano, recompensa5);
				}

				else if (recompensa5.getNombre().equals("Gota vital")) {
					humano.meterHechizo(recompensa5, humano);
					humano.actualizarHechizo(humano, recompensa5);
				}

				else if (recompensa5.getNombre().equals("Llamarada")) {
					humano.meterHechizo(recompensa5, humano);
					humano.actualizarHechizo(humano, recompensa5);
				}

			}
		}

	}

	public void insertarPotenciador(Potenciador premio) {
		potenciadores.add(premio);
	}

	public void insertarArmaRecompensa(Arma arma) {
		armaRecompensa.add(arma);
	}

	public void insertarHechizoRecompensa(Hechizo hechizo) {
		hechizoRecompensa.add(hechizo);
	}

	@Override
	public String toString() {
		return "Pelea [humano=" + humano + ", monstruo=" + monstruo + "]";
	}

}
