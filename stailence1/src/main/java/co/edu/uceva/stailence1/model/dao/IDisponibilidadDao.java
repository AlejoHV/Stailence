package com.stailence.backend.dao;

import com.stailence.backend.entities.Disponibilidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDisponibilidadDao extends JpaRepository<Disponibilidad, Long> {
}