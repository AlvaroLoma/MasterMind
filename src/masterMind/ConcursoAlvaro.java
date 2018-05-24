package masterMind;

import java.util.ArrayList;
import java.util.Iterator;

import concurso.Jugador;

public class ConcursoAlvaro extends Jugador {

	
		protected masterMind.Controlador controlador;
		protected ModoJuego modo;
		
	public ConcursoAlvaro() {
		modo= ModoJuego.DIFICIL;
		controlador= new Controlador(modo);
		crearCombSecreta();
	}
	
	
	@Override
	public boolean buscarGanador(byte[] crearCombPropuesta) {
		
		
		System.out.println("ui");
		return controlador.partida.buscarGanador();
	}

	@Override
	public void dibujarFichero() {
		// TODO Auto-generated method stub

	}

	@Override
	public byte[] comprobacion(byte[] crearCombPropuesta) {
		ArrayList<String> lista = new ArrayList<String>();
		String comprobacion="";
		Iterator it=lista.iterator();
		boolean salir=false;
		byte[] respuesta= new byte[modo.getNumCasillas()];
		int indice=0;
		
		lista=controlador.jugador1.comprobacion();
		do {
			if(it.hasNext()) {
				comprobacion=(String) it.next();
				if(comprobacion.equals(Colores.ROJO + "*" + Colores.RESET)) {
					respuesta[indice]=2;
					indice++;
				}
				else if(comprobacion.equals(Colores.NEGRO + "*" + Colores.RESET)) {
					respuesta[indice]=1;
					indice++;
				}
			}else {
				salir=true;
			}
			
		}while(!salir || indice>modo.getNumCasillas());
		
		return respuesta;
	}

	@Override
	public void dibujarTablero(byte[][] resultado2) {
		// TODO Auto-generated method stub

	}

	@Override
	public byte[] crearCombPropuesta() {
		Combinacion combinacion[]=controlador.jugador1.nuevoIntento();
		Colores.mostrarColores(combinacion);
		controlador.partida.tablero.nuevoIntento(combinacion);
		controlador.partida.aumentarIntento();
		byte[] combPropuesta= new byte[modo.getNumCasillas()];
		for(int x=0;x<modo.getNumCasillas();x++) {
			combPropuesta[x]=(byte)combinacion[x].getNumero();
		}
		return combPropuesta;
	}

	@Override
	public byte[] crearCombSecreta() {
		byte[] combSecreta= new byte[modo.getNumCasillas()];
		
		for(int x=0;x<modo.getNumCasillas();x++) {
			combSecreta[x]=(byte) controlador.jugador1.combinacionGanadora[x].getNumero();
		}
		return combSecreta;
		
	}

}
