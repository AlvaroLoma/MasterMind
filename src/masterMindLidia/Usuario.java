package masterMindLidia;

import masterMindLidia.Teclado.Rango;

/**
 * 
 * @author Lidia
 * @version 1.0
 * @since 1.0
 *
 */
public class Usuario extends Jugador {
	/**
	 * Construye un objeto de tipo Usuario hijo de Jugador
	 * @param dificultad Almacena las características de la partida y sus elementos
	 */
	Usuario(Dificultad dificultad) {
		this.dificultad = dificultad;
	}

	/*
	 * (non-Javadoc)
	 * @see mastermind.Jugador#crearCombinacionSecreta()
	 */
	@Override
	public Combinacion crearCombinacionSecreta() {
		Combinacion combinacion = new Combinacion(dificultad);
		Casilla casilla = new Casilla(Color.FONDO_NEGRO);
		boolean repetido;
		int i, j, opcionColor;
		
		/*
		 * 1. Pedir color al usuario de la posición 
		 * 2. Definir si se puede repetir color o no según el tipo de partida
		 * 3. No se pueden repetir colores. Se comprueba que el color no esté ya en la combinación
		 * 	3.1. Si el color está, se le vuelve a pedir al usuario
		 * 	3.2. Si el color no está, se introduce la casilla en la combinación
		 * 4. Se pueden repetir colores
		 */
		
		System.out.println("Estos son los colores que puede usar para crear la combinación:\n"
		+ Color.FONDO_AMARILLOCLARO + " 1 " + Color.RESET + "  " + Color.FONDO_VERDECLARO + " 2 "
					+ Color.RESET + "  " + Color.FONDO_VERDE + " 3 " + Color.RESET + "  " + Color.FONDO_CELESTECLARO
					+ " 4 " + Color.RESET + "  " + Color.FONDO_AZULCLARO + " 5 " + Color.RESET + "  "
					+ Color.FONDO_ROJOCLARO + " 6 " + Color.RESET + "  " + Color.FONDO_MORADOCLARO + " 7 " + Color.RESET
					+ "  " + Color.FONDO_MORADO + " 8 " + Color.RESET + "\n");
		
		for(i = 0 ; i < dificultad.getCasillas() ; i++) {	
			do {
				repetido = false;		
		//1. Pedir color al usuario de la posicion 
				opcionColor = Teclado.leerRango(1, dificultad.getColores(), Rango.AMBOSINCLUIDOS, "Posición " + (i + 1) + ":");
				casilla = casilla.seleccionarColorCasilla(dificultad, (opcionColor - 1)); //-1 por la comunicación con el usuario
		//2. Definir si se pueden repetir colores o no según el tipo de partida
		//3. No se pueden repetir colores. Se comprueba si el color está
		/*------------------------NO PUEDEN REPETIRSE LOS COLORES------------------------*/				
				if(i==0) {
					combinacion.anadirCasilla(casilla);					
				} else {
					for (j = 0 ; j < i && !repetido ; j++) { //falla cuando se repite
		//	3.1. Si está repetido volver a pedir color			
						if (casilla.equals(combinacion.getCasilla(j))) {
							repetido = true;
						} else if (!casilla.equals(combinacion.getCasilla(j)) && (j == (i - 1))) {
		//	3.2. Si no está repetido añadir a la combinacion
							combinacion.anadirCasilla(casilla);
						}
					}
				} 		
			} while (repetido);
		} //final del for
		
		return combinacion;
	} //final crearCombinacion
	
	/**
	 * Crea una combinación para intentar adivinar la combinación secreta del otro jugador
	 * @return Combinación creada por el objeto como intento de adivinar la combinación secreta del rival
	 * @see mastermind.Dificultad#getCasillas()
	 * @see mastermind.Dificultad#getColores()
	 * @see mastermind.Casilla#seleccionarColorCasilla(Dificultad, int)
	 * @see mastermind.Combinacion#anadirCasilla(Casilla) 
	 */
	public Combinacion crearIntento() {
		Combinacion intento = new Combinacion(dificultad);
		Casilla casilla = new Casilla(Color.FONDO_NEGRO);
		int i, opcionColor;
		
		System.out.println("Estos son los colores que puede usar para crear la combinación:\n"
		+ Color.FONDO_AMARILLOCLARO + " 1 " + Color.RESET + "  " + Color.FONDO_VERDECLARO + " 2 "
					+ Color.RESET + "  " + Color.FONDO_VERDE + " 3 " + Color.RESET + "  " + Color.FONDO_CELESTECLARO
					+ " 4 " + Color.RESET + "  " + Color.FONDO_AZULCLARO + " 5 " + Color.RESET + "  "
					+ Color.FONDO_ROJOCLARO + " 6 " + Color.RESET + "  " + Color.FONDO_MORADOCLARO + " 7 " + Color.RESET
					+ "  " + Color.FONDO_MORADO + " 8 " + Color.RESET + "\n");
		
		for (i = 0; i < dificultad.getCasillas(); i++) {
			//1. Pedir color al usuario de la posicion 
			opcionColor = Teclado.leerRango(1, dificultad.getColores(), Rango.AMBOSINCLUIDOS, "Posición " + (i + 1) + ":");
			//2. Asingar el color a la casilla
			casilla = casilla.seleccionarColorCasilla(dificultad, (opcionColor - 1));
			//3. Introducir la casilla en la combinación
			intento.anadirCasilla(casilla);
		} // final del for	
		return intento;
	}

	/**
	 * Crea una combinación que sirve de resultado, si no se introduce bien lanza un mensaje de error y la pide de nuevo
	 * @param combinacion Combinación de la jugada que el jugador ha propuesto para adivinar la combinación secreta
	 * @param combinacionSecreta Combinación secreta que el rival debe adivinar
	 * @return Combinación que contenga el resultado de comparar la combinación del jugador con la combinación secreta 
	 * que intenta adivinar
	 * @see mastermind.Combinacion#calcularResultado(Combinacion)
	 * @see mastermind.Combinacion#contarColocados()
	 * @see mastermind.Combinacion#anadirCasilla(Casilla)
	 * @see mastermind.Dificultad#getCasillas()
	 */
	public Combinacion colocarPinchos(Combinacion combinacion, Combinacion combinacionSecreta) { 
		Combinacion resultado = new Combinacion(dificultad);
		boolean repetir = false;
		int i, colocados = 0, noColocados = 0, colocadosReales, noColocadosReales;
		
		colocadosReales = combinacion.calcularResultado(combinacionSecreta).contarColocados();
		noColocadosReales = combinacion.calcularResultado(combinacionSecreta).contarNoColocados();
		
		System.out.println("Introduce tu respuesta");
		do {		
			repetir = false;
			colocados = Teclado.leerRango(0, dificultad.getCasillas(), Rango.AMBOSINCLUIDOS, "Introduzca el número de fichas "
					+ "que coinciden color y posición");		
			noColocados = Teclado.leerRango(0, (dificultad.getCasillas() - colocados), Rango.AMBOSINCLUIDOS, "Introduce el número "
					+ "de fichas que coicida solo el color");	
			
			if((colocados!=colocadosReales) || (noColocados!=noColocadosReales)) {
				System.out.println(Color.ROJO + "\nEl resultado no coincide con el verdadero. Introdúzcalo de nuevo\n" + Color.RESET);
				repetir = true;
			}
		} while (repetir);
		
		//Introduce en resultado el número de fichas del mismo color y en la misma posición
		for (i = 0; i < colocados; i++) {
			resultado.anadirCasilla(new Casilla(Color.FONDO_ROJOCLARO));
		}
		//Introduce en resultado el número de fichas del mismo color
		for (i = colocados; i < (colocados + noColocados) ; i++) {
			resultado.anadirCasilla(new Casilla(Color.FONDO_BLANCO));
		}
		//Introduce en resultado el número de fichas que no coinciden
		for (i = (colocados + noColocados); i < dificultad.getCasillas(); i++) {
			resultado.anadirCasilla(new Casilla(Color.FONDO_NEGRO));
		}
		return resultado;
	} //final de colocarPinchos

}
