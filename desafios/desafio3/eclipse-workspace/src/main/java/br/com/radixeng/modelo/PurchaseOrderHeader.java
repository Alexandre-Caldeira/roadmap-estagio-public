package br.com.radixeng.modelo;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "purchaseorderheader")
public class PurchaseOrderHeader implements Entidade {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long PurchaseOrderID; // int

	private int RevisionNumber; // tinyint
	private int Status; // tinyint

	// TODO: add relacionamento
	private Long EmployeeID; // int
	private Long VendorID; // int
	private Long ShipMethodID; // int

	private LocalDateTime OrderDate; // datetime
	private LocalDateTime ShipDate; // datetime
	private Double SubTotal; // double
	private Double TaxAmt; // double
	private Double Freight; // double
	private Double TotalDue; // double

	private LocalDateTime ModifiedDate = LocalDateTime.now();

	public PurchaseOrderHeader() {

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

	public int getRevisionNumber() {
		return RevisionNumber;
	}

	public void setRevisionNumber(int revisionNumber) {
		RevisionNumber = revisionNumber;
	}

	public int getStatus() {
		return Status;
	}

	public void setStatus(int status) {
		Status = status;
	}

	public Long getEmployeeID() {
		return EmployeeID;
	}

	public void setEmployeeID(Long employeeID) {
		EmployeeID = employeeID;
	}

	public Long getVendorID() {
		return VendorID;
	}

	public void setVendorID(Long vendorID) {
		VendorID = vendorID;
	}

	public Long getShipMethodID() {
		return ShipMethodID;
	}

	public void setShipMethodID(Long shipMethodID) {
		ShipMethodID = shipMethodID;
	}

	public LocalDateTime getOrderDate() {
		return OrderDate;
	}

	public void setOrderDate(LocalDateTime orderDate) {
		OrderDate = orderDate;
	}

	public LocalDateTime getShipDate() {
		return ShipDate;
	}

	public void setShipDate(LocalDateTime shipDate) {
		ShipDate = shipDate;
	}

	public Double getSubTotal() {
		return SubTotal;
	}

	public void setSubTotal(Double subTotal) {
		SubTotal = subTotal;
	}

	public Double getTaxAmt() {
		return TaxAmt;
	}

	public void setTaxAmt(Double taxAmt) {
		TaxAmt = taxAmt;
	}

	public Double getFreight() {
		return Freight;
	}

	public void setFreight(Double freight) {
		Freight = freight;
	}

	public Double getTotalDue() {
		return TotalDue;
	}

	public void setTotalDue(Double totalDue) {
		TotalDue = totalDue;
	}

	public LocalDateTime getModifiedDate() {
		return ModifiedDate;
	}

	public void setModifiedDate(LocalDateTime modifiedDate) {
		ModifiedDate = modifiedDate;
	}

}
