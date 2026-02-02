package com.bookify.bookify.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductoDTO {
    private String id;
    private String titulo;
    private String autor;
    private String tipo;  
    private double precio;
    private int stock;    
    private String genero;
    private String imagenUrl;
    private String descripcion;
    private Map<String, Object> detalles;
}
