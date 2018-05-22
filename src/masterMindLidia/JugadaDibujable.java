package masterMindLidia;
/**
 * 
 * @author Lidia
 * @version 1.0
 * @since 1.0
 *
 */
public interface JugadaDibujable {
	
	/**
	 * Crea una cadena que contiene las cadenas que son utilizadas para mostrar la primera fila de la combinación y el resultado en pantalla  
	 * @param dificultad Enum que especifica el modo en que se va a crear la cadena
	 * @return Cadena que muestra por pantalla la primera fila de la combinación y el resultado propios de la jugada
	 * @see mastermind.Dificultad#getCasillas()
	 * @see mastermind.Combinacion#dibujar()
	 */
	String dibujarPrimeraFilaJugada(Dificultad dificultad);
	
	/**
	 * Crea una cadena que contiene las cadenas que son utilizadas para mostrar la segunda fila de la combinación y el resultado en pantalla  
	 * @param dificultad Enum que especifica el modo en que se va a crear la cadena
	 * @return Cadena que muestra por pantalla la segunda fila de la combinación y el resultado propios de la jugada
	 * @see mastermind.Combinacion#dibujar()
	 * @see mastermind.Combinacion#dibujarResultado()
	 */
	String dibujarSegundaFilaJugada(Dificultad dificultad);

}
