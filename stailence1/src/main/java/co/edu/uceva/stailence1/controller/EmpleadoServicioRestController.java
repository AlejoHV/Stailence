package com.stailence.backend.controller;

import com.stailence.backend.entities.EmpleadoServicio;
import com.stailence.backend.entities.EmpleadoServicioId;
import com.stailence.backend.service.IEmpleadoServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/empleado-servicio")
public class EmpleadoServicioRestController {

    @Autowired
    private IEmpleadoServicioService empleadoServicioService;

    @GetMapping
    public List<EmpleadoServicio> listar() {
        return empleadoServicioService.findAll();
    }

    @GetMapping("/{idEmpleado}/{idServicio}")
    public EmpleadoServicio obtenerPorId(@PathVariable Long idEmpleado, @PathVariable Long idServicio) {
        return empleadoServicioService.findById(new EmpleadoServicioId(idEmpleado, idServicio));
    }

    @PostMapping
    public EmpleadoServicio crear(@RequestBody EmpleadoServicio empleadoServicio) {
        return empleadoServicioService.save(empleadoServicio);
    }

    @DeleteMapping("/{idEmpleado}/{idServicio}")
    public void eliminar(@PathVariable Long idEmpleado, @PathVariable Long idServicio) {
        empleadoServicioService.delete(new EmpleadoServicioId(idEmpleado, idServicio));
    }
}