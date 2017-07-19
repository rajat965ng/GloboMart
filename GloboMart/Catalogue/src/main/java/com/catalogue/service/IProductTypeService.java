package com.catalogue.service;

import java.util.List;

import com.catalogue.entity.ProductType;

public interface IProductTypeService {

	public ProductType save(ProductType productType);
	public List<ProductType> findAll();
	public ProductType findTypeByCode(String code);
	
}
