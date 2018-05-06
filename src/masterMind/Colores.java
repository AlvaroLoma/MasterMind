package masterMind;

/**
 * Clase Colores, posee la informacion de los colores
 * 
 * @author Alvaro Lodeiro
 *
 */
public class Colores {

	/**
	 * Atributo necesario para resetear algun color al color por defecto
	 */
	public static final String RESET = "\u001B[0m";
	/**
	 * Atributo para el color Negro
	 */
	public static final String NEGRO = "\u001B[30m";
	/**
	 * Atributo para el color Rojo
	 */
	public static final String ROJO = "\u001B[31m";
	/**
	 * Atributo para el color Blanco
	 */
	public static final String BLANCO = "\u001B[37m";
	/**
	 * Atributo para el color de fondo Negro
	 */
	public static final String FONDO_NEGRO = "\u001B[40m";
	/**
	 * Atributo para el color de fondo burdeos
	 */
	public static final String FONDO_BURDEO = "\u001B[41m";
	/**
	 * Atributo para el color de fondo verde
	 */
	public static final String FONDO_VERDE = "\u001B[42m";
	/**
	 * Atributo para el color de fondo mostaza
	 */
	public static final String FONDO_MOSTAZA = "\u001b[43m";
	/**
	 * Atributo para el color de fondo azul
	 */
	public static final String FONDO_AZUL = "\u001B[104m";
	/**
	 * Atributo para el color de fondo morado
	 */
	public static final String FONDO_MORADO = "\u001B[45m";
	/**
	 * Atributo para el color de fondo celeste
	 */
	public static final String FONDO_CELESTE = "\u001B[46m";
	/**
	 * Atributo para el color de fondo blanco
	 */
	public static final String FONDO_BLANCO = "\u001B[47m";
	/**
	 * Atributo para el color de fondo rosa
	 */
	public static final String FONDO_ROSA = "\u001B[105m";
	/**
	 * Atributo para el color de fondo gris
	 */
	public static final String FONDO_GRIS = "\u001B[100m";
	/**
	 * Atributo para el color de fondo amarillo
	 */
	public static final String FONDO_AMARILLO = "\u001b[103m";
	/**
	 * Atributo para el color de fondo rojo
	 */
	public static final String FONDO_ROJO = "\u001B[101m";

	/**
	 * Atributo de numero entero utilizado para identificar al color
	 */
	protected int numero;
	/**
	 * Atributo para crear la cadena del color
	 */
	protected String colores;

	/**
	 * Metodo que crea los colores
	 * 
	 * @param color
	 *            entero utilizado para identificar el color y crear su cadena
	 */
	public Colores(int color) {

		switch (color) {

		case 1:
			colores = Colores.FONDO_AMARILLO;
			numero = 1;
			break;
		case 2:
			colores = Colores.FONDO_ROSA;
			numero = 2;
			break;
		case 3:
			colores = Colores.FONDO_CELESTE;
			numero = 3;
			break;
		case 4:
			colores = Colores.FONDO_MORADO;
			numero = 4;
			break;
		case 5:
			colores = Colores.FONDO_VERDE;
			numero = 5;
			break;
		case 6:
			colores = Colores.FONDO_BURDEO;
			numero = 6;
			break;
		case 7:
			colores = Colores.FONDO_GRIS;
			numero = 7;
			break;
		case 8:
			colores = Colores.FONDO_AZUL;
			numero = 8;
			break;
		case 9:
			colores = Colores.FONDO_MOSTAZA;
			numero = 9;
			break;
		case 10:
			colores = Colores.FONDO_ROJO;
			numero = 10;
			break;

		}
	}

	/**
	 * Metodo que muestra todos los colores disponibles segun el modo de juego
	 * 
	 * @param modo
	 *            determina el numero de colores que mostraremos
	 */
	public static void mostrarColores(ModoJuego modo) {

		System.out.print(Colores.FONDO_AMARILLO + " 1 " + Colores.RESET + " ");
		System.out.print(Colores.FONDO_ROSA + " 2 " + Colores.RESET + " ");
		System.out.print(Colores.FONDO_CELESTE + " 3 " + Colores.RESET + " ");
		System.out.print(Colores.FONDO_MORADO + " 4 " + Colores.RESET + " ");
		System.out.print(Colores.FONDO_VERDE + " 5 " + Colores.RESET + " ");
		System.out.print(Colores.FONDO_BURDEO + " 6 " + Colores.RESET + " ");
		System.out.print(Colores.FONDO_GRIS + " 7 " + Colores.RESET + " ");
		System.out.print(Colores.FONDO_AZUL + Colores.BLANCO + " 8 " + Colores.RESET + " ");
		if (modo == ModoJuego.DIFICIL) {
			System.out.print(Colores.FONDO_MOSTAZA + Colores.BLANCO + " 9 " + Colores.RESET + " ");
			System.out.print(Colores.FONDO_ROJO + Colores.BLANCO + " 10 " + Colores.RESET + " ");
		}

		System.out.println();

	}

	/**
	 * Metodo equals que compara los numeros de las combinaciones
	 * 
	 * @param combinacion
	 *            a comprobar si es o no iguala la que llama a la funcion
	 * @return si son iguales o no
	 */
	public boolean equals(Colores combinacion) {

		return numero == combinacion.numero;

	}

	/**
	 * Metodo que crea una cadena con un color
	 * 
	 * @return una cadena ya creada con el color seleccionado
	 */
	public String getColor() {

		return colores + "   " + Colores.RESET + " ";
	}

	/**
	 * Cambia el valor del parametro colores
	 * 
	 * @param value
	 *            valor a cambiar en el parametro colores
	 */
	public void setColores(String value) {
		colores = value;

	}

	/**
	 * Obtiene el numero del color
	 * 
	 * @return el numero del color
	 */
	public int getNumero() {

		return numero;
	}

	/**
	 * Muestra un array de combinciones por pantalla
	 * 
	 * @param combinacionGanadora
	 *            que contendra la combinacion que se mostrara por pantalla
	 */
	public static void mostrarColores(Combinacion[] combinacionGanadora) {

		for (int i = 0; i < combinacionGanadora.length; i++) {
			System.out.print(combinacionGanadora[i].getCasilla());
		}
		System.out.println();
	}
}
