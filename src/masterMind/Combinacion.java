package masterMind;


/**
 * Clase encargada de gestionar y crear las combinaciones
 * @author Alvaro Lodeiro
 *
 */
public class Combinacion {
	/**
	 * Atributo de tipo casilla donde se almacenara la informacion del color 
	 */
	protected Casilla casilla;

	/**
	 * Constructor de la clase combinacion
	 * @param color entero necesario para crear la casilla
	 */
	public Combinacion(int color) {
		casilla = new Casilla(color);

	}

	/**
	 * Crea una cadena con un color
	 * @return una cadena de un color
	 */
	public String dibujar() {

		return casilla.dibujar();
	}

	/**
	 * Comprueba si la combinacion que llama a la funcion y la que llega por parametro son o no iguales
	 * @param combinacion a comparar
	 * @return si son o no iguales ambas combinaciones
	 */
	public boolean equals(Combinacion combinacion) {
		boolean iguales = false;
		if (casilla.equals(combinacion.casilla)) {

			iguales = true;
		}
		return iguales;
	}

	/**
	 * @return el color de la casilla
	 */
	public String getCasilla() {

		return casilla.getColor();
	}

	/**
	 * @param value valor para cambiar el valor de la casilla
	 */
	public void setCasilla(String value) {
		casilla.setColor(value);

	}

	/**
	 * 
	 * @return el numero de la casilla
	 */
	public int getNumero() {

		return casilla.getNumero();
	}

}
