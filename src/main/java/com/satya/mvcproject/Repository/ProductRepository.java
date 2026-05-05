package com.satya.mvcproject.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.satya.mvcproject.Models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	
	public interface ProductServiece {
	    List<Product> getAllProducts();
	}

}
