package co.edu.uceva.stailence1.model.service;

import co.edu.uceva.stailence1.model.entities.Servicios;
import java.util.List;

public interface IServicioService {
    List<Servicios> findAll();
    Servicios save(Servicios servicio);
    void delete(Long id);
    Servicios findById(Long id);
}
