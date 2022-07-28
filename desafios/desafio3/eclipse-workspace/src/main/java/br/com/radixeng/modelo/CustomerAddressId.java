package br.com.radixeng.modelo;

import java.io.Serializable;
import java.util.Objects;


public class CustomerAddressId implements Serializable {

	private Long CustomerID;
	
	private Long AddressID;
	
	public CustomerAddressId() {
		// Default
	}

	
	public CustomerAddressId(Long customerID, Long addressID) {
		CustomerID = customerID;
		AddressID = addressID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(AddressID, CustomerID);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomerAddressId other = (CustomerAddressId) obj;
		return Objects.equals(AddressID, other.AddressID) && Objects.equals(CustomerID, other.CustomerID);
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
		
}
