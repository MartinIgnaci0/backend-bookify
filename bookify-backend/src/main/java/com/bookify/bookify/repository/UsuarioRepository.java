package com.bookify.bookify.repository;

import com.bookify.bookify.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByRut(String rut);
    Optional<Usuario> findByCorreo(String correo);
}
