package com.cg.service;

import java.util.List;

import com.cg.dto.AdminDto;
import com.cg.entity.Admin;
import com.cg.exception.AdminIdNotFoundException;

public interface IAdminService {
	//public Admin addNewAdmin(Admin admin) ;
	public AdminDto signIn(int userId,AdminDto admin) throws AdminIdNotFoundException;
	public void signOut(int userId) throws AdminIdNotFoundException;
	public AdminDto updatePassword(int id,AdminDto admin) throws AdminIdNotFoundException;
	
	AdminDto getAdminById(int userId) throws AdminIdNotFoundException;
	List<AdminDto> getAllAdmins();
	
	

}
