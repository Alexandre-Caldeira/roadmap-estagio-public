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
@Table(name = "productmodel")
public class ProductModel implements Entidade {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ProductModelID; // int AI PK
	private String Name; // varchar(50)
	private String CatalogDescription; // text
	private String Instructions; // text

	@Column(columnDefinition = "BINARY(16)")
	private UUID rowguid = UUID.randomUUID(); // varbinary(16)
	private LocalDateTime ModifiedDate = LocalDateTime.now(); // timestamp

	public ProductModel() {

	}
	
	public Object getPK() {
		return this.ProductModelID;
	}
	
	public Long getProductModelID() {
		return ProductModelID;
	}

	public void setProductModelID(Long productModelID) {
		ProductModelID = productModelID;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getCatalogDescription() {
		return CatalogDescription;
	}

	public void setCatalogDescription(String catalogDescription) {
		CatalogDescription = catalogDescription;
	}

	public String getInstructions() {
		return Instructions;
	}

	public void setInstructions(String instructions) {
		Instructions = instructions;
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
