package masterMindLidia;
/**
 * 
 * @author Lidia
 * @version 1.0
 * @since 1.0
 *
 */
public class Jugada implements JugadaDibujable {
	
	/**
	 * Almacena la combinación creada por el jugador, que contiene un array de casillas con la combinación de casillas para un intento concreto
	 */
	private Combinacion combinacion;
	/**
	 * Almacena la combinación resultante de comparar la combinación secreta con la propuesta por el jugador, que contiene un array de 
	 * casillas con la respuesta para un intento concreto
	 */
	private Combinacion resultado;
	
	/**
	 * Contiene la combinación propuesta por el jugador y la combinación resultado resultante de la comparación de la combinación propuesta con 
	 * la combinación secreta para un intento concreto
	 * @param combinacion Contiene la combinación propuesta por el jugador para un intento de adivinar la combinación secreta del rival
	 * @see #setResultado(Combinacion)
	 */
	Jugada(Combinacion combinacion) {
		this.combinacion = combinacion;
		setResultado(resultado);
	}
	
	/**
	 * Retorna el atributo de la clase combinación resultado
	 * @return Combinación que contiene el resultado de comparar una combinación con la combinación secreta
	 */
	public Combinacion getResultado() {
		return resultado;
	}
	
	/**
	 * Retorna el atributo de la clase Combinación combinación
	 * @return Combinación propuesta por el jugador para adivinar la combinación secreta
	 */
	public Combinacion getCombinacion() {
		return combinacion;
	}
	
	/**
	 * Asigna a la variable resultado la combinación que pasamos por parámetro
	 * @param combinacion Combinación que se le va a asignar a la variable resultado
	 */
	public void setResultado(Combinacion combinacion) {
		this.resultado = combinacion;
	}

	/**
	 * Calcula el resultado de comparar la combinación del objeto con la combinación secreta pasada por parámetro
	 * @param combinacionSecreta Combinación que contiene la combinación secreta a adivinar por el rival con que vamos a calcular el resultado
	 * @return Combinación que contiene el resultado
	 */
	public Combinacion calcularResultado(Combinacion combinacionSecreta) {		
		resultado = combinacion.calcularResultado(combinacionSecreta);
		
		return resultado;
	}
	
	/*
	 * (non-Javadoc)
	 * @see mastermind.JugadaDibujable#dibujarPrimeraFilaJugada(mastermind.Dificultad)
	 */
	public String dibujarPrimeraFilaJugada(Dificultad dificultad) {
		final String ESPACIO = " ";
		final int COMB_RESULT = 3, FINALRESULT = 2, OCUPARESULTADO = (3 * dificultad.getCasillas());
		int i, espacioVariable = COMB_RESULT + OCUPARESULTADO + FINALRESULT;
		String espaciosVacios = "";
		
		/*
		 * 1. Construir una cadena que va situada después del inicio y que colocará la jugada que se compone de una combinación y un resultado, en la primera fila
		 * 2. Calculamos el espacio variable que se corresponde a colocar tres espacios entre la combinación y el resultado, la combinación del resultado y dos espacios vacíos al final 
		 * 3. Colocamos la combinación 
		 * 4. Colocamos el espacio variable
		 */
		
		for (i = 0 ; i < espacioVariable ; i++) {
			espaciosVacios = espaciosVacios + ESPACIO;
		}
		
		return combinacion.dibujar() + Color.FONDO_ROJO + espaciosVacios + Color.RESET;
	} //final dibujarPrimeraFilaJugada

	/*
	 * (non-Javadoc)
	 * @see mastermind.JugadaDibujable#dibujarSegundaFilaJugada(mastermind.Dificultad)
	 */
	public String dibujarSegundaFilaJugada(Dificultad dificultad) {
		final String DOSESPACIOS = "  ", TRESESPACIOS = "   ";
		
		/*
		 * 1. Construir una cadena que va situada después del inicio, y que incluye la jugada
		 * 2. Colocamos la combinación, tres espacios de separación con el resultado, el resultado y dos casillas vacías al final
		 */
			
		return combinacion.dibujar() + Color.FONDO_ROJO + TRESESPACIOS + Color.RESET + resultado.dibujarResultado() 
			+ Color.FONDO_ROJO + DOSESPACIOS + Color.RESET;
	} //final dibujarSegundaFilaJugada falta desarrollar

	/**
	 * Muestra en pantalla la jugada
	 * @param dificultad Enum que define la forma en que será mostrada la jugada en pantalla
	 * @param intento Número que indica el intento por el que va la partida
	 * @see mastermind.Dificultad#getCasillas()
	 * @see #dibujarPrimeraFilaInicio(Dificultad, int)
	 * @see mastermind.Combinacion#dibujar()
	 * @see #dibujarSegundaFilaInicio(Dificultad)
	 */
	public void dibujarJugada(Dificultad dificultad, int intento) {
		final String ESPACIO = " ";
		final int OCUPAINICIO = 6, OCUPACOMBINACION = (6 * dificultad.getCasillas()), COMB_RESULT = 3, 
				OCUPARESULTADO = (3 * dificultad.getCasillas()), FINALRESULT = 2;
		int i, espacioVariable = OCUPAINICIO + OCUPACOMBINACION + COMB_RESULT + OCUPARESULTADO + FINALRESULT;
		String espaciosVacios = "", espacioResultado = "";
		
		for (i = 0 ; i < espacioVariable ; i++) {
			espaciosVacios = espaciosVacios + ESPACIO;
		}
		for (i = 0 ; i < (OCUPARESULTADO + COMB_RESULT + FINALRESULT) ; i++) {
			espacioResultado = espacioResultado + ESPACIO;
		}
		
		System.out.println(Color.FONDO_ROJO + espaciosVacios + Color.RESET 
				+ "\n" + dibujarPrimeraFilaInicio(dificultad, intento) + combinacion.dibujar() 
						+ Color.FONDO_ROJO + espacioResultado + Color.RESET
				+ "\n" + dibujarSegundaFilaInicio(dificultad) + combinacion.dibujar() 
					+ Color.FONDO_ROJO + espacioResultado + Color.RESET
				+ "\n" + Color.FONDO_ROJO + espaciosVacios + Color.RESET);
	}
	
	/**
	 * Constuye una cadena que se incluye al principio del tablero par crear una separación, y para alguna dificultad, mostrar el intento 
	 * en la primera fila
	 * @param dificultad Enum que define la manera de construir la cadena
	 * @param intento Número que indica el intento por el que va la partida
	 * @return Cadena que se muestra en pantalla en la parte más izquierda simulando un tablero en la primera fila
	 */
	private String dibujarPrimeraFilaInicio(Dificultad dificultad, int intento) {		
		final String ESPACIO = " ", DOSESPACIOS = "  ";
		String cadena = "";
		
		/*
		 * 1. Construir la cadena que va situada antes de la combinación, según la dificultad la cadena variará, todo en la primera fila
		 * 	1.1. La dificultad es fácil. Se muestran en pantalla dos espacios (si el intento es menor que 10), y un espacio (si es igual o mayor que diez el intento),
		 * 	 el número de intento junto con un punto al final del mismo, y otros dos espacios detrás
		 * 	1.2. La dificultad es media o difícil. Se muestra en pantalla un único espacio
		 */
		
		if (dificultad == Dificultad.FACILADIVINAR || dificultad == Dificultad.FACILCOMPROBAR || dificultad == Dificultad.MEDIO) {
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
	 * Constuye una cadena que se incluye al principio del tablero par crear una separación, y para alguna dificultad, mostrar el intento 
	 * en la segunda fila
	 * @param dificultad Enum que define la manera de construir la cadena
	 * @return Cadena que se muestra en pantalla en la parte más izquierda simulando un tablero en la primera fila
	 */
	private String dibujarSegundaFilaInicio(Dificultad dificultad) {		
		final String ESPACIO = " ", SEISESPACIOS = "      ";
		String cadena = "";
		
		/*
		 * 1. Se construye una cadena de espacios que va antes de la combinación, dependerá su número de la dificultad de la partida, en la segunda fila
		 * 2. En el caso de ser dificultad fácil, es un total de seis espacios
		 * 3. En el caso de ser dificultad media o difícil, únicamente será un espacio
		 */
		
		if (dificultad == Dificultad.FACILADIVINAR || dificultad == Dificultad.FACILCOMPROBAR || dificultad == Dificultad.MEDIO)
			cadena = Color.FONDO_ROJO + SEISESPACIOS + Color.RESET ;
		else
			cadena = Color.FONDO_ROJO + ESPACIO + Color.RESET;

		return cadena;
	} //final dibujarSegundaFilaInicio
}
