package co.edu.uceva.stailence1.controller;

import co.edu.uceva.stailence1.model.entities.Recomendaciones;
import co.edu.uceva.stailence1.model.service.IRecomendacionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recomendaciones")
public class RecomendacionesRestController {

    @Autowired
    private IRecomendacionesService recomendacionesService;

    @GetMapping
    public List<Recomendaciones> listar() {
        return recomendacionesService.findAll();
    }

    @GetMapping("/{id}")
    public Recomendaciones obtenerPorId(@PathVariable Long id) {
        return recomendacionesService.findById(id);
    }

    @PostMapping
    public Recomendaciones crear(@RequestBody Recomendaciones recomendacion) {
        return recomendacionesService.save(recomendacion);
    }

    @PutMapping("/{id}")
    public Recomendaciones actualizar(@PathVariable Long id, @RequestBody Recomendaciones recomendacion) {
        Recomendaciones existente = recomendacionesService.findById(id);
        if (existente != null) {
            existente.setTipo_rostro(recomendacion.getTipo_rostro());
            existente.setCorte_sugerido(recomendacion.getCorte_sugerido());
            existente.setCliente(recomendacion.getCliente());
            return recomendacionesService.save(existente);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        recomendacionesService.delete(id);
    }
}