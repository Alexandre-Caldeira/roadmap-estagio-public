package br.com.radixeng.exemplo;

import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;

import br.com.radixeng.dao.ProductDao;
import br.com.radixeng.modelo.Product;
import br.com.radixeng.util.JPAUtil;

public class ExemploInsertProduct {
	
		public static void main(String[] args) {
			
			Product prodNovo = new Product();
			
			prodNovo.setName("Mouse");
			prodNovo.setRowguid(UUID.randomUUID()); // gera UUID aleatorio
			prodNovo.setReorderPoint(400); // media
			prodNovo.setSafetyStockLevel(535); // media
			prodNovo.setProductNumber("MO-1000"); // padrao 
			
			System.out.println("\n Criou: \n"+prodNovo.toJSON());			
			
			EntityManager em = JPAUtil.getEntityManager();
			ProductDao ProductDao = new ProductDao(em);
			
			em.getTransaction().begin();
			
			ProductDao.cadastrar(prodNovo);
			
//			Product pExemplo = ProductDao.buscarPorNome("Freewheel");	
//			Product pExemplo = ProductDao.buscarPorId(1l);
			
//			em.flush();
			
			List<Product> OUTRO = ProductDao.buscarPorNome("Mouse");	
//			
			System.out.println("\n Returnou \n"+ OUTRO.get(0).toJSON());
//			
			em.getTransaction().commit();
			em.close();
			
		}

}
