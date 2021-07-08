package com.encore.spring.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.encore.spring.domain.MyProduct;
import com.encore.spring.model.MyProductService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("api")
@CrossOrigin(origins = {" * "}, maxAge = 6000)
@Api(tags = {"Encore HRM"})
public class MyProductController {
	
	@Autowired
	private MyProductService service;
	
	@ApiOperation(value="모든 제품 정보를 반환한다", response=List.class)
	@GetMapping("findProducts")
	public ResponseEntity<List<MyProduct>> findProducts() throws Exception {
		List<MyProduct> products = service.findProducts();
		if(products.isEmpty()) return new ResponseEntity<List<MyProduct>>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<MyProduct>>(products, HttpStatus.OK);
	}
	
	@ApiOperation(value="이름으로 제품 정보를 찾는다", response=List.class)
	@GetMapping("findByProductName/{name}")
	public ResponseEntity<List<MyProduct>> findByProductName(@PathVariable String name) throws Exception {
		List<MyProduct> products = service.findByProductName(name);
		if(products.isEmpty()) return new ResponseEntity<List<MyProduct>>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<MyProduct>>(products, HttpStatus.OK);
	}
	
	@ApiOperation(value="생산자명으로 제품 정보를 찾는다", response=List.class)
	@GetMapping("findByProductMaker/{maker}")
	public ResponseEntity<List<MyProduct>> findByProductMaker(@PathVariable String maker) throws Exception {
		List<MyProduct> products = service.findByProductMaker(maker);
		if(products.isEmpty()) return new ResponseEntity<List<MyProduct>>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<MyProduct>>(products, HttpStatus.OK);
	}
	
	@ApiOperation(value="제품을 등록한다", response=MyProduct.class)
	@PostMapping("addProduct")
	public ResponseEntity<MyProduct> addProduct(@RequestBody MyProduct product) throws Exception {
		try {
			service.addProduct(product);
			return new ResponseEntity<MyProduct>(HttpStatus.OK);
		}catch(RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<MyProduct>(HttpStatus.NO_CONTENT);
		}
	}
	
}




















