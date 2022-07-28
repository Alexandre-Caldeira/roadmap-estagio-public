package br.com.radixeng.viewmodel;

import java.lang.reflect.Field;
import java.util.Date;

public class ProdutoView implements IJson {
	// Product ID Name Color
	// SOH OrderDate, DueDate
	// SOH ShipDate Freight
	// Product ListPrice, SOH OrderQty Subtotal
	// SOH TaxAmt
	// SOH TotalDue
	
	private long ID;
	private String Nome;
	private String Cor;
	
	// refatorar valores monetarios para BigDecimal!
	private double PrecoUnitario; 
	private int Quantidade;
	private double Impostos;
	private double Frete;
	private double Subtotal;
	private double Total;
	private Date DataPedido;
	private Date DataEnvio;
	private Date PrevisaoEntrega;
	
	// RUIM mas inevitavel, eu acho. Perguntar na apresentacao!
	public ProdutoView(long iD, String nome, String cor, double precoUnitario, int quantidade, double impostos,
			double frete, double subtotal, double total, Date date, Date date2,
			Date date3) {
		ID = iD;
		Nome = nome;
		Cor = cor;
		PrecoUnitario = precoUnitario;
		Quantidade = quantidade;
		Impostos = impostos;
		Frete = frete;
		Subtotal = subtotal;
		Total = total;
		DataPedido = date;
		DataEnvio = date2;
		PrevisaoEntrega = date3;
	}

	public String toJSON() {
		StringBuilder result = new StringBuilder();
		  String newLine = System.getProperty("line.separator");

		  result.append( this.getClass().getName() );
		  result.append( " Object {" );
		  result.append(newLine);

		  //determine fields declared in this class only (no fields of superclass)
		  Field[] fields = this.getClass().getDeclaredFields();

		  //print field names paired with their values
		  for ( Field field : fields  ) {
		    result.append("\t");
		    try {
		      result.append( field.getName() );
		      result.append(": ");
		      //requires access to private field:
		      result.append( field.get(this) );
		    } catch ( IllegalAccessException ex ) {
		      System.out.println(ex);
		    }
		    result.append(newLine);
		  }
		  result.append("}");

		  return result.toString();
	}

	
	// GETTERS E SETTERS
	
	public long getID() {
		return ID;
	}

	public void setID(long iD) {
		ID = iD;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getCor() {
		return Cor;
	}

	public void setCor(String cor) {
		Cor = cor;
	}

	public double getPrecoUnitario() {
		return PrecoUnitario;
	}

	public void setPrecoUnitario(double precoUnitario) {
		PrecoUnitario = precoUnitario;
	}

	public int getQuantidade() {
		return Quantidade;
	}

	public void setQuantidade(int quantidade) {
		Quantidade = quantidade;
	}

	public double getImpostos() {
		return Impostos;
	}

	public void setImpostos(double impostos) {
		Impostos = impostos;
	}

	public double getFrete() {
		return Frete;
	}

	public void setFrete(double frete) {
		Frete = frete;
	}

	public double getSubtotal() {
		return Subtotal;
	}

	public void setSubtotal(double subtotal) {
		Subtotal = subtotal;
	}

	public double getTotal() {
		return Total;
	}

	public void setTotal(double total) {
		Total = total;
	}
	
	public Date getDataPedido() {
		return DataPedido;
	}

	public void setDataPedido(Date dataPedido) {
		DataPedido = dataPedido;
	}

	public Date getDataEnvio() {
		return DataEnvio;
	}

	public void setDataEnvio(Date dataEnvio) {
		DataEnvio = dataEnvio;
	}

	public Date getPrevisaoEntrega() {
		return PrevisaoEntrega;
	}

	public void setPrevisaoEntrega(Date previsaoEntrega) {
		PrevisaoEntrega = previsaoEntrega;
	}
	
}
