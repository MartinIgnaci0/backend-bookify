package com.bookify.bookify.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.bookify.bookify.model.Libro;
import com.bookify.bookify.repository.LibroRepository;

@RestController
@RequestMapping("/api/libros")
public class LibroController {

    private final LibroRepository repo;

    public LibroController(LibroRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Libro> listar() {
        return repo.findAll();
    }

    @PostMapping
    public Libro crear(@RequestBody Libro libro) {
        return repo.save(libro);
    }

    @PutMapping("/{id}")
    public Libro actualizar(@PathVariable Long id, @RequestBody Libro libro) {
        libro.setId(id);
        return repo.save(libro);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        repo.deleteById(id);
    }
}
