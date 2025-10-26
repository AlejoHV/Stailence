package co.edu.uceva.stailence1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import co.edu.uceva.stailence1.model.entities.TipoUsuario;
import co.edu.uceva.stailence1.model.service.ITipoUsuarioService;

import java.util.List;

@RestController
@RequestMapping("/api/tipo-usuarios")
@CrossOrigin(origins = "*") // Permite peticiones desde frontend
public class TipoUsuarioRestController {

    @Autowired
    private ITipoUsuarioService tipoUsuarioService;

    @GetMapping
    public List<TipoUsuario> listar() {
        return tipoUsuarioService.findAll();
    }

    @PostMapping
    public TipoUsuario crear(@RequestBody TipoUsuario tipoUsuario) {
        return tipoUsuarioService.save(tipoUsuario);
    }

    @GetMapping("/{id}")
    public TipoUsuario obtenerPorId(@PathVariable Long id) {
        return tipoUsuarioService.findById(id);
    }

    @PutMapping("/{id}")
    public TipoUsuario actualizar(@RequestBody TipoUsuario tipoUsuario, @PathVariable Long id) {
        TipoUsuario existente = tipoUsuarioService.findById(id);
        if (existente != null) {
            existente.setDescripcion(tipoUsuario.getDescripcion());
            return tipoUsuarioService.save(existente);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        tipoUsuarioService.delete(id);
    }
}

