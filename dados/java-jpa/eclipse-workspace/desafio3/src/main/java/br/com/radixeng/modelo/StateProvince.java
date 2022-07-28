package br.com.radixeng.modelo;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "stateprovince")
public class StateProvince implements Entidade{
	              
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long StateProvinceID		 	; //int AI PK  
	private String StateProvinceCode	 	; //varchar(3)   
	private String CountryRegionCode	 	; //varchar(3)   
	private Boolean IsOnlyStateProvinceFlag	; //bit(1) 
	private String Name 					; //varchar(50)     
	
	private Long TerritoryID; //int               
	
	@Column(columnDefinition = "BINARY(16)")
	private UUID rowguid;

	private LocalDateTime ModifiedDate = LocalDateTime.now();
	
	public StateProvince() {
		// Default constructor exigido pelo hibernate
	}
	
	public Object getPK() {
		return this.StateProvinceID;
	}

	public Long getStateProvinceID() {
		return StateProvinceID;
	}

	public void setStateProvinceID(Long stateProvinceID) {
		StateProvinceID = stateProvinceID;
	}

	public String getStateProvinceCode() {
		return StateProvinceCode;
	}

	public void setStateProvinceCode(String stateProvinceCode) {
		StateProvinceCode = stateProvinceCode;
	}

	public String getCountryRegionCode() {
		return CountryRegionCode;
	}

	public void setCountryRegionCode(String countryRegionCode) {
		CountryRegionCode = countryRegionCode;
	}

	public Boolean getIsOnlyStateProvinceFlag() {
		return IsOnlyStateProvinceFlag;
	}

	public void setIsOnlyStateProvinceFlag(Boolean isOnlyStateProvinceFlag) {
		IsOnlyStateProvinceFlag = isOnlyStateProvinceFlag;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public Long getTerritoryID() {
		return TerritoryID;
	}

	public void setTerritoryID(Long territoryID) {
		TerritoryID = territoryID;
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
