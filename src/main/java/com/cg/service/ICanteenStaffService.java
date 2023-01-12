package com.cg.service;

import java.util.List;

import com.cg.dto.CanteenStaffDto;
import com.cg.exception.StaffNotFoundException;
public interface ICanteenStaffService {
	List<CanteenStaffDto> getAllStaff();
	CanteenStaffDto getStaffById(long staffId);
	CanteenStaffDto saveStaff(CanteenStaffDto staff);
	CanteenStaffDto updateStaff(Long staffId,CanteenStaffDto staff);
	void deleteStaff(Long staffId);
	CanteenStaffDto signIn(Long staffId, CanteenStaffDto staff) throws StaffNotFoundException;

	
}
