package com.MySqlConnection.repositoory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.MySqlConnection.Entity.Product;

public interface ProductRepo extends JpaRepository<Product, Long>{

	

}
