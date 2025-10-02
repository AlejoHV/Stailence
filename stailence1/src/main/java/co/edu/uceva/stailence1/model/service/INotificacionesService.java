package co.edu.uceva.stailence1.model.service;

import co.edu.uceva.stailence1.model.entities.Notificaciones;
import java.util.List;

public interface INotificacionesService {
    List<Notificaciones> findAll();
    Notificaciones findById(Long id);
    Notificaciones save(Notificaciones notificacion);
    void delete(Long id);
}