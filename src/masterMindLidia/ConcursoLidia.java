package masterMindLidia;

import concurso.Jugador;

public class ConcursoLidia extends Jugador {
	
	Maquina jugador;
	protected byte[][] intentos;
	
	public ConcursoLidia(){
		jugador= new Maquina(Dificultad.DIFICIL);
	
		
	}
	@Override
	public boolean buscarGanador(byte[] crearCombPropuesta) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void dibujarFichero() {
		// TODO Auto-generated method stub

	}

	@Override
	public byte[] comprobacion(byte[] crearCombPropuesta) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void dibujarTablero(byte[][] resultado2) {
		// TODO Auto-generated method stub

	}

	@Override
	public byte[] crearCombPropuesta() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public byte[] crearCombSecreta() {
		Combinacion combinacion=jugador.crearCombinacionSecreta();
		
		
		return null;
	}

}
