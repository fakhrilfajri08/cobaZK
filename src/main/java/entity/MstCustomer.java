package entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import component.BaseEntity;
import entity.enumcol.GenderEnum;
import entity.pk.MstCustomerPk;

@Entity
@Table(name="mst_customer")
@IdClass(value=MstCustomerPk.class)
@NamedQueries({
	@NamedQuery(
			name="Mstcustomer.findById", 
			query="SELECT p FROM Mstcustomer p WHERE p.id = :id")
})
public class MstCustomer extends BaseEntity implements Serializable{

	private static final long serialVersionUID = 209321702337294118L;

	@Id
	@Column(name="id")
	private Integer id;
	
	@Column(name="nama_customer")
	private String namaCustomer;
	
	@Column(name="date_of_birth")
	private Date dateOfBirth;
	
	@Column(name="gender")
	private GenderEnum gender;
	
	
	
	@Column(name="birth_place")
	private String birthPlace;

	
	public void setId(Integer id) {
		this.id = id;
	}

//	@Override
	public Integer getId() {
		return this.id;
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
	
	

}
