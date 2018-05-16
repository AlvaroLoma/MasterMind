package masterMindLidia;

import java.util.LinkedList;
/**
 * 
 * @author Lidia
 * @version 1.0
 * @since 1.0
 *
 */
public class Tablero implements TableroDibujable {

	/**
	 * Contiene las jugadas que se van añadiendo que va añadiendo el rival para intentar adivinar la combinación secreta
	 */
	private LinkedList <Jugada> tablero;
	/**
	 * Contiene la combinación secreta del tablero que tiene que adivinar el rival
	 */
	private Combinacion combinacionSecreta;
	/**
	 * Almacena las características de la partida y sus elementos
	 */
	private Dificultad dificultad;
	
	/**
	 * Contruye un objeto que tiene como atributos una combinación secreta y una lista de jugadas, configurado todo en función de la dificultad
	 * @param combinacionSecreta Combinación que contiene el array de casillas que debe adivinar el rival
	 * @param dificultad Enum que aporta características según la opción tomada 
	 */
	public Tablero(Combinacion combinacionSecreta, Dificultad dificultad) {
		this.combinacionSecreta = combinacionSecreta;
		this.dificultad = dificultad;
		this.tablero = new LinkedList<>();
	}
	
	/**
	 * Retorna una lista de jugada que contiene el objeto
	 * @return Lista de jugadas realizadas por el rival para intentar adivinar la combinación secreta
	 */
	public LinkedList<Jugada> getTablero() {
		return tablero;
	}
	
	/**
	 * Retorna la combinación secreta que contiene el objeto
	 * @return Combinación que contiene un array de casillas del que debe adivinar sus colores y posición el rival
	 */
	public Combinacion getCombinacionSecreta() {
		return combinacionSecreta;
	}
	
	/**
	 * Incluye en la lista tablero propia del objeto una jugada realizada por el rival, que es enviada por parámetro
	 * @param jugada Jugada realizada por el rival para intentar adivinar la combinación secreta del objeto, contiene 
	 * una combinación y un resultado
	 */
	public void anadirJugada(Jugada jugada) {
		tablero.add(jugada);
	}
	
	/**
	 * Construye una cadena que luego será usada para mostrar en pantalla la primera fila la jugada
	 * @param intento Número que almacena el número de intento por el que va la partida
	 * @return Cadena para luego mostrar en pantalla la primera fila que se sitúa justo a la izquierda de la combinación
	 */
	private String dibujarPrimeraFilaInicio(int intento) {		
		final String ESPACIO = " ", DOSESPACIOS = "  ";
		String cadena = "";
		
		/*
		 * 1. Construir la cadena que va situada antes de la combinación, según la dificultad la cadena variará, todo en la primera fila
		 * 	1.1. La dificultad es fácil. Se muestran en pantalla dos espacios (si el intento es menor que 10), y un espacio (si es igual o mayor que diez el intento),
		 * 	 el número de intento junto con un punto al final del mismo, y otros dos espacios detrás
		 * 	1.2. La dificultad es media o difícil. Se muestra en pantalla un único espacio
		 */
		
		if (dificultad == Dificultad.FACILADIVINAR || dificultad == Dificultad.FACILCOMPROBAR) {
			if (intento < 10) 
				cadena = Color.FONDO_ROJO + DOSESPACIOS + intento + "." + DOSESPACIOS + Color.RESET ;
			else 
				cadena = Color.FONDO_ROJO + DOSESPACIOS + intento + "." + ESPACIO + Color.RESET;
		} else {
			cadena = Color.FONDO_ROJO + ESPACIO + Color.RESET;
		}	
		return cadena;
	} //final dibujarPrimeraFilaInicio
	
	/**
	 * Construye una cadena que luego será usada para mostrar en pantalla la primera fila del espacioi intermedio entre 
	 * combinación y resultado
	 * @param intento Número que almacena el número de intento por el que va la partida
	 * @return Cadena para luego mostrar en pantalla la primera fila que se sitúa justo entre la combinación y el resultado
	 */
	private String dibujarPrimeraFilaIntermedio(int intento) {
		final String ESPACIO = " ";
		String intermedio = "";
		
		/*
		 * 1. Construir una cadena que se sitúa entre las dos jugadas
		 * 2. El intento máximo son 999999999, es decir, que la máximo de ocupación sería un espacio, nueve cifras, un punto y un espacio,
		 * 	 que suman 12 caracteres. Para los intentos que tengan menos cifras, por cada cifra menos, esta se sustituirá por un espacio en su lugar
		 */
		
		if (intento < 10) {
			intermedio = ESPACIO + intento + ".    ";
		} else if (intento >= 10 && intento < 100) {
			intermedio = ESPACIO + intento + ".   ";
		} else if (intento >= 100 && intento < 1000) {
			intermedio = ESPACIO + intento + ".  ";
		} 
		return Color.FONDO_ROJO + intermedio + Color.RESET;
	} //final dibujarPrimeraFilaIntermedio
	
	/**
	 * Construye una cadena que luego será usada para mostrar en pantalla la segunda fila la jugada
	 * @return Cadena para luego mostrar en pantalla la primera fila que se sitúa justo a la segunda de la combinación
	 */
	private String dibujarSegundaFilaInicio() {		
		final String ESPACIO = " ", SEISESPACIOS = "      ";
		String cadena = "";
		
		/*
		 * 1. Se construye una cadena de espacios que va antes de la combinación, dependerá su número de la dificultad de la partida, en la segunda fila
		 * 2. En el caso de ser dificultad fácil, es un total de seis espacios
		 * 3. En el caso de ser dificultad media o difícil, únicamente será un espacio
		 */
		
		if (dificultad == Dificultad.FACILADIVINAR || dificultad == Dificultad.FACILCOMPROBAR)
			cadena = Color.FONDO_ROJO + SEISESPACIOS + Color.RESET ;
		else
			cadena = Color.FONDO_ROJO + ESPACIO + Color.RESET;

		return cadena;
	} //final dibujarSegundaFilaInicio
	

	/**
	 * Construye una cadena que luego será usada para mostrar en pantalla la segunda fila del espacioi intermedio entre 
	 * combinación y resultado
	 * @param intento Número que almacena el número de intento por el que va la partida
	 * @return Cadena para luego mostrar en pantalla la segunda fila que se sitúa justo entre la combinación y el resultado
	 */
	private String dibujarSegundaFilaIntermedio() {
		final String SIETEESPACIOS = "       ";
		
		/*
		 * 1. Construir una cadena que se sitúa entre las dos jugadas
		 * 2. El intento máximo son 999999999, es decir, que la máximo de ocupación sería un espacio, nueve cifras, un punto y un espacio,
		 * 	 que suman 12 caracteres. Se colocarán 12 espacios en blanco
		 */

		return Color.FONDO_ROJO + SIETEESPACIOS + Color.RESET;
	} //final dibujarSegundaFilaIntermedio
	
	/**
	 * (non-Javadoc)
	 * @see mastermind.TableroDibujable#dibujarTableros(mastermind.Tablero, int)
	 * @see #dibujarPrimeraFilaInicio(int)
	 * @see #dibujarSegundaFilaInicio()
	 * @see #dibujarPrimeraFilaIntermedio(int)
	 * @see Tablero#dibujarSegundaFilaIntermedio()
	 */
	public void dibujarTableros(Tablero tablero2, int intento) {  //Buena
		final int UNESPACIO = 1, DOSESPACIOS = 2, TRESESPACIOS = 3, SEISESPACIOS = 6, SIETEESPACIOS = 7, 
				OCUPACOMB = (6 * dificultad.getCasillas()), OCUPARESULT = (3 * dificultad.getCasillas());
		final String ESPACIO = " ";
		String espaciosVacios = "";
		int i, largo = 0;

		if(dificultad == Dificultad.FACILADIVINAR || dificultad == Dificultad.FACILCOMPROBAR) {
			largo = SEISESPACIOS + OCUPACOMB + TRESESPACIOS + OCUPARESULT + DOSESPACIOS;
			
			//Banda coloreada de espacios, que simulan la parte superior del tablero
			for(i = 0 ; i < largo ; i++) {
				espaciosVacios = espaciosVacios + ESPACIO;
			}	
			
			//Recorremos todas las jugadas que contiene el tablero y las mostramos en pantalla
			for (int j = 0; j < tablero.size(); j++) {
				if (j == 0) {
				System.out.println(Color.FONDO_ROJO + espaciosVacios + Color.RESET 
						+ "\n" + dibujarPrimeraFilaInicio(j + 1) + tablero.get(j).dibujarPrimeraFilaJugada(dificultad) 
						+ "\n" + dibujarSegundaFilaInicio() + tablero.get(j).dibujarSegundaFilaJugada(dificultad) 
						+ "\n" + Color.FONDO_ROJO + espaciosVacios + Color.RESET);
				} else {
					System.out.println(dibujarPrimeraFilaInicio(j + 1)
							+ tablero.get(j).dibujarPrimeraFilaJugada(dificultad) + "\n"
							+ dibujarSegundaFilaInicio()
							+ tablero.get(j).dibujarSegundaFilaJugada(dificultad) + "\n"
							+ Color.FONDO_ROJO + espaciosVacios + Color.RESET);
				}
			} 			
		} else if(dificultad == Dificultad.MEDIO) {
			largo = UNESPACIO + (2 * OCUPACOMB) + (2 * TRESESPACIOS) + (2 * OCUPARESULT) + (2 * DOSESPACIOS) + SIETEESPACIOS;
			
			for(i = 0 ; i < largo ; i++) {
				espaciosVacios = espaciosVacios + ESPACIO;
			}
			for (int j = 0; j < tablero.size(); j++) {
				if (j == 0) {
				System.out.println(Color.FONDO_ROJO + espaciosVacios + Color.RESET 
						+ "\n" + dibujarPrimeraFilaInicio(j + 1) + tablero2.getTablero().get(j).dibujarPrimeraFilaJugada(dificultad)
						+ dibujarPrimeraFilaIntermedio(j + 1) + tablero.get(j).dibujarPrimeraFilaJugada(dificultad)
						+ "\n" + dibujarSegundaFilaInicio() + tablero2.getTablero().get(j).dibujarSegundaFilaJugada(dificultad)
						+ dibujarSegundaFilaIntermedio() + tablero.get(j).dibujarSegundaFilaJugada(dificultad)
						+ "\n" + Color.FONDO_ROJO + espaciosVacios + Color.RESET);
				} else {
					System.out.println(dibujarPrimeraFilaInicio(j + 1) + tablero2.getTablero().get(j).dibujarPrimeraFilaJugada(dificultad)
							+ dibujarPrimeraFilaIntermedio(j + 1) + tablero.get(j).dibujarPrimeraFilaJugada(dificultad)
							+ "\n" + dibujarSegundaFilaInicio() + tablero2.getTablero().get(j).dibujarSegundaFilaJugada(dificultad)
							+ dibujarSegundaFilaIntermedio() + tablero.get(j).dibujarSegundaFilaJugada(dificultad)
							+ "\n" + Color.FONDO_ROJO + espaciosVacios + Color.RESET);
				}
			} 
		} else {
			largo = UNESPACIO + (2 * OCUPACOMB) + (2 * TRESESPACIOS) + (2 * OCUPARESULT) + (2 * DOSESPACIOS) + SIETEESPACIOS;
			
			for(i = 0 ; i < largo ; i++) {
				espaciosVacios = espaciosVacios + ESPACIO;
			}	
			if (intento == 1) {
			System.out.println(Color.FONDO_ROJO + espaciosVacios + Color.RESET 
					+ "\n" + dibujarPrimeraFilaInicio(intento) + tablero2.getTablero().getLast().dibujarPrimeraFilaJugada(dificultad)
					+ dibujarPrimeraFilaIntermedio(intento) + tablero.getLast().dibujarPrimeraFilaJugada(dificultad)
					+ "\n" + dibujarSegundaFilaInicio() +  tablero2.getTablero().getLast().dibujarSegundaFilaJugada(dificultad)
					+ dibujarSegundaFilaIntermedio() + tablero.getLast().dibujarSegundaFilaJugada(dificultad)
					+ "\n" + Color.FONDO_ROJO + espaciosVacios + Color.RESET);
			} else {
				System.out.println(dibujarPrimeraFilaInicio(intento) + tablero2.getTablero().getLast().dibujarPrimeraFilaJugada(dificultad)
						+ dibujarPrimeraFilaIntermedio(intento) + tablero.getLast().dibujarPrimeraFilaJugada(dificultad)
						+ "\n" + dibujarSegundaFilaInicio() +  tablero2.getTablero().getLast().dibujarSegundaFilaJugada(dificultad)
						+ dibujarSegundaFilaIntermedio() + tablero.getLast().dibujarSegundaFilaJugada(dificultad)
						+ "\n" + Color.FONDO_ROJO + espaciosVacios + Color.RESET);
			}
		}
			
	}

	/*
	 * (non-Javadoc)
	 * @see mastermind.TableroDibujable#dibujarCombinacionSecreta(mastermind.Tablero, int)
	 * @see #dibujarSegundaFilaInicio()
	 * @see Tablero#dibujarSegundaFilaIntermedio()
	 */
	public void dibujarCombinacionSecreta(Tablero tablero2, int indicador) {		
		final int UNESPACIO = 1, DOSESPACIOS = 2, TRESESPACIOS = 3, SEISESPACIOS = 6, SIETEESPACIOS = 7, 
				OCUPACOMB = (6 * dificultad.getCasillas()), OCUPARESULT = (3 * dificultad.getCasillas());
		final String ESPACIO = " ";
		String espaciosVacios = "";
		int i, largo = 0;
		Jugada jugada = new Jugada(combinacionSecreta), jugada2;

		/*
		 * 1. Dibujar la combinación secreta del tablero
		 * 2. Dependiendo de la dificultad, mostrar en pantalla la combinación secreta
		 * 	2.1. Fácil, se muestran los espacios del inicio, la combinación secreta y un espacio final, 2 filas
		 * 	2.2. Medio o Difícil, se muestra en pantalla los espacios del inicio, combinación secreta del jugador1, espacios variables,
		 * 		el espacio intermedio, combinación secreta del jugador2, y un pequeño espacio final, 2 filas
		 * 3. Se muestran también una fila entera vacía coloreado como el tablero antes y después de dibujar las jugadas o combinaciones
		 */
		
		if(dificultad == Dificultad.FACILADIVINAR || dificultad == Dificultad.FACILCOMPROBAR) {
			largo = SEISESPACIOS + OCUPACOMB + TRESESPACIOS + OCUPARESULT + DOSESPACIOS;
			
			for(i = 0 ; i < largo ; i++) {
				espaciosVacios = espaciosVacios + ESPACIO;
			}
			
			System.out.println(Color.FONDO_NEGRO + espaciosVacios + Color.RESET 
							+ "\n" + Color.FONDO_ROJO + espaciosVacios + Color.RESET 
							+ "\n" + dibujarSegundaFilaInicio() + jugada.dibujarPrimeraFilaJugada(dificultad) 
							+ "\n" + dibujarSegundaFilaInicio() + jugada.dibujarPrimeraFilaJugada(dificultad)
							+ "\n" + Color.FONDO_ROJO + espaciosVacios + Color.RESET);
		} else if(dificultad == Dificultad.MEDIO && indicador == 1) {	
			largo = SEISESPACIOS + OCUPACOMB + TRESESPACIOS + OCUPARESULT + DOSESPACIOS;
			String tresEspacios = "   ", dosEspacios = "  ";
			
			for(i = 0 ; i < largo ; i++) {
				espaciosVacios = espaciosVacios + ESPACIO;
			}
			
			System.out.println(Color.FONDO_NEGRO + espaciosVacios + Color.RESET 
							+ "\n" + Color.FONDO_ROJO + espaciosVacios + Color.RESET 
							+ "\n" + Color.FONDO_ROJO  + tresEspacios + dosEspacios + Color.RESET + dibujarSegundaFilaInicio() 
							+ jugada.dibujarPrimeraFilaJugada(dificultad) 
							+ "\n" + Color.FONDO_ROJO  + tresEspacios + dosEspacios + dibujarSegundaFilaInicio() 
							+ jugada.dibujarPrimeraFilaJugada(dificultad)
							+ "\n" + Color.FONDO_ROJO + espaciosVacios + Color.RESET);
			
		} else if (dificultad == Dificultad.DIFICIL || (dificultad == Dificultad.MEDIO && indicador == 2)){
			jugada2 = new Jugada(tablero2.getCombinacionSecreta());
			largo = UNESPACIO + (2 * OCUPACOMB) + (2 * TRESESPACIOS) + (2 * OCUPARESULT) + (2 * DOSESPACIOS) + SIETEESPACIOS;;
			
			for(i = 0 ; i < largo ; i++) {
				espaciosVacios = espaciosVacios + ESPACIO;
			}
			
			System.out.println(Color.FONDO_NEGRO + espaciosVacios + Color.RESET 
							+ "\n" + Color.FONDO_ROJO + espaciosVacios + Color.RESET 
							+ "\n" + dibujarSegundaFilaInicio() + jugada2.dibujarPrimeraFilaJugada(dificultad) + dibujarSegundaFilaIntermedio()
							+ jugada.dibujarPrimeraFilaJugada(dificultad) 
							+ "\n" + dibujarSegundaFilaInicio() + jugada2.dibujarPrimeraFilaJugada(dificultad) + dibujarSegundaFilaIntermedio() 
							+ jugada.dibujarPrimeraFilaJugada(dificultad) 
							+ "\n" + Color.FONDO_ROJO + espaciosVacios + Color.RESET);
		}
	} //final dibujarCombinacionSecreta	

}
