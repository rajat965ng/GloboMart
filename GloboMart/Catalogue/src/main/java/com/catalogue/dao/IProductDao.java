package com.catalogue.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.catalogue.entity.Product;

@Repository
public interface IProductDao extends JpaRepository<Product, Long>{
	
	public default List<Product> findByName(String name, EntityManager entityManager){
		TypedQuery<Product> query =
				entityManager.createNamedQuery("findByName", Product.class);
		query.setParameter("name", name);
		return query.getResultList();
	}
	
	public default List<Product> findByBrand(String name, EntityManager entityManager){
		TypedQuery<Product> query =
				entityManager.createNamedQuery("findByProductBrand", Product.class);
		query.setParameter("name", name);
		return query.getResultList();
	}
	
	public default List<Product> findByProductType(String typeCode, EntityManager entityManager){
		TypedQuery<Product> query =
				entityManager.createNamedQuery("findByProductType", Product.class);
		query.setParameter("typeCode", typeCode);
		return query.getResultList();
	}

}
