package com.cg.canteenAutomationSystem.CanteenAutomationSystem.orderController;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

 

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

 

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

 

import com.cg.controller.AdminController;
import com.cg.controller.OrderController;
import com.cg.dto.AdminDto;
import com.cg.dto.OrderDto;
import com.cg.dto.ProductDto;
import com.cg.exception.AdminIdNotFoundException;
import com.cg.service.IAdminService;
import com.cg.service.IOrderService;

 

@ExtendWith(MockitoExtension.class)
public class AdminControllerTest {
    @InjectMocks
    AdminController adminController;
    @Mock
    IAdminService  iAdminService;
    @Test
    void getAllTest() {
        List<AdminDto> admins = createAdminsDtoMockData();        
        when(iAdminService.getAllAdmins()).thenReturn(admins);
        List<AdminDto> adminList =adminController.getAllAdmins();
        assert(admins.size() == adminList.size());

    }
    private List<AdminDto>  createAdminsDtoMockData(){
        List<AdminDto> admins = new ArrayList<>();
        AdminDto admin = new AdminDto();
        admin.setUserName("kiran");
        admin.setPassword("mom");
        admins.add(admin);
        return admins;

 

}
    @Test
    void getAdminByIdTest() throws AdminIdNotFoundException {
        int id = 1;
        AdminDto admin = createAdminDtoMockData();        
        when( iAdminService.getAdminById(id)).thenReturn(admin);
        AdminDto adminInfo = adminController.getAdminById(id);
        assert(admin.getUserId() == adminInfo.getUserId());

    }
    private AdminDto  createAdminDtoMockData(){
        AdminDto admin = new AdminDto();
        admin.setUserName("kiran");
        admin.setPassword("mom");
        return admin;

 

}@Test
void deleteAdminTest() throws AdminIdNotFoundException {
    int id = 1;
    String msg = "DELEDTED SUCCESFULLY";
    doNothing().when(iAdminService).signOut(id);
    String message = adminController.signOut(id);
    assert(message.equals(msg));

}


}