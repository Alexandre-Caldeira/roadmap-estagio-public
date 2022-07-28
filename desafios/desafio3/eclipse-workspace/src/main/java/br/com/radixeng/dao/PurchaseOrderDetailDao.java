package br.com.radixeng.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.radixeng.modelo.PurchaseOrderDetail;

public class PurchaseOrderDetailDao implements DAO<PurchaseOrderDetail> {
	
	private EntityManager em;

	public PurchaseOrderDetailDao(EntityManager em) {
		this.em = em;
	}
	
	public PurchaseOrderDetail buscarPorId(Long id) {
		return em.find(PurchaseOrderDetail.class, id);
	}

	public List<PurchaseOrderDetail> buscarTodos() {
		String jpql = "SELECT pod FROM PurchaseOrderDetail pod";
		return em.createQuery(jpql, PurchaseOrderDetail.class).getResultList();
	}

	public void cadastrar(PurchaseOrderDetail t) {
		this.em.persist(t);
	}

	public PurchaseOrderDetail atualizar(PurchaseOrderDetail t) {
		return this.em.merge(t);
	}

	public void remover(PurchaseOrderDetail t) {
		t = em.merge(t);
		this.em.remove(t);
	}

}
