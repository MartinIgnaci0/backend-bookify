package com.bookify.bookify.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "ebook")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ebook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String autor;
    private int paginas;

    @Lob 
    @Column(columnDefinition = "TEXT")
    private String descripcion;
    
    private double precio;
    private double pesoMb;
    private String formatoArchivo; 
    private String imagenUrl;
}
