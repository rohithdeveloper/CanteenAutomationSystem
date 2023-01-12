package com.cg.service.seviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dto.AdminDto;
import com.cg.dto.ProductDto;
import com.cg.entity.Admin;
import com.cg.entity.Product;
import com.cg.exception.AdminIdNotFoundException;
import com.cg.exception.PassWordWrongException;
import com.cg.exception.StaffNotFoundException;
import com.cg.repository.AdminRepository;
import com.cg.service.IAdminService;
@Service
public class AdminServiceImpl implements IAdminService{
	@Autowired
	AdminRepository repo;

	@Override
	public AdminDto signIn(int userId,AdminDto admin) throws AdminIdNotFoundException  {
		// TODO Auto-generated method stub
		Optional<Admin> admin1=repo.findById(userId);
		String userInName=admin.getUserName();
		String userInpwd=admin.getPassword();
		if((admin1.isPresent()))
		{
	      String pwd=admin1.get().getPassword();
	      if(pwd.equals(userInpwd)) {
	    	
	    	  return admin;
	      }
	      else {
	    	  throw new PassWordWrongException("ur password is wrong");
	      }
		}
	      
	      else {
	    	 throw new AdminIdNotFoundException("not found");
	      } 
		
		}
	
	@Override
	public void signOut(int userId) throws AdminIdNotFoundException {
		// TODO Auto-generated method stub
	Admin admin=repo.findById(userId).orElseThrow(()->
	new AdminIdNotFoundException("no idmin with this Id"));
	repo.delete(admin);
	
	}
	

	@Override
	public AdminDto updatePassword(int id,AdminDto admin) throws AdminIdNotFoundException {
		// TODO Auto-generated method stub
         Optional<Admin> admin1=repo.findById(id);
		
		String userInName=admin.getUserName();
		String userInpwd=admin.getPassword();
		if((admin1.isPresent()))
		{
	    	  admin1.get().setPassword(admin.getPassword());
	    	  admin1.get().setUserName(admin.getUserName());
	    	  repo.save(admin1.get());
	    	  return admin;
	      
		}
	      else {
	    	 throw new AdminIdNotFoundException("not found");
	      }
	
	}
	public AdminDto getAdminById(int userId) throws AdminIdNotFoundException {
		Admin admin1=repo.findById(userId).orElseThrow(()->
		new AdminIdNotFoundException("no idmin with this Id"));
		AdminDto dto=new AdminDto();
		dto.setUserName(admin1.getUserName());
		dto.setPassword(admin1.getPassword());
		
		return dto;
	}
	public List<AdminDto> getAllAdmins()
	{
		 List<AdminDto> admins = new ArrayList<>();	
		  List<Admin> adminList =repo.findAll();
				adminList .stream().forEach(admin -> {
					//LOGGER.debug("GroundServiceImpl::getAllGrounds::"+ground);
					AdminDto adminDto = new AdminDto();
					adminDto.setPassword(admin.getPassword());
					adminDto.setUserName(admin.getUserName());
					adminDto.setUserId(admin.getUserId());
					admins.add(adminDto);
			});
				return admins;
			}
	
	}


