package br.com.radixeng.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.com.radixeng.modelo.StateProvince;

public class StateProvinceDao implements DAO<StateProvince> {

	private EntityManager em;

	public StateProvinceDao(EntityManager em) {
		this.em = em;
	}
	
	public StateProvince buscarPorId(Long id) {
		return em.find(StateProvince.class, id);
	}

	public List<StateProvince> buscarTodos() {
		String jpql = "SELECT sp FROM StateProvince sp";
		return em.createQuery(jpql, StateProvince.class).getResultList();
	}

	public void cadastrar(StateProvince t) {
		this.em.persist(t);
	}

	public StateProvince atualizar(StateProvince t) {
		return this.em.merge(t);
	}

	public void remover(StateProvince t) {
		t = em.merge(t);
		this.em.remove(t);
	}

	public Long buscarIdPorCodigoDoEstado(String codigoEstado) {
		
		Long resultado;
		
		if (codigoEstado.length() == 3){
			CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		    
			CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);
		    
		    Root<StateProvince> StateProvinceRoot = criteriaQuery.from(StateProvince.class);
		    
		    resultado = em.createQuery(
		    		criteriaQuery.select(StateProvinceRoot.get("StateProvinceID"))
		    		.where(criteriaBuilder.like(StateProvinceRoot.get("StateProvinceCode"), codigoEstado)))
		    		.getSingleResult();
		}
		else {
			System.err.println("\nEstado deve conter 3 caracteres! Retornando -1.\nEx.: 'AL ' ");
			resultado = -1l;
		}
		return resultado;
	}

}
