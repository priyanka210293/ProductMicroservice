package com.MySqlConnection.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.MySqlConnection.dto.Coupon;

import com.MySqlConnection.Entity.Product;
import com.MySqlConnection.repositoory.ProductRepo;

@RestController
@RequestMapping(path="/productApi")
public class ProductController {

	@Autowired
	private ProductRepo productRepo;
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${couponService.url}")
	private String couponServiceURL;
	
	@PostMapping("/addProduct")
	public Product add(@RequestBody Product product) {
		Coupon coupon=restTemplate.getForObject(couponServiceURL+product.getCouponCode(),Coupon.class);
		product.setPrice(product.getPrice().subtract(coupon.getDiscount()));
	return	productRepo.save(product);
	}
	/*@GetMapping("/getCoupon/{code}")
	public Product getCoupon(@PathVariable("code") String code) {
		return productRepo.findByCode(code);*/
		
	}
		
		
	
	

