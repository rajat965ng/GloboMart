package com.catalogue.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.catalogue.entity.ProductType;
import com.catalogue.service.IProductTypeService;

@RestController
@RequestMapping("/type")
public class ProductTypeController {

	@Autowired
	private IProductTypeService productTypeService;
	
	@GetMapping(value="/list",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ProductType>> findAll(){
		return ResponseEntity.ok(productTypeService.findAll());
	}
	
	@PostMapping(value="/save",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProductType> save(@RequestBody ProductType productType){
		return new ResponseEntity<ProductType>(
				productTypeService.save(productType)
				,HttpStatus.CREATED);
	}
	
	@GetMapping(value="/{code}/list",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProductType> findByCode(@PathVariable String code){
		return ResponseEntity.ok(productTypeService.findTypeByCode(code));
	}
	
}
