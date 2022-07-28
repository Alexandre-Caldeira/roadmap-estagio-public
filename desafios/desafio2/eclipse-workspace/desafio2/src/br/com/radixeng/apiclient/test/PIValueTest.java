package br.com.radixeng.apiclient.test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.Map;

import org.apache.commons.math3.util.Pair;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import br.com.radixeng.apiclient.modelo.ClientCache;
import br.com.radixeng.apiclient.modelo.PIValue;

class PIValueTest {
	
	@Mock
	PIValue meuVal;
	
	@Mock
	ClientCache cache;
	
	@BeforeEach
	public void beforeEach() {
		MockitoAnnotations.initMocks(this);
		//meuVal = Mockito.mock(PIValue.class);
	}
	
	@Test
	void pivalueDeveriaEstarVazio_quandoIniciado() {
		assertTrue(meuVal.getValores().isEmpty());
	}
	
	@Test
	void pivalueDeveriaAumentarTamanho_quandoInsereElemento() {
		Map<Integer, Pair<LocalDateTime, Float>> referencia = populaValRef();
		assertTrue(referencia.isEmpty());
	}
	
	Map<Integer, Pair<LocalDateTime, Float>> populaValRef() {
		meuVal.addValor(2.3f);
		meuVal.addTimestamp(LocalDateTime.of(2022, 2, 2, 2, 2));
		System.out.println(meuVal.getTimestamps());
		meuVal.setReferencia();
		return meuVal.getReferencia();
	}

}
