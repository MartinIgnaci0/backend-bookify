package com.bookify.bookify.service;

import com.bookify.bookify.model.Libro;
import com.bookify.bookify.repository.LibroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroService {

    private final LibroRepository repo;

    public LibroService(LibroRepository repo) {
        this.repo = repo;
    }

    public List<Libro> listar() {
        return repo.findAll();
    }

    public Libro buscarPorId(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Libro crear(Libro libro) {
        return repo.save(libro);
    }

    public Libro actualizar(Long id, Libro libro) {
        Libro existente = buscarPorId(id);
        if (existente != null) {
            existente.setTitulo(libro.getTitulo());
            existente.setAutor(libro.getAutor());
            existente.setPaginas(libro.getPaginas());
            existente.setDescripcion(libro.getDescripcion());
            existente.setStock(libro.getStock());
            existente.setPesoGramos(libro.getPesoGramos());
            existente.setFormato(libro.getFormato());
            existente.setPrecio(libro.getPrecio());
            existente.setImagenUrl(libro.getImagenUrl());
            return repo.save(existente);
        }
        return null;
    }

    public void eliminar(Long id) {
        repo.deleteById(id);
    }
    
}

