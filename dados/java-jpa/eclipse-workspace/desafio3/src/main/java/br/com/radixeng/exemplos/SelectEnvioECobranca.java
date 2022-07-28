package br.com.radixeng.exemplos;

import javax.persistence.EntityManager;

import br.com.radixeng.dao.SalesOrderDetailDao;
import br.com.radixeng.modelo.Address;
import br.com.radixeng.modelo.SalesOrderDetail;
import br.com.radixeng.modelo.SalesOrderHeader;
import br.com.radixeng.util.JPAUtil;

public class SelectEnvioECobranca {

	public static void main(String[] args) {
		EntityManager em = JPAUtil.getEntityManager();
		SalesOrderDetailDao salesOrderDetailDao = new SalesOrderDetailDao(em);

		em.getTransaction().begin();
		
		SalesOrderDetail sod = salesOrderDetailDao.buscarPorId(794l); // selecionado manualmente 
		SalesOrderHeader soh = sod.getSalesOrderHeader();
		
		Address cobranca = soh.getBillToAddress();
		Address entrega = soh.getShipToAddress();
				
		System.out.println("\n"+sod.getPK()+"\n");
		
		// Enderecos diferentes
		System.out.println("\n"+cobranca.getAddressLine1()+"\n");
		System.out.println("\n"+entrega.getAddressLine1()+"\n");

		em.close(); // Nao pode fechar antes do lazy... -> Criar um metodo fetch! 

	}

}
