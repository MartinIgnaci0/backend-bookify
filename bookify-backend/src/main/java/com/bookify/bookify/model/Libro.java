package com.bookify.bookify.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "libro")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String autor;
    private String descripcion;
    private int stock;
    private double precio;
    private int paginas;
    private double pesoGramos;
    private String formato;
    private String imagenUrl;
}
