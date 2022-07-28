package br.com.radixeng.modelo;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@IdClass(CustomerAddressId.class)
@Table(name = "customeraddress")
public class CustomerAddress implements Entidade, Serializable {

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CustomerID",insertable = false,updatable = false) //Causa "repeated column mapping"
	private Customer Customer;
	
	@OneToOne(fetch = FetchType.EAGER, optional=false)
	@JoinColumn(name = "AddressID",insertable = false,updatable = false) //Causa "repeated column mapping"
	private Address Address;
	
	@Id
	private Long CustomerID;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long AddressID;
	
	private Long AddressTypeID = 2l;
	
	@Column(columnDefinition = "BINARY(16)")
	private UUID rowguid = UUID.randomUUID();
	
	private LocalDateTime ModifiedDate = LocalDateTime.now();
	
	public CustomerAddress() {
		
	}
	
	public Object getPK() {
		return this.getAddressID();
	}

	public CustomerAddress(Long customerID, Long addressID, Long addressTypeID, UUID rowguid,
			LocalDateTime modifiedDate) {
		CustomerID = customerID;
		AddressID = addressID;
		AddressTypeID = addressTypeID;
		this.rowguid = rowguid;
		ModifiedDate = modifiedDate;
	}

	public Long getCustomerID() {
		return CustomerID;
	}

	public void setCustomerID(Long customerID) {
		CustomerID = customerID;
	}

	public Long getAddressID() {
		return AddressID;
	}

	public void setAddressID(Long addressID) {
		AddressID = addressID;
	}

	public Long getAddressTypeID() {
		return AddressTypeID;
	}

	public void setAddressTypeID(Long addressTypeID) {
		AddressTypeID = addressTypeID;
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
		
	public Customer getCustomer() {
		return Customer;
	}

	public void setCustomer(Customer customer) {
		this.Customer = customer;
	}
	
	public Address getAddress() {
		return Address;
	}

	public void setAddress(Address address) {
		Address = address;
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
