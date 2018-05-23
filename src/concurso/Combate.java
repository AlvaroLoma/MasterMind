package concurso;

public class Combate {

	// Variables
	protected Jugador jugador1;
	protected Jugador jugador2;
	protected int rondasGanadasJ1;
	protected int rondasGanadasj2;
	static protected int RONDASMAXIMAS=5;
	
	
	// Constructor
	Combate(Jugador jugador1,Jugador jugador2) {
		this.jugador1=jugador1;
		this.jugador2=jugador2;
		rondasGanadasJ1=0;
		rondasGanadasj2=0;
		
		
	}
	// Métodos
	
	public Jugador getJugador1() {
		// TODO Auto-generated method stub
		return jugador1;
	}

	public Jugador getJugador2() {
		// TODO Auto-generated method stub
		return jugador2;
	}

	
}
