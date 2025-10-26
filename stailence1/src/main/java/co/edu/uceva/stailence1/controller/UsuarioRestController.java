package co.edu.uceva.stailence1.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uceva.stailence1.model.dto.RegistroUsuarioRequest;
import co.edu.uceva.stailence1.model.entities.Usuarios;
import co.edu.uceva.stailence1.model.service.IUsuarioService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioRestController {

    private final IUsuarioService usuarioService;

    public UsuarioRestController(IUsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public List<Usuarios> listar() {
        return usuarioService.findAll();
    }

    @PostMapping
    public Usuarios crear(@RequestBody Usuarios usuario) {
        return usuarioService.save(usuario);
    }

    @PostMapping("/registro")
    public ResponseEntity<?> registrar(@Valid @RequestBody RegistroUsuarioRequest request) {
        try {
            Usuarios creado = usuarioService.registrar(request);
            return ResponseEntity.status(HttpStatus.CREATED).body(creado);
        } catch (IllegalArgumentException | IllegalStateException ex) {
            Map<String, String> error = new HashMap<>();
            error.put("mensaje", ex.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        }
    }

    @GetMapping("/{id}")
    public Usuarios obtenerPorId(@PathVariable Long id) {
        return usuarioService.findById(id);
    }

    @PutMapping("/{id}")
    public Usuarios actualizar(@RequestBody Usuarios usuario, @PathVariable Long id) {
        Usuarios existente = usuarioService.findById(id);
        if (existente != null) {
            existente.setNombre(usuario.getNombre());
            existente.setApellido(usuario.getApellido());
            existente.setCorreo(usuario.getCorreo());
            existente.setContrasena(usuario.getContrasena());
            existente.setRol(usuario.getRol());
            existente.setTipoUsuario(usuario.getTipoUsuario());
            existente.setNegocio(usuario.getNegocio());
            return usuarioService.save(existente);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        usuarioService.delete(id);
    }
}