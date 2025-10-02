package com.stailence.backend.controller;

import com.stailence.backend.entities.Disponibilidad;
import com.stailence.backend.service.IDisponibilidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/disponibilidad")
public class DisponibilidadRestController {

    @Autowired
    private IDisponibilidadService disponibilidadService;

    @GetMapping
    public List<Disponibilidad> listar() {
        return disponibilidadService.findAll();
    }

    @GetMapping("/{id}")
    public Disponibilidad obtenerPorId(@PathVariable Long id) {
        return disponibilidadService.findById(id);
    }

    @PostMapping
    public Disponibilidad crear(@RequestBody Disponibilidad disponibilidad) {
        return disponibilidadService.save(disponibilidad);
    }

    @PutMapping("/{id}")
    public Disponibilidad actualizar(@PathVariable Long id, @RequestBody Disponibilidad disponibilidad) {
        Disponibilidad existente = disponibilidadService.findById(id);
        if (existente != null) {
            existente.setDia(disponibilidad.getDia());
            existente.setHora_inicio(disponibilidad.getHora_inicio());
            existente.setHora_fin(disponibilidad.getHora_fin());
            existente.setEmpleado(disponibilidad.getEmpleado());
            return disponibilidadService.save(existente);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        disponibilidadService.delete(id);
    }
}