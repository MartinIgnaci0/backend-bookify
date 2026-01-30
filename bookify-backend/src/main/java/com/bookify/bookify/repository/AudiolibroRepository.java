package com.bookify.bookify.repository;

import com.bookify.bookify.model.Audiolibro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AudiolibroRepository extends JpaRepository<Audiolibro, Long> {
}
