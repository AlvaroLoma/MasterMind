package masterMind;

import java.util.HashMap;

import tecladoGenerico.TecladoGenerico;
import tecladoGenerico.TecladoGenerico.Numero;
import tecladoGenerico.TecladoGenerico.Rango;

/**
 * Clase que extiende a la clase jugador y posee la informacion necesaria para
 * el usuario
 * 
 * @author Alvaro Lodeiro
 *
 */
public class Usuario extends Jugador {

	/**
	 * Modo del juego
	 */
	protected ModoJuego modo;

	/**
	 * Crea un nuevo jugador usuario
	 * 
	 * @param modo
	 *            carga la configuracion del modo de juego
	 */
	public Usuario(ModoJuego modo) {
		super(crearCombinacionGanadora(modo), modo);
		this.modo = modo;

	}

	/**
	 * Crea una combinacion ganadora
	 * 
	 * @param modo
	 *            configuracion de la partida
	 * @return una combinacion que sera cargada como la combinacion Ganadora
	 */
	private static Combinacion[] crearCombinacionGanadora(ModoJuego modo) {
		Combinacion combinacion[] = new Combinacion[modo.getNumCasillas()];
		HashMap<String, Boolean> conjunto = new HashMap<String, Boolean>();
		Colores color;
		int numero = 0;
		int contador = 0;
		System.out.println("Creando combinacion aleatoria");
		do {
			numero = (int) (Math.random() * modo.getMaxColores() + 1);
			color = new Colores(numero);
			if (!modo.isRepetirColores()) {
				if (!conjunto.containsKey(color.colores)) {
					conjunto.put(color.colores, true);
					combinacion[contador] = new Combinacion(numero);
					contador++;

				}
			} else {
				combinacion[contador] = new Combinacion(numero);
				contador++;
			}
		} while (contador < modo.getNumCasillas());
		Colores.mostrarColores(combinacion);
		return combinacion;
	}

	/**
	 * Solicita al usuario que introduzca un nuevo intento por teclado
	 */

	public Combinacion[] nuevoIntento() {
		Combinacion nuevoIntento[] = new Combinacion[modo.getNumCasillas()];

		for (int x = 0; x < modo.getNumCasillas(); x++) {
			nuevoIntento[x] = new Combinacion(TecladoGenerico.leerRangoDeterminado(8, 1, Rango.AMBOSIN, Numero.INT));

		}

		combinaciones = nuevoIntento;

		return nuevoIntento;

	}

	@Override
	String respuesta() {
		// TODO Auto-generated method stub
		return null;
	}

}
