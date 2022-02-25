package exercicios;

import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.Test;

class Questao03Test {
	
	private AnagramaCheck objCheck ;
	
	public Questao03Test() {
		objCheck = new AnagramaCheck();
	}

	@Test
	void testAnagramasDaPrimeiraPalavra() {
		objCheck.iniciar("ovo"); 
		assertEquals(2,objCheck.getQuantidadeAnagramas());
	}
	
	@Test
	void testAnagramasDaSegundaPalavra() {
		objCheck.iniciar("ifailuhkqq"); 
		assertEquals(3,objCheck.getQuantidadeAnagramas());
	}
	 
}
