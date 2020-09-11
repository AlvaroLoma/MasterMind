package masterMind;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PruebasTest {

	String rojo = Colores.ROJO + "*" + Colores.RESET;
	String negro = Colores.NEGRO + "*" + Colores.RESET;

<<<<<<< Updated upstream
=======
<<<<<<< HEAD
	@Test
	void comprobacionModoDIficilCorrecta() {
		ModoJuego modo = ModoJuego.DIFICIL;
		Jugador jugador1 = new Maquina(modo);
		ArrayList<String> lista = new ArrayList();
		for (int x = 0; x < modo.getNumCasillas(); x++) {
			jugador1.combinacionGanadora[x] = new Combinacion(x);
			jugador1.combinaciones[x] = new Combinacion(x);
			lista.add(rojo);
		}

		Assert.assertEquals(lista, jugador1.comprobacion());

	}

	@Test
	void comprobacionModoDificilIncorrecta() {
		ModoJuego modo = ModoJuego.DIFICIL;
		Jugador jugador1 = new Maquina(modo);
		ArrayList<String> lista = new ArrayList();
		for (int x = 0; x < modo.getNumCasillas(); x++) {
			jugador1.combinacionGanadora[x] = new Combinacion(x);
			jugador1.combinaciones[x] = new Combinacion(x + 1);
			lista.add(rojo);
		}
		jugador1.combinacionGanadora[1] = new Combinacion(6);

		Assert.assertNotEquals(lista, jugador1.comprobacion());
	}
=======
>>>>>>> Stashed changes
//	@Test
//	void comprobacionModoDIficilCorrecta() {
//		ModoJuego modo = ModoJuego.DIFICIL;
//		Jugador jugador1 = new Maquina(modo);
//		ArrayList<String> lista = new ArrayList();
//		for (int x = 0; x < modo.getNumCasillas(); x++) {
//			jugador1.combinacionGanadora[x] = new Combinacion(x);
//			jugador1.combinaciones[x] = new Combinacion(x);
//			lista.add(rojo);
//		}
//
//		Assert.assertEquals(lista, jugador1.comprobacion());
//
//	}
//
//	@Test
//	void comprobacionModoDificilIncorrecta() {
//		ModoJuego modo = ModoJuego.DIFICIL;
//		Jugador jugador1 = new Maquina(modo);
//		ArrayList<String> lista = new ArrayList();
//		for (int x = 0; x < modo.getNumCasillas(); x++) {
//			jugador1.combinacionGanadora[x] = new Combinacion(x);
//			jugador1.combinaciones[x] = new Combinacion(x + 1);
//			lista.add(rojo);
//		}
//		jugador1.combinacionGanadora[1] = new Combinacion(6);
//
//		Assert.assertNotEquals(lista, jugador1.comprobacion());
//	}
<<<<<<< Updated upstream
=======
>>>>>>> master
>>>>>>> Stashed changes

	@Test
	void comprobacionModoMedioCorrecta() {
		ModoJuego modo = ModoJuego.MEDIO;
		ArrayList<String> lista = new ArrayList();
		Jugador jugador1 = new Maquina(modo);
		for (int x = 0; x < modo.getNumCasillas(); x++) {
			jugador1.combinaciones[x] = new Combinacion(x + 1);
			lista.add(rojo);
		}

		Assert.assertEquals(lista, ((Maquina) jugador1).comprobacionM());
	}

	@Test
	void comprobacionModoMedioIncorrecta() {
		ModoJuego modo = ModoJuego.MEDIO;
		ArrayList<String> lista = new ArrayList();
		Jugador jugador1 = new Maquina(modo);
		for (int x = 0; x < modo.getNumCasillas(); x++) {
			jugador1.combinaciones[x] = new Combinacion(x + 1);
			lista.add(rojo);
		}
		jugador1.combinaciones[3] = new Combinacion(7);
		Assert.assertNotEquals(lista, ((Maquina) jugador1).comprobacionM());
	}

	@Test
	void comprobacionModoFacilCorrecta() {
		ModoJuego modo = ModoJuego.FACIL;
		ArrayList<String> lista = new ArrayList();
		Jugador jugador1 = new Maquina(modo);
		for (int x = 0; x < modo.getNumCasillas(); x++) {
			jugador1.combinaciones[x] = new Combinacion(x + 1);
			lista.add(rojo);
		}

		Assert.assertEquals(lista, ((Maquina) jugador1).comprobacionM());
	}

	@Test
	void comprobacionModoFacilIncorrecta() {
		ModoJuego modo = ModoJuego.FACIL;
		ArrayList<String> lista = new ArrayList();
		Jugador jugador1 = new Maquina(modo);
		for (int x = 0; x < modo.getNumCasillas(); x++) {
			jugador1.combinaciones[x] = new Combinacion(x + 1);
			lista.add(rojo);
		}
		jugador1.combinaciones[0] = new Combinacion(8);
		Assert.assertNotEquals(lista, ((Maquina) jugador1).comprobacionM());
	}

	@Test
	void combinacionIncompletaModoMedio() {
		ModoJuego modo = ModoJuego.MEDIO;

		Jugador jugador1 = new Maquina(modo);

		for (int x = 1; x < modo.getNumCasillas(); x++) {
			jugador1.combinaciones[x] = new Combinacion(x + 1);
		}

		Assertions.assertThrows(NullPointerException.class, () -> {
			((Maquina) jugador1).comprobacionM();
		});

	}

	@Test
	void combinacionIncompletaModoDificil() {
		ModoJuego modo = ModoJuego.DIFICIL;
		Jugador jugador1 = new Maquina(modo);
		for (int x = 1; x < modo.getNumCasillas(); x++) {
			jugador1.combinaciones[x] = new Combinacion(x + 1);
		}

		Assertions.assertThrows(NullPointerException.class, () -> {
			jugador1.comprobacion();
		});

	}

	@Test
	void combinacionIncompletaModoFacil() {
		ModoJuego modo = ModoJuego.FACIL;
		Jugador jugador1 = new Maquina(modo);
		for (int x = 1; x < modo.getNumCasillas(); x++) {
			jugador1.combinaciones[x] = new Combinacion(x + 1);
		}

		Assertions.assertThrows(NullPointerException.class, () -> {
			((Maquina) jugador1).comprobacionM();
		});

	}

	@Test
	void combinacionLargaModoDificil() {
		ModoJuego modo = ModoJuego.DIFICIL;
		Jugador jugador1 = new Maquina(modo);
		Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
			jugador1.combinaciones[modo.getNumCasillas() + 1] = new Combinacion(1);
		});
	}

	@Test
	void combinacionLargaModoMedio() {
		ModoJuego modo = ModoJuego.MEDIO;
		Jugador jugador1 = new Maquina(modo);
		Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
			jugador1.combinaciones[modo.getNumCasillas() + 1] = new Combinacion(1);
		});
	}

	@Test
	void combinacionLargaModoFacil() {
		ModoJuego modo = ModoJuego.FACIL;
		Jugador jugador1 = new Maquina(modo);
		Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
			jugador1.combinaciones[modo.getNumCasillas() + 1] = new Combinacion(1);
		});
	}

}
