package com.encore.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.encore.spring.domain.Product;
import com.encore.spring.model.ProductCatalog;

@Controller
public class ProductController {

	@Autowired
	private ProductCatalog productCatalog;
	
	@RequestMapping("myProduct.do")
	public ModelAndView addProduct(String name, String maker, int price) throws Exception {
		int success = productCatalog.addProduct(new Product(name, maker, price));
		return new ModelAndView("WEB-INF/views/addProductSuccess.jsp", "success", success);
	}
	
	
	@RequestMapping("productSearchByName.do")
	public ModelAndView searchProductByName(String productName) throws Exception {
		 Product product = new Product();
		 
		 if(productName != null) product.setName(productName);
		 
		 List<Product> list = productCatalog.getAllProduct(product);
		
		return new ModelAndView("WEB-INF/views/productList.jsp", "list", list);
	}
	
	@RequestMapping("productSearchByMaker.do")
	public ModelAndView searchProductByMaker(String productMaker) throws Exception {
		
		Product product = new Product();
		System.out.println(productMaker);
		if(productMaker != null) product.setMaker(productMaker);
		
		List<Product> list = productCatalog.getAllProduct(product);
	
		return new ModelAndView("WEB-INF/views/productList.jsp", "list", list);
	}
	
	@RequestMapping("productSearchById.do")
	public ModelAndView searchProductById(String productId) throws Exception {
		
		Product product = new Product();
		int id = 0;
		//System.out.println(productId);
		//System.out.println(product.getId() + "%%");
		if(productId != null) {
			try {
				id=Integer.parseInt(productId);
			}catch(NumberFormatException e) {
			}
		}
		product.setId(id);
		//System.out.println("???" + product.getId());
		List<Product> list = productCatalog.getAllProduct(product);
		
		return new ModelAndView("WEB-INF/views/productList.jsp", "list", list);
	}
	
	
}
