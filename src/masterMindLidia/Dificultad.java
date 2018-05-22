package masterMindLidia;
/**
 * 
 * @author Lidia
 * @version 1.0
 * @since 1.0
 *
 */
public enum Dificultad {
	/**
	 * Modo de juego FACIL el usuario intenta adivinar la combinación secreta de la máquina
	 * Máximo de intentos: 10
	 * Número de casillas de la combinación: 4
	 * Número de colores disponibles: 8
	 * Repetir: no
	 */
	FACILADIVINAR(10, 4, 8, false), 
	/**
	 * Modo de juego FACIL el usuario crea la combinación secreta, la máquina intenta adivinar la combinación
	 * Máximo de intentos: 10
	 * Número de casillas de la combinación: 4
	 * Número de colores disponibles: 8
	 * Repetir: no
	 */
	FACILCOMPROBAR(10, 4, 8, false), 
	/**
	 * Modo de juego MEDIO el usuario crea una combinación secreta, la máquina otra, e intentan adivinar la combinación del rival
	 * Máximo de intentos: 15
	 * Número de casillas de la combinación: 5
	 * Número de colores disponibles: 8
	 * Repetir: no
	 */
	MEDIO(15, 5, 8, false), 
	/**
	 * Modo de juego DIFICIL la máquina1 crea una combinación secreta, la máquina2 otra, e intentan adivinar la combinación del rival
	 * Máximo de intentos: infinitos
	 * Número de casillas de la combinación: 8
	 * Número de colores disponibles: 10
	 * Repetir: si
	 */
	DIFICIL((int)Double.POSITIVE_INFINITY, 8, 10, true);
	
	/**
	 * Almacena el número máximo de intento que se le asginan a la partida
	 */
	private int maximoIntentos;
	/**
	 * Almacena el número de casillas que deben tener las combinaciones de la partida
	 */
	private int numeroCasillas;
	/**
	 * Almacena el número de colores que tienen para elegir los jugadores
	 */
	private int numeroColores;
	/**
	 * Almacena la opción de poder repetir colores en las combinaciones o no
	 */
	private boolean repetir;
	
	/**
	 * Construye un objeto tipo enum que le aporta las características a la partida y sus elementos
	 * @param maximoIntentos Almacena el número máximo de intento que se le asginan a la partida
	 * @param numeroCasillas Almacena el número de casillas que deben tener las combinaciones de la partida
	 * @param numeroColores Almacena el número de colores que tienen para elegir los jugadores
	 * @param repetir Almacena la opción de poder repetir colores en las combinaciones o no
	 */
	Dificultad(int maximoIntentos, int numeroCasillas, int numeroColores, boolean repetir) {
		this.maximoIntentos = maximoIntentos;
		this.numeroCasillas = numeroCasillas;
		this.numeroColores = numeroColores;
		this.repetir = repetir;
	}
	
	/**
	 * Retorna el máximo de intentos de la partida
	 * @return Número que indica el máximo de intentos de la partida
	 */
	public int getIntentos() {
		return maximoIntentos;
	}
	
	/**
	 * Retorna el número de casillas
	 * @return Número que indica el número de casillas que deben tener las combinaciones
	 */
	public int getCasillas() {
		return numeroCasillas;
	}
	
	/**
	 * Retorna el número de colores
	 * @return Número que indica el número de colores de los que disponen los jugadores para elegir
	 */
	public int getColores() {
		return numeroColores;
	}
	
	/**
	 * Retorna la opción de repetir
	 * @return Booleano que almacena la opción de repetir colores de las casillas o no en las combinación
	 */
	public boolean getRepetir() {
		return repetir;
	}
}
