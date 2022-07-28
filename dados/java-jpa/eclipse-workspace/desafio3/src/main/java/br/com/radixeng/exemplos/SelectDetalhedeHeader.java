package br.com.radixeng.exemplos;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.radixeng.dao.SalesOrderDetailDao;
import br.com.radixeng.modelo.SalesOrderDetail;
import br.com.radixeng.util.JPAUtil;

public class SelectDetalhedeHeader {

	public static void main(String[] args) { 
		EntityManager em = JPAUtil.getEntityManager();
		SalesOrderDetailDao salesOrderDetailDao = new SalesOrderDetailDao(em);
		
		em.getTransaction().begin();
		
		List<SalesOrderDetail> listaSODetail = salesOrderDetailDao.buscarTodos();

		listaSODetail.forEach(sod -> 
			System.out.println(sod.getSalesOrderDetailID() +"->"+sod.getSalesOrderHeader().getSalesOrderID())
		);

		em.close();
		// Exemplo de pouco performatico... -> devemos empregar relacionamentos!
	}

}
