package com.rvs.emarket.service;


import com.rvs.emarket.dto.CategoriaDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface CategoriaService {

    CategoriaDTO createCategoria(CategoriaDTO categoriaDTO);

    Optional<CategoriaDTO> getCategoriaById(Integer id);

    Page<CategoriaDTO> getAllCategorias(Pageable pageable);

    CategoriaDTO updateCategoria(Integer id, CategoriaDTO categoriaDTO);

    void deleteCategoria(Integer id);

}
