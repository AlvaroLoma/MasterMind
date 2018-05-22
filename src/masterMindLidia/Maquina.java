package masterMindLidia;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Random;
import java.util.TreeMap;
/**
 * 
 * @author Lidia
 * @version 1.0
 * @since 1.0
 *
 */
public class Maquina extends Jugador {
	/**
	 * Lista que almacena una posición y un color donde se encuentra en la combinación secreta, 
	 * para luego crear una combinación con la lista de definitivos
	 */
	private LinkedHashMap<Integer, Casilla> listaPosicionColorDefinitivo = new LinkedHashMap<>();
	/**
	 * Lista de combinaciones que ya hemos utilizado y no queremos que se vuelvan a utilizar
	 */
	private LinkedHashMap<Combinacion, Boolean> combinacionesProbadas = new LinkedHashMap<>();
	/**
	 * Mapa posición utilizada para un color que hemos descartado
	 */
	private TreeMap<Integer, Casilla> listaPosicionColorDescartado = new TreeMap<>();
	/**
	 * Lista de casillas de color que están en la combinación secreta y que hemos encontrado
	 */
	private LinkedList<Casilla> coloresEncontrados = new LinkedList<>();
	/**
	 * Lista de casillas de color que no están en la combinación secreta y que hemos encontrado
	 */
	private LinkedList<Casilla> coloresDescartados = new LinkedList<>();
	/**
	 * Número de colores que están en la combinación secreta y hemos encontrado
	 */
	private int encontrados = 0;
	/**
	 * Número de veces que se ha intentado colocar una casilla en una posición cualquiera
	 */
	private int intentosColocar = 0;
	/**
	 * Número de colores que hemos introducido en la lista de coloresEncontrados o coloresDescartados
	 */
	private int contadorColores = 0;
	/**
	 * Número de color de la lista de coloresEncontrados
	 */
	private int contadorColoresEncontrados = 0;
	
	/**
	 * Construye un objeto de tipo máquina
	 * @param dificultad Almacena las características de la partida y sus elementos
	 */
	public Maquina(Dificultad dificultad) {
		this.dificultad = dificultad; // heredado del padre Jugador
	}

	/*
	 * (non-Javadoc)
	 * @see mastermind.Jugador#crearCombinacionSecreta()
	 */
	@Override
	public Combinacion crearCombinacionSecreta() {
		Combinacion combinacion = new Combinacion(dificultad);
		Casilla casilla = new Casilla(Color.FONDO_NEGRO);
		Random rnd = new Random();
		boolean repetido;
		int i, j, aleatorioColor;

		/*
		 * 1. Sacar color para la posicion x aleatorio, si la partida es nivel difícil hay 10 colores, en el resto de modos se jugarán con 8 
		 * 2. Definir si se puede repetir color en el tipo de partida 
		 * 3. No se pueden repetir colores. Comprobar si el color está repetido
		 * 	3.1. Si está repetido volver a pedir color
		 *	3.2. Si no está repetido añadir a la combinacion 
		 * 4. Se pueden repetir colores. Comprobar si el color está repetido. Añadir a la combinacion
		 */

		for (i = 0; i < dificultad.getCasillas(); i++) {
			do {
				repetido = false;
		//1. Sacar color para la posicion x aleatorio, si la partida es nivel difícil hay 10 colores, en el resto de modos se jugarán con 8
				aleatorioColor = rnd.nextInt(dificultad.getColores());
				casilla = casilla.seleccionarColorCasilla(dificultad, aleatorioColor);
		//2. Definir si se puede repetir color en el tipo de partida
				
								/*------------------------NO PUEDEN REPETIRSE LOS COLORES------------------------*/
				
				if (!dificultad.getRepetir()) {
					if (i == 0) {
						combinacion.anadirCasilla(casilla);
					} else {
		//3. No se pueden repetir colores. Comprobar si el color está repetido
						for (j = 0; j < i && !repetido; j++) { // falla cuando se repite
		// 3.1. Si está repetido volver a pedir color
							if (casilla.equals(combinacion.getCasilla(j))) {
								repetido = true;
							} else if (!casilla.equals(combinacion.getCasilla(j)) && (j == (i - 1))) {
		// 3.2. Si no está repetido añadir a la combinacion
								combinacion.anadirCasilla(casilla);
							}
						}
					}
				} else {
								/*------------------------PUEDEN REPETIRSE LOS COLORES------------------------*/
		// 4. Se pueden repetir colores. Comprobar si el color está repetido. Añadir a la combinacion
					combinacion.anadirCasilla(casilla);
				}
			} while (repetido);
		} // final del for

		return combinacion;
	}

	/**
	 * Crea una combinación para intentar adivinar la combinación secreta del otro jugador
	 * @param tablero Tablero que almacena los elementos propios del tablero, combinación secreta y una lista jugadas
	 * @param intento Número que almacena el número de intento por el que va la partida
	 * @return Combinación creada por el objeto como intento de adivinar la combinación secreta del rival
	 * @see #crearCombinacionSecreta()
	 * @see mastermind.Casilla#seleccionarColorCasilla(Dificultad, int)
	 * @see mastermind.Dificultad#getCasillas()
	 * @see mastermind.Dificultad#getColores()
	 * @see mastermind.Combinacion#anadirCasilla(Casilla)
	 * @see mastermind.Combinacion#getCasilla(int)
	 * @see mastermind.Combinacion#contarColocados()
	 * @see mastermind.Combinacion#getCombinacion()
	 * @see mastermind.Combinacion#anadirCasillaPosicion(Casilla, int)
	 * @see mastermind.Tablero#getTablero()
	 * @see mastermind.Jugada#getCombinacion()
	 * @see mastermind.Jugada#getResultado()
	 * @see mastermind.Casilla#equals(Object)
	 * 
	 */
	public Combinacion crearIntento(Tablero tablero, int intento) {
		Combinacion intentoCombinacion = new Combinacion(dificultad);
		Casilla casilla = new Casilla(Color.FONDO_NEGRO), casillaDescartado = new Casilla(Color.FONDO_NEGRO);
		Random rnd = new Random();
		int i = 0, numeroPinchos = 0, aleatorioColor = -1, aleatorioPosicion = -1, aleatorioDescartado = 0;
		boolean repetida = false, repetidoColor = false, repetirAleatorio = false;;

		//1. Según el modo de juego la máquina crea una estrategia u otra
		//	1.1. Dificultad fácil y media
		if (dificultad == Dificultad.FACILADIVINAR || dificultad == Dificultad.FACILCOMPROBAR || dificultad == Dificultad.MEDIO) {
			//1. Combinaciones aleatorias que no se repitan
				do {
					repetida = false;
					intentoCombinacion = crearCombinacionSecreta();
					if (combinacionesProbadas.containsKey(intentoCombinacion)) {
						repetida = true;
					}
				} while (repetida);
				combinacionesProbadas.put(intentoCombinacion, false);

		//	1.2. Dificultad difícil
		} else {

		/*
		 * 1. Buscar los colores
		 * 	1.1. Primer intento
		 * 		1.1.1. Elegir un color al azar
		 * 		1.1.2. Crear una combinación entera de ese color
		 * 	1.2. Siguientes intentos
		 * 		1.2.1. Comprobar el intento anterior, contar los pinchos rojos
		 * 			1.2.1.1. Si hay algún pincho rojo, guardar ese color en coloresEncontrados tantas veces como pinchos rojos haya 
		 * 					y aumentar el contador de encontrados
		 * 			1.2.1.2. Si no hay pinchos rojos, guardar ese color en coloresDescartados una única vez
		 * 		1.2.2. Elegir un color que no esté entre los coloresEncontrados ni en los coloresDescartados
		 * 		1.2.3. Si el tamaño de la lista de coloresEncontrados es menor que el total de colores que hay, se recorrerán los colores, 
		 * 			y los que no están ni en coloresEncontrados ni en colores Descartados se introducirán en la lista de descartados
		 * 2. Buscar las posiciones
		 * 	2.1. Primer intento
		 * 		2.1.1. Escoger un color de la lista de coloresEncontrados para colocar en la posición que indicaremos
		 * 		2.1.2. Escoger un color de la lista de coloresDescartados para rellenar el resto de casillas de ese color que sabemos que no está
		 * 		2.1.3. Escoger una posición al azar para colocar el color escogido de la lista coloresEncontrados
		 * 		2.1.4. Crear una combinación con la posición, casilla y casilasDescartadas elegidas
		 * 	2.2. Siguientes intentos
		 * 		2.2.1. Comprobar el resultado del intento anterior, contar los pinchos rojos
		 * 			2.2.1.1. Si el número de pinchos rojos es mayor a 0, el color está en su sitio
		 * 				2.2.1.1.1. Introducimos la posición y el color en la lista de posiciones y colores definitiva
		 * 				2.2.1.1.2. Introducimos la posición y el color en la lista de posiciones y colores descartados
		 * 				2.2.1.1.3. Pasamos al siguiente color de la lista de coloresEncontrados
		 * 			2.2.1.2. Si el número de pinchos rojos es igual a 0, descartamos esa posición para ese color
		 * 				2.2.1.2.1. Introducimos la posición y el color en la lista de posiciones y colores descartados
		 * 		2.2.2. Crear una nueva combinación para probar  
		 * 			2.2.2.1. Elegir una nueva posición para probar
		 * 				2.2.2.1.1. Comprobar que la posición asociada al color no se encuentre en la lista de definitivos ni en la de descartados
		 * 		2.2.3. Si la lista de posiciones y colores definitiva contiene al menos tantas casillas como tiene una combinación,
		 * 				hemos descubierto la combinación ganadora, por lo que convertimos la lista en una combinación para enviarla a la partida
		 */
			
			do {
				repetida = false;
		//1. Buscar los colores
		// 	1.1. Primer intento
				if(intento == 1) {
		// 		1.1.1. Elegir un color al azar
					aleatorioColor = rnd.nextInt(dificultad.getColores());
					casilla = casilla.seleccionarColorCasilla(dificultad, aleatorioColor);
		// 		1.1.2. Crear una combinación entera de ese color
					for(i = 0 ; i < dificultad.getCasillas() ; i++) {
						intentoCombinacion.anadirCasilla(casilla);
					}
		//	1.2. Siguientes intentos
				} else {	
		// 		1.2.1. Comprobar el intento anterior, contar los pinchos rojos
					if(encontrados < dificultad.getCasillas() && contadorColores < dificultad.getColores()) {
						numeroPinchos = tablero.getTablero().getLast().getResultado().contarColocados();
						casilla = tablero.getTablero().getLast().getCombinacion().getCasilla(0);
		// 			1.2.1.1. Si hay algún pincho rojo, guardar ese color en coloresEncontrados tantas veces como pinchos rojos haya 
		// 					y aumentar el contador de encontrados
						if (numeroPinchos > 0) {
							for (i = 0; i < numeroPinchos; i++) {
								coloresEncontrados.addLast(casilla);
								encontrados++;
							}
							contadorColores++;
		// 			1.2.1.2. Si no hay pinchos rojos, guardar ese color en coloresDescartados una única vez
						} else {
							coloresDescartados.addLast(casilla);
							contadorColores++;
						}
					}
					if (encontrados < dificultad.getCasillas()) {
			// 		1.2.2. Si el tamaño de la lista de coloresEncontrados es menor al número de casillas que tiene una combinación, elegir un color 
			//			que no esté entre los coloresEncontrados ni en los coloresDescartados					
						do {
							repetidoColor = false;
							aleatorioColor = rnd.nextInt(dificultad.getColores());
							casilla = casilla.seleccionarColorCasilla(dificultad, aleatorioColor);
							if (coloresEncontrados.contains(casilla) || coloresDescartados.contains(casilla)) {
								repetidoColor = true;
							}
						} while (repetidoColor);

						for (i = 0; i < dificultad.getCasillas(); i++) {
							intentoCombinacion.anadirCasilla(casilla);
						}
					}
					if (encontrados == dificultad.getCasillas() && contadorColores < dificultad.getColores()) {						
		// 		1.2.3. Si el tamaño de la lista de coloresEncontrados es igual al número de casillas que tiene una combinación, se recorrerán los colores, 
		// 			y los que no están ni en coloresEncontrados ni en colores Descartados se introducirán en la lista de descartados
						for (i = 0; i < dificultad.getColores(); i++) {
							casilla = casilla.seleccionarColorCasilla(dificultad, i);
							if (!coloresEncontrados.contains(casilla) && !coloresDescartados.contains(casilla)) {
								coloresDescartados.addLast(casilla);
								contadorColores++;
							}
						}
					}			
		//2. Buscar las posiciones
					if (encontrados == dificultad.getCasillas() && contadorColores >= dificultad.getColores()) {
		//	2.1. Primer intento
						if(intentosColocar == 0) {
		// 		2.1.1. Escoger un color de la lista de coloresEncontrados para colocar en la posición que indicaremos
							casilla = coloresEncontrados.get(contadorColoresEncontrados);
		// 		2.1.2. Escoger un color de la lista de coloresDescartados para rellenar el resto de casillas de ese color que sabemos que no está
							casillaDescartado = coloresDescartados.get(aleatorioDescartado);
		// 		2.1.3. Escoger una posición al azar para colocar el color escogido de la lista coloresEncontrados
							aleatorioPosicion = rnd.nextInt(dificultad.getCasillas());		
		// 		2.1.4. Crear una combinación con la posición, casilla y casilasDescartadas elegidas
		// 	2.2. Siguientes intentos
							for(i = 0 ; i < dificultad.getCasillas() ; i++) {
								if(i == aleatorioPosicion) {
									intentoCombinacion.anadirCasilla(casilla);
								} else {
									intentoCombinacion.anadirCasilla(casillaDescartado);
								}
							}
							intentosColocar++;
						} else {
		// 		2.2.1. Comprobar el resultado del intento anterior, contar los pinchos rojos
							numeroPinchos = tablero.getTablero().getLast().getResultado().contarColocados();
							casilla = coloresEncontrados.get(contadorColoresEncontrados);
		// 			2.2.1.1. Si el número de pinchos rojos es mayor a 0, el color está en su sitio
							if(numeroPinchos > 0) {
								for(i = 0 ; i < tablero.getTablero().getLast().getCombinacion().getCombinacion().length ; i++) {
									if(tablero.getTablero().getLast().getCombinacion().getCasilla(i).equals(casilla)) {
		//				2.2.1.1.1. Introducimos la posición y el color en la lista de posiciones y colores definitiva
										listaPosicionColorDefinitivo.put(i, casilla);
		// 				2.2.1.1.2. Introducimos la posición y el color en la lista de posiciones y colores descartados
										listaPosicionColorDescartado.put(i, casilla);
		// 				2.2.1.1.3. Pasamos al siguiente color de la lista de coloresEncontrados
										contadorColoresEncontrados++;
									}
								}
		// 			2.2.1.2. Si el número de pinchos rojos es igual a 0, descartamos esa posición para ese color
							} else {
								for (i = 0; i < tablero.getTablero().getLast().getCombinacion().getCombinacion().length; i++) {
									if (tablero.getTablero().getLast().getCombinacion().getCasilla(i).equals(casilla)) {
		// 				2.2.1.2.1. Introducimos la posición y el color en la lista de posiciones y colores descartados	
										listaPosicionColorDescartado.put(i, casilla);
									}
								}
							}
		// 		2.2.2. Crear una nueva combinación para probar 
							if (!(listaPosicionColorDefinitivo.size() == dificultad.getCasillas())) {
								casilla = coloresEncontrados.get(contadorColoresEncontrados);
								casillaDescartado = coloresDescartados.get(aleatorioDescartado);

								do {
									repetirAleatorio = false;
		// 			2.2.2.1. Elegir una nueva posición para probar
								aleatorioPosicion = rnd.nextInt(dificultad.getCasillas());
		// 				2.2.2.1.1. Comprobar que la posición asociada al color no se encuentre en la lista de definitivos ni en la de descartados
									if (listaPosicionColorDefinitivo.containsKey(aleatorioPosicion)) {
										if (listaPosicionColorDefinitivo.get(aleatorioPosicion) != null) {
											listaPosicionColorDescartado.put(aleatorioPosicion, casilla);
											repetirAleatorio = true;
										}
									}
									if (listaPosicionColorDescartado.containsKey(aleatorioPosicion)) {
										if (listaPosicionColorDescartado.get(aleatorioPosicion).equals(casilla)) {
											listaPosicionColorDescartado.put(aleatorioPosicion, casilla);
											repetirAleatorio = true;
										}
									}
								} while (repetirAleatorio);

								for (i = 0; i < dificultad.getCasillas(); i++) {
									if (i == aleatorioPosicion) {
										intentoCombinacion.anadirCasilla(casilla);
									} else {
										intentoCombinacion.anadirCasilla(casillaDescartado);
									}
								}
							}
							if (listaPosicionColorDefinitivo.size() == dificultad.getCasillas()) {								
		// 		2.2.3. Si la lista de posiciones y colores definitiva contiene al menos tantas casillas como tiene una combinación,
		// 				hemos descubierto la combinación ganadora, por lo que convertimos la lista en una combinación para enviarla a la partida
								for (i = 0; i < listaPosicionColorDefinitivo.size(); i++) {
									intentoCombinacion.anadirCasillaPosicion(listaPosicionColorDefinitivo.get(i), i);
								}
							}
							intentosColocar++;
						}
					}
				} // fin intentos mayores que 1

				if (combinacionesProbadas.containsKey(intentoCombinacion)) {
					repetida = true;
				}
				combinacionesProbadas.put(intentoCombinacion, false);
			} while (repetida);

		}
		return intentoCombinacion;
	} // final crearIntento()
}
