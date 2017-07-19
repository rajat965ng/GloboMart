package com.catalogue.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.catalogue.entity.Product;
import com.catalogue.service.IProductService;

@RestController
@RequestMapping("/product")
@ComponentScan(basePackages="com.catalogue.service")
public class ProductController {

	@Autowired
	private IProductService productService;

	@GetMapping(value="/list",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Product>> findAll(){
		return ResponseEntity.ok(productService.findAll());
	}

	@GetMapping(value="/id/{productId}/list",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> findProductById(@PathVariable long productId){
		return ResponseEntity.ok(productService.findById(productId));
	}
	
	@GetMapping(value="/type/{productType}/list",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Product>> findByProductType(@PathVariable String productType){
		return ResponseEntity.ok(productService.findByType(productType));
	}

	@GetMapping(value="/brand/{brandName}/list",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Product>> findByBrand(@PathVariable String brandName){
		return ResponseEntity.ok(productService.findByBrand(brandName));
	}

	
	@GetMapping(value="/name/{productName}/list",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Product>> findByName(@PathVariable String productName){
		return ResponseEntity.ok(productService.findByName(productName));
	}

	@PostMapping(value="/save",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> save(@RequestBody Product product){
		return new ResponseEntity<Product>(productService.save(product),HttpStatus.CREATED);
	}

	@DeleteMapping(value="/delete/{id}")
	public void delete(@PathVariable long id){
		productService.delete(id);
	}
}
