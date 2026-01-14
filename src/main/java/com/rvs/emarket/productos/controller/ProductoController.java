package com.rvs.emarket.productos.controller;

import com.rvs.emarket.productos.dto.ProductoDTO;
import com.rvs.emarket.productos.service.ProductoService;
import org.springframework.data.domain.*;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    // LISTAR con paginación
    @GetMapping
    @PreAuthorize("hasAuthority('PRODUCT_READ')")
    public ResponseEntity<Page<ProductoDTO>> getAllProductos(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "idproducto") String sortBy,
            @RequestParam(defaultValue = "asc") String direction
    ) {
        Sort sort = direction.equalsIgnoreCase("desc")
                ? Sort.by(sortBy).descending()
                : Sort.by(sortBy).ascending();

        Pageable pageable = PageRequest.of(page, size, sort);

        return ResponseEntity.ok(productoService.getAllProductos(pageable));
    }

    // OBTENER POR ID
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('PRODUCT_READ')")
    public ResponseEntity<ProductoDTO> getById(@PathVariable Long id) {

        Optional<ProductoDTO> producto = productoService.getProductoById(id);
        return producto
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // CREAR
    @PostMapping
    @PreAuthorize("hasAuthority('PRODUCT_CREATE')")
    public ResponseEntity<ProductoDTO> create(@RequestBody ProductoDTO dto) {

        ProductoDTO created = productoService.createProducto(dto);
        return ResponseEntity.status(201).body(created);
    }

    // ACTUALIZAR
    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('PRODUCT_UPDATE')")
    public ResponseEntity<ProductoDTO> update(
            @PathVariable Long id,
            @RequestBody ProductoDTO dto
    ) {
        ProductoDTO updated = productoService.updateProducto(id, dto);
        return ResponseEntity.ok(updated);
    }

    // ELIMINAR
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('PRODUCT_DELETE')")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        productoService.deleteProducto(id);
        return ResponseEntity.noContent().build();
    }
}
