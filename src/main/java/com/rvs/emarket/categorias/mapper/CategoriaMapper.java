package com.rvs.emarket.mapper;


import com.rvs.emarket.categorias.dto.CategoriaDTO;
import com.rvs.emarket.categorias.entity.Categoria;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface  CategoriaMapper {

    CategoriaMapper INSTANCE = Mappers.getMapper(CategoriaMapper.class);

    CategoriaDTO toDTO(Categoria categoria);

    Categoria toEntity(CategoriaDTO categoriaDTO);

}
