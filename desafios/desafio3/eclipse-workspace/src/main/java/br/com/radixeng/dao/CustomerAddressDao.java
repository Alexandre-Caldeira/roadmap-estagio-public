package br.com.radixeng.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.radixeng.modelo.CustomerAddress;


public class CustomerAddressDao implements DAO<CustomerAddress> {
	
	private EntityManager em;

	public CustomerAddressDao(EntityManager em) {
		this.em = em;
	}
	
	public CustomerAddress buscarPorId(Long id) {
		return em.find(CustomerAddress.class, id);
	}
	
	public List<CustomerAddress> buscarTodos() {
		String jpql = "SELECT ca FROM CustomerAddress ca";
		return em.createQuery(jpql, CustomerAddress.class).getResultList();
	}
	
	public void cadastrar(CustomerAddress customerAddress) {
		this.em.persist(customerAddress);
	}

	public CustomerAddress atualizar(CustomerAddress customerAddress) {
		return this.em.merge(customerAddress);
	}
	
	public void remover(CustomerAddress customerAddress) {
		customerAddress = em.merge(customerAddress);
		this.em.remove(customerAddress);
	}

}
