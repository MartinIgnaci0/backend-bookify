package com.bookify.bookify.controller;

import com.bookify.bookify.model.Ebook;
import com.bookify.bookify.repository.EbookRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ebooks")
public class EbookController {

    private final EbookRepository repo;

    public EbookController(EbookRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Ebook> listar() {
        return repo.findAll();
    }

    @PostMapping
    public Ebook crear(@RequestBody Ebook ebook) {
        return repo.save(ebook);
    }

    @PutMapping("/{id}")
    public Ebook actualizar(@PathVariable Long id, @RequestBody Ebook ebook) {
        ebook.setId(id);
        return repo.save(ebook);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        repo.deleteById(id);
    }
}
