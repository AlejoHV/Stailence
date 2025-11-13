package co.edu.uceva.stailence1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import co.edu.uceva.stailence1.model.entities.Cita;
import co.edu.uceva.stailence1.model.service.ICitaService;

import java.util.List;

@RestController
@RequestMapping("/api/citas")
//@CrossOrigin(origins = "*")
public class CitaRestController {

    private ICitaService citaService;

    public CitaRestController(ICitaService citaService) {
        this.citaService = citaService;
    }

    @GetMapping
    public ResponseEntity<List<Cita>> listar() {
        return ResponseEntity.ok(citaService.findAll());
    }

    @PostMapping
    public ResponseEntity<Cita> crearCita(@RequestBody Cita cita) {
        return ResponseEntity.ok(citaService.save(cita));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cita> obtenerCita(@PathVariable Long id) {
        Cita cita = citaService.findById(id);
        if (cita != null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cita);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cita> actualizarCita(@RequestBody Cita cita, @PathVariable Long id) {
        Cita existente = citaService.findById(id);
        if (existente == null) {
            return ResponseEntity.notFound().build();
        }
        existente.setFechaEstimada(cita.getFechaEstimada());
        existente.setHoraEstipulada(cita.getHoraEstipulada());
        existente.setFechaReal(cita.getFechaReal());
        existente.setEstado(cita.getEstado());
        existente.setEmpleado(cita.getEmpleado());
        existente.setCliente(cita.getCliente());
        existente.setServicio(cita.getServicio());

        Cita actualizado = citaService.save(existente);
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCita(@PathVariable Long id) {
        citaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}