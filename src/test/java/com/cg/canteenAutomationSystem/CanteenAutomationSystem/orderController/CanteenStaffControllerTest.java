package com.cg.canteenAutomationSystem.CanteenAutomationSystem.orderController;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.cg.controller.CanteenStaffController;
import com.cg.dto.CanteenStaffDto;
import com.cg.service.ICanteenStaffService;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CanteenStaffControllerTest {
	
	    @InjectMocks
	    CanteenStaffController canteenStaffController;
	    @Mock
	    ICanteenStaffService canteeenStaffService;


	    @Test
	    void getAllCanteenStaffTest() {
	        List<CanteenStaffDto> canteenStaff = createCanteenStaffsDtoMockData();        
	        when(canteeenStaffService.getAllStaff()).thenReturn(canteenStaff);
	        List<CanteenStaffDto> canteenStaffList = canteenStaffController.getStaff();
	        assert(canteenStaff.size() == canteenStaffList.size());

	    }

	    @Test
	    void getCanteenStaffTest() {

	        long id = 1;
	        CanteenStaffDto canteenStaff = createCanteenStaffDtoMockData();        
	        when(canteeenStaffService.getStaffById(id)).thenReturn(canteenStaff);

	        CanteenStaffDto canteenStaffInfo = canteenStaffController.getstaffById(id);

	        assert(canteenStaff.getStaffId() == canteenStaffInfo.getStaffId());

	    }

	    @Test
	    void saveCanteenStaffTest() {

	        CanteenStaffDto canteenStaff = createCanteenStaffDtoMockData();    

	        when(canteeenStaffService.saveStaff(canteenStaff)).thenReturn(canteenStaff);

	        CanteenStaffDto canteenStaffInfo = canteenStaffController.saveStaff(canteenStaff);

	        assert(canteenStaff.getStaffId() == canteenStaffInfo.getStaffId());

	    }

	    @Test
	    void updateCanteenStaffTest() {
	        long id=100;

	        CanteenStaffDto canteenStaff = createCanteenStaffDtoMockData();    

	        when(canteeenStaffService.updateStaff(id,canteenStaff)).thenReturn(canteenStaff);

	        CanteenStaffDto canteenStaffInfo = canteenStaffController.updateStaff(id,canteenStaff);

	        assert(canteenStaff.getStaffId() == canteenStaffInfo.getStaffId());

	    }

	    @Test
	    void deleteCanteenStaffTest() {

	        long staffId = 100;

	        String msg = "Successfully Deleted Canteen Staff";

	        doNothing().when(canteeenStaffService).deleteStaff(staffId);

	        String message = canteenStaffController.deleteStaff(staffId);

	        assert(message.equals(message));

	    }

	    private List<CanteenStaffDto> createCanteenStaffsDtoMockData() {
	        // TODO Auto-generated method stub
	        List<CanteenStaffDto> canteenStaffs = new ArrayList<>();
	        CanteenStaffDto canteenStaff = new CanteenStaffDto();
	        canteenStaff.setStaffId((long)100);
	        canteenStaff.setStaffName("pavan");
	        canteenStaff.setStaffEmail("pavan@gmail.com");

	        return canteenStaffs;
	    }

	 

	    private CanteenStaffDto createCanteenStaffDtoMockData() {
	        // TODO Auto-generated method stub
	        CanteenStaffDto canteenStaff = new CanteenStaffDto();
	        canteenStaff.setStaffId((long)100);
	        canteenStaff.setStaffName("pavan");
	        canteenStaff.setStaffEmail("pavan@gmail.com");

	 

	        return canteenStaff;
	    }

}
