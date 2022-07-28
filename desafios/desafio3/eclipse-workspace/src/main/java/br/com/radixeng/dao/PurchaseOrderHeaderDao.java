package br.com.radixeng.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.radixeng.modelo.PurchaseOrderHeader;

public class PurchaseOrderHeaderDao implements DAO<PurchaseOrderHeader> {

	private EntityManager em;

	public PurchaseOrderHeaderDao(EntityManager em) {
		this.em = em;
	}
	
	public PurchaseOrderHeader buscarPorId(Long id) {
		return em.find(PurchaseOrderHeader.class, id);
	}

	public List<PurchaseOrderHeader> buscarTodos() {
		String jpql = "SELECT poh FROM PurchaseOrderHeader poh";
		return em.createQuery(jpql, PurchaseOrderHeader.class).getResultList();
	}

	public void cadastrar(PurchaseOrderHeader t) {
		this.em.persist(t);
	}

	public PurchaseOrderHeader atualizar(PurchaseOrderHeader t) {
		return this.em.merge(t);
	}

	public void remover(PurchaseOrderHeader t) {
		t = em.merge(t);
		this.em.remove(t);
	}

}
