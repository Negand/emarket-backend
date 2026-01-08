package com.rvs.emarket.categorias.repository;


import com.rvs.emarket.categorias.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

    // Aquí se pueden agregar métodos personalizados si los necesitamos
    // Ejemplo: List<Categoria> findByNombreContainingIgnoreCase(String nombre);

}
