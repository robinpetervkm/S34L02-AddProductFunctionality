package com.norha.app.DAO;

import java.util.List;

import com.norha.app.entity.Product;

public interface ProductDAO {
	public List<Product> getProducts();

	public void addProduct(Product product);

	public Product getProduct(int id);
}
