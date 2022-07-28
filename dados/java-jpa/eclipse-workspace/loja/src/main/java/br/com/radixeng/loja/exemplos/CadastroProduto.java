package br.com.radixeng.loja.exemplos;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.radixeng.loja.modelo.Produto;

public class CadastroProduto {
	public static void main(String[] args) {
		Produto celular = new Produto();
		celular.setNome("Xiaomi Redmi");
		celular.setDescricao("Muito legal");
		celular.setPreco(new BigDecimal("800"));
		
		// Cria instancia da factory baseado no nome da nossa persistence unit (do .xml) 
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("loja");
		
		EntityManager em = emFactory.createEntityManager();
		
		// submetendo informacoes
		em.getTransaction().begin();
		em.persist(celular);
		em.getTransaction().commit();
		em.close();
		
	}
}
