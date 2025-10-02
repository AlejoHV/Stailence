package co.edu.uceva.stailence1.model.service;

import co.edu.uceva.stailence1.model.entities.Servicio;
import java.util.List;

public interface IServicioService {
    List<Servicio> findAll();
    Servicio save(Servicio servicio);
    void delete(Long id);
    Servicio findById(Long id);
}
