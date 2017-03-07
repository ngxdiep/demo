package com.example.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Product;
import com.example.repository.ProductRepository;

@Service("productService")
@Transactional
public class ProductServiceIplm implements IProductService {
	
	@Autowired
	ProductRepository productRepos;

	@Override
	public Product findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveProduct(Product product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateProduct(Product product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteProductById(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllUProduct() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Product> findAllProduct() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isProductExist(Product product) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public List<Object[]> findByCatalogId(int id){
		return productRepos.findByCatalogId(id);
	}

}
