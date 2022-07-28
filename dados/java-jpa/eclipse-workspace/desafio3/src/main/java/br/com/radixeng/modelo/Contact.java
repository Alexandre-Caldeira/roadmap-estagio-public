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
@Table(name = "contact")
public class Contact implements Entidade {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ContactID; //int AI PK 
	
	private Boolean NameStyle; //bit(1) 
	private String Title; //varchar(8) 
	private String FirstName; //varchar(50) 
	private String MiddleName; //varchar(50) 
	private String LastName; //varchar(50) 
	private String Suffix; //varchar(10) 
	private String EmailAddress; //varchar(50) 
	private Integer EmailPromotion; //int 
	private String Phone; //varchar(25) 
	private String PasswordHash; //varchar(40) 
	private String PasswordSalt; //varchar(10) 
	private String AdditionalContactInfo; //mediumtext 
	
	@Column(columnDefinition = "BINARY(16)")
	private UUID rowguid; //varbinary(16) 
	private LocalDateTime ModifiedDate = LocalDateTime.now(); //timestamp
	
	public Contact() {
		
	}
	
	public Object getPK() {
		return this.getContactID();
	}
	
	public Long getContactID() {
		return ContactID;
	}
	public void setContactID(Long contactID) {
		ContactID = contactID;
	}
	public Boolean getNameStyle() {
		return NameStyle;
	}
	public void setNameStyle(Boolean nameStyle) {
		NameStyle = nameStyle;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getMiddleName() {
		return MiddleName;
	}
	public void setMiddleName(String middleName) {
		MiddleName = middleName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getSuffix() {
		return Suffix;
	}
	public void setSuffix(String suffix) {
		Suffix = suffix;
	}
	public String getEmailAddress() {
		return EmailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		EmailAddress = emailAddress;
	}
	public Integer getEmailPromotion() {
		return EmailPromotion;
	}
	public void setEmailPromotion(Integer emailPromotion) {
		EmailPromotion = emailPromotion;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	public String getPasswordHash() {
		return PasswordHash;
	}
	public void setPasswordHash(String passwordHash) {
		PasswordHash = passwordHash;
	}
	public String getPasswordSalt() {
		return PasswordSalt;
	}
	public void setPasswordSalt(String passwordSalt) {
		PasswordSalt = passwordSalt;
	}
	public String getAdditionalContactInfo() {
		return AdditionalContactInfo;
	}
	public void setAdditionalContactInfo(String additionalContactInfo) {
		AdditionalContactInfo = additionalContactInfo;
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
