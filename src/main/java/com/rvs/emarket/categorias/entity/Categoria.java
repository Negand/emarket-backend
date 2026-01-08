package com.rvs.emarket.categorias.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "categorias")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcategoria")
    private Integer idcategoria;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "icono")
    private String icono;

    @Column(name = "imagen")
    private String imagen;

    @Column(name = "titulo_lista")
    private String tituloLista;

    @Column(name = "url")
    private String url;

    @Column(name = "vistas")
    private Integer vistas;
}
