package br.com.radixeng.exemplo;

import java.util.List;

import javax.persistence.EntityManager;
import br.com.radixeng.dao.CustomerAddressDao;
import br.com.radixeng.modelo.CustomerAddress;
import br.com.radixeng.util.JPAUtil;

public class ExemploSelectCustomerID {
	public static void main(String[] args) {
		EntityManager em = JPAUtil.getEntityManager();
		CustomerAddressDao CustomerAddressDao = new CustomerAddressDao(em);
		em.getTransaction().begin();
		
		List<CustomerAddress> todos = CustomerAddressDao.buscarTodos();
				
		todos.forEach(ca -> {
				System.out.println(ca.getCustomerID()+": "+ca.getRowguid()+" "+ca.getAddressID()+" ");
//		+ca.getAddress().getAddressLine1());
		});
		
		em.getTransaction().commit();
		em.close();
	}

}
