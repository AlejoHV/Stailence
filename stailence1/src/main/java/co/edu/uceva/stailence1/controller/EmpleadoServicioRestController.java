package co.edu.uceva.stailence1.controller;

import co.edu.uceva.stailence1.model.entities.EmpleadoServicio;
import co.edu.uceva.stailence1.model.entities.EmpleadoServicioId;
import co.edu.uceva.stailence1.model.service.IEmpleadoServicioService;
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