package com.bookify.bookify.service;

import com.bookify.bookify.model.Usuario;
import com.bookify.bookify.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository repo;

    public UsuarioService(UsuarioRepository repo) {
        this.repo = repo;
    }

    public List<Usuario> listar() {
        return repo.findAll();
    }

    public Optional<Usuario> buscarPorId(Long id) {
        return repo.findById(id);
    }

    public Optional<Usuario> buscarPorRut(String rut) {
        return repo.findByRut(rut);
    }

    public Optional<Usuario> buscarPorCorreo(String correo) {
        return repo.findByCorreo(correo);
    }

    public Usuario crear(Usuario usuario) {
        if (usuario.getRol() == null || usuario.getRol().trim().isEmpty()) {
            usuario.setRol("USUARIO");
        }
        return repo.save(usuario);
    }

    public Usuario actualizar(Long id, Usuario usuario) {
        Optional<Usuario> opt = buscarPorId(id);
        if (opt.isPresent()) {
            Usuario existente = opt.get();
            existente.setRut(usuario.getRut());
            existente.setNombre(usuario.getNombre());
            existente.setApellido(usuario.getApellido());
            existente.setCorreo(usuario.getCorreo());
            existente.setDireccion(usuario.getDireccion());
            existente.setRegion(usuario.getRegion());
            existente.setComuna(usuario.getComuna());
            existente.setPassword(usuario.getPassword());

            if (usuario.getRol() == null || usuario.getRol().trim().isEmpty()) {
                existente.setRol("USUARIO");
            } else {
                existente.setRol(usuario.getRol());
            }

            return repo.save(existente);
        }
        return null;
    }

    public void eliminar(Long id) {
        repo.deleteById(id);
    }

    // Validar login con correo y password
    public Optional<Usuario> validarLogin(String correo, String password) {
        Optional<Usuario> usuario = repo.findByCorreo(correo);
        if (usuario.isPresent() && usuario.get().getPassword().equals(password)) {
            return usuario;
        }
        return Optional.empty();
    }
}
