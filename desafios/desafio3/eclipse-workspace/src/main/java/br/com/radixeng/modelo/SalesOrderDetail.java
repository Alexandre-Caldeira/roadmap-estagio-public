package br.com.radixeng.modelo;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "salesorderdetail")
//Composite-id class must implement Serializable
public class SalesOrderDetail implements Serializable,Entidade {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long SalesOrderID ; //int PK
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long SalesOrderDetailID; //int AI PK 
	
	private String CarrierTrackingNumber; //varchar(25) 
	private Integer OrderQty; //smallint 
	private Integer ProductID; //int 
	private Integer SpecialOfferID; //int 
	private Double UnitPrice; //double 
	private Double UnitPriceDiscount; //double 
	private Double LineTotal; //double 
	
	@Column(columnDefinition = "BINARY(16)")
	private UUID rowguid; // varbinary(16)

	private LocalDateTime ModifiedDate = LocalDateTime.now(); // timestamp
	private String AccountNumber; //varchar(255) 
	
	
	private Long BillToAddressID; //bigint 
	private String Comment; //varchar(255) 
	
	
	private Long ContactID; //bigint 
	
	private String CreditCardApprovalCode; //varchar(255) 
	private Long CreditCardID; //bigint 
	private Long CurrencyRateID; //int 
	
	
	private Long CustomerID; //bigint 
	
	private LocalDateTime DueDate; //datetime 
	private Double Freight; //double 
	private Boolean OnlineOrderFlag; //bit(1) 
	private LocalDateTime OrderDate 					; //datetime 
	private String PurchaseOrderNumber; //varchar(255) 
	private Integer RevisionNumber; //smallint => Integer(Nullable) para evitar javax.persistence.PersistenceException
	private String SalesOrderNumber; //varchar(255) 
	
	
	private Long SalesPersonID; //bigint 
	private LocalDateTime ShipDate; //datetime 
	private Long ShipMethodID; //bigint 
	
	
	private Long ShipToAddressID; //bigint 
	private Integer Status = 0; //smallint 
	
	private Double SubTotal; //double 
	private Double TaxAmt; //double 
	private Long TerritoryID; //bigint 
	private Double TotalDue; //double
	
	public SalesOrderDetail() {
		// Default constructor exigido pelo hibernate
	}

	public Object getPK() {
		return this.SalesOrderID;
	}
	
	public Long getSalesOrderID() {
		return SalesOrderID;
	}

	public void setSalesOrderID(Long salesOrderID) {
		SalesOrderID = salesOrderID;
	}

	public Long getSalesOrderDetailID() {
		return SalesOrderDetailID;
	}

	public void setSalesOrderDetailID(Long salesOrderDetailID) {
		SalesOrderDetailID = salesOrderDetailID;
	}

	public String getCarrierTrackingNumber() {
		return CarrierTrackingNumber;
	}

	public void setCarrierTrackingNumber(String carrierTrackingNumber) {
		CarrierTrackingNumber = carrierTrackingNumber;
	}

	public Integer getOrderQty() {
		return OrderQty;
	}

	public void setOrderQty(Integer orderQty) {
		OrderQty = orderQty;
	}

	public Integer getProductID() {
		return ProductID;
	}

	public void setProductID(Integer productID) {
		ProductID = productID;
	}

	public Integer getSpecialOfferID() {
		return SpecialOfferID;
	}

	public void setSpecialOfferID(Integer specialOfferID) {
		SpecialOfferID = specialOfferID;
	}

	public Double getUnitPrice() {
		return UnitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
		UnitPrice = unitPrice;
	}

	public Double getUnitPriceDiscount() {
		return UnitPriceDiscount;
	}

	public void setUnitPriceDiscount(Double unitPriceDiscount) {
		UnitPriceDiscount = unitPriceDiscount;
	}

	public Double getLineTotal() {
		return LineTotal;
	}

	public void setLineTotal(Double lineTotal) {
		LineTotal = lineTotal;
	}

	public UUID getRowguid() {
		return rowguid;
	}

	public void setRowguid(UUID rowguid) {
		this.rowguid = rowguid;
	}

	public LocalDateTime getModifiedDate() {
		return ModifiedDate;
	}

	public void setModifiedDate(LocalDateTime modifiedDate) {
		ModifiedDate = modifiedDate;
	}

	public String getAccountNumber() {
		return AccountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		AccountNumber = accountNumber;
	}

	public Long getBillToAddressID() {
		return BillToAddressID;
	}

	public void setBillToAddressID(Long billToAddressID) {
		BillToAddressID = billToAddressID;
	}

	public String getComment() {
		return Comment;
	}

	public void setComment(String comment) {
		Comment = comment;
	}

	public Long getContactID() {
		return ContactID;
	}

	public void setContactID(Long contactID) {
		ContactID = contactID;
	}

	public String getCreditCardApprovalCode() {
		return CreditCardApprovalCode;
	}

	public void setCreditCardApprovalCode(String creditCardApprovalCode) {
		CreditCardApprovalCode = creditCardApprovalCode;
	}

	public Long getCreditCardID() {
		return CreditCardID;
	}

	public void setCreditCardID(Long creditCardID) {
		CreditCardID = creditCardID;
	}

	public Long getCurrencyRateID() {
		return CurrencyRateID;
	}

	public void setCurrencyRateID(Long currencyRateID) {
		CurrencyRateID = currencyRateID;
	}

	public Long getCustomerID() {
		return CustomerID;
	}

	public void setCustomerID(Long customerID) {
		CustomerID = customerID;
	}

	public LocalDateTime getDueDate() {
		return DueDate;
	}

	public void setDueDate(LocalDateTime dueDate) {
		DueDate = dueDate;
	}

	public Double getFreight() {
		return Freight;
	}

	public void setFreight(Double freight) {
		Freight = freight;
	}

	public Boolean getOnlineOrderFlag() {
		return OnlineOrderFlag;
	}

	public void setOnlineOrderFlag(Boolean onlineOrderFlag) {
		OnlineOrderFlag = onlineOrderFlag;
	}

	public LocalDateTime getOrderDate() {
		return OrderDate;
	}

	public void setOrderDate(LocalDateTime orderDate) {
		OrderDate = orderDate;
	}

	public String getPurchaseOrderNumber() {
		return PurchaseOrderNumber;
	}

	public void setPurchaseOrderNumber(String purchaseOrderNumber) {
		PurchaseOrderNumber = purchaseOrderNumber;
	}

	public int getRevisionNumber() {
		return RevisionNumber;
	}

	public void setRevisionNumber(int revisionNumber) {
		RevisionNumber = revisionNumber;
	}

	public String getSalesOrderNumber() {
		return SalesOrderNumber;
	}

	public void setSalesOrderNumber(String salesOrderNumber) {
		SalesOrderNumber = salesOrderNumber;
	}

	public Long getSalesPersonID() {
		return SalesPersonID;
	}

	public void setSalesPersonID(Long salesPersonID) {
		SalesPersonID = salesPersonID;
	}

	public LocalDateTime getShipDate() {
		return ShipDate;
	}

	public void setShipDate(LocalDateTime shipDate) {
		ShipDate = shipDate;
	}

	public Long getShipMethodID() {
		return ShipMethodID;
	}

	public void setShipMethodID(Long shipMethodID) {
		ShipMethodID = shipMethodID;
	}

	public Long getShipToAddressID() {
		return ShipToAddressID;
	}

	public void setShipToAddressID(Long shipToAddressID) {
		ShipToAddressID = shipToAddressID;
	}

	public int getStatus() {
		return Status;
	}

	public void setStatus(int status) {
		Status = status;
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

	public Long getTerritoryID() {
		return TerritoryID;
	}

	public void setTerritoryID(Long territoryID) {
		TerritoryID = territoryID;
	}

	public Double getTotalDue() {
		return TotalDue;
	}

	public void setTotalDue(Double totalDue) {
		TotalDue = totalDue;
	}
	
}
