package com.rvs.emarket.productos.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rvs.emarket.productos.entity.Product;
import com.rvs.emarket.productos.service.ProductService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService= productService;
    }


    // Leer todos los productos → permiso: PRODUCT_READ
    @GetMapping("/")
    @PreAuthorize("hasAuthority('PRODUCT_READ')")
    public List<Product> listar() {
        return productService.findAll();
    }


    // Leer un producto por ID → permiso: PRODUCT_READ
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('PRODUCT_READ')")
    public ResponseEntity<Product> obtener(@PathVariable Long id) {
        return productService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    // Crear un producto → permiso: PRODUCT_CREATE
    @PostMapping("/")
    @PreAuthorize("hasAuthority('PRODUCT_CREATE')")
    public Product crear(@RequestBody Product product) {
        return productService.save(product);
    }



    // Actualizar un producto → permiso: PRODUCT_UPDATE
    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('PRODUCT_UPDATE')")
    public ResponseEntity<Product> actualizar(@PathVariable Long id, @RequestBody Product product) {
        return productService.findById(id)
                .map(p -> {
                    p.setNombre(product.getNombre());
                    p.setDescripcion(product.getDescripcion());
                    p.setPrecio(product.getPrecio());
                    p.setStock(product.getStock());
                    return ResponseEntity.ok(productService.save(p));
                })
                .orElse(ResponseEntity.notFound().build());
    }


    // Eliminar un producto → permiso: PRODUCT_DELETE
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('PRODUCT_DELETE')")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (productService.findById(id).isPresent()) {
            productService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}
