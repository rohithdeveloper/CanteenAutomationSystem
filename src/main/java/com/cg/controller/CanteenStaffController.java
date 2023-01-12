package com.cg.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.dto.CanteenStaffDto;
import com.cg.dto.ProductDto;
import com.cg.exception.StaffNotFoundException;
import com.cg.service.ICanteenStaffService;
import com.cg.service.ICustomerService;
import com.cg.service.IProductService;

@RestController
@RequestMapping("/staff")
@CrossOrigin("*")
public class CanteenStaffController {
	
	
		Log LOGGER = LogFactory.getFactory().getLog(CanteenStaffController .class);
	 @Autowired
		ICanteenStaffService service;
	 
	 @PostMapping(path ="/StafflogIn/{staffId}")
     CanteenStaffDto signIn (@PathVariable("staffId") Long staffId,@RequestBody CanteenStaffDto staff) throws StaffNotFoundException
    {
        //log.info("Login succesfull");
        return service.signIn(staffId,staff);
    }
	 
	 
	 @GetMapping("/getstaff")
		public List<CanteenStaffDto> getStaff() {
		 LOGGER.info("CanteenStaffController::getstaff::Entered");
			List<CanteenStaffDto> staff =	service.getAllStaff();
			 LOGGER.info("CanteenStaffController::getStaff::Exits");
			return staff;	
		}
	 @GetMapping("/getstaffId/{staffId}")
	 public CanteenStaffDto getstaffById(@PathVariable("staffId") long staffId)
	 {
		 LOGGER.info("Canteen staff Controller::getstaffById::Entered");
		 CanteenStaffDto dto=service.getStaffById(staffId);
		 LOGGER.info("CanteenStaff Controller::getstaffById::Exits");
		 return dto;	 
	 }
	 @Validated
	 @PostMapping("/save/staff")
		public CanteenStaffDto saveStaff(@RequestBody @Valid CanteenStaffDto staff) {
		 LOGGER.info("CanteenStaff Controller::saveProduct::Entered");
		 CanteenStaffDto dto = service.saveStaff(staff)	;
	     LOGGER.info("CanteenStaff Controller::save::Exit");
	     return dto;
		}
	 @PutMapping("/updateStaff/{id}")
		public CanteenStaffDto updateStaff(@PathVariable Long id,@RequestBody CanteenStaffDto staff) {
		 LOGGER.info("CanteenStaff Controller::UpdateStaff::Entered");
		 CanteenStaffDto dto =  service.updateStaff(id, staff);
		 LOGGER.info("canteenstaff Controller::update::Exits");
			return dto;
			
		}
	 @DeleteMapping("/delete/staff/{staffId}")
		public String deleteStaff(@PathVariable("staffId") long staffId) {
		 LOGGER.info("Canteen Staff Controller::deletestaff::Entered");
			service.deleteStaff(staffId);
		 LOGGER.info("Canteen Staff Controller::deletestaff::Entered");
			return "Successfully Deleted Staff";
			
		}
	 
	 

	}


