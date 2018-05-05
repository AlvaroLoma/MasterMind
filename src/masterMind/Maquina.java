package masterMind;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

import tecladoGenerico.TecladoGenerico;
import tecladoGenerico.TecladoGenerico.Numero;
import tecladoGenerico.TecladoGenerico.Rango;

/**
 * Clase maquina, que extiende a la clase jugador, llevara a cabo las funciones de la maquina y de la IA
 * @author Alvaro Lodeiro
 *
 */
public class Maquina extends Jugador {
	/**
	 * Atributo que indica el momento en el que se encontraron todos los colores y empieza a buscar las posiciones
	 */
	private boolean buscarPosiciones;
	/**
	 * Atributo que indica si se encontraron ya todos los colores o no
	 */
	private boolean coloresEncontrados;
	/**
	 * Atributo utilizado para almacenar las posibles posiciones de los colores
	 */
	private HashMap<Integer, Boolean[]> posiciones = new HashMap<Integer, Boolean[]>();
	/**
	 * Atributo que almacenara la combinacion final cuando se haya encontrado
	 */
	private Combinacion[] intentoFinal;
	/**
	 * Atributo utilizado para calcular la posicion de los colores
	 */
	private int numeroColor;
	/**
	 * Atributo que almacena un color que no esta en la combinacion y que sera utilizado para encontrar las posiciones
	 */
	private Colores noEsta;
	/**
	 * Atributo que almacena los colores que se han acertado
	 */
	private ArrayList<Integer> coloresAcertados = new ArrayList<>();
	/**
	 * Atributo que almacenara los colores que ya hemos intentado buscar
	 */
	private HashSet<Integer> listaColores = new HashSet<>();

	/**
	 * Contruye un jugador de tipo maquina 
	 * @param modo que indica las normas del juego
	 */
	public Maquina(ModoJuego modo) {
		super(crearCombinacionGanadora(modo), modo);
		coloresEncontrados = false;
		buscarPosiciones = false;
		numeroColor = 0;
		intentoFinal = new Combinacion[modo.getNumCasillas()];

	}
	/**
	 * Metodo que creara una combinacion ganadora dependiendo del modo de juego que se haya seleccionado
	 * @param modo indica el modo de juego seleccionado
	 * @return un array de combinaciones que sera usada como la combinacion Ganadora
	 */
	private static Combinacion[] crearCombinacionGanadora(ModoJuego modo) {
		Combinacion combinacion[] = new Combinacion[modo.getNumCasillas()];
		Colores color;
		int numero = 0;
		int contador = 0;
		HashMap<String, Boolean> conjunto = new HashMap<String, Boolean>();
		conjunto.clear();

		if (modo == ModoJuego.DIFICIL) {

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
		} else {
			System.out.println("Introduzca una combinación para que la maquina la adivine ");
			do {
				numero = tecladoGenerico.TecladoGenerico.leerRangoDeterminado(8, 1, Rango.AMBOSIN, Numero.INT);
				color = new Colores(numero);
				if (!modo.isRepetirColores()) {
					if (!conjunto.containsKey(color.colores)) {
						conjunto.put(color.colores, true);
						combinacion[contador] = new Combinacion(numero);
						contador++;
					} else {
						System.out.println("No se pueden repetir colores en la combinación lol");
					}
				} else {
					combinacion[contador] = new Combinacion(numero);
					contador++;
				}
			} while (contador < modo.getNumCasillas());
		}
		return combinacion;
	}

	/**
	 * Comprueba si la combinacion que llama al metodo coincide con la combinacion Ganadora y crea una respuesta
	 * @return un lista con la comprobacion del array de combinaciones que llamase al metodo
	 */
	public ArrayList<String> comprobacionM() {
		int numero = 0;
		boolean comprobacion=false;
		ArrayList<String> lista = new ArrayList<String>();
		ArrayList<String> listaComprobacion = new ArrayList<String>();
		boolean salir = false;
		System.out.println("Combinacion ganadora: ");
		Colores.mostrarColores(combinacionGanadora);
		System.out.println("Intento de la maquina: ");
		Colores.mostrarColores(combinaciones);
		System.out.println(
				"Indique el número de aciertos de la máquina\n 1-Si alguna casilla corresponde en posición y color\n 2-Si alguna casilla corresponde en color pero no en posición\n 3- Si no hay mas aciertos");
		do {
			numero = TecladoGenerico.leerRangoDeterminado(3, 1, Rango.AMBOSIN, Numero.INT);
			if (numero == 1) {
				lista.add(Colores.ROJO + "*" + Colores.RESET);

			} else if (numero == 2) {
				lista.add(Colores.NEGRO + "*" + Colores.RESET);

			} else {
				salir = true;
			}
		} while (!salir);

		
		listaComprobacion=comprobacion();
		
		if(lista.size()==listaComprobacion.size()) {
			Iterator <String> it = listaComprobacion.iterator();
			do {
				if(it.hasNext()) {
					
					if(!lista.contains(it.next())) {
						System.out.println("Error. La comprobacion introducida es erronea, cargando la comprobacion autentica");
						lista.clear();
						lista.addAll(listaComprobacion);
					}
				}else {
					comprobacion=true;
				}
				
			}while(!comprobacion);
			
		}else {
			System.out.println("Error. La comprobacion introducida es erronea, cargando la comprobacion autentica");
			lista.clear();
			lista.addAll(listaComprobacion);
		}
		
		return lista;
	}
	/**
	 * Metodo que desarrolla los intentos del jugador creado un nuevo array de combinaciones
	 * @return un array de combinaciones con el nuevo intento que el jugador ha calculado
	 */
	protected Combinacion[] nuevoIntento() {
		int numero = 0;
		Combinacion[] combinacion = new Combinacion[modo.getNumCasillas()];
		boolean salir = false;
		boolean primeros = false;
		boolean colorNoEsta = false;
		int code = 0;
		ArrayList<String> lista = new ArrayList<String>();
		Iterator<Integer> it = coloresAcertados.iterator();

		if (!buscarPosiciones) {
			if (!coloresAcertados.isEmpty()) {

				if (coloresAcertados.size() == modo.getNumCasillas()) {
					for (int x = 0; x < coloresAcertados.size(); x++) {
						posiciones.put(code, new Boolean[modo.getNumCasillas()]);

						for (int e = 0; e < modo.getNumCasillas(); e++) {
							posiciones.get(code)[e] = true;
						}
						code++;
					}

					do {
						numero = (int) (Math.random() * modo.getMaxColores() + 1);
						if (!coloresAcertados.contains(numero)) {
							noEsta = new Colores(numero);
							colorNoEsta = true;
						}

					} while (!colorNoEsta);
					buscarPosiciones = true;
					coloresEncontrados = true;
				} else {
					do {

						if (it.hasNext()) {

							combinacion[numero] = new Combinacion((int) it.next());
							numero++;
						} else {
							primeros = true;
						}

					} while (!primeros);
				}

			}
		}

		if (!coloresEncontrados) {

			do {

				numero = (int) (Math.random() * modo.getMaxColores() + 1);

				if (!listaColores.contains(numero)) {
					listaColores.add(numero);
					for (int x = coloresAcertados.size(); x < combinacionGanadora.length; x++) {
						combinacion[x] = new Combinacion(numero);

					}
					salir = true;
				}
			} while (!salir);
			combinaciones = combinacion;
			coloresAcertados.clear();
			lista = comprobacion();

			if (!lista.isEmpty()) {
				for (int x = 0; x < lista.size(); x++) {
					coloresAcertados.add(combinacion[x].getNumero());

				}
			} else {
				listaColores.add(numero);

			}

		} else {

			combinacion = buscarPosiciones();

		}

		return combinacion;
	}
	/**
	 * Metodo que busca las posibles posiciones de un array de combinaciones respecto con la combinacion Ganadora
	 * @return un array de combinaciones con un nuevo intento
	 */
	private Combinacion[] buscarPosiciones() {
		ArrayList<String> lista = new ArrayList<String>();
		int numero = 0;
		boolean salir = false;
		Combinacion[] combinacion = new Combinacion[modo.getNumCasillas()];

		for (int x = 0; x < modo.getNumCasillas(); x++) {
			combinacion[x] = new Combinacion(noEsta.numero);
		}

		do {

			if (numeroColor >= modo.getNumCasillas()) {
				combinacion = intentoFinal;
				combinaciones = intentoFinal;
				salir = true;
			} else {
				numero = (int) (Math.random() * modo.getNumCasillas());
				if (numero < modo.getNumCasillas() && posiciones.get(numeroColor)[numero] != null
						&& posiciones.get(numeroColor)[numero] == true) {
					combinacion[numero] = new Combinacion(coloresAcertados.get(numeroColor));
					salir = true;
					combinaciones = combinacion;
				}
			}
		} while (!salir);

		if (numeroColor < modo.getNumCasillas()) {
			lista = comprobacion();
			if (lista.contains(Colores.ROJO + "*" + Colores.RESET)) {
				if (intentoFinal[numero] == null) {
					intentoFinal[numero] = new Combinacion(coloresAcertados.get(numeroColor));
					posiciones.get(numeroColor)[numero] = false;
					for (int x = numeroColor; x < modo.getNumCasillas(); x++) {
						posiciones.get(x)[numero] = false;
					}
					numeroColor++;
				} else {
					posiciones.get(numeroColor)[numero] = false;
				}
			} else {
				posiciones.get(numeroColor)[numero] = false;
			}
		}
		return combinacion;
	}
		/**
		 * Metodo que crea una lista con la comprobacion del ultimo intento del jugador
		 * @return una lista con la comprobacion
		 */
	public ArrayList<String> comprobacion() {

		HashMap<Integer, String> conjuntoColores = new HashMap<Integer, String>();
		ArrayList<String> listaf = new ArrayList<String>();
		ArrayList<String> lista = new ArrayList<String>();
		Iterator<String> it = lista.iterator();
		String rojo = Colores.ROJO + "*" + Colores.RESET;
		String negro = Colores.NEGRO + "*" + Colores.RESET;
		String comprobar = "";
		boolean encontrado = false;
		boolean salir = false;
		boolean orden = false;
		int uno = 0;
		int dos = 0;
		int x = 0;

		do {
			if (uno < combinacionGanadora.length && combinaciones[uno].equals(combinacionGanadora[dos])) {
				x = uno;
				do {
					if (x < combinacionGanadora.length && combinaciones[x].equals(combinacionGanadora[dos])) {
						if (x == dos) {
							conjuntoColores.remove(dos, negro);
							conjuntoColores.put(dos, rojo);
							dos++;
							uno = -1;
							salir = true;
						} else {
							if (!encontrado) {
								conjuntoColores.put(dos, negro);
								encontrado = true;
							}

						}
					} else {
						if (!encontrado) {
							conjuntoColores.put(0, negro);
							encontrado = true;
						}
					}
					if (x >= combinacionGanadora.length) {
						salir = true;
					}
					x++;

				} while (!salir);
				encontrado = false;
				salir = false;
			}
			if (uno > combinacionGanadora.length) {
				uno = -1;
				dos++;
			}
			if (dos >= combinacionGanadora.length) {
				salir = true;
			}
			uno++;
		} while (!salir);
		lista.addAll(conjuntoColores.values());
		it = lista.iterator();
		do {
			if (it.hasNext()) {
				comprobar = it.next();
				if (comprobar == rojo) {
					listaf.add(rojo);
				}
			} else {
				orden = true;
			}

		} while (!orden);
		orden = false;
		it = lista.iterator();
		do {
			if (it.hasNext()) {
				comprobar = it.next();
				if (comprobar == negro) {
					listaf.add(negro);
				}
			} else {
				orden = true;
			}

		} while (!orden);

		return listaf;

	}

}
