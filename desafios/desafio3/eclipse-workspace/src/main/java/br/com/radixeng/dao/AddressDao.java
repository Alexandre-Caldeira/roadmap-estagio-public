package br.com.radixeng.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.radixeng.modelo.Address;

public class AddressDao implements DAO<Address> {

	private EntityManager em;

	public AddressDao(EntityManager em) {
		this.em = em;
	}
	
	public Address buscarPorId(Long id) {
		return em.find(Address.class, id);
	}

	public List<Address> buscarTodos() {
		String jpql = "SELECT a FROM Address a";
		return em.createQuery(jpql, Address.class).getResultList();
	}

	public void cadastrar(Address t) {
		this.em.persist(t);
	}

	public Address atualizar(Address t) {
		return this.em.merge(t);
	}

	public void remover(Address t) {
		t = em.merge(t);
		this.em.remove(t);
	}
	
	public List<Address> buscarEnderecosComEstado(Long id) {
		return em.createQuery("SELECT a FROM Address a WHERE a.StateProvinceID = :id", Address.class)
				.setParameter("id", id)
				.getResultList();
	}

}
