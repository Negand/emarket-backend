package com.rvs.emarket.productos.service.Impl;

import com.rvs.emarket.productos.dto.ProductoDTO;
import com.rvs.emarket.productos.entity.Producto;
import com.rvs.emarket.productos.mapper.ProductoMapper;
import com.rvs.emarket.productos.repository.ProductoRepository;
import com.rvs.emarket.productos.service.ProductoService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository productoRepository;
    private final ProductoMapper productoMapper;

    @Override
    public ProductoDTO createProducto(ProductoDTO productoDTO) {

        Producto producto = productoMapper.toEntity(productoDTO);
        Producto saved = productoRepository.save(producto);
        return productoMapper.toDTO(saved);
    }

    @Override
    public ProductoDTO updateProducto(Long id, ProductoDTO productoDTO) {

        Producto existing = productoRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Producto no encontrado con id: " + id)
                );

        productoMapper.updateEntityFromDto(productoDTO, existing);
        Producto updated = productoRepository.save(existing);
        return productoMapper.toDTO(updated);

    }

    @Override
    public Page<ProductoDTO> getAllProductos(Pageable pageable) {
        return productoRepository.findAll(pageable)
                .map(productoMapper::toDTO);
    }

    @Override
    public void deleteProducto(Long id) {
        productoRepository.deleteById(id);
    }

    @Override
    public Optional<ProductoDTO> getProductoById(Long id) {
        return productoRepository.findById(id)
                .map(productoMapper::toDTO);
    }


}
