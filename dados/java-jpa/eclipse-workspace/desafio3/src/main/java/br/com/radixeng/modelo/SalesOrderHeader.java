package br.com.radixeng.modelo;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "salesorderheader")
public class SalesOrderHeader implements Entidade{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long SalesOrderID; // int PK

	private Short RevisionNumber; // tinyint
	private Date OrderDate; // timestamp
	private Date DueDate; // datetime
	private Date ShipDate; // datetime
	private Short Status; // tinyint
	private Boolean OnlineOrderFlag; // bit(1)
	private String SalesOrderNumber; // varchar(25)
	private String PurchaseOrderNumber; // varchar(25)
	private String AccountNumber; // varchar(15)

	// TODO: add outros relacionamentos de salesorderdetail
	private Long CustomerID; // int
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ContactID") // bigint
	private Contact Contact;
	
	private Long SalesPersonID; // int
	private Long TerritoryID; // int
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BillToAddressID") // bigint
	private Address BillToAddress;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ShipToAddressID") // bigint
	private Address ShipToAddress;
	
	private Long ShipMethodID; // int
	private Long CreditCardID; // int

	private String CreditCardApprovalCode; // varchar(15)
	private Integer CurrencyRateID; // int
	private Double SubTotal; // double
	private Double TaxAmt; // double
	private Double Freight; // double
	private Double TotalDue; // double
	private String Comment; // varchar(128)

	@Column(columnDefinition = "BINARY(16)")
	private UUID rowguid; // varbinary(16)

	private LocalDateTime ModifiedDate = LocalDateTime.now(); // timestamp
	
	// TODO: sobrecarregar construtor SalesOrderDetail
	public SalesOrderHeader() {
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

	public Short getRevisionNumber() {
		return RevisionNumber;
	}

	public void setRevisionNumber(Short revisionNumber) {
		RevisionNumber = revisionNumber;
	}

	public Date getOrderDate() {
		return OrderDate;
	}

	public void setOrderDate(Date orderDate) {
		OrderDate = orderDate;
	}

	public Date getDueDate() {
		return DueDate;
	}

	public void setDueDate(Date dueDate) {
		DueDate = dueDate;
	}

	public Date getShipDate() {
		return ShipDate;
	}

	public void setShipDate(Date shipDate) {
		ShipDate = shipDate;
	}

	public Short getStatus() {
		return Status;
	}

	public void setStatus(Short status) {
		Status = status;
	}

	public Boolean getOnlineOrderFlag() {
		return OnlineOrderFlag;
	}

	public void setOnlineOrderFlag(Boolean onlineOrderFlag) {
		OnlineOrderFlag = onlineOrderFlag;
	}

	public String getSalesOrderNumber() {
		return SalesOrderNumber;
	}

	public void setSalesOrderNumber(String salesOrderNumber) {
		SalesOrderNumber = salesOrderNumber;
	}

	public String getPurchaseOrderNumber() {
		return PurchaseOrderNumber;
	}

	public void setPurchaseOrderNumber(String purchaseOrderNumber) {
		PurchaseOrderNumber = purchaseOrderNumber;
	}

	public String getAccountNumber() {
		return AccountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		AccountNumber = accountNumber;
	}

	public Long getCustomerID() {
		return CustomerID;
	}

	public void setCustomerID(Long customerID) {
		CustomerID = customerID;
	}

	public Contact getContact() {
		return Contact;
	}

	public void setContactID(Contact contact) {
		Contact = contact;
	}

	public Long getSalesPersonID() {
		return SalesPersonID;
	}

	public void setSalesPersonID(Long salesPersonID) {
		SalesPersonID = salesPersonID;
	}

	public Long getTerritoryID() {
		return TerritoryID;
	}

	public void setTerritoryID(Long territoryID) {
		TerritoryID = territoryID;
	}

	public Address getBillToAddress() {
		return BillToAddress;
	}

	public void setBillToAddress(Address billToAddress) {
		BillToAddress = billToAddress;
	}

	public Address getShipToAddress() {
		return ShipToAddress;
	}

	public void setShipToAddress(Address shipToAddress) {
		ShipToAddress = shipToAddress;
	}

	public Long getShipMethodID() {
		return ShipMethodID;
	}

	public void setShipMethodID(Long shipMethodID) {
		ShipMethodID = shipMethodID;
	}

	public Long getCreditCardID() {
		return CreditCardID;
	}

	public void setCreditCardID(Long creditCardID) {
		CreditCardID = creditCardID;
	}

	public String getCreditCardApprovalCode() {
		return CreditCardApprovalCode;
	}

	public void setCreditCardApprovalCode(String creditCardApprovalCode) {
		CreditCardApprovalCode = creditCardApprovalCode;
	}

	public Integer getCurrencyRateID() {
		return CurrencyRateID;
	}

	public void setCurrencyRateID(Integer currencyRateID) {
		CurrencyRateID = currencyRateID;
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

	public String getComment() {
		return Comment;
	}

	public void setComment(String comment) {
		Comment = comment;
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


}
