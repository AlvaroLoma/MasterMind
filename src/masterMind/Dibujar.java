package masterMind;

public interface Dibujar {

	/**
	 * Dibuja un tablero simple
	 */
	void dibujarTablero();

	/**
	 * Recibe dos tableros y los dibuja por pantalla
	 * @param tablero1 tablero a dibujar
	 * @param tablero2 tablero a dibujar
	 */
	void dibujarTableros(Tablero tablero1, Tablero tablero2);

}