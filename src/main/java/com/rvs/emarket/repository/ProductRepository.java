package com.rvs.emarket.repository;

import com.rvs.emarket.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product, Long> {

}
