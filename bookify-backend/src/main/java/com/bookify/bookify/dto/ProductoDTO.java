package com.bookify.bookify.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductoDTO {
    private Long id;
    private String titulo;
    private String autor;
    private String tipo;  // libro, ebook, cd, audiolibro
    private double precio;
    private int stock;    // si no aplica, puede ser 0 o ignorado
    private String genero; // Aquí no veo en modelos, puedes eliminar o agregar
    private String imagenUrl;
    private String descripcion;
    private Map<String, Object> detalles; // peso, paginas, duracion, etc según tipo
}
