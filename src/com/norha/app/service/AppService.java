package com.norha.app.service;

import java.util.List;

import com.norha.app.entity.Product;

public interface AppService {
	
	List<Product> getProducts();

	void addProduct(Product product);

	Product getProduct(int id);

	void deleteProduct(int id);

}
