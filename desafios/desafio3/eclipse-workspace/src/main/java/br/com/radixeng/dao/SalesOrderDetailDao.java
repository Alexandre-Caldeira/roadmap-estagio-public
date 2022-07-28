package br.com.radixeng.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.radixeng.modelo.SalesOrderDetail;

public class SalesOrderDetailDao implements DAO<SalesOrderDetail> {

	private EntityManager em;

	public SalesOrderDetailDao(EntityManager em) {
		this.em = em;
	}
	
	
	public SalesOrderDetail buscarPorId(Long id) {
		return em.find(SalesOrderDetail.class, id);
	}

	public List<SalesOrderDetail> buscarTodos() {
		String jpql = "SELECT soh FROM SalesOrderDetail soh";
		return em.createQuery(jpql, SalesOrderDetail.class).getResultList();
	}

	public void cadastrar(SalesOrderDetail t) {
		this.em.persist(t);
	}

	public SalesOrderDetail atualizar(SalesOrderDetail t) {
		return this.em.merge(t);
	}

	public void remover(SalesOrderDetail t) {
		t = em.merge(t);
		this.em.remove(t);
	}

}
