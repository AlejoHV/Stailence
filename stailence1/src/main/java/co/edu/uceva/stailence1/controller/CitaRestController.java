package co.edu.uceva.stailence1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import co.edu.uceva.stailence1.model.entities.Cita;
import co.edu.uceva.stailence1.model.service.ICitaService;

import java.util.List;

@RestController
@RequestMapping("/api/citas")
@CrossOrigin(origins = "*")
public class CitaRestController {

    @Autowired
    private ICitaService citaService;

    @GetMapping
    public List<Cita> listar() {
        return citaService.findAll();
    }

    @PostMapping
    public Cita crear(@RequestBody Cita cita) {
        return citaService.save(cita);
    }

    @GetMapping("/{id}")
    public Cita obtenerPorId(@PathVariable Long id) {
        return citaService.findById(id);
    }

    @PutMapping("/{id}")
    public Cita actualizar(@RequestBody Cita cita, @PathVariable Long id) {
        Cita existente = citaService.findById(id);
        if (existente != null) {
            existente.setFechaEstimada(cita.getFechaEstimada());
            existente.setHoraEstipulada(cita.getHoraEstipulada());
            existente.setFechaReal(cita.getFechaReal());
            existente.setEstado(cita.getEstado());
            existente.setEmpleado(cita.getEmpleado());
            existente.setCliente(cita.getCliente());
            existente.setServicio(cita.getServicio());
            return citaService.save(existente);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        citaService.delete(id);
    }
}