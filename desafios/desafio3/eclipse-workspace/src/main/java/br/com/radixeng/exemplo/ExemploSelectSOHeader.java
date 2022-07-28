package br.com.radixeng.exemplo;

import javax.persistence.EntityManager;
import br.com.radixeng.dao.SalesOrderHeaderDao;
import br.com.radixeng.modelo.SalesOrderHeader;
import br.com.radixeng.util.JPAUtil;

public class ExemploSelectSOHeader {
	public static void main(String[] args) {
		EntityManager em = JPAUtil.getEntityManager();
		SalesOrderHeaderDao SalesOrderHeaderDao = new SalesOrderHeaderDao(em);
		
//		List<SalesOrderHeader> todos = SalesOrderHeaderDao.buscarTodos();
		
		SalesOrderHeader soh = SalesOrderHeaderDao.buscarPorId(43744l);
		
		System.out.println(soh.getSalesOrderID()+": "+soh.getOrderDate()+", due:"+soh.getDueDate());
		
		em.close();
		
//		todos.forEach(soh -> System.out.println(soh.getSalesOrderID()+": "+soh.getOrderDate()+", due:"+soh.getDueDate()));
		
	}

}
