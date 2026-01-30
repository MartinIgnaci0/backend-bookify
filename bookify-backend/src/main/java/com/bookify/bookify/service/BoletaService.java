package com.bookify.bookify.service;

import com.bookify.bookify.model.Boleta;
import com.bookify.bookify.repository.BoletaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BoletaService {

    private final BoletaRepository repo;

    public BoletaService(BoletaRepository repo) {
        this.repo = repo;
    }

    public List<Boleta> listar() {
        return repo.findAll();
    }

    public Optional<Boleta> buscarPorId(Long id) {
        return repo.findById(id);
    }

    public Boleta crear(Boleta boleta) {
        return repo.save(boleta);
    }

    public Boleta actualizar(Long id, Boleta boleta) {
        Optional<Boleta> opt = buscarPorId(id);
        if (opt.isPresent()) {
            Boleta existente = opt.get();
            existente.setFecha(boleta.getFecha());
            existente.setUsuario(boleta.getUsuario());
            existente.setDetalleProductos(boleta.getDetalleProductos());
            existente.setSubtotal(boleta.getSubtotal());
            existente.setTotal(boleta.getTotal());
            return repo.save(existente);
        }
        return null;
    }

    public void eliminar(Long id) {
        repo.deleteById(id);
    }
}
