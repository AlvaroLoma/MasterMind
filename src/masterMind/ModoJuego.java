package masterMind;

/**
 * La clase ModoJuego posee los modos de juegos que se pueden cargar en la aplicacion, asi como su configuracion
 * @author Alvaro Lodeiro
 *
 */
public enum ModoJuego {

		/**
		 * Modo de juego FACIL
		 * 10 numero intentos
		 * 4 numero de casillas
		 * false repetir colores
		 * 8 numero de colores
		 */
		FACIL(10,4,false,8),
		/**
		 * Modo de juego MEDIO
		 * 15 numero de intentos
		 * 6 numero de casillas
		 * false repetir colores
		 * 8 numero de colores
		 */
		MEDIO(15,6,false,8),
		/**
		 * Modo de juego DIFICIL
		 * numero de intentos ilimitado?
		 * 8 numero de casillas
		 * true repetir colores
		 * 10 numero de colores
		 */
		DIFICIL(10000,8,true,10);
		
		/**
		 * Numero de intentos
		 */
		private int intentos;
		/**
		 * Numero de casillas
		 */
		private int numCasillas;
		/**
		 * Si podremos o no repetir colores
		 */
		private boolean repetirColores;
		/**
		 * Numero maximo de colores
		 */
		private int maxColores;
		/**
		 * Crea el modo de juego
		 * @param intentos numero de intentos
		 * @param numCasillas numero de casillas
		 * @param repetirColores posibilidad de repetir colores
		 * @param maxColores numero maximo de colores
		 */
		ModoJuego(int intentos, int numCasillas, boolean repetirColores,int maxColores) {
			this.intentos=intentos;
			this.numCasillas=numCasillas;
			this.repetirColores=repetirColores;
			this.maxColores=maxColores;
			
		}

		/**
		 * @return el numero de intentos
		 */
		public int getIntentos() {
			return intentos;
		}
		/**
		 * @return el numero de casillas
		 */
		public int getNumCasillas() {
			return numCasillas;
		}

		/**
		 * 
		 * @return si se puede o no repetir colores
		 */
		public boolean isRepetirColores() {
			return repetirColores;
		}

		/**
		 * @return el numero maximo de colores
		 */
		public int getMaxColores() {
		
			return this.maxColores;
		}

		
	
}
