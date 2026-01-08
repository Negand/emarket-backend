package com.rvs.emarket.productos.repository;

import com.rvs.emarket.productos.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product, Long> {

}
