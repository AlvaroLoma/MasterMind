package masterMind;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import org.omg.Messaging.SyncScopeHelper;

import concurso.Jugadores;
import tecladoGenerico.TecladoGenerico;

/**
 * La clase controlador sera utilizada para implementar un main dinamico. La
 * clase controlador controla toda la informacion sobre la partida, los
 * jugadores y el modo de juego
 * 
 * @author Alvaro Lodeiro
 * 
 * 
 */


public class Controlador extends Jugadores {

	// Atributos necesarios para el objeto controlador, estos son una partida, dos
	// jugadores y el modo que nos dara
	// toda la informacion que necesitamos
	/**
	 * Atributo clase partida, necesario para el desarrollo de la partida
	 */

	private static boolean principio=false;
	private int ganador;

	private Partida partida;


	/**
	 * Atributo clase Jugador, necesario para el control de jugador 1
	 */
	protected Jugador jugador1;

	/**
	 * Atributo clase Jugador, necesario para el control de jugador 2
	 */
	private Jugador jugador2;
	/**
	 * Atributo clase ModoJuego, necesario para cargar las normas del modo de juego
	 */

	private ModoJuego modo;

	 static Writer fichero = null;




	/**
	 * Contruye el objeto controlador que inicializara el resto de objetos
	 * necesarios del juego
	 * 
	 * @see #pantallaInicio()
	 * @see #menuModoJuego()
	 * @see #crearJugadores()
	 */
	/*
	 * 1º Crea objetos de tipo controlador, este metodo inicializa todo lo necesario
	 * con la ayuda del usuario 2º Muestra la pantalla de inicio del programa 3º
	 * Muestra el menu para que el usuario elija un modo de juego 4º Crea la partida
	 * con el modo de juego 5º Carga los jugadores con la ayuda del usuario
	 */

	@SuppressWarnings("javadoc")
	public Controlador() {
		pantallaInicio();
		menuModoJuego();
		partida = new Partida(modo);

		try {
			if(!principio) {
			fichero= new BufferedWriter(new OutputStreamWriter(new FileOutputStream("fichero_escritura2.html"), "UTF-8"));	
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		crearJugadores();

	}

	public Controlador(ModoJuego modo2) {
		partida= new Partida(modo2);
		jugador1= new Maquina(modo2);
	}

	/**
	 * Metodo para crear a los jugadores, dependiendo del modo de juego se crearan
	 * el numero de jugadores necesarios para empezar la partida
	 * 
	 * Dependiendo del modo de juego seleccionado cargaremos 1 o 2 jugadores
	 * 
	 */
	/*
	 * 1º Comprobamos cual es el modo de juego seleccionado por el usuario 2º Si el
	 * modo dee juego esta en modo facil preguntaremos al usuario que jugador desea
	 * que juege la partida 2.2 Si selecciona que jugara el la partida cargaremos un
	 * nuevo usuario 2.3 Si selecciona que jugara la maquina la partida cargaremos
	 * una nueva maquina 3º Una vez cargamos los jugadores empezara la partida
	 */
	private void crearJugadores() {
		// Seleccionado el modo de juego facil
		if (modo == ModoJuego.FACIL) {
			// Se pregunta al usuario quien de los dos jugara el modo facil, La maquina o el
			// usuario
			if (tecladoGenerico.TecladoGenerico.leerBolean("Elige quien jugara la partida, tu o la Maquina", "Tu",
					"La maquina")) {
				jugador1 = new Usuario(modo); // Si selecciona jugar el usuario solo creamos un jugador
				jugador2 = null;
			} else {
				jugador1 = null;
				jugador2 = new Maquina(modo); // Si selecciona jugar la maquina solo creamos un jugador

			}
			jugarModoFacil(); // Metodo para jugar la partida en modo facil
		} else if (modo == ModoJuego.MEDIO) { // El modo medio carga dos jugadores, uno usuario y otro maquina

			jugador1 = new Usuario(modo);
			jugador2 = new Maquina(modo);
			jugar();// Metodo para jugar la partida en modo medio
		} else if (modo == ModoJuego.DIFICIL) { // El modo dificil carga dos jugadores, dos maquinas

			jugador1 = new Maquina(modo);
			jugador2 = new Maquina(modo);
			jugarModoDIficil(); // Metodo para jugar la partida en modo dficil

			Tablero.intento=0;

		}

	}

	/**
	 * Metodo encargado de desarrolla la partida si se ha seleccionado el modo
	 * dificil
	 * 
	 */
	/*
	 * 1º Solicitamos al primer jugador un nuevo intento. 1.2 Comprobamos el nuevo
	 * intento del jugador 1.3 Introducimos tanto el intento como la comprobacion
	 * como informacion para la partida 2º Haremos el mismo procedimiento para el
	 * jugador2 3º Comprobamos si alguno de los jugadores ha acertado la combinacion
	 * secreta 3.2 Si alguno de los jugadores ha ganado mostraremos un mensaje por
	 * pantalla y salimos del juego 3.3 Si ningun jugador ha ganado la partida,
	 * aumentaremos el numero de intento y realizamos de nuevo los pasos desde el
	 * punto 1
	 */
	private void jugarModoDIficil() {

		boolean salir = false;
		do {

			partida.intentoUsuario(jugador1.nuevoIntento(), jugador1.comprobacion());
			partida.intentoMaquina(jugador2.nuevoIntento(), jugador2.comprobacion());
			partida.dibujarTableroDoble(); 

			try { // Hace que el juego espere medio segundo entre turno y turno

				Thread.sleep(500);

				Thread.sleep(100);

			} catch (InterruptedException e) {
				System.out.println("Thread Interrupted");
			}
			if (partida.UsuarioGanador()) {
				System.out.println("El jugador 1 es el ganador!!!!");
				Colores.mostrarColores(jugador1.combinacionGanadora);
				ganador=1;
				salir = true;
			} else if (partida.MaquinaGanador()) {
				System.out.println("El jugador 2 es el ganador!!!!");
				Colores.mostrarColores(jugador2.combinacionGanadora);
				ganador=2;
				salir = true;
			}

			partida.aumentarIntento();
		} while (!salir);
		
		if(!principio) {
			primeraParte();
			principio=true;
		}
		documentoConcurso();
		

	}

	private void primeraParte() {
		try {
			fichero.write("<html lang=\"en\" dir=\"ltr\">\n" + "  <head>\n" + 
		"    <style type=\"text/css\">\n"+
					"     span{\n" + "      display: inline;\n" + "    }\n" + "     "+ 
					" 	  div{\n"+ 
					"        border: black 1px solid;\n" +
					"		width: 25%;\n" + "		padding-top:2%;\n"
					+ "		padding-left:2%;\n" + "		padding-right:15px;\n" + "		padding-bottom:2%;\n"
					+ "		float:left;\n" + "		background-color:#663300;" + "       \n" + "      }\n"
					+ "      .rojo{\n" + "        color: red;\n" + "        background-color: red;\n" + "      }\n"
					+ "      .verde{\n" + "        color: green;\n" + "        background-color: green;\n" + "      }\n"
					+ "      .amarillo{\n" + "        color: yellow;\n" + "        background-color: yellow;\n"
					+ "        \n" + "      }\n" + "      .rosa{\n" + "        color: pink;\n"
					+ "        background-color: pink;\n" + "      }\n" + "      .celeste{\n" + "        color:cyan;\n"
					+ "        background-color: cyan;\n" + "      }\n" + "      .morado{\n"
					+ "        color: purple;\n" + "        background-color: purple;\n" + "      }\n"
					+ "      .burdeo{\n" + "        color: brown;\n" + "        background-color: brown;\n"
					+ "      }\n" + "      .gris{\n" + "        color: grey;\n" + "        background-color: grey;\n"
					+ "      }\n" + "      .azul{\n" + "        color: blue;\n" + "        background-color: blue;\n"
					+ "      }\n" + "      .mostaza{\n" + "        color: #808c25;\n"
					+ "        background-color: #808c25;\n" + "      }\n" + "      .negro{\n"
					+ "        color: black;\n" + "      }\n" + "      .ganador{\n" + "		background-color: #33ccff;"
					+ "        color: black;\n" + "		width: 53%;" + "		text-align:center;" + "      }\n"
					+ "      .contenedor{\n" + "		background-color:black;\n" + " 		box-sizing: border-box;\n"
					+ "		padding-left:25%;\n" +  "        color: black;\n"
					+ "		width: 100%;" + "      }\n" + "      .rojo2{\n" + "        color: white;\n" + "      }\n"
					+ "    </style>\n" + "    <meta charset=\"utf-8\">\n" + "    <title>Concurso MasterMind</title>"
					+ "  </head>\n" + "  <body>\n" + "<h1>Nueva partida</h1>\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void documentoConcurso() {
		try {
			fichero.write("<div class='contenedor'>\n");
			fichero.write("<h1 class='rojo2'>Nueva ronda</h1>\n");
			fichero.write("<div class='ganador'>\n");
			fichero.write("<span class='ganador'>El ganador es: El jugador " + ganador + " </span>\n" + "<br/>\n");
			fichero.write("</div>\n");
			fichero.write("<br/>\n");
			fichero.write("<br/>\n");
			fichero.write("<br/>\n");
			fichero.write("<br/>\n");
			fichero.write("<div>\n");
			fichero.write("<h4 class='rojo2'>Tablero del jugador 1</h4>\n");
			escribirIntentos(partida.tablero);
			fichero.write("</div>\n");
			fichero.write("<div>\n");
			fichero.write("<h4 class='rojo2'>Tablero Jugador 2</h4>\n");
			escribirIntentos(partida.tablero2);
			fichero.write("</div>\n");
			fichero.write("</div>\n");
			fichero.write("</body>\n </html>");

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	private void escribirComprobacion(int a, Tablero tablero) {
		for (int x = a; x < a + 1; x++) {
			for (int f = 0; f < modo.getNumCasillas(); f++) {
				try {
					if (tablero.comprobacion[x][f] != null) {
						switch (tablero.comprobacion[x][f]) {
						case Colores.ROJO + "*" + Colores.RESET:
							fichero.write("<span class='rojo2'>*</span>");
							break;
						case Colores.NEGRO + "*" + Colores.RESET:
							fichero.write("<span class='negro'>*</span>");
							break;
						}
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
		try {
			fichero.write("<br/>\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void escribirIntentos(Tablero tablero) {
		for (int x = 0; x < tablero.intento; x++) {

			for (int e = 0; e < modo.getNumCasillas(); e++) {

				try {
					switch (tablero.tableroPartida[x][e].getNumero()) {

					case 1:
						fichero.write("<span class='amarillo'>&nbsp &nbsp</span><span>&nbsp</span>\n");
						break;
					case 2:
						fichero.write("<span class='rosa'>&nbsp &nbsp</span><span>&nbsp</span>\n");
						break;
					case 3:
						fichero.write("<span class='celeste'>&nbsp &nbsp</span><span>&nbsp</span>\n");
						break;
					case 4:
						fichero.write("<span class='morado'>&nbsp &nbsp</span><span>&nbsp</span>\n");
						break;
					case 5:
						fichero.write("<span class='verde'>&nbsp &nbsp</span><span>&nbsp</span>\n");
						break;
					case 6:
						fichero.write("<span class='burdeo'>&nbsp &nbsp</span><span>&nbsp</span>\n");
						break;
					case 7:
						fichero.write("<span class='gris'>&nbsp &nbsp</span><span>&nbsp</span>\n");
						break;
					case 8:
						fichero.write("<span class='azul'>&nbsp &nbsp</span><span>&nbsp</span>\n");
						break;
					case 9:
						fichero.write("<span class='mostaza'>&nbsp &nbsp</span><span>&nbsp</span>\n");
						break;
					case 10:
						fichero.write("<span class='rojo'>&nbsp &nbsp</span><span>&nbsp</span>\n");
						break;
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			escribirComprobacion(x, tablero);
		}

	}

	/**
	 * Metodo encargado en desarrollar la partida en el modo de juego medio
	 *
	 */

	/*
	 * 1º Solicitamos a ambos jugadores que introduzcan un nuevo intento 2º
	 * Comprobamos el intento introduzido por los usuarios 2.1 En el caso de la
	 * maquina sera el usuario quien introduca la comprobacion de forma manual 3º
	 * Dibujamos ambos tableros 4º Comprobamos si alguno de los dos jugadores ha
	 * conseguido acertar la combinacion 5º Si ningun jugador ha acertado la
	 * combinacion aumentaremos en uno los intentos 6º Comprobamos si quedan o no
	 * intentos 6.1 Si quedan intentos volveremos al paso 1 6.2 Si no quedan
	 * intentos se comprobara cual de los dos jugadores tiene mas numero de
	 * aciertos, este jugador sera el ganador 6.2.1 Si ambos jugadores tienen el
	 * mismo numero de aciertos se declarara un empante
	 */
	private void jugar() {
		boolean salir = false;
		int ganador = 0;
		System.out.println("Empieza la partida: ");
		do {
			System.out.println("Elija una nueva combinacion: ");
			Colores.mostrarColores(modo);
			partida.intentoUsuario(jugador1.nuevoIntento(), jugador1.comprobacion());
			partida.intentoMaquina(jugador2.nuevoIntento(), ((Maquina) jugador2).comprobacionM());
			partida.dibujarTableroDoble();
			if (partida.UsuarioGanador() && !partida.MaquinaGanador()) {
				System.out.println("El jugador 1 es el ganador!!!!");
				salir = true;
			} else if (!partida.UsuarioGanador() && partida.MaquinaGanador()) {
				System.out.println("El jugador 2 es el ganador!!!!");
				salir = true;
			} else if (partida.UsuarioGanador() && partida.MaquinaGanador()) {
				System.out.println("Sorprendentemente ambos jugadores han adivinado la combinacion a la vez");
				salir = true;
			} else {

				partida.aumentarIntento();

				if (partida.quedanIntentos()) {
					System.out.println("Ambos jugadores se quedaron sin mas intentos");
					ganador = partida.empate();
					if (ganador == 1) {
						System.out.println("el jugador 1 tiene mas aciertos que el jugador 2");
						salir = true;
					}
					if (ganador == 2) {
						salir = true;
						System.out.println("el jugador 2 tiene mas aciertos que el jugador 1");
					}
					if (ganador == 3) {
						salir = true;
						System.out.println("Ambos jugadores tienen el mismo numero de aciertos se declara un empate");
					}
				}

			}

		} while (!salir);

	}

	/**
	 * Metodo que muestra la pantalla de inicio del juego y la ayuda si el usuario
	 * lo desea
	 */
	/*
	 * 1º Mostraremos el menu de inicio al usuario para que decida si desea jugar
	 * directamente o que se muestra una ayuda de como jugar 1.1 Si el usuario elige
	 * "Como jugar" mostraremos una explicacion del juego y de los modos de juego
	 */
	private void pantallaInicio() {
		System.out.println();
		if (!TecladoGenerico.leerBolean("!BIENVENIDO\n     A\nMASTERMIND¡\n", "Nueva Partida", "Como Jugar")) {

			System.out.println("MasterMind es un juego de logica en el cual pueden participar uno o dos jugadores."
					+ "\nEl juego consiste en adivinar una combinacion secreta de colores mediante intentos de combinaciones\nlas cuales devolveran una secuencia de caracteres que indicaran el numero de aciertos:"
					+ "" + "\nUn * rojo: Indica que se ha acertado tanto en color como en posicion."
					+ "\nUn * negro: Indica que se ha acertado el color pero no la posicion."
					+ "\nLas reglas del juego dependeran del modo de juego que se seleccione:"
					+ "\nModo facil: En el modo facil constara de 4 casillas, 8 colores, 10 intentos y no se podran repetir colores, El usuario tambien debera elegir quien jugara: Si el o la maquina."
					+ "\nModo medio: En el modo medio constara de 6 casillas, 8 colores y 15 intentos y no se podran repetir colores, En este modo jugaran ambos, usuario y maquina."
					+ "\nModo dificil: En el modo dificil constara de 8 casillas, 10 colores y un numero ilimitado de intentos, En este modo jugaran la maquina contra la maquina.\n");
		}

	}

	/**
	 * Metodo que desarrolla el juego en modo facil
	 * 
	 */
	/*
	 * 1º Comprobaremos cual de los dos jugadores esta jugando 2º Pedimos a ese
	 * usuario que introduzca un nuevo intento y lo comprobaremos 3º Dibujamos el
	 * tablero 4º Comprobamos si el jugador ha acertado la combinacion 4.1 Si la ha
	 * acertado mostramos el mansaje de que ha ganado 4.2 Si no ha acertado
	 * aumentaremos en uno el numero de intentos 5º Comprobaremos si al usuario le
	 * quedan intentos 5.1 Si le quedan intentos volveremos al paso 1º 5.2 Si no
	 * quedan intentos le comunicaremos al jugador que ha perdido la partida
	 */
	private void jugarModoFacil() {
		boolean salir = false;
		System.out.println("Empieza a jugar  ");

		do {
			if (!partida.quedanIntentos()) {

				if (jugador1 != null) {
					System.out.println("Elija una nueva combinacion: ");
					Colores.mostrarColores(modo);
					partida.intentoUsuario(jugador1.nuevoIntento(), jugador1.comprobacion());
					partida.dibujarTableroUsuario();

				} else {
					partida.intentoMaquina(jugador2.nuevoIntento(), ((Maquina) jugador2).comprobacionM());
					partida.dibujarTableroMaquina();
				}

				if (partida.UsuarioGanador() || partida.MaquinaGanador()) {
					if (jugador1 != null) {
						System.out.println("Enhorabuena!!! Eres el ganador de la partida");
					} else {
						System.out.println("La maquina ha acertado la combinacion y ha ganado");
					}

					salir = true;
				} else {
					partida.aumentarIntento();
				}
			} else {
				if (jugador1 != null) {
					System.out.println("Lo sentimos te has quedado sin intentos y has perdido");
				} else {
					System.out.println("La maquina se ha quedado sin intentos y ha perdido");
				}
				salir = true;
			}

		} while (!salir);

	}

	/**
	 * Metodo que muestra los diversos modos de juegos y solicita al usuario que
	 * elija uno de ellos para cargar las normas de la partida
	 */
	/*
	 * 1º Mostramos al usuario un menu para que elija un modo de juego 2º Cuando el
	 * usuario haya seleccionado un modo de juego, cargaremos dicho modo
	 */
	private void menuModoJuego() {

		int opcion = 0;
		System.out.println("Elija el modo de juego que desea jugar: ");
		System.out.println("1-Modo facil\n2-Modo medio\n3-Modo dificil\n");
		opcion = TecladoGenerico.leerTeclado(TecladoGenerico.Numero.INT);
		if (opcion == 1)
			modo = ModoJuego.FACIL;
		else if (opcion == 2)
			modo = ModoJuego.MEDIO;
		else if (opcion == 3)
			modo = ModoJuego.DIFICIL;

	}



	

}
