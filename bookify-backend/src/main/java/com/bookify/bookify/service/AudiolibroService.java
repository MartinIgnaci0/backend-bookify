package com.bookify.bookify.service;

import com.bookify.bookify.model.Audiolibro;
import com.bookify.bookify.repository.AudiolibroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AudiolibroService {

    private final AudiolibroRepository repo;

    public AudiolibroService(AudiolibroRepository repo) {
        this.repo = repo;
    }

    public List<Audiolibro> listar() {
        return repo.findAll();
    }

    public Audiolibro buscarPorId(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Audiolibro crear(Audiolibro audiolibro) {
        return repo.save(audiolibro);
    }

    public Audiolibro actualizar(Long id, Audiolibro audiolibro) {
        Audiolibro existente = buscarPorId(id);
        if (existente != null) {
            existente.setTitulo(audiolibro.getTitulo());
            existente.setAutor(audiolibro.getAutor());
            existente.setDuracionMinutos(audiolibro.getDuracionMinutos());
            existente.setPesoMb(audiolibro.getPesoMb());
            existente.setDescripcion(audiolibro.getDescripcion());
            existente.setPrecio(audiolibro.getPrecio());
            existente.setImagenUrl(audiolibro.getImagenUrl());
            return repo.save(existente);
        }
        return null;
    }

    public void eliminar(Long id) {
        repo.deleteById(id);
    }
}
