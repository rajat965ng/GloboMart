package com.catalogue.service;

import java.util.List;

import com.catalogue.entity.Brand;


public interface IBrandService {

	public Brand save(Brand brand);
	public List<Brand> findAll();
	public Brand findByBrandName(String brandName);
	
}
