package co.edu.uceva.stailence1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import co.edu.uceva.stailence1.model.entities.Negocio;
import co.edu.uceva.stailence1.model.service.INegocioService;

import java.util.List;

@RestController
@RequestMapping("/api/negocios")
@CrossOrigin(origins = "*")
public class NegocioRestController {

    @Autowired
    private INegocioService negocioService;

    @GetMapping
    public List<Negocio> listar() {
        return negocioService.findAll();
    }

    @PostMapping
    public Negocio crear(@RequestBody Negocio negocio) {
        return negocioService.save(negocio);
    }

    @GetMapping("/{id}")
    public Negocio obtenerPorId(@PathVariable Long id) {
        return negocioService.findById(id);
    }

    @PutMapping("/{id}")
    public Negocio actualizar(@RequestBody Negocio negocio, @PathVariable Long id) {
        Negocio existente = negocioService.findById(id);
        if (existente != null) {
            existente.setNombre(negocio.getNombre());
            existente.setDireccion(negocio.getDireccion());
            existente.setTelefono(negocio.getTelefono());
            existente.setCorreo(negocio.getCorreo());
            existente.setHorarioGeneral(negocio.getHorarioGeneral());
            return negocioService.save(existente);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        negocioService.delete(id);
    }
}
