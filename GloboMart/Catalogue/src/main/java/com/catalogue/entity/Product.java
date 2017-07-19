package com.catalogue.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="PRODUCT")
@NamedQueries({
	@NamedQuery(name="findByProductType",
			query="select p from Product p left join fetch p.productType where p.productType.typeCode =:typeCode"),
	@NamedQuery(name="findByProductBrand",
			query="select p from Product p left join fetch p.brand where p.brand.brandName =:name"),
	@NamedQuery(name="findByName",
			query="select p from Product p  where p.name =:name")
})
public class Product {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private long id;
	
	@Column(name="NAME")
	private String name;
	
	@OneToOne
	private ProductType productType;
	
	@OneToOne
	private Brand brand;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ProductType getProductType() {
		return productType;
	}
	public void setProductType(ProductType productType) {
		this.productType = productType;
	}
	public Brand getBrand() {
		return brand;
	}
	public void setBrand(Brand brand) {
		this.brand = brand;
	}
	
	
}
