package com.bookify.bookify.service;

import com.bookify.bookify.model.Cd;
import com.bookify.bookify.repository.CdRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CdService {

    private final CdRepository repo;

    public CdService(CdRepository repo) {
        this.repo = repo;
    }

    public List<Cd> listar() {
        return repo.findAll();
    }

    public Cd buscarPorId(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Cd crear(Cd cd) {
        return repo.save(cd);
    }

    public Cd actualizar(Long id, Cd cd) {
        Cd existente = buscarPorId(id);
        if (existente != null) {
            existente.setTitulo(cd.getTitulo());
            existente.setAutor(cd.getAutor());
            existente.setDescripcion(cd.getDescripcion());
            existente.setStock(cd.getStock());
            existente.setDuracionMinutos(cd.getDuracionMinutos());
            existente.setFormato(cd.getFormato());
            existente.setPrecio(cd.getPrecio());
            existente.setImagenUrl(cd.getImagenUrl());
            return repo.save(existente);
        }
        return null;
    }

    public void eliminar(Long id) {
        repo.deleteById(id);
    }
}
