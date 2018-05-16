package masterMindLidia;
/**
 * 
 * @author Lidia
 * @version 1.0
 * @since 1.0
 *
 */
public interface Dibujable {	
	/**
	 * Forma la cadena necesaria para hacer que se vea una casilla de la combinación coloreada por pantalla
	 * @return La cadena para dibujar una casilla para las combinaciones
	 */
	String dibujar();
	/**
	 * Forma la cadena necesaria para hacer que se vea una casilla del resultado coloreada por pantalla
	 * @return La cadena para dibujar una casilla para los resultados
	 */
	String dibujarResultado();
}
