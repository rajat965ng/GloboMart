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

import com.catalogue.entity.Brand;
import com.catalogue.service.IBrandService;

@RestController
@RequestMapping("/brand")
public class BrandController {

	@Autowired
	private IBrandService brandService;
	
	@GetMapping(value="/list",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Brand>> findAll(){
		return ResponseEntity.ok(brandService.findAll());
	}
	
	@PostMapping(value="/save",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Brand> save(@RequestBody Brand brand){
		return new ResponseEntity<Brand>(brandService.save(brand),HttpStatus.CREATED);
	}
	
	@GetMapping(value="/{brandName}/list",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Brand> findByName(@PathVariable String brandName){
		return ResponseEntity.ok(brandService.findByBrandName(brandName));
	}
}
