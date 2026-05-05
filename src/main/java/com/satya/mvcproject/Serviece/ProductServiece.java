package com.satya.mvcproject.Serviece;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.satya.mvcproject.Models.Product;
import com.satya.mvcproject.Repository.ProductRepository;

@Service
public class ProductServiece {
	@Autowired
	ProductRepository productRepository;
	
public Product saveProductData(Product product) 
{
	return productRepository.save(product);
	
}

public List<Product> getAllProducts() {
	
	return productRepository.findAll();
	
}

public Optional<Product> getProductById(Long id) {
	
	return productRepository.findById(id);
}



public void deleteById(Long id) {
	// TODO Auto-generated method stub
	productRepository.deleteById(id);
}

public Product getProductById1(Long id) {
	// TODO Auto-generated method stub
	return  productRepository.findById(id).orElse(null);
}


	
}






