package br.com.radixeng.exemplo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import br.com.radixeng.dao.AddressDao;
import br.com.radixeng.dao.CustomerAddressDao;
import br.com.radixeng.dao.CustomerDao;
import br.com.radixeng.modelo.Address;
import br.com.radixeng.modelo.Customer;
import br.com.radixeng.modelo.CustomerAddress;
import br.com.radixeng.util.JPAUtil;

public class ExemploORMPuroVsNamedQuery {
	public static void main(String[] args) {
		EntityManager em = JPAUtil.getEntityManager();

//		RUIM(em); // 8 segundos

		BOM(em); // +/- 2 segundos

	}

	public static void RUIM(EntityManager em) {
		CustomerAddressDao caDao = new CustomerAddressDao(em);
		em.getTransaction().begin();

		em.flush();

		List<CustomerAddress> listaCA = caDao.buscarTodos();

		AddressDao addressDao = new AddressDao(em);

		Map<Long, Address> enderecos = new HashMap<Long, Address>();

		listaCA.forEach(ca -> enderecos.put(ca.getAddressID(), addressDao.buscarPorId(ca.getAddressID())));

		em.getTransaction().commit();
		em.close();

		listaCA.forEach(ca -> System.out
				.println(enderecos.get(ca.getAddressID()).getAddressLine1() + "->" + ca.getCustomer().getCustomerID()));
	}

	public static void BOM(EntityManager em) {
		CustomerDao caDao = new CustomerDao(em);
		CustomerAddressDao CustomerAddressDao = new CustomerAddressDao(em);
		
		em.getTransaction().begin();

		List<Customer> listaCustomer = caDao.buscarTodos();
		List<CustomerAddress> todos = CustomerAddressDao.buscarTodos();
		
//		List<Address> listaEnderecos = caDao.buscarEnderecos();
//		System.out.println(listaCustomer.size()); //19185
//		System.out.println(todos.size()); //19220
		
		em.flush();
		
//		System.out.println(todos.get(0).getCustomer().getAccountNumber());
		
		System.out.println(listaCustomer.get(0).getCustomerAddress());
		
//		listaCustomer.forEach(c -> 
//			System.out.println(c.getCustomerAddress())
//		);
//		
//		System.out.println(
//		c.getCustomerAddress().getAddressID()
//		+"->"+c.getCustomerID())
		
		// NamedQuery nao esta funcioandno pq c.ca.Address esta nulo
//		for (int iteradorLista = 0; iteradorLista < listaCustomer.size(); iteradorLista++) {
//
//			System.out.println(listaEnderecos.get(iteradorLista).getAddressLine1() + "->"
//					+ listaCustomer.get(iteradorLista).getCustomerID());
//
//		}
		em.getTransaction().commit();
		em.close();
		

	}
}
