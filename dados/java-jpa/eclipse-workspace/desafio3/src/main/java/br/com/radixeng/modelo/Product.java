package br.com.radixeng.modelo;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product implements Entidade {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ProductID;

	private String Name;
	private String ProductNumber;
	private Boolean MakeFlag = false;
	private Boolean FinishedGoodsFlag = false;
	private String Color;
	private Integer SafetyStockLevel;
	private Integer ReorderPoint;
	private Double StandardCost = 0d;
	private Double ListPrice = 0d;
	private String Size;
	private String SizeUnitMeasureCode;
	private String WeightUnitMeasureCode;
	private BigDecimal Weight;
	private Integer DaysToManufacture = 0;
	private String ProductLine;
	
	@Column(name = "class")
	private String Classe;
	
	private String Style;
	private Long ProductSubcategoryID;
	private Long ProductModelID;
	private LocalDateTime SellStartDate = LocalDateTime.now();
	private LocalDateTime SellEndDate;
	private LocalDateTime DiscontinuedDate;

	@Column(columnDefinition = "BINARY(16)")
	private UUID rowguid;

	private LocalDateTime ModifiedDate = LocalDateTime.now();
	
	//TODO: sobrecarregar construtor produto
	public Product() {
		// Default constructor exigido pelo hibernate
	}
	
	public Object getPK() {
		return this.getProductID();
	}

	public Long getProductID() {
		return ProductID;
	}

	public void setProductID(Long productID) {
		ProductID = productID;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getProductNumber() {
		return ProductNumber;
	}

	public void setProductNumber(String productNumber) {
		ProductNumber = productNumber;
	}

	public Boolean getMakeFlag() {
		return MakeFlag;
	}

	public void setMakeFlag(Boolean makeFlag) {
		MakeFlag = makeFlag;
	}

	public Boolean getFinishedGoodsFlag() {
		return FinishedGoodsFlag;
	}

	public void setFinishedGoodsFlag(Boolean finishedGoodsFlag) {
		FinishedGoodsFlag = finishedGoodsFlag;
	}

	public String getColor() {
		return Color;
	}

	public void setColor(String color) {
		Color = color;
	}

	public Integer getSafetyStockLevel() {
		return SafetyStockLevel;
	}

	public void setSafetyStockLevel(Integer safetyStockLevel) {
		SafetyStockLevel = safetyStockLevel;
	}

	public Integer getReorderPoint() {
		return ReorderPoint;
	}

	public void setReorderPoint(Integer reorderPoint) {
		ReorderPoint = reorderPoint;
	}

	public Double getStandardCost() {
		return StandardCost;
	}

	public void setStandardCost(Double standardCost) {
		StandardCost = standardCost;
	}

	public Double getListPrice() {
		return ListPrice;
	}

	public void setListPrice(Double listPrice) {
		ListPrice = listPrice;
	}

	public String getSize() {
		return Size;
	}

	public void setSize(String size) {
		Size = size;
	}

	public String getSizeUnitMeasureCode() {
		return SizeUnitMeasureCode;
	}

	public void setSizeUnitMeasureCode(String sizeUnitMeasureCode) {
		SizeUnitMeasureCode = sizeUnitMeasureCode;
	}

	public String getWeightUnitMeasureCode() {
		return WeightUnitMeasureCode;
	}

	public void setWeightUnitMeasureCode(String weightUnitMeasureCode) {
		WeightUnitMeasureCode = weightUnitMeasureCode;
	}

	public BigDecimal getWeight() {
		return Weight;
	}

	public void setWeight(BigDecimal weight) {
		Weight = weight;
	}

	public Integer getDaysToManufacture() {
		return DaysToManufacture;
	}

	public void setDaysToManufacture(Integer daysToManufacture) {
		DaysToManufacture = daysToManufacture;
	}

	public String getProductLine() {
		return ProductLine;
	}

	public void setProductLine(String productLine) {
		ProductLine = productLine;
	}

	public String getClasse() {
		return Classe;
	}

	public void setClasse(String classe) {
		Classe = classe;
	}

	public String getStyle() {
		return Style;
	}

	public void setStyle(String style) {
		Style = style;
	}

	public Long getProductSubcategoryID() {
		return ProductSubcategoryID;
	}

	public void setProductSubcategoryID(Long productSubcategoryID) {
		ProductSubcategoryID = productSubcategoryID;
	}

	public Long getProductModelID() {
		return ProductModelID;
	}

	public void setProductModelID(Long productModelID) {
		ProductModelID = productModelID;
	}

	public LocalDateTime getSellStartDate() {
		return SellStartDate;
	}

	public void setSellStartDate(LocalDateTime sellStartDate) {
		SellStartDate = sellStartDate;
	}

	public LocalDateTime getSellEndDate() {
		return SellEndDate;
	}

	public void setSellEndDate(LocalDateTime sellEndDate) {
		SellEndDate = sellEndDate;
	}

	public LocalDateTime getDiscontinuedDate() {
		return DiscontinuedDate;
	}

	public void setDiscontinuedDate(LocalDateTime discontinuedDate) {
		DiscontinuedDate = discontinuedDate;
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
