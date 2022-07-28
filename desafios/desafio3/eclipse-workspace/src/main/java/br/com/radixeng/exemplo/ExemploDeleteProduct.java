package br.com.radixeng.exemplo;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.radixeng.dao.ProductDao;
import br.com.radixeng.modelo.Product;
import br.com.radixeng.util.JPAUtil;

public class ExemploDeleteProduct {
	public static void main(String[] args) {

		EntityManager em = JPAUtil.getEntityManager();
		ProductDao ProductDao = new ProductDao(em);
		
		em.getTransaction().begin();
		
		List<Product> mouses = ProductDao.buscarPorNome("Mouse!");
		
		System.out.println("\nTemos "+ mouses.size() + " mouses no banco de dados.\n");

		mouses.forEach( produto -> ProductDao.remover(produto));
		
		List<Product> sobraramMouses = ProductDao.buscarPorNome("Mouse!");
		
		System.out.println("\n Quantos mouses sobraram? " + sobraramMouses.size()+".");
		
		em.getTransaction().commit();
		em.close();
	}
	
}
