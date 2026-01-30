package com.bookify.bookify.service;

import com.bookify.bookify.model.Ebook;
import com.bookify.bookify.repository.EbookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EbookService {

    private final EbookRepository repo;

    public EbookService(EbookRepository repo) {
        this.repo = repo;
    }

    public List<Ebook> listar() {
        return repo.findAll();
    }

    public Ebook buscarPorId(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Ebook crear(Ebook ebook) {
        return repo.save(ebook);
    }

    public Ebook actualizar(Long id, Ebook ebook) {
        Ebook existente = buscarPorId(id);
        if (existente != null) {
            existente.setTitulo(ebook.getTitulo());
            existente.setAutor(ebook.getAutor());
            existente.setPaginas(ebook.getPaginas());
            existente.setPrecio(ebook.getPrecio());
            existente.setDescripcion(ebook.getDescripcion());
            existente.setPesoMb(ebook.getPesoMb());
            existente.setFormatoArchivo(ebook.getFormatoArchivo());
            existente.setImagenUrl(ebook.getImagenUrl());
            return repo.save(existente);
        }
        return null;
    }

    public void eliminar(Long id) {
        repo.deleteById(id);
    }
}
