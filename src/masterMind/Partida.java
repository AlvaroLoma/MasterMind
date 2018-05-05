package masterMind;

import java.util.ArrayList;

/**
 * Clase partida controla la partida del juego, los intentos y las comprobaciones asi como los tableros
 * @author Alvaro Lodeiro
 *
 */
public class Partida {
	/**
	 * Tablero del jugador 1
	 */
	protected Tablero tablero;
	/**
	 * Tablero del jugador 2
	 */
	protected Tablero tablero2;
	/**
	 * Modo de juego 
	 */
	private ModoJuego modo;

	/**
	 * Crea una nueva partida
	 * @param modo de juego
	 */
	public Partida(ModoJuego modo) {
		this.modo = modo;
		tablero = new Tablero(modo);
		tablero2 = new Tablero(modo);

	}

	/**
	 * Carga una comprobacion en un tablero
	 * @param comprobarCombinacion comprobacion para cargar en el tablero
	 */
	public void comprobacion(ArrayList<String> comprobarCombinacion) {
		tablero.comprobacion(comprobarCombinacion);

	}

	/**
	 * Busca si el jugador 1 ha ganado la partida
	 * @return devuelve si el tablero  ha completado la partida
	 */
	public boolean buscarGanador() {
		return tablero.buscarGanador();

	}

	/**
	 * Aumenta un intento en el tablero
	 */
	public void aumentarIntento() {
		tablero.aumentoIntento();
	}

	/**
	 * Comprueba si quedan intentos
	 * @return si quedan o no intentos
	 */
	public boolean quedanIntentos() {

		return tablero.quedanIntentos(modo.getIntentos());
	}

	/**
	 * Carga una comprobacion en el tablero
	 * @param comprobarCombinacion comprobacion a cargar en el tablero
	 */
	public void comprobacionM(ArrayList<String> comprobarCombinacion) {

		tablero2.comprobacion(comprobarCombinacion);

	}

	/**
	 * Llama a metodo para dibujar los dos tableros
	 */
	public void dibujarTableroDoble() {
		tablero.dibujarTableros(tablero, tablero2);

	}

	/**
	 * Comprueba que jugador ha tenido mas aciertos en un empate
	 * @return el jugador que ha obtenido mas aciertos
	 */
	public int empate() {
		int jugador1 = 0;
		int jugador2 = 0;
		int ganador = 0;
		jugador1 = tablero.numeroAciertos();
		jugador2 = tablero2.numeroAciertos();

		if (jugador1 > jugador2) {
			ganador = 1;
		} else if (jugador1 < jugador2) {
			ganador = 2;
		} else {
			ganador = 3;
		}

		return ganador;
	}

	
	/**
	 * Carga un nuevo intento y su comprobacion en el tablero 1
	 * @param nuevoIntento nuevo intento del usuario
	 * @param comprobacion nueva comprobacion del usuario
	 */
	@SuppressWarnings("unchecked")
	public void intentoUsuario(Combinacion[] nuevoIntento, Object comprobacion) {
		tablero.nuevoIntento(nuevoIntento);
		tablero.comprobacion((ArrayList<String>) comprobacion);
	}

	
	/**
	 * Carga un nuevo intento y su comprobacion en el tablero 2
	 * @param intentoIA nuevo intento de la maquina
	 * @param comprobacion nueva comprobacion de la maquina
	 */
	@SuppressWarnings("unchecked")
	public void intentoMaquina(Combinacion[] intentoIA, Object comprobacion) {
		tablero2.nuevoIntento(intentoIA);
		tablero2.comprobacion((ArrayList<String>) comprobacion);
	}

	/**
	 * Dibuja el tablero del usuario
	 */
	public void dibujarTableroUsuario() {
		tablero.dibujarTablero();
	}

	/**
	 * Dibuja el tablero de la maquina
	 */
	public void dibujarTableroMaquina() {
		tablero2.dibujarTablero();
	}

	/**
	 * Comprueba si el usuario ha ganado la partida
	 * @return si el usuario ha ganado o no la partida
	 */
	public boolean UsuarioGanador() {
		return tablero.buscarGanador();
	}

	/**
	 * Comprueba si la maquina ha ganado la partida
	 * @return si la maquina ha ganado o no la partida
	 */
	public boolean MaquinaGanador() {
		return tablero2.buscarGanador();
	}

	/**
	 * Carga ambos intentos de las dos IA en sus tableros
	 * @param nuevoIntento de la IA en el jugador 1
	 * @param nuevoIntento2 de la IA en el jugador 2
	 */
	public void IA(Combinacion[] nuevoIntento, Combinacion[] nuevoIntento2) {
		tablero.nuevoIntento(nuevoIntento);
		tablero2.nuevoIntento(nuevoIntento2);
	}

}
