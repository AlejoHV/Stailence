package com.stailence.backend.dao;

import com.stailence.backend.entities.Recomendaciones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRecomendacionesDao extends JpaRepository<Recomendaciones, Long> {
}