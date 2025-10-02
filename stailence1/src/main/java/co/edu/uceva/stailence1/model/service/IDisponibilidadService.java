package com.stailence.backend.service;

import com.stailence.backend.entities.Disponibilidad;
import java.util.List;

public interface IDisponibilidadService {
    List<Disponibilidad> findAll();
    Disponibilidad findById(Long id);
    Disponibilidad save(Disponibilidad disponibilidad);
    void delete(Long id);
}