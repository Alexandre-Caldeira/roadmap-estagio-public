package br.com.alura.leilao.service;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import br.com.alura.leilao.dao.PagamentoDao;
import br.com.alura.leilao.model.Lance;
import br.com.alura.leilao.model.Leilao;
import br.com.alura.leilao.model.Pagamento;
import br.com.alura.leilao.model.Usuario;

class GeradorDePagamentoTest {

	private GeradorDePagamento gerador;
	
	@Mock
	private PagamentoDao pagamentoDao;
	
	@Captor
	private ArgumentCaptor<Pagamento> captor;
	
	@BeforeEach
	public void beforeEach() {
		MockitoAnnotations.initMocks(this);
		this.gerador =new GeradorDePagamento(pagamentoDao);
	}
	
	@Test
	void deveriaCriarPagamentoParaVencedorDoLeilao() {
		
		Leilao leilao = leilao();
		Lance vencedor = leilao.getLanceVencedor();
	
		gerador.gerarPagamento(vencedor);
		
		// verificando objeto criado dentro do teste:
		Mockito.verify(pagamentoDao).salvar(captor.capture());
		Pagamento pagamento = captor.getValue();
		assertEquals(LocalDate.now().plusDays(1), pagamento.getVencimento());
		assertEquals(vencedor.getValor(), pagamento.getValor());
		assertFalse(pagamento.getPago());
		assertEquals(vencedor.getUsuario(), pagamento.getUsuario());
		assertEquals(leilao, pagamento.getLeilao());
	}

	private Leilao leilao() {
		
		Leilao leilao = new Leilao("Celular", 
				new BigDecimal("500"), new Usuario("Fulano"));
		
		Lance lance = new Lance(new Usuario("Beltrano"), new BigDecimal("600"));

		leilao.propoe(lance);
		leilao.setLanceVencedor(lance);
		
		return leilao;
	}
}
