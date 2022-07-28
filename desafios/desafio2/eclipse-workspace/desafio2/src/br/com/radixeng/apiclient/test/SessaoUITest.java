package br.com.radixeng.apiclient.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import br.com.radixeng.apiclient.modelo.SessaoUI;

class SessaoUITest {

	@Test 
	void cacheDeveriaEstarVazio_quandoIniciado() {
		SessaoUI ui = Mockito.mock(SessaoUI.class);
		assertEquals(0, ui.getClientCache().getTamanho());
	}

}
