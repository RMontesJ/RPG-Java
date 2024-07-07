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
	
	public void enfrentamiento(Humano humano,Monstruo bestia, Hechizo hechizo) {
		System.out.println("Inicio del combate 1");
		
		if(humano.habilidad.equals("Intimidación")) {
			bestia.setFuerza(bestia.getFuerza() - 5);
			System.out.println("Tu habilidad ha bajado el ataque del enemigo");
		}
		
		else if(humano.habilidad.equals("Saludable")) {
			humano.setVida(humano.getVida() + 10);
			System.out.println("Tu habilidad te ofrece mas vida");
		}
		
		else if(humano.habilidad.equals("Potencia")) {
			humano.setFuerza(humano.getFuerza() + 5);
			System.out.println("Tu habilidad ha aumentado tu ataque");
		}
		Scanner sc = new Scanner(System.in);
		while(humano.getVida() > 0 && bestia.getVida() > 0) {
			System.out.println("1- Atacar");
			System.out.println("2- Usar hechizo");
			System.out.println("3- Informacion de " + humano.getNombre());
			String opcion = "";
			opcion = sc.nextLine();
			if(opcion.equals("1") ) {
				ataque(humano, bestia);
			}
			
			else if(opcion.equals("2")) {
				hechizo(humano, hechizo, bestia);
			}
			
			else if(opcion.equals("3")) {
			System.out.println(humano);
			}
			
		}
		
		if(bestia.getVida() <= 0) {
			humano.setVida(50);
		}
		
	}
	
	public void ataque(Humano humano, Monstruo monstruo) {
		monstruo.setVida(monstruo.getVida() - humano.getFuerza());
		System.out.println("El "+ monstruo.getNombre() + " ha perdido " + humano.getFuerza() + " puntos de vida");
		humano.setVida(humano.getVida() - monstruo.getFuerza());
		System.out.println("Has perdido " + monstruo.getFuerza() + " puntos de vida");
		System.out.println(humano);
		System.out.println(monstruo);
	}
	
	public void hechizo(Humano humano, Hechizo hechizo, Monstruo monstruo) {
		Scanner sc = new Scanner(System.in);
		System.out.println("¿Que hechizo quieres usar?");
		humano.verHechizos();
		int posicion = sc.nextInt();
		
		System.out.println();
		System.out.println("Lanzas " + humano.hechizos.get(posicion).getNombre());
		System.out.println("El" + monstruo.getNombre() + " ha perdido " + humano.hechizos.get(posicion).getAtaque() + " puntos de vida");
		monstruo.setVida(monstruo.getVida() - humano.hechizos.get(posicion).getAtaque());
		if(humano.hechizos.get(posicion).getNombre().equals("Hipnosis")) {
			monstruo.setFuerza(monstruo.getFuerza() - 1);
		}
		System.out.println(humano);
		System.out.println(monstruo);
	}
	
	
	public void enfrentamiento2(Humano humano,Monstruo monstruo, Hechizo hechizo){
		System.out.println("Inicio del combate 2");
		Scanner sc = new Scanner(System.in);
		while(humano.getVida() > 0 && monstruo.getVida() > 0) {
			System.out.println("1- Atacar");
			System.out.println("2- Usar hechizo");
			System.out.println("3- Transformarse");
			System.out.println("4- Informacion de " + humano.getNombre());
			String opcion = "";
			opcion = sc.nextLine();
			if(opcion.equals("1") ) {
				ataque(humano, monstruo);
			}
			
			else if(opcion.equals("2")) {
				hechizo(humano, hechizo, monstruo);
			}
			else if(opcion.equals("3")) {
				transformacion(humano);
			}
			else if(opcion.equals("4")) {
				System.out.println(humano);
			}
			
		}
	}
	
	public void transformacion(Humano humano) {
		
		if(humano.isTransformacion() == false) {
			System.out.println("Te has transformado");
			humano.setTransformacion(true);
			if(humano.isTransformacion() == true) {
				humano.setFuerza(humano.getFuerza() + 10); 
			}
		}
	}
	
	@Override
	public String toString() {
		return "Pelea [humano=" + humano + ", monstruo=" + monstruo + "]";
	}
	
	
	
}
