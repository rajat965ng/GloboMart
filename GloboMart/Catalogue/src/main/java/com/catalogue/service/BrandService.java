package com.catalogue.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.catalogue.dao.IBrandDao;
import com.catalogue.entity.Brand;


@Service
@Transactional
public class BrandService implements IBrandService{

	@Autowired
	private IBrandDao brandDao;
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public Brand save(Brand brand) {
		return brandDao.saveAndFlush(brand);
	}

	@Override
	public List<Brand> findAll() {
		return brandDao.findAll();
	}

	@Override
	public Brand findByBrandName(String brandName) {
		TypedQuery<Brand> query = 
				entityManager.createNamedQuery("findBrandByName", Brand.class);
		query.setParameter("brandName", brandName);
		return query.getSingleResult();
	}

	
}
