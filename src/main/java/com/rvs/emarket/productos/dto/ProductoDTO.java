package com.rvs.emarket.productos.dto;

import jakarta.persistence.Column;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductoDTO {

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
    private String respuestaAdmin;
    private String reviews;
    private String sliderHorizontal;
    private String sliderVertical;
    private Integer stock;
    private String tags;
    private String tiempoEntrega;
    private String url;
    private String video;
    private String bannerDefault;
    private String bannerSuperior;
    private String tituloLista;



}
