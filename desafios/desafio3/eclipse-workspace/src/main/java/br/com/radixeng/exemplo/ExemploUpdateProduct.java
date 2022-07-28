package br.com.radixeng.exemplo;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.radixeng.dao.ProductDao;
import br.com.radixeng.modelo.Product;
import br.com.radixeng.util.JPAUtil;

public class ExemploUpdateProduct {
	public static void main(String[] args) {
		EntityManager em = JPAUtil.getEntityManager();
		ProductDao ProductDao = new ProductDao(em);
		
		em.getTransaction().begin();
		
		Product novo = ProductDao.buscarPorNome("Mouse").get(0);
//				buscarPorId(317l);
		
		novo.setName(novo.getName()+"!");
		
//		novo.setName(novo.getName().replace("!"," ").trim());
		
		novo = ProductDao.atualizar(novo);
		
		Product outro = ProductDao.buscarPorNome("Mouse").get(0);
		
		System.out.println(outro.getName()+" "+ novo.getName()); // +" "+pModelo.getColor());
		
		em.getTransaction().commit();
		em.close();
		
//		System.out.println(pModelo.getProductID()+": "+pModelo.getName()+" "+pModelo.getSize()+pModelo.getSizeUnitMeasureCode());
	}
}
