package com.rvs.emarket.categorias.service.Impl;


import com.rvs.emarket.categorias.dto.CategoriaDTO;
import com.rvs.emarket.categorias.entity.Categoria;
import com.rvs.emarket.categorias.service.CategoriaService;
import com.rvs.emarket.mapper.CategoriaMapper;
import com.rvs.emarket.categorias.repository.CategoriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoriaServiceImpl  implements CategoriaService {

    private final CategoriaRepository categoriaRepository;
    private final CategoriaMapper categoriaMapper;

    @Override
    public CategoriaDTO createCategoria(CategoriaDTO categoriaDTO) {
        Categoria categoria = categoriaMapper.toEntity(categoriaDTO);
        Categoria saved = categoriaRepository.save(categoria);
        return categoriaMapper.toDTO(saved);
    }

    @Override
    public Optional<CategoriaDTO> getCategoriaById(Integer id) {
        return categoriaRepository.findById(id)
                .map(categoriaMapper::toDTO);
    }

    @Override
    public Page<CategoriaDTO> getAllCategorias(Pageable pageable) {
        return categoriaRepository.findAll(pageable)
                .map(categoriaMapper::toDTO);
    }


    @Override
    public CategoriaDTO updateCategoria(Integer id, CategoriaDTO categoriaDTO) {
        Categoria existing = categoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria no encontrada con id: " + id));
        // Actualizamos los campos
        existing.setNombre(categoriaDTO.getNombre());
        existing.setVistas(categoriaDTO.getVistas());
        existing.setIcono(categoriaDTO.getIcono());
        existing.setTituloLista(categoriaDTO.getTituloLista());
        existing.setUrl(categoriaDTO.getUrl());
        existing.setImagen(categoriaDTO.getImagen());
        Categoria updated = categoriaRepository.save(existing);
        return categoriaMapper.toDTO(updated);
    }

    @Override
    public void deleteCategoria(Integer id) {
        categoriaRepository.deleteById(id);
    }

}
