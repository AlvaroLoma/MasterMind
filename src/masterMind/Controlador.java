package masterMind;

import tecladoGenerico.TecladoGenerico;

public class Controlador {

	
	private Partida partida;
	private Jugador jugador1;
	private Jugador jugador2;
	private ModoJuego modo;
	
	
	public Controlador() {
		
		pantallaInicio();
		menuModoJuego();
		partida= new Partida(modo);
		crearJugadores();
		
	
	}

	private void crearJugadores() {
		
		if(modo==ModoJuego.FACIL) {
			
			if(tecladoGenerico.TecladoGenerico.leerBolean("Elige quien jugara la partida, tu o la Maquina", "Tu", "La maquina")) {
				jugador1= new Usuario(modo);
				jugador2=null;
			}else {
				jugador1=null;
				jugador2= new maquina(modo);
				
			}
			jugarModoFacil();
		}
		else if(modo==ModoJuego.MEDIO) {
		
			jugador1= new Usuario(modo);
			jugador2=new maquina(modo);
			jugar();
		}
		else if(modo==ModoJuego.DIFICIL) {
		
			jugador1= new maquina(modo);
			jugador2=new maquina(modo);
			jugarModoDIficil();
		}
		
	}

	private void jugarModoDIficil() {
		int limite=0;
		boolean salir=false;
		do {
		
			partida.intentoUsuario(jugador1.nuevoIntento(),jugador1.comprobacion());
			partida.intentoMaquina(jugador2.nuevoIntento(),jugador2.comprobacion());
			partida.dibujarTableroDoble();
			partida.aumentarIntento();
			try{ 
				Thread.sleep(500);
			}catch(InterruptedException e ) { 
				System.out.println("Thread Interrupted"); 
			}
//			if(partida.UsuarioGanador() && !partida.MaquinaGanador()) {
//				System.out.println("El jugador 1 es el ganador!!!!");
//				salir=true;
//			}
//			else if(partida.MaquinaGanador() && !partida.UsuarioGanador()) {
//				System.out.println("El jugador 2 es el ganador!!!!");
//				salir=true;
//			}
			limite++;
			//System.out.println(limite);
		}while(limite<10000);
		jugador1.mejorIntento();
		jugador2.mejorIntento();
		
	}

	private void jugar() {
		boolean salir= false;
		int ganador=0;
		System.out.println("Empieza la partida: ");
		do {
				System.out.println("Elija una nueva combinacion: ");
				Colores.mostrarColores();
				partida.intentoUsuario(jugador1.nuevoIntento(),jugador1.comprobacion());
				partida.intentoMaquina(jugador2.nuevoIntento(),jugador2.comprobacionM());
				partida.dibujarTableroDoble();
				if(partida.UsuarioGanador() && !partida.MaquinaGanador()) {
					System.out.println("El jugador 1 es el ganador!!!!");
					salir=true;
				}
				else if(!partida.UsuarioGanador() && partida.MaquinaGanador()) {
					System.out.println("El jugador 2 es el ganador!!!!");
					salir=true;
				}
				else if(partida.UsuarioGanador() && partida.MaquinaGanador()) {
					System.out.println("Sorprendentemente ambos jugadores han adivinado la combinacion a la vez");
					salir=true;
				}else {
					
					partida.aumentarIntento();
					
					if(partida.quedanIntentos()) {
						System.out.println("Ambos jugadores se quedaron sin mas intentos");
						ganador=partida.empate();
						if(ganador==1) {
							System.out.println("el jugador 1 tiene mas aciertos que el jugador 2");
							salir=true;
						}
						if(ganador==2) {
							salir=true;
							System.out.println("el jugador 2 tiene mas aciertos que el jugador 1");
						}
						if(ganador==3) {
							salir=true;
							System.out.println("Ambos jugadores tienen el mismo numero de aciertos se declara un empate");
						}
					}
					
				}
				
		
		}while(!salir);
		
		
	}

	private void pantallaInicio() {
		System.out.println();
		if(!TecladoGenerico.leerBolean("!BIENVENIDO\n     A\nMASTERMIND¡\n", "Nueva Partida", "Como Jugar")) {
			
			System.out.println("Ayuda");
		}
		
		
	}

	private void jugarModoFacil() { 
		boolean salir= false;
		System.out.println("Empieza a jugar  ");
		
		do {
			if(!partida.quedanIntentos()) {
				
				if(jugador1!=null) {
					System.out.println("Elija una nueva combinacion: ");
					Colores.mostrarColores();
					partida.intentoUsuario(jugador1.nuevoIntento(),jugador1.comprobacion());
					partida.dibujarTableroUsuario();
					
				}else {
					partida.intentoMaquina(jugador2.nuevoIntento(),jugador2.comprobacionM());
					partida.dibujarTableroMaquina();
				}
				
				if(partida.UsuarioGanador() || partida.MaquinaGanador()) {
					if(jugador1!=null) {
						System.out.println("Enhorabuena!!! Eres el ganador de la partida");
					}else {
						System.out.println("La maquina ha acertado la combinacion y ha ganado");
					}
					
					salir=true;
				}else {
					partida.aumentarIntento();	
				}
			}else {
				if(jugador1!=null) {
					System.out.println("Lo sentimos te has quedado sin intentos y has perdido");
				}else {
					System.out.println("La maquina se ha quedado sin intentos y ha perdido");
				}
				salir=true;
			}
			
	
		}while(!salir);
		
	}


	private void menuModoJuego() {
		
		int opcion=0;
		System.out.println("Elija el modo de juego que desea jugar: ");
		System.out.println("1-Modo facil\n2-Modo medio\n3-Modo dificil\n");
		opcion= TecladoGenerico.leerTeclado(TecladoGenerico.Numero.INT);
		if(opcion==1) modo=ModoJuego.FACIL;
		else if(opcion==2)modo=ModoJuego.MEDIO;
		else if(opcion==3)modo =ModoJuego.DIFICIL;
		
		
	}
	
}
