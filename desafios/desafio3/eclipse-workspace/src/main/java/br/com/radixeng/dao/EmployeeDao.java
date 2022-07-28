package br.com.radixeng.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.radixeng.modelo.Employee;

public class EmployeeDao implements DAO<Employee> {

	private EntityManager em;

	public EmployeeDao(EntityManager em) {
		this.em = em;
	}
	
	public Employee buscarPorId(Long id) {
		return em.find(Employee.class, id);
	}

	public List<Employee> buscarTodos() {
		String jpql = "SELECT e FROM Employee e";
		return em.createQuery(jpql, Employee.class).getResultList();
	}

	public void cadastrar(Employee t) {
		this.em.persist(t);
	}

	public Employee atualizar(Employee t) {
		return this.em.merge(t);
	}

	public void remover(Employee t) {
		t = em.merge(t);
		this.em.remove(t);
	}

}
