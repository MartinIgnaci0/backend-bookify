package com.bookify.bookify.service;

import com.bookify.bookify.model.Usuario;
import com.bookify.bookify.repository.UsuarioRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; // Importante
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository repo;
    private final BCryptPasswordEncoder passwordEncoder; // 1. Declarar el encoder

    // 2. Inyectarlo en el constructor
    public UsuarioService(UsuarioRepository repo, BCryptPasswordEncoder passwordEncoder) {
        this.repo = repo;
        this.passwordEncoder = passwordEncoder;
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
        // 3. ENCRIPTAR la contraseña antes de guardar
        String passwordEncriptada = passwordEncoder.encode(usuario.getPassword());
        usuario.setPassword(passwordEncriptada);

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

            // 4. Si la contraseña viene en el update, encriptarla también
            if (usuario.getPassword() != null && !usuario.getPassword().isBlank()) {
                existente.setPassword(passwordEncoder.encode(usuario.getPassword()));
            }

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

    // 5. CAMBIO CRUCIAL EN EL LOGIN
    public Optional<Usuario> validarLogin(String correo, String passwordPlana) {
        Optional<Usuario> usuarioOpt = repo.findByCorreo(correo);
        
        if (usuarioOpt.isPresent()) {
            Usuario usuario = usuarioOpt.get();
            if (passwordEncoder.matches(passwordPlana, usuario.getPassword())) {
                return Optional.of(usuario);
            }
        }
        return Optional.empty();
    }
}