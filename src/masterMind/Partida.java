package masterMind;

import java.util.ArrayList;

public class Partida {

	protected Tablero tablero;
	protected Tablero tablero2;
	private ModoJuego modo;

	public Partida(ModoJuego modo2) {
		modo = modo2;
		tablero = new Tablero(modo);
		tablero2 = new Tablero(modo);

	}

	public void comprobacion(ArrayList<String> comprobarCombinacion) {
		tablero.comprobacion(comprobarCombinacion);

	}

	public boolean buscarGanador() {
		return tablero.buscarGanador();

	}

	public void aumentarIntento() {
		tablero.aumentoIntento();
	}

	public boolean quedanIntentos() {

		return tablero.quedanIntentos(modo.getIntentos());
	}

	public void comprobacionM(ArrayList<String> comprobarCombinacion) {

		tablero2.comprobacion(comprobarCombinacion);

	}

	public void dibujarTableroDoble() {
		tablero.dibujarTableros(tablero, tablero2);

	}

	public int empate() {
		int jugador1 = 0;
		int jugador2 = 0;
		int ganador = 0;
		jugador1 = tablero.numeroAciertos();
		jugador2 = tablero2.numeroAciertos();

		if (jugador1 > jugador2) {
			ganador = 1;
		} else if (jugador1 < jugador2) {
			ganador = 2;
		} else {
			ganador = 3;
		}

		return ganador;
	}

	@SuppressWarnings("unchecked")
	public void intentoUsuario(Combinacion[] nuevoIntento, Object comprobacion) {
		tablero.nuevoIntento(nuevoIntento);
		tablero.comprobacion((ArrayList<String>) comprobacion);
	}

	@SuppressWarnings("unchecked")
	public void intentoMaquina(Combinacion[] intentoIA, Object comprobacion) {
		tablero2.nuevoIntento(intentoIA);
		tablero2.comprobacion((ArrayList<String>) comprobacion);
	}

	public void dibujarTableroUsuario() {
		tablero.dibujarTablero();
	}

	public void dibujarTableroMaquina() {
		tablero2.dibujarTablero();
	}

	public boolean UsuarioGanador() {
		return tablero.buscarGanador();
	}

	public boolean MaquinaGanador() {
		return tablero2.buscarGanador();
	}

	public void IA(Combinacion[] nuevoIntento, Combinacion[] nuevoIntento2) {
		tablero.nuevoIntento(nuevoIntento);
		tablero2.nuevoIntento(nuevoIntento2);
	}

}
