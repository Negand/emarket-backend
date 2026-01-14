package com.rvs.emarket.productos.mapper;

import com.rvs.emarket.productos.dto.ProductoDTO;
import com.rvs.emarket.productos.entity.Producto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ProductoMapper {

    Producto toEntity(ProductoDTO dto);

    ProductoDTO toDTO(Producto entity);

    void updateEntityFromDto(ProductoDTO dto, @MappingTarget Producto entity);
}
