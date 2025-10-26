package co.edu.uceva.stailence1.model.service;

import co.edu.uceva.stailence1.model.entities.Cita;
import java.util.List;

public interface ICitaService {
    List<Cita> findAll();
    Cita save(Cita cita);
    void delete(Long id);
    Cita findById(Long id);
}