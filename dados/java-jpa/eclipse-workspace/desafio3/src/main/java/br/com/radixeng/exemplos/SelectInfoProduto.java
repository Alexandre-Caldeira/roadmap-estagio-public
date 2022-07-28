package br.com.radixeng.exemplos;

import javax.persistence.EntityManager;

import br.com.radixeng.dao.SalesOrderDetailDao;
import br.com.radixeng.modelo.Product;
import br.com.radixeng.modelo.SalesOrderDetail;
import br.com.radixeng.modelo.SalesOrderHeader;
import br.com.radixeng.util.JPAUtil;

public class SelectInfoProduto {

	public static void main(String[] args) {
		EntityManager em = JPAUtil.getEntityManager();
		SalesOrderDetailDao salesOrderDetailDao = new SalesOrderDetailDao(em);
		em.getTransaction().begin();	
		
		SalesOrderDetail soDetail = salesOrderDetailDao.buscarPorId(794l);
		SalesOrderHeader soHeader = soDetail.getSalesOrderHeader();
		Product produto = soDetail.getProduct();

		System.out.println("\n PRODUTO: "+produto.getProductID()+"\n"+produto.getName()+", "+produto.getColor()+".\n");
		System.out.println("$"+produto.getListPrice()+" * "+soDetail.getOrderQty()+" => SubTotal: $"+soHeader.getSubTotal());
		System.out.println("\nData do pedido: "+soHeader.getOrderDate());
		System.out.println("Data de envio: "+soHeader.getShipDate()+", frete: $"+soHeader.getFreight());
		System.out.println("Entrega estimada para: "+soHeader.getDueDate());
		
		System.out.println("Impostos e taxas: $"+soHeader.getTaxAmt());
		System.out.println("\nTOTAL: $"+soHeader.getTotalDue());
		em.close();
	}

}
