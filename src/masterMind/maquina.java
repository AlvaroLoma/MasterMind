package masterMind;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import tecladoGenerico.TecladoGenerico;
import tecladoGenerico.TecladoGenerico.Numero;
import tecladoGenerico.TecladoGenerico.Rango;

public class maquina extends Jugador {
	
	
	private boolean ochoNegros=false;
	private ArrayList < Integer > coloresAcertados = new ArrayList <> ();
	private HashSet < Integer > listaColores= new HashSet <> ();
	private Combinacion[] peorIntento;
	private HashSet < Combinacion[] > mejoresIntentos= new HashSet <> ();
	private HashMap<Integer,Combinacion[]> aciertos=new HashMap <Integer,Combinacion[]>();
	
	
	public maquina (ModoJuego modo) {
		super( crearCombinacionGanadora( modo) , modo );
		peorIntento= new Combinacion[modo.getNumCasillas()];
		
	}

	private static Combinacion[] crearCombinacionGanadora ( ModoJuego modo ) {
		Combinacion combinacion[] = new Combinacion[modo.getNumCasillas()];
		Colores color;
		int numero = 0;
		int contador = 0;
		HashMap < String , Boolean > conjunto = new HashMap < String , Boolean >();
		conjunto.clear();
		
		if(modo==ModoJuego.DIFICIL) {
		
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
		}else {
		System.out.println("Introduzca una combinación para que la maquina la adivine ");
		do {
			numero = tecladoGenerico.TecladoGenerico.leerRangoDeterminado( 8 , 1 , Rango.AMBOSIN , Numero.INT );
			color = new Colores( numero );
			if( !modo.isRepetirColores()) {
				if( !conjunto.containsKey( color.colores ) ) {
					conjunto.put( color.colores , true );
					combinacion[contador] = new Combinacion( numero );
					contador++;
				}else {
					System.out.println( "No se pueden repetir colores en la combinación lol" );
				}
			}else {
				combinacion[contador] = new Combinacion( numero );
				contador++;
			}
		}while(contador < modo.getNumCasillas() );
		}
		return combinacion ;
	}
	
	public ArrayList<String> comprobacionM() {
		int numero = 0;
		
		ArrayList < String > lista = new ArrayList();
	
		boolean salir = false;
		System.out.println( "Combinacion ganadora: " );
		Colores.mostrarColores( combinacionGanadora );
		System.out.println( "Intento de la maquina: " );
		Colores.mostrarColores( combinaciones );
		System.out.println("Indique el número de aciertos de la máquina\n 1-Si alguna casilla corresponde en posición y color\n 2-Si alguna casilla corresponde en color pero no en posición\n 3- Si no hay mas aciertos");
		do{
			numero = TecladoGenerico.leerRangoDeterminado( 3 , 1 , Rango.AMBOSIN , Numero.INT );
			if(numero == 1) {
				lista.add( Colores.ROJO+"*"+Colores.RESET );	
				
			}
			else if(numero == 2) {
				lista.add( Colores.NEGRO+"*"+Colores.RESET );
				
			}else {
				salir = true;
			}
		}while(!salir);
		
		return lista;
	}
	protected Combinacion[] primerIntentoIA() {
		int numero = 0;
		Combinacion[] combinacion = new Combinacion[combinacionGanadora.length];
	
		numero = (int) ( Math.random() * modo.getMaxColores() + 1 );
		for(int x = 0 ; x < combinacionGanadora.length ; x++ ) {
			combinacion[x] = new Combinacion(numero);
		}
		combinaciones = combinacion;
		return combinacion;
		
	}
	
	protected Combinacion[] nuevoIntento() {
		ArrayList < String > lista = new ArrayList();
		Iterator it = lista.iterator();
		Combinacion[] combinacion = new Combinacion[combinacionGanadora.length];
		
		combinacion = demasIntentoIA();
		lista.clear();
		lista=comprobacion();
		if(lista.size()==combinacionGanadora.length) {
		mejorIntento(lista);	
		}
		coloresAcertados.clear();
		if(lista.isEmpty()) {
			listaColores.add( combinaciones[0].getNumero() );
		}else {
			for(int x = 0 ; x < lista.size() ; x++ ) {
				coloresAcertados.add( combinaciones[x].getNumero() );
			}
		}
		return combinacion;
	}



	private Combinacion[] demasIntentoIA() {
		Combinacion[] combinacion = new Combinacion[combinacionGanadora.length];
		Iterator it = coloresAcertados.iterator();
		int i = 0;
		boolean primeros = false;
		boolean salir = false;
		boolean completo=false;
		int numero2=0;
		int aciertos=0;
		Colores color;
		if( coloresAcertados.size() == combinacionGanadora.length) {
			
			do {
				if(ochoNegros) {
					
					do {
						if(it.hasNext()) {
					
							color= new Colores((int) it.next());
							do {
								numero2 = (int)  (Math.random() *(combinacion.length-0))+0;
							
								if(combinacion[numero2]==null) {	
									System.out.println(numero2);
									if(peorIntento[numero2].getNumero()!=color.getNumero()) {
										combinacion[numero2]=new Combinacion( color.getNumero());
										completo=true;
										
									}
								
								}
							
							}while(!completo);
							
						}else {
							salir=true;
						}
					
						completo=false;
					}while(!salir);
				
				}else {
					if(it.hasNext()) {
						numero2 = (int)  (Math.random() *(combinacion.length-0))+0;	
				
						if(numero2<combinacionGanadora.length && combinacion[numero2]==null) {
							combinacion[numero2]=new Combinacion( (int) it.next() );
						
						}
					
					}else {
						if(!mejoresIntentos.contains(combinacion)) {
							mejoresIntentos.add(combinacion);
							salir=true;
						
						}else {
						//System.out.println("repite");
						//tecladoGenerico.TecladoGenerico.leerTeclado(Numero.INT);
							it = coloresAcertados.iterator();
						}
					
					}
				}
				
			}while(!salir);
			salir=false;
			//final de la IA
				
				//combinacion=mejorIntento;
				
				//ya tengo la mejor combinacion, cambiar poasiciones para que mejore el numero de rojos
				
			
		}else {
			do {
				if( i < combinacionGanadora.length && it.hasNext()) {
					combinacion[i] = new Combinacion( (int) it.next() );
					listaColores.add( combinacion[i].getNumero() );
					i++;
				}else {
					primeros = true;
				}
			}while( !primeros );
			
			do {
				int numero = (int) ( Math.random() * modo.getMaxColores()+1);	
				if(!listaColores.contains(numero)) {
					listaColores.add(numero);
					for(int x = i ; x < combinacionGanadora.length ; x++ ) {
						combinacion[x] = new Combinacion(numero);
					}
					salir = true;
				}
			}while(!salir);
		}
		combinaciones = combinacion;
		return combinacion;
	}

	public ArrayList<String> comprobacion() {
		
		HashMap<Integer,String> conjuntoColores=new HashMap <Integer,String>();
		ArrayList<String> lista= new ArrayList();
		String rojo=Colores.ROJO+"*"+Colores.RESET;
		String negro=Colores.NEGRO+"*"+Colores.RESET;
		boolean encontrado=false;
		boolean salir=false;          
	
		int uno=0;
		int dos=0;
		int x=0;
	
		do {
			
			if(uno<combinacionGanadora.length && combinaciones[uno].equals(combinacionGanadora[dos])) {
					x=uno;
					do {
						
						if(x<combinacionGanadora.length && combinaciones[x].equals(combinacionGanadora[dos])) {
							
							if(x==dos) {
								conjuntoColores.remove(dos, negro);
								conjuntoColores.put(dos, rojo);
								dos++;
								uno=-1;
								salir=true;
							}else {
								if(!encontrado) {
								conjuntoColores.put(dos, negro);
								encontrado=true;
								}
								
							}
						}else {
							if(!encontrado) {
								conjuntoColores.put(0, negro);
								encontrado=true;
								}
						}
						if(x>=combinacionGanadora.length) {
							salir=true;
						}
					x++;
					}while(!salir);
					
				encontrado=false;
				salir=false;
			}	
				
			
			
			if(uno>combinacionGanadora.length) {
					uno=-1;
					dos++;
			}
			if(dos>=combinacionGanadora.length) {
					salir=true;
			}
			
			uno++;	
		}while(!salir);
	
		lista.addAll(conjuntoColores.values());
		
		return lista;
		
	}

	private void mejorIntento(ArrayList<String> lista) {
		Iterator it = lista.iterator();
		
		 Set<Integer> numeros=aciertos.keySet();
		 Iterator itNum = numeros.iterator();
		 String cadena;
		 int rojos=0;
		 int negros=0;
		 int acierto=0;
		boolean salir=false;
		do {
			
			
			if(it.hasNext()) {
				cadena=(String) it.next();
				if(cadena==Colores.ROJO+"*"+Colores.RESET) {
					rojos++;
					
				}else {
					negros++;
				}
			}else {
				salir=true;
			}
			
		
		}while(!salir);
		
	
		if(negros==8) {
			ochoNegros=true;
			peorIntento=combinaciones;
		}
		
		
		//System.out.println("numero de aciertos "+ aciertos.keySet());
		else if(aciertos.isEmpty()) {
			aciertos.put(rojos, combinaciones);
		}else {
			do {
				if(itNum.hasNext()) {
					acierto=(int) itNum.next();
					if(rojos>acierto) {
						
						aciertos.clear();
						aciertos.put(rojos, combinaciones);
						
						//System.out.println("numero de aciertos "+ aciertos.keySet());
						//Colores.mostrarColores(combinaciones);
						if(rojos==8) {
							tecladoGenerico.TecladoGenerico.leerTeclado(Numero.INT);
						}
					}
				}
				
			}while(!salir);
		}
		}
//			
	
		
		
		
		
//		if(listaAciertos.size()<intento.size()) {
//			listaAciertos.clear();
//			listaAciertos.addAll(intento);
//		}
//		if(listaAciertos.size()==intento.size()) {
//			//aqui me quedo
//		}
		
		
	

	public void mejorIntento() {
		
		Colores.mostrarColores(peorIntento);
	}

	
	
}
