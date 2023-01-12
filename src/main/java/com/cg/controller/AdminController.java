package com.cg.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import com.cg.dto.AdminDto;
import com.cg.dto.CanteenStaffDto;
import com.cg.entity.Admin; 

import com.cg.exception.AdminIdNotFoundException;
//import com.cg.model.Admin;
import com.cg.service.IAdminService;

@RestController
@RequestMapping("/admin")
@CrossOrigin("*")
public class AdminController {
	@Autowired
	IAdminService service;
	
	@PostMapping(path = "/AdminlogIn/{userId}")
	public AdminDto signIn (@PathVariable("userId") int userId,@RequestBody AdminDto admin) throws AdminIdNotFoundException
	{
		//log.info("Login succefull");
		return service.signIn(userId,admin);
	}
    @PutMapping("/update/{id}")
    public AdminDto update(@PathVariable("id") int id,@RequestBody AdminDto admin) throws AdminIdNotFoundException
    {
		return service.updatePassword(id, admin);
    	
    }
    @DeleteMapping("/signout/{userId}")
    public String signOut(@PathVariable("userId") int userId) throws AdminIdNotFoundException
    {
    	 service.signOut(userId);
    	 return  "DELEDTED SUCCESFULLY";
    }
    @GetMapping("/getAdmin/{userId}")
	 public AdminDto getAdminById(@PathVariable("userId") int userId) throws AdminIdNotFoundException
	 {
		 //LOGGER.info("Canteen staff Controller::getstaffById::Entered");
		 AdminDto dto=service.getAdminById(userId);
		 //LOGGER.info("CanteenStaff Controller::getstaffById::Exits");
		 return dto;	 
	 }
    @GetMapping("/getAdmin")
    public List<AdminDto> getAllAdmins()
    {
    	List<AdminDto> admins=service.getAllAdmins();
    	return admins;
    }
}
