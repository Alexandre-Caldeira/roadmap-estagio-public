package br.com.radixeng.service;

import javax.persistence.EntityManager;

import br.com.radixeng.dao.SalesOrderDetailDao;
import br.com.radixeng.modelo.Contact;
import br.com.radixeng.modelo.Product;
import br.com.radixeng.modelo.SalesOrderDetail;
import br.com.radixeng.modelo.SalesOrderHeader;
import br.com.radixeng.util.JPAUtil;
import br.com.radixeng.viewmodel.ClienteView;
import br.com.radixeng.viewmodel.EnderecoView;
import br.com.radixeng.viewmodel.ProdutoView;

public class MostraViews {
	public static void main(String[] args) {
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();	
		
		SalesOrderDetailDao salesOrderDetailDao = new SalesOrderDetailDao(em);
		SalesOrderDetail soDetail = salesOrderDetailDao.buscarPorId(794l);
		SalesOrderHeader soHeader = soDetail.getSalesOrderHeader();
		Product produto = soDetail.getProduct();
		
		
		EnderecoView entregaView = new EnderecoView(
				soHeader.getShipToAddress().getAddressLine1(), 
				soHeader.getShipToAddress().getAddressLine2(), 
				soHeader.getShipToAddress().getStateProvince().getStateProvinceCode(), 
				soHeader.getShipToAddress().getStateProvince().getCountryRegionCode(), 
				"Entrega");
		
		EnderecoView cobrancaView = new EnderecoView(
				soHeader.getBillToAddress().getAddressLine1(), 
				soHeader.getBillToAddress().getAddressLine2(), 
				soHeader.getBillToAddress().getStateProvince().getStateProvinceCode(), 
				soHeader.getBillToAddress().getStateProvince().getCountryRegionCode(), 
				"Cobranca");
				
		Contact cliente = soDetail.getSalesOrderHeader().getContact();
		
		ClienteView clienteView = new ClienteView(
				cliente.getTitle(),
				cliente.getFirstName(),
				cliente.getLastName(),
				cliente.getEmailAddress());
		
		ProdutoView produtoView = new ProdutoView(
				produto.getProductID(), 
				produto.getName(), 
				produto.getColor(), 
				produto.getListPrice(), 
				soDetail.getOrderQty(), 
				soHeader.getTaxAmt(), 
				soHeader.getFreight(), 
				soHeader.getSubTotal(), 
				soHeader.getTotalDue(), 
				soHeader.getOrderDate(), 
				soHeader.getShipDate(), 
				soHeader.getDueDate());
				
		// Apresentando na tela:
		System.out.println("\nOBJETOS CARREGADOS:\n");
		System.out.println("\n"+clienteView.toJSON());
		System.out.println("\n"+cobrancaView.toJSON());
		System.out.println("\n"+produtoView.toJSON());
		System.out.println("\n"+entregaView.toJSON());
		
		// E o caminho contrário? Binding pendente! :_C
		// Construtores com milhoes de parametros -> ma pratica! substituir por Builder Pattern?
	}
}
