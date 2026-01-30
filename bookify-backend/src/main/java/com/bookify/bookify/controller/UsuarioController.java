package com.bookify.bookify.controller;

import com.bookify.bookify.model.Usuario;
import com.bookify.bookify.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @GetMapping
    public List<Usuario> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Optional<Usuario> obtener(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public ResponseEntity<Usuario> crear(@RequestBody Usuario usuario) {
        if (usuario.getRol() == null || usuario.getRol().isBlank()) {
            usuario.setRol("USUARIO");
        }
        Usuario nuevoUsuario = service.crear(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoUsuario);
    }

    @PutMapping("/{id}")
    public Usuario actualizar(@PathVariable Long id, @RequestBody Usuario usuario) {
        return service.actualizar(id, usuario);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }

    // Endpoint para login con correo y password
        @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> credentials) {
        String correo = credentials.get("correo");
        String contraseña = credentials.get("contraseña");

        Optional<Usuario> usuarioOpt = service.validarLogin(correo, contraseña);

        if (usuarioOpt.isPresent()) {
            Usuario usuario = usuarioOpt.get();
            return ResponseEntity.ok(Map.of(
                "ok", true,
                "rol", usuario.getRol(),
                "nombre", usuario.getNombre(),
                "correo", usuario.getCorreo()
            ));
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuario o contraseña incorrectos");
    }
}
