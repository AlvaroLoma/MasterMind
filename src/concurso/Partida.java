package concurso;

public class Partida {
	static protected int intento;
	Jugador jugador1;
	Jugador jugador2;
	public Partida(Jugador jugador1, Jugador jugador2) {
		this.jugador1=jugador1;
		this.jugador2=jugador2;
		partidaDificil();
	}

	public int partidaDificil() {
		int ganador=0;
		boolean ganadorJ1 = false;
		boolean ganadorJ2 = false;
		boolean salir = false;
		jugador1.setCombSecreta(jugador1.crearCombSecreta());
		jugador2.setCombSecreta(jugador2.crearCombSecreta());
		do {
			ganadorJ1 = jugador1.buscarGanador(jugador1.comprobacion(jugador1.crearCombPropuesta()));
			ganadorJ2 = jugador2.buscarGanador(jugador1.comprobacion(jugador2.crearCombPropuesta()));
			dibujarTablero();
			
			if (ganadorJ1 && !ganadorJ2) {
				ganador=1;
					System.out.println("el Jugador: " + jugador1.getClass() + "Ha ganado");
					salir = true;
				
			}
			if (!ganadorJ1 && ganadorJ2) {
				System.out.println("el Jugador: " + jugador2.getClass() + "Ha ganado");
				ganador =2;
				salir = true;
			}
			
			aumentarIntento();
		} while (!salir);

		return ganador;
	}
	private void dibujarTablero() {
		//dibujar bonito
		jugador1.dibujarTablero(jugador1.resultado);
		jugador2.dibujarTablero(jugador2.resultado);
		
	}
	public void dibujar() {
		jugador1.dibujarFichero();
		jugador2.dibujarFichero();
		
	}
	public void aumentarIntento() {
		intento++;
	}
}
