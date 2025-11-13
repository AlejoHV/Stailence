package co.edu.uceva.stailence1.controller;

import co.edu.uceva.stailence1.model.entities.EmpleadoServicio;
import co.edu.uceva.stailence1.model.entities.EmpleadoServicioId;
import co.edu.uceva.stailence1.model.service.IEmpleadoServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/empleado-servicio")
public class EmpleadoServicioRestController {

    private IEmpleadoServicioService empleadoServicioService;

    public EmpleadoServicioRestController(IEmpleadoServicioService empleadoServicioService) {
        this.empleadoServicioService = empleadoServicioService;
    }

    @GetMapping
    public ResponseEntity<List<EmpleadoServicio>> listar() {
        return ResponseEntity.ok(empleadoServicioService.findAll());
    }

    @GetMapping("/{idEmpleado}/{idServicio}")
    public ResponseEntity<EmpleadoServicio> obtenerPorId(
            @PathVariable("idEmpleado") Long idEmpleado,
            @PathVariable("idServicio") Long idServicio) {

        EmpleadoServicio empleadoServicio = empleadoServicioService
            .findById(new EmpleadoServicioId(idEmpleado, idServicio));

        if (empleadoServicio != null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(empleadoServicio);
    }

    @PostMapping
    public ResponseEntity<EmpleadoServicio> crear(@RequestBody EmpleadoServicio empleadoServicio) {
        EmpleadoServicio creado = empleadoServicioService.save(empleadoServicio);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

    @DeleteMapping("/{idEmpleado}/{idServicio}")
    public ResponseEntity<Void> eliminar(
            @PathVariable("idEmpleado") Long idEmpleado,
            @PathVariable("idServicio") Long idServicio) {

        EmpleadoServicioId id = new EmpleadoServicioId(idEmpleado, idServicio);
        empleadoServicioService.delete(id);
        return ResponseEntity.noContent().build();
    }

    // Endpoint adicional para obtener todos los servicios de un empleado
    @GetMapping("/empleado/{idEmpleado}")
    public ResponseEntity<List<EmpleadoServicio>> listarPorEmpleado(@PathVariable Long idEmpleado) {
        List<EmpleadoServicio> servicios = empleadoServicioService.findByEmpleadoId(idEmpleado);
        return ResponseEntity.ok(servicios);
    }

    // Endpoint adicional para obtener todos los empleados de un servicio
    @GetMapping("/servicio/{idServicio}")
    public ResponseEntity<List<EmpleadoServicio>> listarPorServicio(@PathVariable Long idServicio) {
        List<EmpleadoServicio> empleados = empleadoServicioService.findByServicioId(idServicio);
        return ResponseEntity.ok(empleados);
    }

}