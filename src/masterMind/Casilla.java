package masterMind;

/**
 * La clase casilla es la que almacena la informacion sobre los colores
 * 
 * @author Alvaro Lodeiro
 *
 */
public class Casilla {
	/**
	 * Atributo clase colores, guarda la informacion del color en la casilla
	 */
	private Colores color;

	/**
	 * @param color2
	 *            numero entero para crear el color
	 */
	public Casilla(int color2) {
		color = new Colores(color2);
	}

	/**
	 * @return llama a la funcion dibujarColor() en la clase color
	 */
	public String dibujar() {

		return color.getColor();
	}

	/**
	 * @param combinacion
	 *            Array de combinaciones que se va a comprobar
	 * @return resultado de la comprobacion
	 */
	public boolean equals(Casilla combinacion) {

		return color.equals(combinacion.color);

	}

	/**
	 * @return cadena del color
	 */
	public String getColor() {

		return color.getColor();
	}

	/**
	 * @param value
	 *            valor para cambia el color
	 */
	public void setColor(String value) {
		color.setColores(value);

	}

	/**
	 * @return devuelve el numero del color
	 */
	public int getNumero() {

		return color.getNumero();
	}
}
