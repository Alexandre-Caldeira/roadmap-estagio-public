package br.com.radixeng.exemplos;

import javax.persistence.EntityManager;

import br.com.radixeng.dao.SalesOrderDetailDao;
import br.com.radixeng.modelo.Contact;
import br.com.radixeng.modelo.SalesOrderDetail;
import br.com.radixeng.util.JPAUtil;

public class SelectInfoContato {
	public static void main(String[] args) {
		EntityManager em = JPAUtil.getEntityManager();
		SalesOrderDetailDao salesOrderDetailDao = new SalesOrderDetailDao(em);
		em.getTransaction().begin();	
		
		SalesOrderDetail soDetail = salesOrderDetailDao.buscarPorId(794l);
		Contact cliente = soDetail.getSalesOrderHeader().getContact();
		
		System.out.println("\n CLIENTE: \n"+cliente.getTitle()+" "+cliente.getFirstName()+" "+cliente.getLastName());
		em.close();
	}
}
