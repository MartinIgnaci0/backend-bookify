package com.bookify.bookify.service;

import com.bookify.bookify.dto.ProductoDTO;
import com.bookify.bookify.repository.AudiolibroRepository;
import com.bookify.bookify.repository.CdRepository;
import com.bookify.bookify.repository.EbookRepository;
import com.bookify.bookify.repository.LibroRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CatalogoService {

    private final LibroRepository libroRepo;
    private final EbookRepository ebookRepo;
    private final CdRepository cdRepo;
    private final AudiolibroRepository audiolibroRepo;

    public CatalogoService(LibroRepository libroRepo, EbookRepository ebookRepo,
                           CdRepository cdRepo, AudiolibroRepository audiolibroRepo) {
        this.libroRepo = libroRepo;
        this.ebookRepo = ebookRepo;
        this.cdRepo = cdRepo;
        this.audiolibroRepo = audiolibroRepo;
    }

    public List<ProductoDTO> obtenerCatalogoCompleto() {
        List<ProductoDTO> catalogo = new ArrayList<>();

        // Libros - Prefijo L
        libroRepo.findAll().forEach(libro -> {
            Map<String, Object> detalles = new HashMap<>();
            detalles.put("paginas", libro.getPaginas());
            detalles.put("pesoGramos", libro.getPesoGramos());
            detalles.put("formato", libro.getFormato());

            catalogo.add(new ProductoDTO(
                    "L" + libro.getId(),
                    libro.getTitulo(),
                    libro.getAutor(),
                    "libro",
                    libro.getPrecio(),
                    libro.getStock(),
                    null,
                    libro.getImagenUrl(),
                    libro.getDescripcion(),
                    detalles
            ));
        });

        // Ebooks - Prefijo E
        ebookRepo.findAll().forEach(ebook -> {
            Map<String, Object> detalles = new HashMap<>();
            detalles.put("paginas", ebook.getPaginas());
            detalles.put("pesoMb", ebook.getPesoMb());
            detalles.put("formatoArchivo", ebook.getFormatoArchivo());

            catalogo.add(new ProductoDTO(
                    "E" + ebook.getId(),
                    ebook.getTitulo(),
                    ebook.getAutor(),
                    "ebook",
                    ebook.getPrecio(),
                    0,
                    null,
                    ebook.getImagenUrl(),
                    ebook.getDescripcion(),
                    detalles
            ));
        });

        // CDs - Prefijo C
        cdRepo.findAll().forEach(cd -> {
            Map<String, Object> detalles = new HashMap<>();
            detalles.put("duracionMinutos", cd.getDuracionMinutos());
            detalles.put("formato", cd.getFormato());

            catalogo.add(new ProductoDTO(
                    "C" + cd.getId(),
                    cd.getTitulo(),
                    cd.getAutor(),
                    "cd",
                    cd.getPrecio(),
                    cd.getStock(),
                    null,
                    cd.getImagenUrl(),
                    cd.getDescripcion(),
                    detalles
            ));
        });

        // Audiolibros - Prefijo A
        audiolibroRepo.findAll().forEach(audio -> {
            Map<String, Object> detalles = new HashMap<>();
            detalles.put("duracionMinutos", audio.getDuracionMinutos());
            detalles.put("pesoMb", audio.getPesoMb());

            catalogo.add(new ProductoDTO(
                    "A" + audio.getId(),
                    audio.getTitulo(),
                    audio.getAutor(),
                    "audiolibro",
                    audio.getPrecio(),
                    0,
                    null,
                    audio.getImagenUrl(),
                    audio.getDescripcion(),
                    detalles
            ));
        });

        return catalogo;
    }
}