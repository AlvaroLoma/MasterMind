package masterMind;

public class Combinacion {

	Casilla casilla;

	public Combinacion(int color) {
		casilla = new Casilla(color);

	}

	public String dibujar() {

		return casilla.dibujar();
	}

	public boolean equals(Combinacion combinacion) {
		boolean iguales = false;
		if (casilla.equals(combinacion.casilla)) {

			iguales = true;
		}
		return iguales;
	}

	public String getCasilla() {

		return casilla.getColor();
	}

	public void setCasilla(String value) {
		casilla.setColor(value);

	}

	public int getNumero() {

		return casilla.getNumero();
	}

}
