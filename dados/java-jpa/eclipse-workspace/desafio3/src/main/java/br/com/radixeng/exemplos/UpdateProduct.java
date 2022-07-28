package br.com.radixeng.exemplos;

import javax.persistence.EntityManager;

import br.com.radixeng.dao.ProductDao;
import br.com.radixeng.modelo.Product;
import br.com.radixeng.util.JPAUtil;

public class UpdateProduct {
	public static void main(String[] args) {
		EntityManager em = JPAUtil.getEntityManager();
		ProductDao ProductDao = new ProductDao(em);
		
		em.getTransaction().begin();
		
		Product novo = ProductDao.buscarPorNome("Mouse").get(0); //buscarprimeiro
//				buscarPorId(317l);
		
		novo.setName(novo.getName()+"!");
		
//		novo.setName(novo.getName().replace("!"," ").trim());
		
		novo = ProductDao.atualizar(novo);
		
		Product outro = ProductDao.buscarPorNome("Mouse!").get(0);
		
		System.out.println(outro.getName()+" "+ novo.getName()); // +" "+pModelo.getColor());
		
		em.getTransaction().commit();
		em.close();
		
//		System.out.println(pModelo.getProductID()+": "+pModelo.getName()+" "+pModelo.getSize()+pModelo.getSizeUnitMeasureCode());
	}
}
