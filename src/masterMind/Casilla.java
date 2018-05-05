package masterMind;

/**
 * @author Saladillo
 *
 */
public class Casilla {

	Colores color;

	/**
	 * @param color2
	 */
	public Casilla(int color2) {
		color = new Colores(color2);
	}

	/**
	 * @return
	 */
	public String dibujar() {
		
		return color.dibujarColor();
	}

	/**
	 * @param combinacion
	 * @return
	 */
	public boolean equals(Casilla combinacion) {

		return color.equals(combinacion.color);

	}

	/**
	 * @return
	 */
	public String getColor() {

		return color.getColor();
	}

	/**
	 * @param value
	 */
	public void setColor(String value) {
		color.setColores(value);

	}

	/**
	 * @return
	 */
	public int getNumero() {

		return color.getNumero();
	}
}
