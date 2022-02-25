package exercicios;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;


import org.junit.jupiter.api.Test;

class Questao02Test {
	
	private SenhaCheck objCheck ;
	
	public Questao02Test() {
		objCheck = new SenhaCheck();
	}

	@Test
	void testSenhaValida() {
		assertTrue(objCheck.validarSenha("abcdEF12#"));
	}
	
	@Test
	void testSenhaInValidaPoucosCaracteres() {
		assertFalse(objCheck.validarSenha("aBcd"));
	}
	
	@Test
	void testSenhaInValidaPoucosSemMaiuscula() {
		assertFalse(objCheck.validarSenha("abcdsa12#@"));
	}
	
	@Test
	void testSenhaInValidaPoucosSemMinuscula() {
		assertFalse(objCheck.validarSenha("ABCDES12#@"));
	}
	
	@Test
	void testSenhaInValidaPoucosSemNumero() {
		assertFalse(objCheck.validarSenha("abcdSDA@"));
	}

	
	 
}
