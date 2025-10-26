package co.edu.uceva.stailence1.model.service;

import co.edu.uceva.stailence1.model.entities.Negocio;
import java.util.List;

public interface INegocioService {
    List<Negocio> findAll();
    Negocio save(Negocio negocio);
    void delete(Long id);
    Negocio findById(Long id);
}