package br.com.radixeng.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.mysql.cj.x.protobuf.MysqlxCursor.Fetch;

@Entity
@IdClass(PurchaseOrderDetailId.class)
@Table(name = "purchaseorderdetail")
//Composite-id class must implement Serializable
public class PurchaseOrderDetail implements Entidade, Serializable{
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "PurchaseOrderID",insertable = false,updatable = false) //Causa "repeated column mapping"
	private PurchaseOrderHeader PurchaseOrderHeader; 
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long PurchaseOrderID; // int PK
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long PurchaseOrderDetailID; // int AI PK
	
	private LocalDateTime DueDate; // datetime
	private int OrderQty; // smallint

	// TODO: Relacionamento
	private Long ProductID; // int

	private Double UnitPrice; // double
	private Double LineTotal; // double
	private BigDecimal ReceivedQty; // decimal(8,2)
	private BigDecimal RejectedQty; // decimal(8,2)
	private BigDecimal StockedQty; // decimal(9,2)
	private LocalDateTime ModifiedDate = LocalDateTime.now(); // timestamp

	public PurchaseOrderDetail() {

	}
	
	public Object getPK() {
		return this.PurchaseOrderID;
	}

	public Long getPurchaseOrderID() {
		return PurchaseOrderID;
	}

	public void setPurchaseOrderID(Long purchaseOrderID) {
		PurchaseOrderID = purchaseOrderID;
	}

	public Long getPurchaseOrderDetailID() {
		return PurchaseOrderDetailID;
	}

	public void setPurchaseOrderDetailID(Long purchaseOrderDetailID) {
		PurchaseOrderDetailID = purchaseOrderDetailID;
	}

	public LocalDateTime getDueDate() {
		return DueDate;
	}

	public void setDueDate(LocalDateTime dueDate) {
		DueDate = dueDate;
	}

	public int getOrderQty() {
		return OrderQty;
	}

	public void setOrderQty(int orderQty) {
		OrderQty = orderQty;
	}

	public Long getProductID() {
		return ProductID;
	}

	public void setProductID(Long productID) {
		ProductID = productID;
	}

	public Double getUnitPrice() {
		return UnitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
		UnitPrice = unitPrice;
	}

	public Double getLineTotal() {
		return LineTotal;
	}

	public void setLineTotal(Double lineTotal) {
		LineTotal = lineTotal;
	}

	public BigDecimal getReceivedQty() {
		return ReceivedQty;
	}

	public void setReceivedQty(BigDecimal receivedQty) {
		ReceivedQty = receivedQty;
	}

	public BigDecimal getRejectedQty() {
		return RejectedQty;
	}

	public void setRejectedQty(BigDecimal rejectedQty) {
		RejectedQty = rejectedQty;
	}

	public BigDecimal getStockedQty() {
		return StockedQty;
	}

	public void setStockedQty(BigDecimal stockedQty) {
		StockedQty = stockedQty;
	}

	public LocalDateTime getModifiedDate() {
		return ModifiedDate;
	}

	public void setModifiedDate(LocalDateTime modifiedDate) {
		ModifiedDate = modifiedDate;
	}

	public PurchaseOrderHeader getPurchaseOrderHeader() {
		return PurchaseOrderHeader;
	}

	public void setPurchaseOrderHeader(PurchaseOrderHeader purchaseOrderHeader) {
		PurchaseOrderHeader = purchaseOrderHeader;
	}

}
