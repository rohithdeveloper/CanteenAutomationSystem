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

import com.cg.dto.OrderDto;
import com.cg.dto.ProductDto;
import com.cg.service.IOrderService;
import com.cg.service.IProductService;
@RestController
@RequestMapping("/product")
@CrossOrigin("*")
public class ProductController {
	
	
		Log LOGGER = LogFactory.getFactory().getLog(ProductController.class);
	 @Autowired
		IProductService service;
	 @GetMapping("/getproducts")
		public List<ProductDto> getProducts() {
		 LOGGER.info("ProductController::getAllProduct::Entered");
			List<ProductDto> products =	service.getAllProducts();
			 LOGGER.info("ProductController::getAllProduct::Exits");
			return products;	
		}
	 @GetMapping("/getProductId/{productId}")
	 public ProductDto getProductById(@PathVariable("productId") long productId)
	 {
		 LOGGER.info("productController::getproductById::Entered");
		ProductDto product=service.getProduct(productId);
		 LOGGER.info("productController::getproductById::Exits");
		 return  product;	 
	 }
	 @Validated
	 @PostMapping("/save/product")
		public ProductDto saveProduct(@RequestBody @Valid ProductDto product) {
		 LOGGER.info("ProductController::saveProduct::Entered");
			
			ProductDto dto = service.saveProduct(product)	;
			
			 LOGGER.info("ProductController::save::Exit");
			return dto;
		}
	 @PutMapping("/updateProduct/{id}")
		public ProductDto updateProduct(@PathVariable Long id,@RequestBody ProductDto product) {
		 LOGGER.info("ProductController::UpdateProduct::Entered");
			ProductDto productDto =  service.updateProduct(id, product);
		 LOGGER.info("ProductController::update::Exits");
			return productDto;
			
		}
	 @DeleteMapping("/delete/product/{productId}")
		public String deleteProduct(@PathVariable("productId") long productId) {
		 LOGGER.info("OrderController::deleteOrder::Entered");
			service.deleteProduct(productId);
		 LOGGER.info("OrderController::deleteOrder::Entered");
			return "Successfully Deleted Product";
			
		}
	 

	}


