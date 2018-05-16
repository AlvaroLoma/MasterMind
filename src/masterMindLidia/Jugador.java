package masterMindLidia;
/**
 * 
 * @author Lidia
 * @version 1.0
 * @since 1.0
 *
 */
public abstract class Jugador {
	/**
	 * Almacena los elementos propios del tablero, combinación secreta y una lista jugadas
	 */
	Tablero tablero;
	/**
	 * Almacena las características de la partida y sus elementos
	 */
	Dificultad dificultad;
	
	/**
	 * Construye un objeto que almacena un tablero y las características para desarrollar el juego
	 * @see #setTablero(Tablero)
	 */
	Jugador() {
		setTablero(tablero);
	}

	/**
	 * Genera una combinación secreta
	 * @return Combinación que contiene un array de casillas de colores en cierto orden que hay que adivinar
	 * @see mastermind.Dificultad#getCasillas()
	 * @see mastermind.Dificultad#getColores()
	 * @see mastermind.Dificultad#getRepetir()
	 * @see mastermind.Casilla#seleccionarColorCasilla(Dificultad, int)
	 * @see mastermind.Casilla#equals(Object)
	 * @see mastermind.Combinacion#anadirCasilla(Casilla)
	 * @see mastermind.Combinacion#calcularResultado(Combinacion)
	 * @see mastermind.Combinacion#contarColocados()
	 * @see mastermind.Combinacion#contarNoColocados()
	 */
	public abstract Combinacion crearCombinacionSecreta();
	
	/**
	 * Retorna el atributo tablero del objeto
	 * @return Tablero que contiene la lista de jugadas del rival y la combinación secreta del objeto
	 */
	public Tablero getTablero() {
		return tablero;
	}
	
	/**
	 * Asigna el valor del tablero pasado por parámetro al tablero del objeto
	 * @param tablero Tablero que contiene la lista de jugadas del rival y la combinación secreta del objeto 
	 */
	public void setTablero(Tablero tablero) {
		this.tablero = tablero;
	}
}
