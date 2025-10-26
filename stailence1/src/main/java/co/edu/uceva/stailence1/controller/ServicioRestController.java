package co.edu.uceva.stailence1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import co.edu.uceva.stailence1.model.entities.Servicios;
import co.edu.uceva.stailence1.model.service.IServicioService;

import java.util.List;

@RestController
@RequestMapping("/api/servicios")
@CrossOrigin(origins = "*")
public class ServicioRestController {

    @Autowired
    private IServicioService servicioService;

    @GetMapping
    public List<Servicios> listar() {
        return servicioService.findAll();
    }

    @PostMapping
    public Servicios crear(@RequestBody Servicios servicio) {
        return servicioService.save(servicio);
    }

    @GetMapping("/{id}")
    public Servicios obtenerPorId(@PathVariable Long id) {
        return servicioService.findById(id);
    }

    @PutMapping("/{id}")
    public Servicios actualizar(@RequestBody Servicios servicio, @PathVariable Long id) {
        Servicios existente = servicioService.findById(id);
        if (existente != null) {
            existente.setNombreServicio(servicio.getNombreServicio());
            existente.setDuracionServicio(servicio.getDuracionServicio());
            existente.setPrecio(servicio.getPrecio());
            existente.setNegocio(servicio.getNegocio());
            return servicioService.save(existente);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        servicioService.delete(id);
    }
}