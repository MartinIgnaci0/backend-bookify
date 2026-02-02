package com.bookify.bookify.controller;

import com.bookify.bookify.dto.ProductoDTO;
import com.bookify.bookify.service.CatalogoService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/catalogo")
@CrossOrigin(origins = "http://localhost:5173") // Ajusta el puerto si usas uno distinto a Vite (5173) o Webpack (3000)
public class CatalogoController {

    private final CatalogoService catalogoService;

    public CatalogoController(CatalogoService catalogoService) {
        this.catalogoService = catalogoService;
    }

    @GetMapping
    public List<ProductoDTO> obtenerCatalogo() {
        return catalogoService.obtenerCatalogoCompleto();
    }
}