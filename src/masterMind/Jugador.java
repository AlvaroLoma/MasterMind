package masterMind;

import java.util.ArrayList;
import java.util.HashMap;



/**
 * Clase abstracta Jugador, encargado de controlar la herencia de los jugadores
 * y de almacenar informacion comun de todos los jugadores
 * 
 * @author Alvaro Lodeiro
 *
 */
public abstract class Jugador {
	/**
	 * Atributo que guarda la combinacion Ganadora que debera ser adivinada
	 */
	protected Combinacion combinacionGanadora[];
	/**
	 * Atributo que almacena la ultima combinacion del jugador
	 */
	protected Combinacion[] combinaciones;
	/**
	 * Atributo que almacena la informacion sobre el modo de juego
	 */
	protected ModoJuego modo;

	/**
	 * @param combinacion
	 *            Combinacion ganadora que sera almacenada en el atributo
	 *            combinacionGanadora
	 * @param modo
	 *            carga el modo de juego
	 */
	public Jugador(Combinacion[] combinacion, ModoJuego modo) {
		this.modo = modo;
		combinacionGanadora = new Combinacion[combinacion.length];
		cargarCombinacion(combinacion);
		combinaciones = new Combinacion[combinacion.length];

	}

	/**
	 * Carga una combinacion como combinacion Ganadora
	 * 
	 * @param combinacion
	 *            Que sera cargada en el atributo combinacionGanadora
	 */
	private void cargarCombinacion(Combinacion[] combinacion) {

		for (int i = 0; i < combinacionGanadora.length; i++) {
			combinacionGanadora[i] = new Combinacion(combinacion[i].getNumero());

		}

	}

	/**
	 * Comprueba la ultima jugada del jugador y crea una lista con la comprobacion
	 * 
	 * @return una lista con la comprobacion de una jugada
	 */
	public ArrayList<String> comprobacion() {
		HashMap<String, String> conjunto = new HashMap<String, String>();
		ArrayList<String> lista = new ArrayList<String>();
		String rojo = Colores.ROJO + "*" + Colores.RESET;
		String negro = Colores.NEGRO + "*" + Colores.RESET;
		boolean remplazar = false;
		boolean salir = false;
		int acierto = 0;
		int uno = 0;
		int dos = 0;

		do {

			if (uno < modo.getNumCasillas() && combinaciones[uno].equals(combinacionGanadora[dos])) {

				if (!conjunto.containsKey(combinaciones[uno].getCasilla())) {

					if (uno == dos) {

						conjunto.put(combinaciones[uno].getCasilla(), rojo);
						remplazar = true;

					} else {

						conjunto.put(combinaciones[uno].getCasilla(), negro);
					}

				} else {

					if (uno == dos) {

						conjunto.remove(combinaciones[uno].getCasilla());

						conjunto.put(combinaciones[uno].getCasilla(), rojo);
						remplazar = true;

					} else {
						if (!remplazar) {

							conjunto.put(combinaciones[uno].getCasilla(), negro);
							remplazar = true;
						}

					}
				}
				uno++;
				acierto++;
			} else {
				uno++;

			}
			if (uno > combinaciones.length) {
				dos++;
				uno = 0;
			}
			if (dos >= combinacionGanadora.length) {
				salir = true;
			}
			if (acierto == combinacionGanadora.length) {
				salir = true;
			}

		} while (!salir);
		lista.addAll(conjunto.values());

		return lista;

	}

	abstract protected Combinacion[] nuevoIntento();

<<<<<<< Updated upstream

	abstract String respuesta();


=======
<<<<<<< HEAD
=======
	abstract String respuesta();

>>>>>>> master
>>>>>>> Stashed changes
}
