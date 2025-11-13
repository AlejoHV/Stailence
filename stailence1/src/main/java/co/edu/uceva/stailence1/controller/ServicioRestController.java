package co.edu.uceva.stailence1.controller;

import co.edu.uceva.stailence1.model.entities.Servicios;
import co.edu.uceva.stailence1.model.service.IServicioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/servicios")
public class ServicioRestController {

    private final IServicioService servicioService;

    public ServicioRestController(IServicioService servicioService) {
        this.servicioService = servicioService;
    }

    @GetMapping
    public ResponseEntity<List<Servicios>> listar() {
        return ResponseEntity.ok(servicioService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Servicios> obtenerPorId(@PathVariable Long id) {
        Servicios servicio = servicioService.findById(id);
        if (servicio == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(servicio);
    }

    @PostMapping
    public ResponseEntity<Servicios> crear(@RequestBody Servicios servicio) {
        Servicios creado = servicioService.save(servicio);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Servicios> actualizar(@RequestBody Servicios servicio, @PathVariable Long id) {
        Servicios existente = servicioService.findById(id);
        if (existente == null) {
            return ResponseEntity.notFound().build();
        }
        existente.setNombreServicio(servicio.getNombreServicio());
        existente.setDuracionServicio(servicio.getDuracionServicio());
        existente.setPrecio(servicio.getPrecio());
        existente.setNegocio(servicio.getNegocio());
        Servicios actualizado = servicioService.save(existente);
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        servicioService.delete(id);
        return ResponseEntity.noContent().build();
    }
}