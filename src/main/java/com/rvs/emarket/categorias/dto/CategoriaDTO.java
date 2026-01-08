package com.rvs.emarket.categorias.dto;


import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoriaDTO {
    private Integer id;
    private String nombre;
    private Integer vistas;
    private String icono;
    private String tituloLista;
    private String url;
    private String imagen;
}
