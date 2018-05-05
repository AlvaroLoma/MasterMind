package masterMind;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Loma
 *
 */
public abstract class Jugador {

	protected Combinacion combinacionGanadora[];
	protected Combinacion[] combinaciones;
	protected ModoJuego modo;

	/**
	 * @param combinacion
	 * @param modo
	 */
	public Jugador(Combinacion[] combinacion, ModoJuego modo) {
		this.modo = modo;
		combinacionGanadora = new Combinacion[combinacion.length];
		cargarCombinacion(combinacion);
		combinaciones = new Combinacion[combinacion.length];
		

	}

	private void cargarCombinacion(Combinacion[] combinacion) {

		for (int i = 0; i < combinacionGanadora.length; i++) {
			combinacionGanadora[i] = new Combinacion(combinacion[i].getNumero());

		}

	}

	/**
	 * @return
	 */
	public ArrayList<String> comprobacion() {
		HashMap<String, String> conjunto = new HashMap<String, String>();
		ArrayList<String> lista = new ArrayList<String>();
		String rojo = Colores.ROJO + "*" + Colores.RESET;
		String negro = Colores.NEGRO + "*" + Colores.RESET;
		boolean remplazar=false;
		boolean salir = false;
		int acierto = 0;
		int uno = 0;
		int dos = 0;

		do {

			if (uno < modo.getNumCasillas() && combinaciones[uno].equals(combinacionGanadora[dos])) {

				if (!conjunto.containsKey(combinaciones[uno].getCasilla())) {

					if (uno == dos) {
						
						conjunto.put(combinaciones[uno].getCasilla(), rojo);
						remplazar=true;

					} else {
					
						conjunto.put(combinaciones[uno].getCasilla(), negro);
					}

				} else {

					if (uno == dos) {
					
						conjunto.remove(combinaciones[uno].getCasilla());
						
						conjunto.put(combinaciones[uno].getCasilla(), rojo);
						remplazar=true;

					} else {
						if(!remplazar) {
							
							conjunto.put(combinaciones[uno].getCasilla(), negro);
							remplazar=true;
						}
						
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




	/**
	 * 
	 */
	public void mostrarCombinacionGanadora() {
		Colores.mostrarColores(combinacionGanadora);

	}

}
