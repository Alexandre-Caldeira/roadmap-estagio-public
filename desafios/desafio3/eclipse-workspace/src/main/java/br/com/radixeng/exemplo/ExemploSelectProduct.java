package br.com.radixeng.exemplo;

import java.util.List;

import javax.persistence.EntityManager;
import br.com.radixeng.dao.CustomerAddressDao;
import br.com.radixeng.dao.ProductDao;
import br.com.radixeng.modelo.CustomerAddress;
import br.com.radixeng.modelo.Product;
import br.com.radixeng.util.JPAUtil;

public class ExemploSelectProduct {
	public static void main(String[] args) {
		EntityManager em = JPAUtil.getEntityManager();
		ProductDao ProductDao = new ProductDao(em);
		
		List<Product> todos = ProductDao.buscarTodos();
		
		em.close();
		
		todos.forEach(p -> System.out.println(p.getProductID()+": "+p.getName()+" "+p.getSize()+p.getSizeUnitMeasureCode()));
	}

}
