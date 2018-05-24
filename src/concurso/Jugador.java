package concurso;

public abstract class Jugador {
	
	protected byte[][] resultado;
	protected byte[] combSecreta= new byte[8];
	protected byte[] mejorIntento;


	public void setCombSecreta(byte[] combS) {
		for(int x=0;x<combS.length;x++) {
			
			combSecreta[x]=combS[x];
		}
		
	}
	public void setMejorIntento(byte[] mejorIntento) {
		for(int x=0;x<mejorIntento.length;x++) {
			this.mejorIntento[x]=mejorIntento[x];
		}
	}
	
	public void setResultado(byte[] a) {
		for(int x=0;x<a.length;x++) {
			resultado[Partida.intento][x]=a[x];
		}
		
	}
	

	abstract public boolean buscarGanador(byte[] crearCombPropuesta);
	abstract public void dibujarFichero(); //abstracto o mejor uno en comun?
	abstract public byte[] comprobacion(byte[] crearCombPropuesta);
	abstract public void dibujarTablero(byte[][] resultado2);
	
	abstract public byte[] crearCombPropuesta(); //crearla y cargarla en resultado
	abstract public byte[] crearCombSecreta();

	
	
	
}
