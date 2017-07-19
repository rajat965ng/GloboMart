package com.catalogue.service;

import java.util.List;

import com.catalogue.entity.Product;

public interface IProductService {

	public List<Product> findAll();
	public Product save(Product product);
	public Product findById(long id);
	public List<Product> findByType(String type);
	public List<Product> findByBrand(String brandCode);
	public List<Product> findByName(String name);
	public void delete(long id);
}
