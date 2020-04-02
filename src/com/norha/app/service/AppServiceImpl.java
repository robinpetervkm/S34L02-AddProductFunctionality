package com.norha.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.norha.app.DAO.ProductDAO;
import com.norha.app.entity.Product;

@Service
public class AppServiceImpl implements AppService {
	@Autowired
	private ProductDAO productDAO;

	@Override
	@Transactional
	public List<Product> getProducts() {
		return productDAO.getProducts();
	}

}
