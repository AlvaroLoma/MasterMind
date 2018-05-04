package masterMind;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class Jugador {

	protected Combinacion combinacionGanadora[];
	protected Combinacion[] combinaciones;
	protected ModoJuego modo;

	public Jugador(Combinacion[] combinacion, ModoJuego modo) {
		this.modo = modo;
		combinacionGanadora = new Combinacion[combinacion.length];
		cargarCombinacion(combinacion);
		combinaciones = new Combinacion[combinacion.length];
		Colores.mostrarColores(combinacionGanadora);

	}

	private void cargarCombinacion(Combinacion[] combinacion) {

		for (int i = 0; i < combinacionGanadora.length; i++) {
			combinacionGanadora[i] = new Combinacion(combinacion[i].casilla.color.numero);

		}

	}

	public ArrayList<String> comprobacion() {
		HashMap<String, String> conjunto = new HashMap<String, String>();
		ArrayList<String> lista = new ArrayList<String>();
		String rojo = Colores.ROJO + "*" + Colores.RESET;
		String negro = Colores.NEGRO + "*" + Colores.RESET;

		boolean salir = false;
		int acierto = 0;
		int uno = 0;
		int dos = 0;

		do {

			if (uno < combinaciones.length && combinaciones[uno].equals(combinacionGanadora[dos])) {

				if (!conjunto.containsKey(combinaciones[uno].getCasilla())) {

					if (uno == dos) {

						conjunto.put(combinaciones[uno].getCasilla(), rojo);

					} else {

						conjunto.put(combinaciones[uno].getCasilla(), negro);
					}

				} else {

					if (uno == dos) {
						if (!modo.isRepetirColores()) {
							conjunto.replace(combinaciones[uno].getCasilla(), negro, rojo);
						} else {
							conjunto.put(combinaciones[uno].getCasilla(), rojo);
						}

					} else {
						conjunto.put(combinaciones[uno].getCasilla(), negro);
					}
				}
				uno++;
				acierto++;
			} else {
				uno++;

			}
			if (uno > combinaciones.length) {
				dos++;
				uno = 0;
			}
			if (dos >= combinacionGanadora.length) {
				salir = true;
			}
			if (acierto == combinacionGanadora.length) {
				salir = true;
			}

		} while (!salir);
		lista.addAll(conjunto.values());

		return lista;

	}

	abstract protected Combinacion[] nuevoIntento();




	public void mostrarCombinacionGanadora() {
		Colores.mostrarColores(combinacionGanadora);

	}

}
