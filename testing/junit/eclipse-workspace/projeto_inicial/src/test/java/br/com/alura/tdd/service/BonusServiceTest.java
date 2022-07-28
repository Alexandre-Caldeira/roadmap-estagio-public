package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Funcionario;

class BonusServiceTest {

	@Test
	void calculaBonusDeveriaSerZeroParaFuncionarioComSalarioMuitoAlto() {
		BonusService service = new BonusService();
		BigDecimal bonus = service.calcularBonus(new Funcionario("Jose", LocalDate.now(), new BigDecimal(25000)));
		assertEquals(new BigDecimal("0.00"), bonus);
	}
	
	@Test
	void calculaBonusretorna10PorCento() {
		BonusService service = new BonusService();
		BigDecimal bonus = service.calcularBonus(new Funcionario("Jose", LocalDate.now(), new BigDecimal(2500)));
		assertEquals(new BigDecimal("250.00"), bonus);
	}

	@Test
	void calculaBonus() {
		BonusService service = new BonusService();
		BigDecimal bonus = service.calcularBonus(new Funcionario("Jose", LocalDate.now(), new BigDecimal(2500)));
		assertEquals(new BigDecimal("250.00"), bonus);
	}

}
