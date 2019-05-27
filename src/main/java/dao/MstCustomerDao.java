package dao;

import org.springframework.data.jpa.repository.JpaRepository;

import entity.MstCustomer;
import entity.pk.MstCustomerPk;

public interface MstCustomerDao extends 
	JpaRepository<MstCustomer, MstCustomerPk>{

}
