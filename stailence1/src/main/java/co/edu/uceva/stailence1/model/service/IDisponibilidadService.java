package co.edu.uceva.stailence1.model.service;

import co.edu.uceva.stailence1.model.entities.Disponibilidad;
import java.util.List;

public interface IDisponibilidadService {
    List<Disponibilidad> findAll();
    Disponibilidad findById(Long id);
    Disponibilidad save(Disponibilidad disponibilidad);
    void delete(Long id);
}