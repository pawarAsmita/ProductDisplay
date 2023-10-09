package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Product;
import com.example.demo.repos.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductRepository proRepo;

	@Override
	public Product saveData(Product proObj) {
		// TODO Auto-generated method stub
		return proRepo.save(proObj);
	}

	@Override
	public List<Product> findByName(String name) {
		// TODO Auto-generated method stub
		return proRepo.findByName(name);
	}

	
}
