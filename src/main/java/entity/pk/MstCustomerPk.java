package entity.pk;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class MstCustomerPk implements Serializable{

	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6737711144305780165L;
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
