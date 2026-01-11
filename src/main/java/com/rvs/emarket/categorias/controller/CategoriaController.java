package com.rvs.emarket.categorias.controller;


import com.rvs.emarket.categorias.dto.CategoriaDTO;
import com.rvs.emarket.categorias.service.CategoriaService;
import com.rvs.emarket.productos.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/categorias")
@RequiredArgsConstructor
public class CategoriaController {

    private final CategoriaService categoriaService;

   //public CategoriaController (CategoriaService categoriaService){ this.categoriaService = categoriaService; }

   /*----------

   // Leer todos los productos → permiso: PRODUCT_READ
    @GetMapping("/")
    @PreAuthorize("hasAuthority('PRODUCT_READ')")
    public List<Product> listar() {
        return productService.findAll();
   --- */

    // Listar categorías con paginación y sorting  → permiso: CATEGORY_READ
    @GetMapping("/")
    @PreAuthorize("hasAuthority('CATEGORY_READ')")
    public ResponseEntity<Page<CategoriaDTO>> getAllCategorias(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "idcategoria") String sortBy,
            @RequestParam(defaultValue = "asc") String direction
    ) {
        Sort sort = direction.equalsIgnoreCase("desc") ? Sort.by(sortBy).descending() : Sort.by(sortBy).ascending();
        Pageable pageable = PageRequest.of(page, size, sort);
        Page<CategoriaDTO> categorias = categoriaService.getAllCategorias(pageable);
        return ResponseEntity.ok(categorias);
    }


    // Crear nueva categoría
    @PostMapping
    @PreAuthorize("hasAuthority('CATEGORY_CREATE')")
    public ResponseEntity<CategoriaDTO> createCategoria(@RequestBody CategoriaDTO categoriaDTO) {
        CategoriaDTO created = categoriaService.createCategoria(categoriaDTO);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    // Obtener categoría por id
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('CATEGORY_READ')")
    public ResponseEntity<CategoriaDTO> getCategoriaById(@PathVariable Integer id) {
        Optional<CategoriaDTO> categoria = categoriaService.getCategoriaById(id);
        return categoria.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    // Actualizar categoría
    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('CATEGORY_UPDATE')")
    public ResponseEntity<CategoriaDTO> updateCategoria(@PathVariable Integer id, @RequestBody CategoriaDTO categoriaDTO) {
        CategoriaDTO updated = categoriaService.updateCategoria(id, categoriaDTO);
        return ResponseEntity.ok(updated);
    }

    // Eliminar categoría
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('CATEGORY_DELETE')")
    public ResponseEntity<Void> deleteCategoria(@PathVariable Integer id) {
        categoriaService.deleteCategoria(id);
        return ResponseEntity.noContent().build();
    }







}
