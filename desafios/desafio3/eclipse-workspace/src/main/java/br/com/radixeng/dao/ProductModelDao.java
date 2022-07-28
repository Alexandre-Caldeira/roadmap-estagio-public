package br.com.radixeng.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.radixeng.modelo.ProductModel;

public class ProductModelDao implements DAO<ProductModel> {

	private EntityManager em;

	public ProductModelDao(EntityManager em) {
		this.em = em;
	}
	
	public ProductModel buscarPorId(Long id) {
		return em.find(ProductModel.class, id);
	}

	public List<ProductModel> buscarTodos() {
		String jpql = "SELECT pm FROM ProductModel pm";
		return em.createQuery(jpql, ProductModel.class).getResultList();
	}

	public void cadastrar(ProductModel t) {
		this.em.persist(t);
	}

	public ProductModel atualizar(ProductModel t) {
		return this.em.merge(t);
	}

	public void remover(ProductModel t) {
		t = em.merge(t);
		this.em.remove(t);
	}

}
