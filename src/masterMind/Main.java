package masterMind;

import java.io.IOException;
<<<<<<< Updated upstream

public class Main {  

	public static void main(String[] args) {
		Controlador controlador;
		int salir=0;
		do {
		controlador=new Controlador();
		salir++;

//		try {
//			controlador.fichero.write("<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		try {
			controlador.fichero.write("<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

=======

public class Main {  

	public static void main(String[] args) {
		Controlador controlador;
		int salir=0;
		do {
		controlador=new Controlador();
		salir++;
<<<<<<< HEAD
//		try {
//			controlador.fichero.write("<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
=======
		try {
			controlador.fichero.write("<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
>>>>>>> master
>>>>>>> Stashed changes
		}while(salir<5);
		try {
			controlador.fichero.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
