package concurso;

import java.util.ArrayList;
import java.util.Random;

public class Concurso {
	
	ArrayList<Jugador> participantes=new ArrayList<Jugador>();
	static ArrayList<Jugador>  ganadores=new ArrayList<Jugador>();


	Concurso(){
		cargarParticipantes();
	}
	
	private void cargarParticipantes() {
//		participantes.add(new Pablo());
//		participantes.add (new Salva());
//		participantes.add (new Migue());
//		participantes.add (new AleD());
//		participantes.add (new AleS());
//		participantes.add (new Ruben());
//		participantes.add (new Jaime());
//		participantes.add ( new Adri());
//		participantes.add (new Ismael());
//		participantes.add (new Esther());
//		participantes.add (new Lidia());
//		participantes.add (new Alvaro());
//		participantes.add (new Lolo());
//		participantes.add (new Maria());
//		participantes.add (new Nicolas());
		
	}




	public void setGanador(Jugador jugador) {
		
		ganadores.add(jugador);
		
	}
	
}
