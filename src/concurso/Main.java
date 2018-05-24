package concurso;

import masterMind.ConcursoAlvaro;

public class Main {

	public static void main(String[] args) {
		int ganador=0;
		int rondas=0;
		Concurso concurso = new Concurso();
		//Combate combate =buscarParticipantes(concurso);
		System.out.println("gg");
		Combate combate= new Combate(new ConcursoAlvaro(),new ConcursoAlvaro());
		do {
			Partida partida = new Partida(combate.getJugador1(),combate.getJugador2());
			ganador=partida.partidaDificil();
			if(ganador==1) {
				combate.rondasGanadasJ1++;
			}
			if(ganador==2) {
				combate.rondasGanadasj2++;
			}
		}while(rondas<combate.RONDASMAXIMAS);
		
		if(combate.rondasGanadasJ1>combate.rondasGanadasj2) {
			concurso.setGanador(combate.getJugador1());
		}
		if(combate.rondasGanadasJ1<combate.rondasGanadasj2) {
			concurso.setGanador(combate.getJugador2());
		}
	
		
	}

	private static Combate buscarParticipantes(Concurso concurso) {
		int numero = (int) (Math.random() *15 + 1);
		int numero2 = (int) (Math.random() *15 + 1);
		Combate combate = new Combate(concurso.participantes.get(numero),concurso.participantes.get(numero2));
		concurso.participantes.remove(numero);
		concurso.participantes.remove(numero2);
		return combate;
	}

}
