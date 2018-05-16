package masterMindLidia;


import java.util.InputMismatchException;
import java.util.Scanner;

public class Teclado {
	
	public static Scanner teclado = new Scanner(System.in);
	
	//Cerrar teclado
	public static void cerrarTeclado() {
		teclado.close();
	}
	
	//Lectura de si o no
	public static boolean leerBooleanSN(String mensaje1) {
		
		boolean booleano;
		char respuesta;
		
		
		do {
			System.out.println(mensaje1);
			respuesta = teclado.next().toLowerCase().charAt(0);
			if (respuesta=='s') {
				booleano = true;
			}
			else {
				booleano = false;
			}
		} while (respuesta!='s' && respuesta!='n');

		return booleano;
	}
	
	//Lectura byte
	public static byte leerByte() {
		
		byte numero=0;
		boolean error=false;

		do {
			error =  false;
			System.out.println("Introduzca un número:");
	
			try {
				numero = teclado.nextByte();
				error = false;
			} catch (InputMismatchException e) {
				System.out.println("Error. Número no válido");
				error = true;
			} finally {
				teclado.nextLine(); //En petición de números siempre se limpia el buffer
			}
		} while (error);
		
		return numero;
	}
	
	//Lectura int	
	public static int leerInt() {
		
		int numero=0;
		boolean error=false;


		do {
			error =  false;	
			
			try {
				numero = teclado.nextInt();
				error = false;
			} catch (InputMismatchException e) {
				System.out.println("Error. El valor introducido debe ser un número");
				error = true;
			} finally {
				teclado.nextLine();
			}
		} while (error==true);
		
		return numero;
	}
	public static int leerInt(String mensaje1) {
		
		int numero=0;
		boolean error=false;


		do {
			error =  false;		
			System.out.println(mensaje1);
			
			try {
				numero = teclado.nextInt();
				error = false;
			} catch (InputMismatchException e) {
				System.out.println("Error. Número no válido o el valor introducido debe ser un número");
				error = true;
			} finally {
				teclado.nextLine();
			}
		} while (error);
		
		return numero;
	}
	
	//Enumeración rangos
	public static enum Rango {
		AMBOSINCLUIDOS, AMBOSEXCLUIDOS, MININCMAXEXC, MINEXCMAXINC;
	}

	//Leer rango con sobrecarga	
	public static int leerRango(int minimo, int maximo, Rango rang, String mensaje1) {
		
		System.out.println(mensaje1);
		
		if (minimo>maximo) {
			throw new IllegalArgumentException("Error. Máximo no puede ser menor que mínimo");
		}
			
		int numeroUsuario;
		boolean error=false;
		
		do {
			error = false;
			numeroUsuario = leerInt();
			
			switch (rang) {
			
			case AMBOSINCLUIDOS:
				if (numeroUsuario < minimo || numeroUsuario > maximo) {
					System.out.println("Error. El número debe estar entre " + minimo + " y " + maximo + " incluidos");
					error = true;
				} 
				break;
			case AMBOSEXCLUIDOS:
				if (numeroUsuario <= minimo || numeroUsuario >= maximo) {
					System.out.println("Error. El número debe estar entre " + minimo + " y " + maximo + " no incluidos");
					error = true;
				} 
				break;
			case MININCMAXEXC:
				if (numeroUsuario < minimo || numeroUsuario >= maximo) {
					System.out.println("Error. El número debe estar entre " + minimo + " incluido y " + maximo + " no incluido");
					error = true;
				} 
				break;
			case MINEXCMAXINC:
				if (numeroUsuario <= minimo || numeroUsuario > maximo) {
					System.out.println("Error. El número debe estar entre " + minimo + " no incluido y " + maximo + " incluido");
					error =  true;
				} 
				else {
				}
				break;
			}
		} while (error);
		return numeroUsuario;
	}
	
}
	