package br.com.radixeng.dao;

import java.util.List;
import javax.persistence.EntityManager;

import br.com.radixeng.modelo.SalesOrderHeader;

public class SalesOrderHeaderDao implements DAO<SalesOrderHeader>{
	
	private EntityManager em;

	public SalesOrderHeaderDao(EntityManager em) {
		this.em = em;
	}
	
	public SalesOrderHeader buscarPorId(Long id) {
		return em.find(SalesOrderHeader.class, id);
	}
	
	public List<SalesOrderHeader> buscarTodos() {
		String jpql = "SELECT soh FROM SalesOrderHeader soh";
		return em.createQuery(jpql, SalesOrderHeader.class).getResultList();
	}
	
	public void cadastrar(SalesOrderHeader salesOrderHeader) {
		this.em.persist(salesOrderHeader);
	}
	
	public SalesOrderHeader atualizar(SalesOrderHeader salesOrderHeader) {
		return this.em.merge(salesOrderHeader);
	}
	
	public void remover(SalesOrderHeader salesOrderDetail) {
		salesOrderDetail = em.merge(salesOrderDetail);
		this.em.remove(salesOrderDetail);
	}

}
