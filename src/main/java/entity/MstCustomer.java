package entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import component.BaseEntity;
import entity.enumcol.GenderEnum;
import entity.pk.MstCustomerPk;


@Entity
@Table(name="mst_customer")
@IdClass(value=MstCustomerPk.class)
public class MstCustomer extends BaseEntity implements Serializable{

	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 2406423172161738513L;

	@Id
	@Column(name="id")
	private Integer id;
	
	@Column(name="cust_name")
	private String custName;
	
	@Column(name="date_of_birth")
	private Date dateOfBirth;
	
	@Column(name="gender")
	private GenderEnum gender;
	
	@ManyToOne
	private MstDepartment department;
		
	@Column(name="birth_place")
	private String birthPlace;
	
//	@Column(name="address")
//	private String addressCust;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
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
//
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
