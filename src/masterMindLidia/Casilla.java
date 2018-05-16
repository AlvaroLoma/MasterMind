package masterMindLidia;
/**
 * 
 * @author Lidia
 * @version 1.0
 * @since 1.0
 *
 */
public class Casilla implements Dibujable {
	/**
	 * Cadena que contiene un color
	 */	
	private String color;
	/**
	 * Construye un nuevo objeto Casilla que almacen aun color específico
	 * @param color Cadena a través de la cual se forma la Casilla 
	 */	
	public Casilla(String color){
		this.color = color;
	}
	/**
	 * Devuelve el color propio de la casilla
	 * @return La cadena que está definida por un color
	 */
	public String getColor() {
		return color;
	}
	/**
	 * Comparar un objeto de este tipo que llama la función con otro del mismo que pasamos por parámetro
	 * @param obj	Objeto sobre el que queremos comparar
	 * @return		El booleano resultante de comparar los dos objetos
	 */
	public boolean equals(Object obj) {
		boolean resultado = false;
		
		if (obj instanceof Casilla && color.equals(((Casilla)obj).color))
			resultado = true;		
		return resultado;
	}
	/**
	 * Asigna un color a una casilla según la dificultad y la elección de color que hayamos tomado
	 * @param dificultad Enum tipo Dificultad que nos determina una forma de actuar u otra dentro del método
	 * @param aleatorioColor Elección que hemos tomado para conseguir una casilla de ese color
	 * @return La casilla de color seleccionada por nosotros con el parámetro
	 */
	public Casilla seleccionarColorCasilla(Dificultad dificultad, int aleatorioColor) {
		Casilla casilla = null;
		
		if(dificultad != Dificultad.DIFICIL) {
			switch (aleatorioColor) {
			case 0:
				casilla = new Casilla(Color.FONDO_AMARILLOCLARO);
				break;
			case 1:
				casilla = new Casilla(Color.FONDO_VERDECLARO);
				break;
			case 2:
				casilla = new Casilla(Color.FONDO_VERDE);
				break;
			case 3:
				casilla = new Casilla(Color.FONDO_CELESTECLARO);
				break;
			case 4:
				casilla = new Casilla(Color.FONDO_AZULCLARO);
				break;
			case 5:
				casilla = new Casilla(Color.FONDO_ROJOCLARO);
				break;
			case 6:
				casilla = new Casilla(Color.FONDO_MORADOCLARO);
				break;
			case 7:
				casilla = new Casilla(Color.FONDO_MORADO);
				break;
			}
		} else {
			switch (aleatorioColor) {
			case 0:
				casilla = new Casilla(Color.FONDO_AMARILLOCLARO);
				break;
			case 1:
				casilla = new Casilla(Color.FONDO_AMARILLO);
				break;
			case 2:
				casilla = new Casilla(Color.FONDO_VERDECLARO);
				break;
			case 3:
				casilla = new Casilla(Color.FONDO_VERDE);
				break;
			case 4:
				casilla = new Casilla(Color.FONDO_CELESTECLARO);
				break;
			case 5:
				casilla = new Casilla(Color.FONDO_AZULCLARO);
				break;
			case 6:
				casilla = new Casilla(Color.FONDO_ROJOCLARO);
				break;
			case 7:
				casilla = new Casilla(Color.FONDO_MORADOCLARO);
				break;
			case 8:
				casilla = new Casilla(Color.FONDO_MORADO);
				break;
			case 9:
				casilla = new Casilla(Color.FONDO_GRISOSCURO);
				break;
			}	
		}
		return casilla;
	}
	
	/*
	 * (non-Javadoc)
	 * @see mastermind.Dibujable#dibujar()
	 */
	public String dibujar() {
		return (color + "    " + Color.RESET);
	}

	/*
	 * (non-Javadoc)
	 * @see mastermind.Dibujable#dibujarResultado()
	 */
	public String dibujarResultado() {
		return (color + "  " + Color.RESET);
	}	
}
