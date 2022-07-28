package br.com.radixeng.modelo;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "address")
public class Address implements Entidade {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long AddressID; // int AI PK
	private String AddressLine1; // varchar(60)
	private String AddressLine2; // varchar(60)
	private String City; // varchar(30)

	private Long StateProvinceID; // int
	private String PostalCode; // varchar(15)

	@Column(columnDefinition = "BINARY(16)")
	private UUID rowguid; // varbinary(16)

	private LocalDateTime ModifiedDate = LocalDateTime.now(); // timestamp

	public Address() {

	}
	
	public Object getPK() {
		return this.AddressID;
	}
	
	public Long getAddressID() {
		return AddressID;
	}

	public void setAddressID(Long addressID) {
		AddressID = addressID;
	}

	public String getAddressLine1() {
		return AddressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		AddressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return AddressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		AddressLine2 = addressLine2;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public Long getStateProvinceID() {
		return StateProvinceID;
	}

	public void setStateProvinceID(Long stateProvinceID) {
		StateProvinceID = stateProvinceID;
	}

	public String getPostalCode() {
		return PostalCode;
	}

	public void setPostalCode(String postalCode) {
		PostalCode = postalCode;
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
