package br.com.radixeng.exemplos;

import java.util.List;

import javax.persistence.EntityManager;
import br.com.radixeng.dao.ProductDao;
import br.com.radixeng.modelo.Product;
import br.com.radixeng.util.JPAUtil;

public class SelectProduct {
	public static void main(String[] args) {
		EntityManager em = JPAUtil.getEntityManager();
		ProductDao ProductDao = new ProductDao(em);
		
		List<Product> todos = ProductDao.buscarTodos();
		
		em.close();
		
		todos.forEach(p -> System.out.println(p.getProductID()+": "+p.getName()+" "+p.getSize()+p.getSizeUnitMeasureCode()));
	}

}
