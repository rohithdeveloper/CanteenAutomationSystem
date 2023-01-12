package com.cg.service;

import java.util.List;

import com.cg.dto.OrderDto;
import com.cg.dto.ProductDto;

public interface IProductService {
List<ProductDto> getAllProducts();
ProductDto getProduct(long productId);
ProductDto saveProduct(ProductDto product);
ProductDto updateProduct(Long productId,ProductDto product);
void deleteProduct(Long productId);

}
