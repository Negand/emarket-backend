package com.rvs.emarket.categorias.dto;


import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoriaDTO {
    private Integer idcategoria;
    private String nombre;
    private String icono;
    private String imagen;
    private String tituloLista;
    private String url;
    private Integer vistas;
}
