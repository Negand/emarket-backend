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
    private Integer id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "vistas")
    private Integer vistas;

    @Column(name = "icono")
    private String icono;

    @Column(name = "titulo_lista")
    private String tituloLista;

    @Column(name = "url")
    private String url;

    @Column(name = "imagen")
    private String imagen;

}
