package com.example.demo.service;

import java.util.List;

import com.example.demo.entities.Product;

public interface ProductService {
	
	Product saveData(Product proObj);
	
	List<Product> findByName(String name);

}
