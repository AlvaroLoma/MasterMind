package masterMind;
import java.awt.Canvas;
import java.awt.Paint;
import java.lang.System;




public class Colores {

	public static final String RESET = "\u001B[0m";
	public static final String NEGRO = "\u001B[30m";
	public static final String ROJO = "\u001B[31m";
	public static final String VERDE = "\u001B[32m";
	public static final String AMARILLO = "\u001B[33m";
	public static final String AZUL = "\u001B[34m";
	public static final String MORADO = "\u001B[35m";
	public static final String CELESTE = "\u001B[36m";
	public static final String BLANCO = "\u001B[37m";
	
	
	public static final String FONDO_NEGRO = "\u001B[40m";
	public static final String FONDO_BURDEO = "\u001B[41m";
	public static final String FONDO_VERDE = "\u001B[42m";
	public static final String FONDO_MOSTAZA = "\u001b[43m";
	public static final String FONDO_AZUL = "\u001B[104m";
	public static final String FONDO_MORADO = "\u001B[45m";
	public static final String FONDO_CELESTE = "\u001B[46m";
	public static final String FONDO_BLANCO = "\u001B[47m";
	public static final String FONDO_ROSA = "\u001B[105m";
	public static final String FONDO_GRIS = "\u001B[100m";
	public static final String FONDO_AMARILLO = "\u001b[103m";
	public static final String FONDO_ROJO = "\u001B[101m";
	
	
	public static final String FONDO_AZULF = "\u001B[44m";
	public static final String FONDO_VERDEF = "\u001B[102m";
	public static final String FONDO_CELESTEF= "\u001B[106m";
	public static final String FONDO_BLANCOF = "\u001B[107m";
	
		protected int numero;
		protected String colores;
		public Colores(int color) {
			
			switch(color){
				
			case 1:
				colores=Colores.FONDO_AMARILLO;
				numero=1;
				break;
			case 2:
				colores=Colores.FONDO_ROSA;
				numero=2;
				break;
			case 3:
				colores=Colores.FONDO_CELESTE;
				numero=3;
				break;
			case 4:
				colores=Colores.FONDO_MORADO;
				numero=4;
				break;
			case 5:
				colores=Colores.FONDO_VERDE;
				numero=5;
				break;
			case 6:
				colores=Colores.FONDO_BURDEO;
				numero=6;
				break;
			case 7:
				colores=Colores.FONDO_GRIS;
				numero=7;
				break;
			case 8:
				colores=Colores.FONDO_AZUL;
				numero=8;
				break;
			case 9:
				colores=Colores.FONDO_MOSTAZA;
				numero=9;
				break;
			case 10:
				colores=Colores.FONDO_ROJO;
				numero=10;
				break;
				
			}
		}

		public static void mostrarColores() {
			
			System.out.print(Colores.FONDO_AMARILLO+" 1 "+Colores.RESET+" ");
			System.out.print(Colores.FONDO_ROSA+" 2 "+Colores.RESET+" ");
			System.out.print(Colores.FONDO_CELESTE+" 3 "+Colores.RESET+" ");
			System.out.print(Colores.FONDO_MORADO+" 4 "+Colores.RESET+" ");
			System.out.print(Colores.FONDO_VERDE+" 5 "+Colores.RESET+" ");
			System.out.print(Colores.FONDO_BURDEO+" 6 "+Colores.RESET+" ");
			System.out.print(Colores.FONDO_GRIS+" 7 "+Colores.RESET+" ");
			System.out.print(Colores.FONDO_AZUL+Colores.BLANCO+" 8 "+Colores.RESET+" ");
			System.out.println();
				
		
		}

		public String dibujarColor() {
			
			String cadena=colores+"  "+Colores.RESET+"  ";
			return cadena;
		}

		public boolean equals(Colores combinacion) {
			
			return numero==combinacion.numero;
			
		}

		public String getColor() {
		
			return colores+"   "+Colores.RESET+" ";
		}

		public void setColores(String value) {
			colores=value;
			
		}

		public int getNumero() {
			
			return numero;
		}

		public static void mostrarColores(Combinacion[] combinacionGanadora) {
			
			for(int i=0;i<combinacionGanadora.length;i++) {
				System.out.print(combinacionGanadora[i].casilla.color.colores+"  "+Colores.RESET+" ");
			}
			System.out.println();
		}
}
