package com.cg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer>{

	//@Query(value="select userName from admin whereg admin_id=?1 ",nativeQuery=true)
	//public String getUserName(int getId );

}
