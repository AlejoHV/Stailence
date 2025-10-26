package co.edu.uceva.stailence1.model.service;

import co.edu.uceva.stailence1.model.entities.Recomendaciones;
import java.util.List;

public interface IRecomendacionesService {
    List<Recomendaciones> findAll();
    Recomendaciones findById(Long id);
    Recomendaciones save(Recomendaciones recomendacion);
    void delete(Long id);
}