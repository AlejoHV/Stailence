package co.edu.uceva.stailence1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import co.edu.uceva.stailence1.model.entities.Usuarios;
import co.edu.uceva.stailence1.model.service.IUsuarioService;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioRestController {

    @Autowired
    private IUsuarioService usuarioService;

    @GetMapping
    public List<Usuarios> listar() {
        return usuarioService.findAll();
    }

    @PostMapping
    public Usuarios crear(@RequestBody Usuarios usuario) {
        return usuarioService.save(usuario);
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