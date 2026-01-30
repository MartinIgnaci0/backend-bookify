package com.bookify.bookify.controller;

import com.bookify.bookify.model.Cd;
import com.bookify.bookify.service.CdService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cds")
public class CdController {

    private final CdService service;

    public CdController(CdService service) {
        this.service = service;
    }

    @GetMapping
    public List<Cd> listar() {
        return service.listar();
    }

    @PostMapping
    public Cd crear(@RequestBody Cd cd) {
        return service.crear(cd);
    }

    @PutMapping("/{id}")
    public Cd actualizar(@PathVariable Long id, @RequestBody Cd cd) {
        return service.actualizar(id, cd);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}
