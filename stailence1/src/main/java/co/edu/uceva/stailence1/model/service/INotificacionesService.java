package com.stailence.backend.service;

import com.stailence.backend.entities.Notificaciones;
import java.util.List;

public interface INotificacionesService {
    List<Notificaciones> findAll();
    Notificaciones findById(Long id);
    Notificaciones save(Notificaciones notificacion);
    void delete(Long id);
}