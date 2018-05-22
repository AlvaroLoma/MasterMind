package masterMindLidia;

import masterMindLidia.Teclado.Rango;

/**
 * 
 * @author Lidia
 * @version 1.0
 * @since 1.0
 *
 */
public class Controlador {
	/**
	 * Construye un objeto que contiene un menú con el que controlar la partida
	 */
	Controlador() {
		Menu();
	}
	
	/**
	 * Modela una estructura que nos facilita controlar los menús internos
	 * @see mastermind.Partida#jugar()
	 * @see #mostrarNormas()
	 */
	public void Menu() {	
		
		boolean salir = false, volverJugar;
		int menu1 = 0, menu2 = 0, menu3 = 0;
		Jugador jugador1 = null, jugador2 = null;
		Partida partida;
		
		//1. Presentación del juego
		System.out.println("    " + Color.FONDO_ROJOCLARO + "  " + Color.RESET + "   " + Color.FONDO_VERDECLARO
				+ "  " + Color.RESET + "   " + "MasterMind" + "   " + Color.FONDO_AMARILLOCLARO + "  " + Color.RESET
				+ "   " + Color.FONDO_AZULCLARO + "  " + Color.RESET + "\n");
	
		do {
			volverJugar = false;
		//2. Menú inicial, elige jugar, ver normas o salir del juego
			menu1 = Teclado.leerRango(1, 3, Rango.AMBOSINCLUIDOS, "1. Juego nuevo\n2. Normas\n3. Salir");
		//	2.1. Jugar
		//		2.1.2. Menú elección de dificultad
			switch (menu1) {
			case 1: 
				System.out.println("Elija la dificultad");
				menu2 = Teclado.leerRango(1, 3, Rango.AMBOSINCLUIDOS, "1. Fácil\n2. Medio\n3. Difícil");
		//			2.1.2.1. Menú de elección de modo fácil
				switch (menu2) {
				case 1: 
					System.out.println("Elegir modo fácil");
					menu3 = Teclado.leerRango(1, 2, Rango.AMBOSINCLUIDOS, "1. Adivinar combinación\n2. Crear combinación");
					switch (menu3) {
		//				2.1.2.1.1. Fácil, adivinar la combinación
					case 1: 
						partida = new Partida(Dificultad.FACILADIVINAR, jugador1, jugador2);
						partida.jugar();
						break;
		//				2.1.2.1.2. Fácil, crear la combinación
					case 2: 
						partida = new Partida(Dificultad.FACILCOMPROBAR, jugador1, jugador2);
						partida.jugar();
						break;
					} //switch menú3

					break;
				case 2: 	
					partida = new Partida(Dificultad.MEDIO, jugador1, jugador2);
					partida.jugar();
					break;
				case 3: 	
					partida = new Partida(Dificultad.DIFICIL, jugador1, jugador2);
					partida.jugar();
					break;
				} //switch menú2

				volverJugar = Teclado.leerBooleanSN("\n¿Quiere jugar una nueva partida? Sí o No");
				if(!volverJugar) {
					System.out.println("¡Hasta pronto!");
					salir = true;
				}
				break;
		//	2.2. Ver normas		
			case 2: 	
				mostrarNormas();
				volverJugar = Teclado.leerBooleanSN("\n¿Quiere jugar una nueva partida? Sí o No");
				if(!volverJugar) {
					System.out.println("¡Hasta pronto!");
					salir = true;
				}
				break;
			
		//	2.3. Salir del juego
			case 3: 
				volverJugar = Teclado.leerBooleanSN("\n¿Quiere jugar una nueva partida? Sí o No");
				if(!volverJugar) {
					System.out.println("¡Hasta pronto!");
					salir = true;
				}
				break;
			} //switch menú1		
		} while (!salir);
			
	} //final menu()
	
	/**
	 * Nos muestra en pantalla las normas del juego
	 */
	private void mostrarNormas() {
		System.out.println("Mastermind (en español, Mente maestra) es un juego de habilidad y lógica que consiste en "
			    + "descubrir una secuencia de colores oculta.\n\nSe disponen de fichas de colores para: \n\n• Realizar "
			    + "la combinación oculta.\n• Para intentar adivinarla.\n\nSe disponen además de fichas de colores para "
			    + "indicar las respuestas:\n\n• Ficha bien colocada: ficha de color bien colocada pero sin indicar cuál."
			    + "\n• Ficha colocada en otro lugar: ficha de color con el color correcto pero mal colocada.\nTampoco se "
			    + "indica cuál.\n\nEl juego termina al averiguarse la combinación o bien al agotarse el número de intentos."
			    + "\nRealizar tres modos de funcionamiento del juego:\n\n\n1. Modo fácil\n\nSe compone solamente de 1 "
			    + "jugador. Realizar dos versiones del modo fácil:\n\n• El jugador es el usuario: la máquina pone la"
			    + " combinación oculta y le va indicando al\n usuario las respuestas a sus intentos.\n• El jugador es la"
			    + " máquina: el usuario pone la combinación oculta y le va indicando a la\n máquina las respuestas a sus"
			    + " intentos.\n\nNúmero de casillas: 4\nNúmero de colores: 8\nRepetición de colores: no\nNúmero de"
			    + " intentos: 10\n\n\n2. Modo medio\n\nSe compone de 2 jugadores: el usuario y la máquina.\n\nNúmero de"
			    + " casillas: 5\nNúmero de colores: 8\nRepetición de colores: no\nNúmero de intentos: 15.\n\nSi en este"
			    + " número de intentos no hay ningún ganador, ganará el que más fichas colocadas \ntenga en el último intento."
			    + "\nEn caso de empate, el que más fichas colocadas en otro lugar tenga. En caso de empate,\nse considerará un "
			    + "empate en dicha partida.\n\n\n 3. Modo difícil\n\nSe compone de 2 jugadores: la máquina contra la máquina."
			    + "\n\nNúmero de casillas: 8\nNúmero de colores: 10\nRepetición de colores: sí\nNúmero de intentos: hasta que "
			    + "uno de los dos gane.\n");
	}
}
