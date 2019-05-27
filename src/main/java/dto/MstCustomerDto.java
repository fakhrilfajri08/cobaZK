package dto;

import java.util.Date;

import entity.MstCustomer;
import entity.MstDepartment;
import entity.enumcol.GenderEnum;

public class MstCustomerDto {

	private Date createdDate;// = LocalDateTime.now();
	private String createdUser;
	private Date updatedDate;
	private String updatedUser;
	private Boolean deleted = false;
	
	private Integer id;
	private String namaCustomer;
	private Date dateOfBirth;
	private MstDepartment department;
	private GenderEnum gender;
	private String birthPlace;
//	private String addressCust;
	
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public String getCreatedUser() {
		return createdUser;
	}
	public void setCreatedUser(String createdUser) {
		this.createdUser = createdUser;
	}
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	public String getUpdatedUser() {
		return updatedUser;
	}
	public void setUpdatedUser(String updatedUser) {
		this.updatedUser = updatedUser;
	}
	public Boolean getDeleted() {
		return deleted;
	}
	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNamaCustomer() {
		return namaCustomer;
	}
	public void setNamaCustomer(String namaCustomer) {
		this.namaCustomer = namaCustomer;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public GenderEnum getGender() {
		return gender;
	}
	public void setGender(GenderEnum gender) {
		this.gender = gender;
	}
	public String getBirthPlace() {
		return birthPlace;
	}
	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}
//	public String getAddressCust() {
//		return addressCust;
//	}
//	public void setAddressCust(String addressCust) {
//		this.addressCust = addressCust;
//	}
	public MstDepartment getDepartment() {
		return department;
	}
	public void setDepartment(MstDepartment department) {
		this.department = department;
	}
}
