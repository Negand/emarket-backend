package com.rvs.emarket.productos.service;

import java.util.Optional;
import com.rvs.emarket.productos.dto.ProductoDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ProductoService {

    ProductoDTO createProducto(ProductoDTO productoDTO);

    Optional<ProductoDTO> getProductoById(Long id);

    Page<ProductoDTO> getAllProductos(Pageable pageable);

    ProductoDTO updateProducto(Long id, ProductoDTO productoDTO);

    void deleteProducto(Long id);


}
