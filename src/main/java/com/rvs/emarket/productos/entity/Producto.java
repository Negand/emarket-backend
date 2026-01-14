package com.rvs.emarket.productos.entity;

import java.math.BigDecimal;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "productos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idproducto;
    private Integer idcategoria;
    private Integer idsubcategoria;
    private String tienda;
    private String nombre;
    private String descripcion;
    private String detalles;
    private String especificacion;
    private String galeria;
    private String imagen;
    private String oferta;
    private BigDecimal precio;
    private BigDecimal envio;
    @Column(name = "respuesta_admin")
    private String respuestaAdmin;
    private String reviews;
    @Column(name = "slider_horizontal")
    private String sliderHorizontal;
    @Column(name = "slider_vertical")
    private String sliderVertical;
    private Integer stock;
    private String tags;
    @Column(name = "tiempo_entrega")
    private String tiempoEntrega;
    private String url;
    private String video;
    @Column(name = "banner_default")
    private String bannerDefault;
    @Column(name = "banner_superior")
    private String bannerSuperior;
    @Column(name = "titulo_lista")
    private String tituloLista;


}
