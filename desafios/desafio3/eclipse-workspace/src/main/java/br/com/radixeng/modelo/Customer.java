package br.com.radixeng.modelo;


import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "customer") 
//@NamedQuery(name= "Customer.buscarEnderecos", 
//	query = 
//	"SELECT A FROM Customer c "
//			+ "INNER JOIN CustomerAddress ca ON ca.CustomerID = c.CustomerID "
//			+ "INNER JOIN Address A ON a.AddressID = ca.AddressID")
//Composite-id class must implement Serializable -> TerritoryID removido/ignorado no ORM!
public class Customer implements Entidade {
	
	@OneToOne(fetch = FetchType.LAZY)
	private CustomerAddress CustomerAddress;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long CustomerID; // int AI PK
		
	private Long TerritoryID; // int
	private String AccountNumber = "AW00000000"; // varchar(10)
	private String CustomerType = "I"; // varchar(1)

	@Column(columnDefinition = "BINARY(16)")
	private UUID rowguid = UUID.randomUUID();
	private LocalDateTime ModifiedDate = LocalDateTime.now();

	public Customer() {

	}
	
	public Object getPK() {
		return this.getCustomerID();
	}

	public Long getCustomerID() {
		return CustomerID;
	}

	public void setCustomerID(Long customerID) {
		CustomerID = customerID;
	}

	public Long getTerritoryID() {
		return TerritoryID;
	}

	public void setTerritoryID(Long territoryID) {
		TerritoryID = territoryID;
	}

	public String getAccountNumber() {
		return AccountNumber;
	}

	public void setAccountNumber(String accountNumbe) {
		AccountNumber = accountNumbe;
	}

	public String getCustomerType() {
		return CustomerType;
	}

	public void setCustomerType(String customerType) {
		CustomerType = customerType;
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
		
	public CustomerAddress getCustomerAddress() {
		return CustomerAddress;
	}

	public void setCustomerAddress(CustomerAddress customerAddress) {
		CustomerAddress = customerAddress;
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
}
