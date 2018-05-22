package masterMindLidia;
/**
 * 
 * @author Lidia
 * @version 1.0
 * @since 1.0
 *
 */
public interface TableroDibujable {
	
	/**
	 * Muestra por pantalla los que contienen cada uno el fondo, las combinaciones y sus correspondientes resultados, además de la combinación secreta
	 * @param tablero2 Tablero que se envía para mostrar o no en pantalla, dependiendo de si hay uno o dos jugadores
	 * @param intento Número que almacena el número de intento por el que va la partida
	 * @see mastermind.Dificultad#getCasillas()
	 * @see mastermind.Jugada#dibujarPrimeraFilaJugada(Dificultad)
	 * @see mastermind.Jugada#dibujarSegundaFilaJugada(Dificultad)
	 * @see mastermind.Tablero#getTablero()
	 */
	void dibujarTableros(Tablero tablero2, int intento);
	
	/**
	 * Muestra por pantalla la combinación secreta con el tablero de fondo y un separador
	 * @param tablero2 Tablero que se envía para mostrar o no en pantalla, dependiendo de si hay uno o dos jugadores
	 * @param indicador Número que indica el modo de dificultad medio para cuando se muestran una o dos combinaciones secretas
	 * @see mastermind.Dificultad#getCasillas()
	 * @see mastermind.Jugada#dibujarPrimeraFilaJugada(Dificultad)
	 * @see mastermind.Tablero#getCombinacionSecreta()
	 */
	void dibujarCombinacionSecreta(Tablero tablero2, int indicador);

}
