package com.bookify.bookify.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "audiolibro")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Audiolibro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String autor;
    private int duracionMinutos;
    private double pesoMb;
    private String descripcion;
    private double precio;
    private String imagenUrl;
}
