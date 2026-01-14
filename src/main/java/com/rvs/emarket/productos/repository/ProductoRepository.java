package com.rvs.emarket.productos.repository;

import com.rvs.emarket.productos.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductoRepository extends JpaRepository<Producto, Long> {

}
