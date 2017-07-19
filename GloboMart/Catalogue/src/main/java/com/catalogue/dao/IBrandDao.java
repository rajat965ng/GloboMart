package com.catalogue.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.catalogue.entity.Brand;

@Repository
public interface IBrandDao extends JpaRepository<Brand, Long>{

}
