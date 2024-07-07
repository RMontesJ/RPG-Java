package modelo;

public class Bestia {
	

	public class Monstruo {

		private int vida;
		private int fuerza;
		private int aguante;

		public Monstruo() {
			this.fuerza = 20;
			this.vida = 100;
			this.aguante = 20;
		}
		
		public Monstruo(int fuerza, int vida, int aguante) {
			this.fuerza = fuerza;
			this.vida = vida;
			this.aguante = aguante;
		}
		
		public int getFuerza() {
			return fuerza;
		}
		
		public void setFuerza(int fuerza) {
			this.fuerza = fuerza;
		}
		
		public int getVida() {
			return vida;
		}
		
		public void setVida(int vida) {
			this.vida = vida;
		}
		
		public int getAguante() {
			return aguante;
		}
		
		public void setAguante(int aguante) {
			this.aguante = aguante;
		}
		
		public int ataque() {
			int ataque = fuerza - vida;
			return ataque;
		}
		
		public int defensa(Humano a) {
			int defensa = vida - a.getFuerza();
			
			return defensa;
		}

		@Override
		public String toString() {
			return "Monstruo [vida=" + vida + ", fuerza=" + fuerza + ", aguante=" + aguante + "]";
		}

		
		
	}

}
