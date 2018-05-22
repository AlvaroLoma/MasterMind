package masterMindLidia;

import java.util.Arrays;
import java.util.LinkedList;
/**
 * 
 * @author Lidia
 * @version 1.0
 * @since 1.0
 *
 */
public class Combinacion implements Dibujable {
	/**
	 * Almacena un conjunto de determinado tamaño de casillas que juntas forman una combinación
	 */
	private Casilla[] combinacion;
	/**
	 * Almacena la dificultad que hemos elegido al crear la partida
	 */
	private Dificultad dificultad;
	/**
	 * Contador de posiciones de creación de una combinación
	 */
	private int posicion = 0;
	/**
	 * Construye un nuevo objeto combinación que almacena dificultad y un conjunto de casillas que forman una combinación
	 * @param dificultad Enum que nos facilita el tamaño que tendrá el array de casillas
	 */
	public Combinacion(Dificultad dificultad) {
		combinacion = new Casilla[dificultad.getCasillas()];
		this.dificultad = dificultad;
	}

	/**
	 * Obtenemos el array de casillas que define la combinación que llama al método
	 * @return Array de casillas que forman la combinación que define el objeto
	 */
	public Casilla[] getCombinacion() {
		return combinacion;
	}
	
	/**
	 * Obtenemos la casilla que le indicamos con el número que introducimos por parámetro
	 * @param indice Número que inica al método que casilla de la combinación del objeto extraer
	 * @return Casilla de la combinación del objeto que está situada en la posición indicada por parámetro
	 */
	public Casilla getCasilla(int indice) {
		return combinacion[indice];
	}
	
	/**	 
	 * Comparar un objeto de este tipo que llama la función con otro del mismo que pasamos por parámetro
	 * @param obj Objeto sobre el que queremos comparar
	 * @return El booleano resultante de comparar los dos objetos
	 */
	public boolean equals(Object obj) {
		boolean resultado = false;

		if (obj instanceof Combinacion && Arrays.equals(combinacion, ((Combinacion) obj).combinacion) && dificultad == (((Combinacion) obj).dificultad))
		resultado = true;
		
		return resultado;
	}
	
	/**
	 * Añade al array de casillas del objeto una casilla en la posición indicada por el contador propio de la clase 
	 * @param casilla Casilla que introducimos dentro del array propio del objeto
	 */
	public void anadirCasilla(Casilla casilla) {
		if(posicion < combinacion.length) {
			combinacion[posicion] = casilla;
			posicion++;
		}
	}
	
	/**
	 * Añade al array de casillas del objeto una casilla en la posición indicada por el número pasado por parámetro
	 * @param casilla Casilla que intoducimos en el array del objeto
	 * @param posicionCasilla Número que indica la posición en la que introduciremos la casilla en el array de casillas del objeto
	 */
	public void anadirCasillaPosicion(Casilla casilla, int posicionCasilla) {
		combinacion[posicionCasilla] = casilla;
	}
	
	/**
	 * Genera una combinación que contiene el resultado de comparar la combinación secreta que pasamos por parámetro con el objeto que la llama
	 * @param combinacionSecreta Combinación creada por el rival, con la que comparamos la combinación que llama a este método
	 * @return Combinación resultado de comparar la combinación que llama al método con la que pasamos por parámetro
	 * @see #anadirCasilla(Casilla)
	 * @see mastermind.Casilla#equals(Object)
	 */
	public Combinacion calcularResultado(Combinacion combinacionSecreta) {
		LinkedList<Casilla> combinacionOculta = new LinkedList<>(),
				combinacionIntento = new LinkedList<>();
		Combinacion resultado = new Combinacion(dificultad);
		int i, j;
		
		//Introducir las combinaciones en los mapas para poder trabajar con ellos
		for(i = 0 ; i < combinacion.length ; i++) {
			combinacionIntento.add(this.getCasilla(i));
		}
		for(i = 0 ; i < combinacionSecreta.getCombinacion().length ; i++) {
			combinacionOculta.add(combinacionSecreta.getCasilla(i));
		}
		
		//Coincide posición y color 
		for(i = 0 ; i < combinacionOculta.size() ; i++) {
			if(combinacionOculta.get(i).equals(combinacionIntento.get(i))) {
				resultado.anadirCasilla(new Casilla(Color.FONDO_ROJOCLARO));
				combinacionOculta.remove(i);
				combinacionIntento.remove(i);
				i--;
			}
		}	
		//Coincide color
		for(i = 0 ; i < combinacionOculta.size() ; i++) {
			for(j = 0 ; j < combinacionIntento.size() ; j++) {
				if(combinacionOculta.get(i).equals(combinacionIntento.get(j))) {
					resultado.anadirCasilla(new Casilla(Color.FONDO_BLANCO));
					combinacionIntento.remove(j);
					j--;
				}
			}
		}	
		//No está
		for(i = 0 ; i < combinacionOculta.size() ; i++) {
			resultado.anadirCasilla(new Casilla(Color.FONDO_NEGRO));
		}	
		return resultado; //devolver resultado
	}
	
	/**
	 * Compara las casillas del objeto con una casilla rojo, cuenta el número de casillas rojas de la combinación que llama al método
	 * @return Número total de casillas rojas encontradas en el objeto que llama al método
	 * @see mastermind.Casilla#equals(Object)
	 */
	public int contarColocados() {
		int colocado = 0, i;
		Casilla pinchoRojo = new Casilla(Color.FONDO_ROJOCLARO);
		
		for(i = 0 ; i < combinacion.length ; i++) {
			if(combinacion[i].equals(pinchoRojo)) {
				colocado++;
			}
		}
		
		return colocado;
	}
	
	/**
	 * Compara las casillas del objeto con una casilla blanca, cuenta el número de casillas blancas de la combinación que llama al método
	 * @return Número total de casillas blancas encontradas en el objeto que llama al método
	 * @see mastermind.Casilla#equals(Object)
	 */
	public int contarNoColocados() {
		int noColocado = 0, i;
		Casilla pinchoBlanco = new Casilla(Color.FONDO_BLANCO);
		
		for(i = 0 ; i < combinacion.length ; i++) {
			if(combinacion[i].equals(pinchoBlanco)) {
				noColocado++;
			}
		}
		
		return noColocado;
	}
	
	/*
	 * (non-Javadoc)
	 * @see mastermind.Dibujable#dibujar()
	 */
	public String dibujar() {		
		String cadena = "";
		
		for(int i = 0 ; i < combinacion.length ; i++) {
			cadena = cadena + (Color.FONDO_ROJO + "  " + Color.RESET) + combinacion[i].dibujar();
		}		
		return cadena;
	}
	
	/*
	 * (non-Javadoc)
	 * @see mastermind.Dibujable#dibujarResultado()
	 */
	public String dibujarResultado() {		
		String cadena = "";
		
		for(int i = 0 ; i < combinacion.length ; i++) {
			cadena = cadena + (Color.FONDO_ROJO + " " + Color.RESET) + combinacion[i].dibujarResultado();
		}		
		return cadena;
	}
	
}
