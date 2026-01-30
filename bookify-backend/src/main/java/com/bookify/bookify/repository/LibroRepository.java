package com.bookify.bookify.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bookify.bookify.model.Libro;

public interface LibroRepository extends JpaRepository<Libro, Long> {
}
