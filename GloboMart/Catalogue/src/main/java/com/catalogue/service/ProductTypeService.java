package com.catalogue.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.catalogue.dao.IProductTypeDao;
import com.catalogue.entity.ProductType;

@Service
@Transactional
public class ProductTypeService implements IProductTypeService{

	@Autowired
	private IProductTypeDao productTypeDao;
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public ProductType save(ProductType productType) {
		return productTypeDao.save(productType);
	}

	@Override
	public List<ProductType> findAll() {
		return productTypeDao.findAll();
	}

	@Override
	public ProductType findTypeByCode(String code) {
		TypedQuery<ProductType> query = 
				entityManager.createNamedQuery("findByCode", ProductType.class);
		query.setParameter("typeCode", code);
		return query.getSingleResult();
	}

	
}
