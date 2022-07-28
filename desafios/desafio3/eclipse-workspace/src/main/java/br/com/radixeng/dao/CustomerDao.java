package br.com.radixeng.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.radixeng.modelo.Address;
import br.com.radixeng.modelo.Customer;

public class CustomerDao implements DAO<Customer> {

	private EntityManager em;

	public CustomerDao(EntityManager em) {
		this.em = em;
	}
	
	public Customer buscarPorId(Long id) {
		return em.find(Customer.class, id);
	}

	public List<Customer> buscarTodos() {
		String jpql = "SELECT c FROM Customer c";
		return em.createQuery(jpql, Customer.class).getResultList();
	}

	public void cadastrar(Customer t) {
		this.em.persist(t);
	}

	public Customer atualizar(Customer t) {
		return this.em.merge(t);
	}

	public void remover(Customer t) {
		t = em.merge(t);
		this.em.remove(t);
	}
	
	public List<Address> buscarEnderecos() {
		return em.createNamedQuery("Customer.buscarEnderecos").getResultList();
	}

}
