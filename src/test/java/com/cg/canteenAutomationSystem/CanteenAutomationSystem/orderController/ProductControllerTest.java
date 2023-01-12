package com.cg.canteenAutomationSystem.CanteenAutomationSystem.orderController;


import static org.mockito.Mockito.doNothing;


import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cg.controller.ProductController;
import com.cg.dto.ProductDto;
import com.cg.service.IProductService;



@ExtendWith(MockitoExtension.class)
public class ProductControllerTest {

	@InjectMocks
	ProductController productcontroller;
	@Mock
	IProductService productservice;
	
	
	
	@Test
	void testCreateProduct() {
		 
		ProductDto product = createProductDtoMockData();
		
		when(productservice.saveProduct(product)).thenReturn(product);
		
		ProductDto productdto =productcontroller.saveProduct(product);
		
		assert(product.getProductId() == productdto.getProductId());
		
	}


	@Test
	void testViewProduct() {
		long id=1;
		ProductDto productId = createProductDtoMockData();
		when(productservice.getProduct(id)).thenReturn(productId);
		ProductDto productdto = productcontroller.getProductById(id);
		assert(productId.getProductId() == productdto.getProductId());
	}
	
	@Test
	void ViewAllProducts() {
		List<ProductDto> products = createAllProductDtoMockData();
		
		when(productservice.getAllProducts()).thenReturn(products);
		List<ProductDto> productList = productcontroller.getProducts();
		assert(products.size() == productList.size());
	}
	
	@Test
	void testUpdateProduct() {
		long id=1;
		ProductDto productdto =createProductDtoMockData();
			when(productservice.updateProduct( id, productdto)).thenReturn(productdto);
			ProductDto product = productcontroller.updateProduct(id, productdto);
			assert(productdto.getProductId() ==  product.getProductId() );
		}
	
	
	@Test
	void testDeleteProduct() {
		long id=1;
		String msg="successfully deleted product";
		doNothing().when(productservice).deleteProduct(id);
		String message = productcontroller.deleteProduct(id);
		assert(message.equals(message));
		
	}
	private List< ProductDto> createAllProductDtoMockData() {
		// TODO Auto-generated method stub
		List<ProductDto> product =new ArrayList<>();
		ProductDto productdto =new ProductDto();
		productdto.setPrice(200);
		productdto.setProductId((long) 1234);
		productdto.setProductName("parimella");
		productdto.setQuantity(500);
		return product;
	
	}
	private ProductDto createProductDtoMockData() {
		// TODO Auto-generated method stub
		ProductDto product =new ProductDto();
		product.setPrice(200);
		product.setProductId((long) 1234);
		product.setProductName("rahul");
		product.setQuantity(500);
		return product;
	}
}
