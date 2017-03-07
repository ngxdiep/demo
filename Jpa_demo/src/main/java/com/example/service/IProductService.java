package com.example.service;

import java.util.List;

import com.example.entity.Product;
import com.example.entity.User;

public interface IProductService {
	Product findById(int id);
	 
    Product findByName(String name);
 
    void saveProduct(Product product);
 
    void updateProduct(Product product);
 
    void deleteProductById(int id);
 
    void deleteAllUProduct();
 
    List<Product> findAllProduct();
 
    boolean isProductExist(Product product);
    
    //List<Object> findByCatalogId();
}
