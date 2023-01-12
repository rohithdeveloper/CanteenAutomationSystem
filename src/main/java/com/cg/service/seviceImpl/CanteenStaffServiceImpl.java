package com.cg.service.seviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dto.CanteenStaffDto;
import com.cg.dto.CustomerDto;
import com.cg.entity.CanteenStaff;
import com.cg.entity.Customer;
import com.cg.exception.CustomerNotFoundException;
import com.cg.exception.PassWordWrongException;
import com.cg.exception.StaffNotFoundException;
import com.cg.repository.CanteenStaffRepository;
import com.cg.service.ICanteenStaffService;

@Service
public class CanteenStaffServiceImpl implements ICanteenStaffService{
	@Autowired
    CanteenStaffRepository repo;
	
	
	@Override
	public List<CanteenStaffDto> getAllStaff() {
		
			List<CanteenStaffDto> canteenStaffs = new ArrayList<>();
					
			List<CanteenStaff> staffList =repo.findAll();
					
					staffList .stream().forEach(canteenStaff -> {
						//LOGGER.debug("GroundServiceImpl::getAllGrounds::"+ground);
						CanteenStaffDto canteenStaffDto = new CanteenStaffDto();
						canteenStaffDto.setStaffName(canteenStaff.getStaffName());
						canteenStaffDto.setStaffEmail(canteenStaff.getStaffEmail());
						
						canteenStaffDto.setStaffId(canteenStaff.getStaffId());
						canteenStaffs.add(canteenStaffDto);
						
				});
					return canteenStaffs;
	}

	@Override
	public CanteenStaffDto getStaffById(long staffId) {
		Optional<CanteenStaff> canteenOpt = repo.findById(staffId);
		CanteenStaffDto  canteenStaffDto = new CanteenStaffDto();
		if(canteenOpt.isPresent()) {
			CanteenStaff canteenStaff =  canteenOpt.get();
			canteenStaffDto.setStaffName(canteenStaff.getStaffName());
			canteenStaffDto.setStaffEmail(canteenStaff.getStaffEmail());
			canteenStaffDto.setStaffId(canteenStaff.getStaffId());
			
			
			
		}else {
			throw new StaffNotFoundException("staff with id::"+staffId+" Not found");
	}
return canteenStaffDto;
	}

	@Override
	public CanteenStaffDto saveStaff(CanteenStaffDto staff) {
	CanteenStaff entity = new CanteenStaff();
		//	groundEntity.setGroundId(ground.getGroundId());
	entity.setStaffName(staff.getStaffName());
	entity.setStaffEmail(staff.getStaffEmail());
	repo.save(entity);
			staff.setStaffId(entity.getStaffId());
			return staff;
	}

	@Override
	public CanteenStaffDto updateStaff(Long staffId, CanteenStaffDto staff) {
		CanteenStaff canteenStaff = repo.findById(staffId)
				 .orElseThrow(()->new StaffNotFoundException("staff with id::"+staffId+" Not found") )	;
		canteenStaff.setStaffEmail(staff.getStaffEmail());
		canteenStaff.setStaffName(staff.getStaffName());;
	
		 repo.save(canteenStaff);						
		return staff;
	}

	@Override
	public void deleteStaff(Long staffId) {
		CanteenStaff canteenStaff = repo.findById(staffId)
				 .orElseThrow(()->new StaffNotFoundException("staff with id::"+staffId+" Not found") );
		repo.deleteById(staffId);
		
	}

	@Override
	public CanteenStaffDto signIn(Long staffId, CanteenStaffDto staff) throws StaffNotFoundException {
		// TODO Auto-generated method stub
		
		Optional<CanteenStaff> staff1=repo.findById(staffId);
        Long staffInid=staff.getStaffId();
        String staffInName=staff.getStaffName();
        //String userInName=admin.getUserName();
        //String userInpwd=admin.getPassword();
        if((staff1.isPresent()))
        {
          String Name=staff1.get().getStaffName();
          if(Name.equals(staffInName)) {

              return staff;
          }
          else {
              throw new PassWordWrongException("ur password is wrong");
          }
        }

          else {
             throw new StaffNotFoundException("not found");
          } 
	}
    
}
