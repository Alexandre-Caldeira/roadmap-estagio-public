package br.com.radixeng.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.radixeng.modelo.Contact;

public class ContactDao implements DAO<Contact>{
	private EntityManager em;

	public ContactDao(EntityManager em) {
		this.em = em;
	}

	public Contact buscarPorId(Long id) {
		return em.find(Contact.class, id);
	}

	public List<Contact> buscarTodos() {
		String jpql = "SELECT ct FROM Contact ct";
		return em.createQuery(jpql, Contact.class).getResultList();
	}

	public void cadastrar(Contact t) {
		this.em.persist(t);
	}

	public Contact atualizar(Contact t) {
		return this.em.merge(t);
	}

	public void remover(Contact t) {
		t = em.merge(t);
		this.em.remove(t);
	}
	
}
