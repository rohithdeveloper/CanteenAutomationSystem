package com.cg.canteenAutomationSystem.CanteenAutomationSystem.orderController;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cg.entity.Product;
import com.cg.dto.ProductDto;
import com.cg.repository.ProductRepository;
import com.cg.service.seviceImpl.ProductServiceImpl;

@ExtendWith(MockitoExtension.class)
public class ProductServicesTest {
	
	@InjectMocks
	ProductServiceImpl productservice;
	
	@Mock
	ProductRepository repo;
	
	
	@Test
	public void addProductTest() {
		ProductDto productdto=CreateProductDtoMockData(); 
		Product  product=CreateProductMockData();
		 when(repo.save(product)).thenReturn(product);
		 ProductDto productInfo=productservice.saveProduct(productdto);
		 assert(productdto.getProductId()== product.getProductId());
	}
	
	@Test
	public void getAllproducts() {
		List<Product> products=CreateAllProductDtoMockData();
		when(repo.findAll()).thenReturn(products);
		assertEquals(1,productservice.getAllProducts().size());
		
		
	}
	
	 private ProductDto CreateProductDtoMockData() {
		  
			ProductDto productdto=new ProductDto();
			productdto.setProductId((long) 1);
			productdto.setProductName("chicken");
			productdto.setPrice(( 100));
			productdto.setQuantity(200);
			
			return productdto;
			 
		 }
	 private List<Product> CreateAllProductDtoMockData() {
		  
			List<Product> products=new ArrayList<>();
			Product productdto=new Product();
			productdto.setProductId((long)1);
			productdto.setProductName("chicken");
			productdto.setPrice(100);
			productdto.setQuantity(200);
			products.add(productdto);
			return products;
			 
		 }
	 private Product CreateProductMockData() {
		  
			Product product=new Product();
			product.setProductId((long)1);
			product.setProductName("chicken");
			product.setPrice(100);
			product.setQuantity(200);
			
			return product;
			 
		 }

}
