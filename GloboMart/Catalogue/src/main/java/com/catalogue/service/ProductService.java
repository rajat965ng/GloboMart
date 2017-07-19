package com.catalogue.service;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.catalogue.dao.IProductDao;
import com.catalogue.entity.Product;

@Service
@Transactional
public class ProductService implements IProductService{

	@Autowired
	private IProductDao productDao;
	@Autowired
	private EntityManager entityManager;

	
	
	@Override
	public Product findById(long id) {
		return productDao.findOne(id);
	}

	@Override
	public List<Product> findAll() {
		return productDao.findAll();
	}

	@Override
	public Product save(Product product) {
		return productDao.save(product);
	}

	@Override
	public List<Product> findByType(String type) {
		return productDao.findByProductType(type, entityManager);
	}

	@Override
	public List<Product> findByBrand(String brandCode) {
		return productDao.findByBrand(brandCode, entityManager);
	}

	@Override
	public List<Product> findByName(String name) {
		return productDao.findByName(name, entityManager);
	}

	@Override
	public void delete(long id) {
		productDao.delete(id);
	}
	
	
}
