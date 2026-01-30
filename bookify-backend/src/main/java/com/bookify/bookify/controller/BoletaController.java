package com.bookify.bookify.controller;

import com.bookify.bookify.model.Boleta;
import com.bookify.bookify.service.BoletaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/boletas")
public class BoletaController {

    private final BoletaService service;

    public BoletaController(BoletaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Boleta> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Optional<Boleta> obtener(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public Boleta crear(@RequestBody Boleta boleta) {
        return service.crear(boleta);
    }

    @PutMapping("/{id}")
    public Boleta actualizar(@PathVariable Long id, @RequestBody Boleta boleta) {
        return service.actualizar(id, boleta);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}
