package com.bookify.bookify.controller;

import com.bookify.bookify.dto.ProductoDTO;
import com.bookify.bookify.service.CatalogoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CatalogoController {

    private final CatalogoService catalogoService;

    public CatalogoController(CatalogoService catalogoService) {
        this.catalogoService = catalogoService;
    }

    @GetMapping("/api/catalogo")
    public List<ProductoDTO> obtenerCatalogo() {
        return catalogoService.obtenerCatalogoCompleto();
    }
}
