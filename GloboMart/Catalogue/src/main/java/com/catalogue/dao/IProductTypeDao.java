package com.catalogue.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.catalogue.entity.ProductType;

@Repository
public interface IProductTypeDao extends JpaRepository<ProductType, Long>{

}
