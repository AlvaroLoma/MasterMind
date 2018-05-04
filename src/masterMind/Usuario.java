package masterMind;

import java.util.ArrayList;
import java.util.HashMap;

import tecladoGenerico.TecladoGenerico;
import tecladoGenerico.TecladoGenerico.Numero;
import tecladoGenerico.TecladoGenerico.Rango;

public class Usuario extends Jugador {
	
	
	
	protected ModoJuego modo;
	
	public Usuario(ModoJuego modo) {
		super(crearCombinacionGanadora(modo),modo);
		this.modo=modo;
		
	}

	private static  Combinacion[] crearCombinacionGanadora(ModoJuego modo) {
		Combinacion combinacion[]= new Combinacion[modo.getNumCasillas()];
		HashMap<String,Boolean> conjunto=new HashMap <String,Boolean>();
		Colores color;
		int numero=0;
		int contador=0;
		System.out.println("Creando combinacion aleatoria");
		do {
			numero= (int) (Math.random()*modo.getMaxColores()+1);
			color=new Colores(numero);
			if(!modo.isRepetirColores()) {
				if(!conjunto.containsKey(color.colores)) {
					conjunto.put(color.colores, true);
					combinacion[contador]= new Combinacion(numero);
					contador++;
					
				}
			}else {
				combinacion[contador]= new Combinacion(numero);
				contador++;
			}
		}while(contador<modo.getNumCasillas());
		return combinacion ;	
	}
	
	
	public Combinacion[] nuevoIntento() {
		Combinacion nuevoIntento[]= new Combinacion[modo.getNumCasillas()];
		System.out.println(modo.getNumCasillas());
			for(int x=0;x<modo.getNumCasillas();x++) {
				nuevoIntento[x]=new Combinacion(TecladoGenerico.leerRangoDeterminado(8, 1, Rango.AMBOSIN, Numero.INT));
		
			}
			
			combinaciones=nuevoIntento;
	
		return nuevoIntento;
	
	}
	
	


	
	
}
		
		
		
		
		
	


