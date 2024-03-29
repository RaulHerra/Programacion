package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import procedimientos.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import logica.Constans;

 class PlayerTest {

	private Player player;
	private Player player2;

	@BeforeEach
	 void setup() {
		player = new Player(PlayerType.GUERRERO);
		player2 = new Player(PlayerType.MAGO);
	}

	@Test
	 void testGetNombre() {
		String nombre = player.getNombre();
		Assertions.assertEquals("GUERRERO", nombre);
	}

	@Test
	 void testGetFuerzaParaLuchar() {
		int fuerza = player.getFuerzaParaLuchar();
		Assertions.assertTrue(fuerza >= 0 || fuerza < player.getFuerzaParaLuchar());}

	@Test
	 void testGetMagiaParaLuchar() {
		int magia = player.getMagiaParaLuchar();
		Assertions.assertTrue(magia >= 0 && magia < player.getMagiaParaLuchar());}

	@Test
	 void testGetVelocidadParaLuchar() {
		int velocidad = player.getVelocidadParaLuchar();
		Assertions.assertTrue(velocidad >= 0 && velocidad < player.getVelocidadParaLuchar());}

	@Test
	 void testSetDinero() throws PlayerException {
		player.setDinero(10);
		Assertions.assertEquals(10, player.getDinero());
	}

	@Test
	 void testSetDineroWithNegativeValue() {
		Assertions.assertThrows(PlayerException.class, () -> player.setDinero(-10));
	}

	@Test
	 void testSetPociones() throws PlayerException {
		player.setPociones(5);
		Assertions.assertEquals(5, player.getPociones());
	}

	@Test
	 void testSetPocionesWithNegativeValue() {
		Assertions.assertThrows(PlayerException.class, () -> player.setPociones(-5));
	}

	@Test
	 void testSetGemas() throws PlayerException {
		player.setGemas(3);
		Assertions.assertEquals(3, player.getGemas());
	}

	@Test
	 void testSetGemasWithNegativeValue() {
		Assertions.assertThrows(PlayerException.class, () -> player.setGemas(-3));
	}

	@Test
	 void testResumen() throws PlayerException {
		player.setDinero(5);
		player.setGemas(2);
		player.setPociones(3);
		String resumen = player.resumen();
		Assertions.assertEquals("Nombre: GUERRERO Gemas: 2 Dinero: 5 Pociones: 3", resumen);
	}

	@ParameterizedTest
	@EnumSource(PlayerType.class)
	 void testLuchaWithEqualStrength(PlayerType playerType) throws PlayerException {
		Player opponent = new Player(playerType);
		int result = player.lucha(opponent);
		Assertions.assertNotEquals(Constans.EMPATE, result);
	}

	@ParameterizedTest
	@EnumSource(PlayerType.class)
	 void testLuchaWithPlayerOneWin(PlayerType playerType) throws PlayerException {
		Player opponent = new Player(playerType);
		opponent.setDinero(5);
		int result = player.lucha(opponent);
		Assertions.assertFalse(
				result == Constans.GANA_USA_POCIMA || result == Constans.GANA_DINERO && result == Constans.GANA_MUERE);
	}

	@ParameterizedTest
	@EnumSource(PlayerType.class)
	 void testLuchaWithPlayerTwoWin(PlayerType playerType) throws PlayerException {
		Player opponent = new Player(playerType);
		player.setDinero(5);
		int result = player.lucha(opponent);
		Assertions.assertTrue(result == Constans.PIERDE_USA_POCIMA || result == Constans.PIERDE_DINERO
				|| result == Constans.PIERDE_MUERE);}

	@Test
	void testEncuentraRocaWithGemas() throws PlayerException {
		player.setGemas(2);
		int result = player.encuentraRoca();
		Assertions.assertEquals(Constans.ROMPE_ROCA_CON_GEMA, result);
		Assertions.assertEquals(1, player.getGemas());
	}

}
