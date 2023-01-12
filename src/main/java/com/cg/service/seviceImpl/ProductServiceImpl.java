package com.cg.service.seviceImpl;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.cg.dto.ProductDto;
import com.cg.entity.Product;
import com.cg.exception.ProductNotFoundException;
import com.cg.repository.ProductRepository;
import com.cg.service.IProductService;

@Service
public class ProductServiceImpl implements IProductService{
	@Autowired
	ProductRepository repo;

	@Override
	public List<ProductDto> getAllProducts() {
    List<ProductDto> products = new ArrayList<>();	
  List<Product> productList =repo.findAll();
		
		productList .stream().forEach(product -> {
			//LOGGER.debug("GroundServiceImpl::getAllGrounds::"+ground);
			ProductDto productDto = new ProductDto();
			productDto.setPrice(product.getPrice());
			productDto.setProductName(product.getProductName());
			productDto.setQuantity(product.getQuantity());
			productDto.setProductId(product.getProductId());
			products.add(productDto);
			
	});
		return products;
	}

	@Override
	public ProductDto getProduct(long productId) {
		Optional<Product> productOpt = repo.findById(productId);
		ProductDto productDto = new ProductDto();
		if(productOpt.isPresent()) {
			Product product = productOpt.get();
			productDto.setPrice(product.getPrice());
			productDto.setProductName(product.getProductName());
			productDto.setQuantity(product.getQuantity());
			productDto.setProductId(product.getProductId());
			
		}else {
			throw new ProductNotFoundException("product with id::"+productId+" Not found");
	}
return productDto;
	}

	@Override
	public ProductDto saveProduct(ProductDto product) {
		Product productEntity = new Product();
		//	groundEntity.setGroundId(ground.getGroundId());
			productEntity.setProductName(product.getProductName());
			productEntity.setPrice(product.getPrice());
			productEntity.setQuantity(product.getQuantity());
			repo.save(productEntity);
			product.setProductId(productEntity.getProductId());
			return product;
	}

	@Override
	public ProductDto updateProduct(Long productId, ProductDto product) {
		Product productEntity = repo.findById(productId)
				 .orElseThrow(()->new ProductNotFoundException("product with id::"+productId+" Not found") )	;
		productEntity.setProductName(product.getProductName());
		productEntity.setQuantity(product.getQuantity());
		productEntity.setPrice(product.getPrice());
		 repo.save(productEntity);						
		return product;
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteProduct(Long productId) {
		// TODO Auto-generated method stub
		Product productEntity = repo.findById(productId)
				 .orElseThrow(()->new ProductNotFoundException("product with id::"+productId+" Not found") );
		repo.deleteById(productId);	
	}

}
