package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.entity.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
//	@Query("Select * from Product")
//	List<Object[]> 	findByCatalogId()
	@Query("SELECT  p.productName, c.catalogName FROM  Product p INNER JOIN p.catalog c WHERE c.catalogId = :id")
	List<Object[]> findByCatalogId(@Param("id") int id);
}
