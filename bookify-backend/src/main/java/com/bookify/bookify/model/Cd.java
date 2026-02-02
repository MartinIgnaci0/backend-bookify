package com.bookify.bookify.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "cd")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cd {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String autor;

    @Lob 
    @Column(columnDefinition = "TEXT")
    private String descripcion;
    
    private int stock;
    private int duracionMinutos;
    private String formato;
    private double precio;
    private String imagenUrl;
}
