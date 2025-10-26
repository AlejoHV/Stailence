package co.edu.uceva.stailence1.controller;

import co.edu.uceva.stailence1.model.entities.Notificaciones;
import co.edu.uceva.stailence1.model.service.INotificacionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/notificaciones")
public class NotificacionRestController {

    @Autowired
    private INotificacionesService notificacionesService;

    @GetMapping
    public List<Notificaciones> listar() {
        return notificacionesService.findAll();
    }

    @GetMapping("/{id}")
    public Notificaciones obtenerPorId(@PathVariable Long id) {
        return notificacionesService.findById(id);
    }

    @PostMapping
    public Notificaciones crear(@RequestBody Notificaciones notificacion) {
        return notificacionesService.save(notificacion);
    }

    @PutMapping("/{id}")
    public Notificaciones actualizar(@PathVariable Long id, @RequestBody Notificaciones notificacion) {
        Notificaciones existente = notificacionesService.findById(id);
        if (existente != null) {
            existente.setMensaje_recordatorio(notificacion.getMensaje_recordatorio());
            existente.setFecha(notificacion.getFecha());
            existente.setEstado_notificacion(notificacion.getEstado_notificacion());
            existente.setUsuario(notificacion.getUsuario());
            existente.setCita(notificacion.getCita());
            return notificacionesService.save(existente);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        notificacionesService.delete(id);
    }
}