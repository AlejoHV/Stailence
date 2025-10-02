package com.stailence.backend.service;

import com.stailence.backend.entities.Recomendaciones;
import java.util.List;

public interface IRecomendacionesService {
    List<Recomendaciones> findAll();
    Recomendaciones findById(Long id);
    Recomendaciones save(Recomendaciones recomendacion);
    void delete(Long id);
}