package br.com.radixeng.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.com.radixeng.modelo.Product;

public class ProductDao implements DAO<Product> {
	
	private EntityManager em;

	public ProductDao(EntityManager em) {
		this.em = em;
	}
	
	public Product buscarPorId(Long id) {
		return em.find(Product.class, id);
	}
	
	public List<Product> buscarTodos() {
		String jpql = "SELECT p FROM Product p";
		return em.createQuery(jpql, Product.class).getResultList();
	}
	
	public void cadastrar(Product product) {
		this.em.persist(product);
	}
	
	public Product atualizar(Product product) {
		return this.em.merge(product);
	}
	
	public void remover(Product product) {
		product = em.merge(product);
		this.em.remove(product);
	}

	public List<Product> buscarPorNome(String name) {
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
	    
		CriteriaQuery<Product> criteriaQuery = criteriaBuilder.createQuery(Product.class);
	    
	    Root<Product> productRoot = criteriaQuery.from(Product.class);
	    
	    List<Product> queryResult = em.createQuery(
	    		criteriaQuery.select(productRoot)
	    		.where(criteriaBuilder.like(productRoot.get("Name"), name))).getResultList();
		
		
		return queryResult;
	}

}
