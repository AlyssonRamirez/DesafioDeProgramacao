package exercicios;

import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.Test;

class Questao01Test {
	private Montador objMontador ;
	public Questao01Test() {
		objMontador = new Montador(6,'*');
	}

	@Test
	void testPrimeiraLinha() {
		assertEquals("     *",objMontador.montarLinha(6));
	}
	
	@Test
	void testSegundaLinha() {
		assertEquals("    **",objMontador.montarLinha(5));
	}
	
	@Test
	void testTerceiraLinha() {
		assertEquals("   ***",objMontador.montarLinha(4));
	}
	
	@Test
	void testQuartaLinha() {
		assertEquals("  ****",objMontador.montarLinha(3));
	}
	
	@Test
	void testQuintaLinha() {
		assertEquals(" *****",objMontador.montarLinha(2));
	}
	
	@Test
	void testSextaLinha() {
		assertEquals("******",objMontador.montarLinha(1));
	}

}
