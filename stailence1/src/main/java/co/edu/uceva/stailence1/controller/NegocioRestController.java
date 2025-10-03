package co.edu.uceva.stailence1.controller;

import co.edu.uceva.stailence1.model.entities.Negocio;
import co.edu.uceva.stailence1.model.service.INegocioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/negocios")  // Prefijo para la ruta
public class NegocioRestController {

    @Autowired
    private INegocioService negocioService;

    // Crear negocio
    @PostMapping
    public Negocio crearNegocio(@RequestBody Negocio negocio) {
        return negocioService.save(negocio);
    }

    // Listar todos los negocios
    @GetMapping
    public List<Negocio> listarNegocios() {
        return negocioService.findAll();
    }

    // Buscar un negocio por id
    @GetMapping("/{id}")
    public Negocio obtenerNegocio(@PathVariable Long id) {
        return negocioService.findById(id);
    }

    // Actualizar un negocio
    @PutMapping("/{id}")
    public Negocio actualizarNegocio(@PathVariable Long id, @RequestBody Negocio negocio) {
        Negocio negocioExistente = negocioService.findById(id);
        if (negocioExistente != null) {
            negocio.setId_Negocios(id);
            return negocioService.save(negocio);
        }
        return null;
    }

    // Eliminar un negocio
    @DeleteMapping("/{id}")
    public void eliminarNegocio(@PathVariable Long id) {
        negocioService.delete(id);
    }
}