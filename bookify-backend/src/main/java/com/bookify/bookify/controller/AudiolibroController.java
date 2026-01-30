package com.bookify.bookify.controller;

import com.bookify.bookify.model.Audiolibro;
import com.bookify.bookify.service.AudiolibroService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/audiolibros")
public class AudiolibroController {

    private final AudiolibroService service;

    public AudiolibroController(AudiolibroService service) {
        this.service = service;
    }

    @GetMapping
    public List<Audiolibro> listar() {
        return service.listar();
    }

    @PostMapping
    public Audiolibro crear(@RequestBody Audiolibro audiolibro) {
        return service.crear(audiolibro);
    }

    @PutMapping("/{id}")
    public Audiolibro actualizar(@PathVariable Long id, @RequestBody Audiolibro audiolibro) {
        return service.actualizar(id, audiolibro);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}
