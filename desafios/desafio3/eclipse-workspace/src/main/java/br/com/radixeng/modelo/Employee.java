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
@Table(name = "employee")
public class Employee implements Entidade {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long EmployeeID; // int PK
	
	// TODO: verificar
	private String NationalIDNumber; // varchar(15)
	private Long ContactID; // int
	private String LoginID; // varchar(256)
	private Long ManagerID; // int
	
	private String Title; // varchar(50)
	private LocalDateTime BirthDate; // datetime
	private String MaritalStatus; // varchar(1)
	private String Gender; // varchar(1)
	private LocalDateTime HireDate; // datetime
	private Boolean SalariedFlag; // bit(1)
	private int VacationHours; // smallint
	private int SickLeaveHours; // smallint
	private Boolean CurrentFlag; // bit(1)

	@Column(columnDefinition = "BINARY(16)")
	private UUID rowguid; // varbinary(16)
	private LocalDateTime ModifiedDate = LocalDateTime.now(); // timestamp

	public Employee() {

	}

	public Object getPK() {
		return this.getEmployeeID();
	}

	public Long getEmployeeID() {
		return EmployeeID;
	}

	public void setEmployeeID(Long employeeID) {
		EmployeeID = employeeID;
	}

	public String getNationalIDNumber() {
		return NationalIDNumber;
	}

	public void setNationalIDNumber(String nationalIDNumber) {
		NationalIDNumber = nationalIDNumber;
	}

	public Long getContactID() {
		return ContactID;
	}

	public void setContactID(Long contactID) {
		ContactID = contactID;
	}

	public String getLoginID() {
		return LoginID;
	}

	public void setLoginID(String loginID) {
		LoginID = loginID;
	}

	public Long getManagerID() {
		return ManagerID;
	}

	public void setManagerID(Long managerID) {
		ManagerID = managerID;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public LocalDateTime getBirthDate() {
		return BirthDate;
	}

	public void setBirthDate(LocalDateTime birthDate) {
		BirthDate = birthDate;
	}

	public String getMaritalStatus() {
		return MaritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		MaritalStatus = maritalStatus;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	public LocalDateTime getHireDate() {
		return HireDate;
	}

	public void setHireDate(LocalDateTime hireDate) {
		HireDate = hireDate;
	}

	public Boolean getSalariedFlag() {
		return SalariedFlag;
	}

	public void setSalariedFlag(Boolean salariedFlag) {
		SalariedFlag = salariedFlag;
	}

	public int getVacationHours() {
		return VacationHours;
	}

	public void setVacationHours(int vacationHours) {
		VacationHours = vacationHours;
	}

	public int getSickLeaveHours() {
		return SickLeaveHours;
	}

	public void setSickLeaveHours(int sickLeaveHours) {
		SickLeaveHours = sickLeaveHours;
	}

	public Boolean getCurrentFlag() {
		return CurrentFlag;
	}

	public void setCurrentFlag(Boolean currentFlag) {
		CurrentFlag = currentFlag;
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
