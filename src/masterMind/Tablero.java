package masterMind;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Clase tablero carga los intentos y sus comprobaciones y dibuja los tableros
 * @author Alvaro Lodeiro
 *
 */
public class Tablero {
	/**
	 * Array de doble dimension que almacen las comprobaciones
	 */
	protected String comprobacion[][];
	/**
	 * Array de doble dimension que almacena los intentos
	 */
	private Combinacion tableroPartida[][];
	/**
	 * Atributo estatico que controla los intentos de ambos tableros
	 */
	static protected int intento = 0;

	/**
	 * Crea un tablero
	 * @param modo con la configuracion de la partida
	 */
	public Tablero(ModoJuego modo) {
		tableroPartida = new Combinacion[modo.getIntentos()][modo.getNumCasillas()];
		comprobacion = new String[modo.getIntentos()][modo.getNumCasillas()];

	}

	/**
	 * Dibuja un tablero simple
	 */
	public void dibujarTablero() {
		boolean salir = false;
		int intentos = 0;
		System.out.println(" _______________________");
		do {
			System.out.print("|");
			if (intentos < 9) {
				System.out.print((intentos + 1) + " º| ");
			} else {
				System.out.print((intentos + 1) + "º| ");
			}

			for (int i = 0; i < tableroPartida[intentos].length; i++) {
				if (tableroPartida[intentos][i] != null) {

					System.out.print(tableroPartida[intentos][i].getCasilla());
				} else {
					System.out.print("    ");
				}
			}

			System.out.print("|");

			for (int k = 0; k < comprobacion[intento].length; k++) {
				if (comprobacion[intentos][k] != null) {
					System.out.print(comprobacion[intentos][k]);
				}

			}
			System.out.println();

			intentos++;
			if (intentos > intento) {
				salir = true;
				System.out.println();
			}

		} while (!salir);

	}

	/**
	 * Carga un nuevo intento en el tablero
	 * @param nuevoIntento nuevo intento a cargar
	 */
	public void nuevoIntento(Combinacion[] nuevoIntento) {

		for (int i = 0; i < nuevoIntento.length; i++) {

			tableroPartida[intento][i] = new Combinacion(nuevoIntento[i].getNumero());
		}

	}

	/**
	 * Carga una comprobacion en el tablero
	 * @param arrayList nueva comprobacion a cargar
	 */
	public void comprobacion(ArrayList<String> arrayList) {
		Iterator<String> it = arrayList.iterator();
		boolean salir = false;
		int x = 0;
		do {
			if (x < comprobacion[intento].length && it.hasNext()) {
				comprobacion[intento][x] = it.next();
				x++;
			} else {
				salir = true;
			}

		} while (!salir);

	}

	/**
	 * Aumenta el numero de intento
	 */
	public void aumentoIntento() {

		intento++;

	}

	/**
	 * 
	 * Comprueba si el jugador ha ganado la partida
	 * @return Devuelve si el jugador ha ganado o no la partida
	 */
	public boolean buscarGanador() {
		int correcto = 0;
		boolean ganador = false;

		for (int i = 0; i < comprobacion[intento].length; i++) {

			if (comprobacion[intento][i] != null
					&& comprobacion[intento][i].equals(Colores.ROJO + "*" + Colores.RESET)) {

				correcto++;
			}
		}
		if (correcto == tableroPartida[intento].length) {
			ganador = true;
		}
		return ganador;
	}

	/**
	 * Comprueba si el numero de intentos de la partida actual es mayor o no del numero de intento
	 * @param intentos numero de intentos actuales de la partida
	 * @return si el numero de intento actual es menor o no que el numero de intento
	 */
	public boolean quedanIntentos(int intentos) {

		return intento >= intentos;
	}

	/**
	 * Recibe dos tableros y los dibuja por pantalla
	 * @param tablero1 tablero a dibujar
	 * @param tablero2 tablero a dibujar
	 */
	public void dibujarTableros(Tablero tablero1, Tablero tablero2) {
		boolean salir = false;
		String separacionV = "          ";
		int intentos = 0;
		if (intento == 0) {
			System.out.println(
					separacionV + "Tablero del jugador" + separacionV + separacionV + "         Tablero de la maquina");
			for (int e = 0; e < 2; e++) {
				System.out.print(" __");
				for (int i = 0; i < tableroPartida[intento].length + 1; i++) {
					System.out.print("_____");
				}
				System.out.print(separacionV);
			}
			System.out.println();
		}

		do {
			System.out.print("|");
			if (intento < 9) {
				System.out.print((intento + 1) + " º| ");
			} else {
				System.out.print((intento + 1) + "º| ");
			}

			for (int i = 0; i < tableroPartida[intento].length; i++) {
				if (tablero1.tableroPartida[intento][i] != null) {

					System.out.print(tableroPartida[intento][i].getCasilla());
				} else {
					System.out.print("    ");
				}
			}

			System.out.print("|");
			for (int k = 0; k < tableroPartida[intento].length; k++) {
				if (tablero1.comprobacion[intento][k] != null) {
					System.out.print(tablero1.comprobacion[intento][k]);
				} else {
					System.out.print(" ");
				}

			}
			System.out.print("|" + separacionV + "|");
			if (intento < 9) {
				System.out.print((intento + 1) + " º| ");
			} else {
				System.out.print((intento + 1) + "º| ");
			}
			for (int i = 0; i < tableroPartida[intento].length; i++) {
				if (tablero2.tableroPartida[intento][i] != null) {
					System.out.print(tablero2.tableroPartida[intento][i].getCasilla());
				}
			}
			System.out.print("|");
			for (int k = 0; k < tableroPartida[intento].length; k++) {
				if (tablero2.comprobacion[intento][k] != null) {
					System.out.print(tablero2.comprobacion[intento][k]);
				} else {
					System.out.print(" ");
				}
			}
			System.out.println("|");
			intentos++;
			if (intentos > 0) {
				salir = true;

			}

		} while (!salir);

	}

	/**
	 * Calcula el numero de aciertos de un jugador para determinar los empates
	 * @return el numero de aciertos que tiene el jugador
	 */
	public int numeroAciertos() {
		int correcto = 0;

		for (int i = 0; i < comprobacion[intento - 1].length; i++) {

			if (comprobacion[intento - 1][i] != null
					&& comprobacion[intento - 1][i].equals(Colores.ROJO + "*" + Colores.RESET)) {
				correcto++;

			}
		}

		return correcto;
	}

}
